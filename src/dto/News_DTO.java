package dto;

public class News_DTO{
	String news_no, title, contents, images, file_name_1, reg_date;
	int hit;

	public News_DTO(){}
	
	public News_DTO(String news_no, String title, String contents, String file_name_1, String reg_date) {
		super();
		this.news_no = news_no;
		this.title = title;
		this.contents = contents;
		this.file_name_1 = file_name_1;
		this.reg_date = reg_date;
	}

	public News_DTO(String news_no, String title, String contents, String images, String file_name_1, String reg_date, int hit){
		this.news_no 		= news_no;
		this.title 			= title;
		this.contents 		= contents;
		this.images			= images;
		this.file_name_1	= file_name_1;
		this.reg_date 		= reg_date;
		this.hit 			= hit;
	}	
	public News_DTO(String news_no, String title, String contents, String images, String reg_date, int hit){
		this.news_no 		= news_no;
		this.title 			= title;
		this.contents 		= contents;
		this.images			= images;
		this.reg_date 		= reg_date;
		this.hit 			= hit;
	}	
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getNews_no() {
		return news_no;
	}
	public void setNews_no(String news_no) {
		this.news_no = news_no;
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