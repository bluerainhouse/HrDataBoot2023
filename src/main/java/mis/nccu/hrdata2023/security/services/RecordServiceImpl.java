package mis.nccu.hrdata2023.security.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mis.nccu.hrdata2023.models.Record;
import mis.nccu.hrdata2023.repository.RecordRepository;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;
	@Override
	public List<Record> getAll() {
		return recordRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Record getById(int id) {
		return recordRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(Record record) {
		//判斷是否為新物件
		if (record.getId() == 0) {
			record.setRecordDate(new Date());
		}
		recordRepository.save(record);

	}

	@Override
	public void delete(int id) {
		recordRepository.deleteById(id);
	}

	@Override
	public List<Record> getAllByLogin(String login) {
		return recordRepository.getAllByLogin(login);
	}

}

