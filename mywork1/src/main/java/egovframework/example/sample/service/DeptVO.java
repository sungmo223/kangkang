package egovframework.example.sample.service;

public class DeptVO {
	//캡슐화- 접근지정자 : public protected private 
	private String deptno; // 인스턴트(객체)변수 
	private String dname;
	private String loc;
	// private은 직접적으로 접근불가하므로 메소드로 접근 
	
	public static String message = "abc"; // 클래스 변수 
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
