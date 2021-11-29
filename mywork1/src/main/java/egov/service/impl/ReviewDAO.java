package egov.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egov.service.CommentVO;
import egov.service.ReviewVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("reviewDAO")
public class ReviewDAO extends EgovAbstractDAO {

	
	public List<?> selectReviewList(ReviewVO vo) {
		return list("reviewDAO.selectReviewList",vo);
	}

	public String insertReview(ReviewVO vo) {
		return (String) insert("reviewDAO.insertReview",vo);
	}

	public int selectReviewTotal(ReviewVO vo) {
		return (int) select("reviewDAO.selectReviewTotal",vo) ;
	}

	public ReviewVO selectReviewboardDetail(ReviewVO vo) {
		return (ReviewVO) select("reviewDAO.selectReviewboardDetail",vo);
	}

	public int updateReviewboardHits(ReviewVO vo) {
		return update("reviewDAO.updateReviewboardHits",vo);
	}

	public String insertComment(CommentVO vo) {
		System.out.println("=====dao");
		return (String) insert("reviewDAO.insertComment",vo);
	}

	public List<?> selectCommentList(int p_unq) {
		return list("reviewDAO.selectCommentList", p_unq);
	}

	public int selectCommentPass(CommentVO vo) {
		return (int) select("reviewDAO.selectCommentPass",vo);
	}

	public int updateComment(CommentVO vo) {
		return (int) update("reviewDAO.updateComment",vo);
	}

	public int deleteComment(CommentVO vo) {
		return (int) delete("reviewDAO.deleteComment",vo);
	}

	public int selectReviewPass(Map map) {
		return (int) select("reviewDAO.selectReviewPass",map);
	}

	public int updateReviewboard(ReviewVO vo) {
		return (int) update("reviewDAO.updateReviewboard",vo);
	}

	public int deleteReviewboard(ReviewVO vo) {
		return (int) delete("reviewDAO.deleteReviewboard",vo);
	}

	public int deleteCommentALL(int p_unq) {
		return (int) delete("reviewDAO.deleteCommentALL",p_unq) ;
	}

	

	

}
