package egov.service;

import java.util.List;

public interface ReviewService {

	List<?> selectReviewList( ReviewVO vo ) throws Exception;
	String insertReview( ReviewVO vo ) throws Exception;
	//insert에는 String 목록출력에는 List
}
