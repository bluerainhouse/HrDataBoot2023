package mis.nccu.hrdata2023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mis.nccu.hrdata2023.models.Record;
import mis.nccu.hrdata2023.payload.request.RecordRequest;
import mis.nccu.hrdata2023.services.RecordService;

@RestController
@RequestMapping("/api/record")
//@CrossOrigin(origins = "http://localhost:3000") // 指定允許的來源
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecordRestController {
	@Autowired
	RecordService recordService;

	@GetMapping(value = "/iot")
	public void inputIot(@RequestParam("login") String login, 
			@RequestParam("highBp") int highBp, @RequestParam("lowBp") int lowBp, 
			@RequestParam("hr") int hr, @RequestParam("i1") int i1,@RequestParam("i2") int i2,
			@RequestParam("i3") int i3) {
		Record record = new Record();
		record.setLogin(login);
		record.setHighBp(highBp);
		record.setLowBp(lowBp);
		record.setHeartbeats(hr);
		record.setI1(i1);
		record.setI2(i2);
		record.setI3(i3);
		recordService.saveOrUpdate(record);
	}
	
	@PostMapping("/")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RecordRequest recordRequest) {
		Record record = new Record();
		record.setLogin(recordRequest.getLogin());
		record.setHighBp(recordRequest.getHighBp());
		record.setLowBp(recordRequest.getLowBp());
		record.setHeartbeats(recordRequest.getHr());
		record.setI1(recordRequest.getI1());
		record.setI2(recordRequest.getI2());
		record.setI3(recordRequest.getI3());
		recordService.saveOrUpdate(record);
		return null;
	}
	@GetMapping("/allchart")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public List<Record> outputJson() {
		return recordService.getAll();
	}
	@GetMapping("/chart/{login}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public List<Record> getJsonByUserName(@PathVariable String login) {
		return recordService.getAllByLogin(login);
	}
	
	@GetMapping("/{recordId}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	public Record getRecordById(@PathVariable int recordId) {
		return recordService.getById(recordId);
	}
	
	@DeleteMapping("/{recordId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteById(@PathVariable int recordId){
		Record record = recordService.getById(recordId);
		if (record == null) {
            return ResponseEntity.notFound().build();
        }
		recordService.delete(recordId);
		return ResponseEntity.ok("Record deleted successfully");
	}
}

