package dto;

public class exam_DTO {
	String id,pw,name,bd,sex,phone;

	public exam_DTO(String id, String pw, String name, String bd, String sex, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.bd = bd;
		this.sex = sex;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	
}
