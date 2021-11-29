package egov.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.service.CommentVO;
import egov.service.ReviewService;
import egov.service.ReviewVO;

@Service("reviewService")
public class ReviewImpl implements ReviewService {

	@Resource(name = "reviewDAO")
	ReviewDAO reviewDAO;
	
	
	@Override
	public List<?> selectReviewList(ReviewVO vo) throws Exception {
		return reviewDAO.selectReviewList(vo);
	}


	@Override
	public String insertReview(ReviewVO vo) throws Exception {
		return reviewDAO.insertReview(vo);
	}


	@Override
	public int selectReviewTotal(ReviewVO vo) throws Exception {
		return reviewDAO.selectReviewTotal(vo);
	}


	@Override
	public ReviewVO selectReviewboardDetail(ReviewVO vo) throws Exception {
		return reviewDAO.selectReviewboardDetail(vo);
	}


	@Override
	public int updateReviewboardHits(ReviewVO vo) throws Exception {
		return reviewDAO.updateReviewboardHits(vo);
	}


	@Override
	public String insertComment(CommentVO vo) throws Exception {
		return reviewDAO.insertComment(vo);
	}


	@Override
	public List<?> selectCommentList(int p_unq) throws Exception {
		return reviewDAO.selectCommentList(p_unq);
	}


	@Override
	public int selectCommentPass(CommentVO vo) throws Exception {
		return reviewDAO.selectCommentPass(vo);
	}


	@Override
	public int updateComment(CommentVO vo) throws Exception {
		return reviewDAO.updateComment(vo);
	}


	@Override
	public int deleteComment(CommentVO vo) throws Exception {
		return reviewDAO.deleteComment(vo);
	}


	@Override
	public int selectReviewPass(Map map) throws Exception {
		return reviewDAO.selectReviewPass(map);
	}


	@Override
	public int updateReviewboard(ReviewVO vo) throws Exception {
		return reviewDAO.updateReviewboard(vo);
	}


	@Override
	public int deleteReviewboard(ReviewVO vo) throws Exception {
		return reviewDAO.deleteReviewboard(vo);
	}


	@Override
	public int deleteCommentALL(int p_unq) throws Exception {
		return reviewDAO.deleteCommentALL(p_unq);
	}



	

	
}
