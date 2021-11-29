package egov.service;

import java.util.List;

public interface EmpService {
	
	
	List<?> selectEmpList(EmpVO vo) throws Exception;
	
	String insertEmp(EmpVO vo) throws Exception;
	
	int selectEmpTotal() throws Exception;

	// 상세보기처럼 단건을 받는 경우에 VO로 받기 
	// (sql에서 조건식으로 넘어갈 변수... (?) )
	EmpVO selectEmpDetail(int empno) throws Exception;
	
	int updateEmp(EmpVO vo) throws Exception;
	
	int deleteEmp(int empno) throws Exception;
	
	int selectEmpEmpno() throws Exception;
				//데이터베이스로 전달되는거 없음. 
	
	/*List<?> selectDeptList() throws Exception;
		dept service에서 이미 만들어뒀었음. 
	*/
	List<?> selectEmpJobList() throws Exception;
	
}
