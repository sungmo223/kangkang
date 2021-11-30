package egov.service;

import java.util.List;

public interface ReviewService {

	List<?> selectReviewList( ReviewVO vo ) throws Exception;
}
