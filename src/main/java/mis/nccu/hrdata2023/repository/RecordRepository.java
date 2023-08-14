package mis.nccu.hrdata2023.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mis.nccu.hrdata2023.models.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer>{
	@Query("from Record r where r.login = :login order by r.id asc")
	public List<Record> getAllByLogin(@Param("login") String login);
	
}
