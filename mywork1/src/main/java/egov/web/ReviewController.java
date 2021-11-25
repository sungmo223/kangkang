package egov.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egov.service.ReviewVO;

@Controller
public class ReviewController {
	
	
	@RequestMapping("reviewBoardList.do")
	public String selectReviewList(ReviewVO vo)
									throws Exception{
		
		
		
		return "admin/reviewList";
	}
}
