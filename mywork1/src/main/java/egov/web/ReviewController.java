package egov.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egov.service.ReviewService;
import egov.service.ReviewVO;

@Controller
public class ReviewController {

	@Resource(name = "reviewService")
	ReviewService reviewService;
	
	@RequestMapping("reviewBoardList.do")
	public String selectReviewList( ReviewVO vo, Model model ) 
								throws Exception{
		
		List<?> list = reviewService.selectReviewList(vo);
		
		model.addAttribute("list",list);
		
		return "admin/reviewList";
	}
}
