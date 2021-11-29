package egov.service;

public class ReviewVO {

	int unq ;
	String title; 
	String pass;
	String name ;
	String content;
	int hits ;
	String rdate;
	String udate;
	String email; 
	String	sns;
	
	//검색을 위한 변수
	String s_field;
	String s_text;
	
	// 총 데이터 개수
	int total = 0;
	
	// 총 페이지 개수
	int total_page = 1;
	//출력 페이지 번호
	int page_no =1;
	//출력 페이지 시작 행 번호
	int rownum = 1;
	
	//SQL 범위 시작과 끝 번호
	int s_no = 1;
	int e_no = 10;
	
	//한 화면당 출력 행 개수
	int page_unit = 10;
	//한 화면에 출력할 페이지 개수  (next, before 버튼처리도 필요~)
	int page_size = 10;
	
	// 코멘트 숫자 => 0일경우 코멘트 목록 안보이게..!
	int commcnt;
	
	
	
	public int getCommcnt() {
		return commcnt;
	}
	public void setCommcnt(int commcnt) {
		this.commcnt = commcnt;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage_unit() {
		return page_unit;
	}
	public void setPage_unit(int page_unit) {
		this.page_unit = page_unit;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	public int getPage_no() {
		return page_no;
	}
	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}
	public String getS_field() {
		return s_field;
	}
	public void setS_field(String s_field) {
		this.s_field = s_field;
	}
	public String getS_text() {
		return s_text;
	}
	public void setS_text(String s_text) {
		this.s_text = s_text;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getE_no() {
		return e_no;
	}
	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	public int getUnq() {
		return unq;
	}
	public void setUnq(int unq) {
		this.unq = unq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	
	
	
	
}
