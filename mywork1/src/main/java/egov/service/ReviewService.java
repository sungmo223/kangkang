package egov.service;

import java.util.List;
import java.util.Map;

public interface ReviewService {

	String insertReview(ReviewVO vo) throws Exception;
	
	List<?> selectReviewList(ReviewVO vo) throws Exception;
	
	int selectReviewTotal(ReviewVO vo) throws Exception;
	
	ReviewVO selectReviewboardDetail(ReviewVO vo) throws Exception;

	int updateReviewboardHits(ReviewVO vo) throws Exception;

	String insertComment(CommentVO vo) throws Exception;

	List<?> selectCommentList(int p_unq) throws Exception ;

	int selectCommentPass(CommentVO vo) throws Exception ;

	int updateComment(CommentVO vo) throws Exception;

	int deleteComment(CommentVO vo) throws Exception;
	
	/* vo에 태우지 or 세팅되지 않은 여러가지 데이터를 전송할 때 MAP 사용*/
	int selectReviewPass(Map map) throws Exception;
	
	int updateReviewboard(ReviewVO vo) throws Exception;

	int deleteReviewboard(ReviewVO vo) throws Exception;

	/*
	 * comment 테이블 p_unq를 이용한 삭제 
	 */
	int deleteCommentALL(int p_unq) throws Exception;


	
	
	
}
