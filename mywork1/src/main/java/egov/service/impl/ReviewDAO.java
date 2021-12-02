package egov.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.service.ReviewVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("reviewDAO")
public class ReviewDAO extends EgovAbstractDAO{

	public List<?> selectReviewList(ReviewVO vo) {
		
		return list("reviewDAO.selectReviewList",vo);
	}

	public String insertReview(ReviewVO vo) {
		return (String) insert("reviewDAO.insertReview",vo);
	}

}
