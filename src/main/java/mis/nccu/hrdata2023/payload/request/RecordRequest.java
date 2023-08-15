package mis.nccu.hrdata2023.payload.request;

import jakarta.validation.constraints.NotBlank;

public class RecordRequest {
	@NotBlank
	private String login;
	
	private int highBp;
	
	private int lowBp;
	
	private int hr;
	
	private int i1;
	
	private int i2;
	
	private int i3;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
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
