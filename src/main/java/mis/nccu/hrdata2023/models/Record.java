package mis.nccu.hrdata2023.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "record")
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String login;
	
	private Date recordDate;
	
	private int highBp;
	
	private int lowBp;
	
	private int heartbeats;
	
	private int i1;
	
	private int i2;
	
	private int i3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public int getHighBp() {
		return highBp;
	}

	public void setHighBp(int highBp) {
		this.highBp = highBp;
	}

	public int getLowBp() {
		return lowBp;
	}

	public void setLowBp(int lowBp) {
		this.lowBp = lowBp;
	}

	public int getHeartbeats() {
		return heartbeats;
	}

	public void setHeartbeats(int heartbeats) {
		this.heartbeats = heartbeats;
	}

	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

	public int getI3() {
		return i3;
	}

	public void setI3(int i3) {
		this.i3 = i3;
	}

}