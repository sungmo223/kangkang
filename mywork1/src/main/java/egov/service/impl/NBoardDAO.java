package egov.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.service.EmpVO;
import egov.service.NBoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("nboardDAO")
public class NBoardDAO extends EgovAbstractDAO {

	public String insertNBoard(NBoardVO vo) {
		// TODO Auto-generated method stub
		return (String) insert("nboardDAO.insertNBoard",vo);
	}
	
	// 고유한id값. 
	public List<?> selectNBoardList(NBoardVO vo) {
		// TODO Auto-generated method stub
		return list("nboardDAO.selectNBoardList",vo);
	}

	public int selectNBoardTotal(NBoardVO vo) {
		return (int) select("nboardDAO.selectNBoardTotal",vo);
	}

	public NBoardVO selectNBoardDetail(NBoardVO vo) {
		return (NBoardVO) select("nboardDAO.selectNBoardDetail",vo);
	}

	public int updateNBoard(NBoardVO vo) {
		return update("nboardDAO.updateNBoard",vo);
	}

	public int deleteNBoard(NBoardVO vo) {
		return delete("nboardDAO.deleteNBoard",vo);
	}

	public int deleteNBoardAll(String datas) {
		return delete("nboardDAO.deleteNBoardAll",datas);
	}

	public int updateNBoardHits(NBoardVO vo) {
		return update("nboardDAO.updateNBoardHits",vo);
	}

	

}
