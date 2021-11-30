package egov.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.service.ReviewService;
import egov.service.ReviewVO;

@Service("reviewService")
public class ReviewImpl implements ReviewService{

	@Resource(name = "reviewDAO")
	ReviewDAO reviewDAO;
	
	
	@Override
	public List<?> selectReviewList(ReviewVO vo) throws Exception {

		return reviewDAO.selectReviewList(vo);
	}

}
