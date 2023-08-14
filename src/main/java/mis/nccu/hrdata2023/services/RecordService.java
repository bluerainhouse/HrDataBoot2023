package mis.nccu.hrdata2023.services;

import java.util.List;

import mis.nccu.hrdata2023.models.Record;
public interface RecordService {
	public List<Record> getAll();
	
	public Record getById(int id);
	
	public void saveOrUpdate(Record record);
	
	public void delete(int id);
	
	public List<Record> getAllByLogin(String login);
}

