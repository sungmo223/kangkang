package egov.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/*
	 * 이용후기 등록화면
	 */
	@RequestMapping("reviewBoardWrite.do")
	public String reviewBoardWrite() throws Exception{
		
		
		return "admin/reviewWrite";
	}
	
	/*
	 * 이용후기 등록처리(저장)
	 * @ResponseBody 이건 사용자측에 결과메세지를 뿌리기 위해 필요
	 */
	
	@RequestMapping("reviewBoardWriteSave.do")
	@ResponseBody
	public String insertReviewboard( ReviewVO vo ) 
							throws Exception{
		
		String result = reviewService.insertReview(vo);
		
		String message = "";
		if(result == null) {
			message = "ok";
		}
		return message;
	} 
	
}
