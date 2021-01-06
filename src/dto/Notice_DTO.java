package dto;

public class Notice_DTO{
	String notice_no, title, contents, file_name_1, reg_date;
	int hit;
	
	public Notice_DTO(){}
	public Notice_DTO(String notice_no, String title, String contents, String reg_date) {
		super();
		this.notice_no = notice_no;
		this.title = title;
		this.contents = contents;
		this.reg_date = reg_date;
	}
	public Notice_DTO(String notice_no, String title, String contents, String reg_date, int hit){
		this.notice_no 		= notice_no;
		this.title 			= title;
		this.contents 		= contents;
		this.reg_date 		= reg_date;
		this.hit 			= hit;
	}	
	public Notice_DTO(String notice_no, String title, String contents, String file_name_1, String reg_date, int hit){
		this.notice_no 		= notice_no;
		this.title 			= title;
		this.contents 		= contents;
		this.file_name_1 	= file_name_1;
		this.reg_date 		= reg_date;
		this.hit 			= hit;
	}	
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFile_name_1() {
		return file_name_1;
	}
	public void setFile_name_1(String file_name_1) {
		this.file_name_1 = file_name_1;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}