package egov.service;

import java.util.List;

public interface NBoardService {

	/*
	 *  nboard 저장처리 , 
	 *  저장후 null값 받음 -> String 
	 */
	String insertNBoard(NBoardVO vo) throws Exception;
	
	List<?> selectNBoardList(NBoardVO vo) throws Exception;
	
	int selectNBoardTotal(NBoardVO vo) throws Exception;
	/* select count(*) from nboard
	 토탈갯수로는 전달할 데이터가 없으나.
	검색기능에 따라 전달해줄 데이터가생길거 이기 때문에, vo 
	*/
	
	NBoardVO selectNBoardDetail(NBoardVO vo) throws Exception;
	
	int updateNBoard(NBoardVO vo) throws Exception;
	int updateNBoardHits(NBoardVO vo ) throws Exception;
						// unq 전달해야..! NBoardVO vo or int unq
	
	int deleteNBoard(NBoardVO vo) throws Exception;
	int deleteNBoardAll(String datas) throws Exception;
	
}
