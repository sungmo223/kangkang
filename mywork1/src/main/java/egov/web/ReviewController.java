package egov.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import egov.service.CommentVO;
import egov.service.ReviewService;
import egov.service.ReviewVO;

@Controller
public class ReviewController {
	
	@Resource(name = "reviewService")
	ReviewService reviewService;
	
	
	
	@RequestMapping("reviewBoardList.do")
	public String selectReviewList(ReviewVO vo, Model model)
									throws Exception{
		
		//출력 페이지번호를 받음. 
		int page_no = vo.getPage_no();
		
		//페이지 번호를 이용하여 sql의 시작번호와 끝번호 변수 설정. 
		int s_no = (page_no -1)*10 +1;
		int e_no = s_no + (10-1);
		
		// 완성된 s_no, e_no 변수를 vo에 탑재 (=> sql로 이동) 
		vo.setS_no(s_no);
		vo.setE_no(e_no);
		
		//목록출력 서비스 실행.  
		List<?> list = reviewService.selectReviewList(vo);
	
		//총 데이터 개수를 얻는 서비스 실행. 
		int total = reviewService.selectReviewTotal(vo);
		
		//총 페이지 번호를 얻는 설정. 
		int total_page = (int) Math.ceil((double) total/10);
		
		//출력 페이지의 시작 행번호 설정 
		int rownum = total - (page_no-1)*10;
		
		// vo에 화면(jsp)으로 전송힐 변수 세팅. 
		// 여러번 model에 태우기보다 vo에 탑재를 시켜서 한번에 보내기
		vo.setTotal(total);
		vo.setTotal_page(total_page);
		vo.setRownum(rownum);
		
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);

		return "admin/reviewList";
	}
	
	@RequestMapping("reviewBoardWrite.do")
	public String reviewBoardWrite()
								throws Exception {
		
		
		
		return "admin/reviewWrite";
	}
	
	@RequestMapping("reviewBoardWriteSave.do")
	@ResponseBody  
	public String insertReviewboard (ReviewVO vo)
								throws Exception {
		
		String result = reviewService.insertReview(vo);
		
		String message = "";
		if(result == null ) {
			message = "ok";
		}
	
		return message;
	}
	
	@RequestMapping("reviewBoardDetail.do")
	public String selectReviewboardDetail(ReviewVO vo, Model model) 
															throws Exception {
		// 상세보기 서비스 실행
		vo = reviewService.selectReviewboardDetail(vo);
		
		// 조회수 증가 서비스 실행
		reviewService.updateReviewboardHits(vo);
	
		// 코멘트 목록출력 서비스 실행
		int p_unq = vo.getUnq();   //상세보기의 unq값이 p_unq
		List<?> comList = reviewService.selectCommentList(p_unq);
		
		
		
		
		String content = vo.getContent();
		if(content != null && !content.equals("")) {
			content = content.replace("\n", "<br>");
			content = content.replace(" ","&nbsp;");
			vo.setContent(content);
		}		
		
		
		model.addAttribute("comList",comList);
		model.addAttribute("vo",vo);
		return "admin/reviewDetail";
	}
	
	@RequestMapping("reviewBoardModify.do")
	public String selectReviewboardModify (ReviewVO vo,Model model ) 
													throws Exception {
		
		//상세보기 서비스 실행 
		vo = reviewService.selectReviewboardDetail(vo);
		
		model.addAttribute("vo",vo);
		
		return "admin/reviewModify";
	}
	
	@RequestMapping("reviewBoardModifySave.do")
	@ResponseBody
	public String updateReviewboard (ReviewVO vo) 
									throws Exception {
		
		//map으로 여러 데이터IBATIS로 전송
		Map<String,String> map =  new HashMap<String,String>();
		int unq = vo.getUnq();
		String pass = vo.getPass();
				// key, value
		map.put("unq", unq+"");
		map.put("pass", pass);
		
		// 암호확인서비스 실행
		int cnt_pass = reviewService.selectReviewPass(map);
		
		
		System.out.println("출력갯수 : " + cnt_pass); 
		String message = "ok";

		if(cnt_pass == 0) {
			message ="pass_fail";
		} else {
		
			//수정하기 서비스 실행 
	
			int result = reviewService.updateReviewboard(vo);
			if(result == 0) {
				message = "update_fail";
			} 
		
		}
	
		return message;
	}
	
	@RequestMapping("passWrite.do")
	public String boardPassWrite(int unq, Model model) 
										throws Exception {
		// model을 이용해 화면으로 parameter unq 전송 
		model.addAttribute("unq",unq);
		return "admin/passWrite";
	}
	@RequestMapping("reviewBoardDelete.do")
	@ResponseBody
	public String deleteReview(ReviewVO vo) 
										throws Exception {
		
		String msg = "ok";
		
		// 암호체크
		int unq = vo.getUnq();
		String pass = vo.getPass();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("unq",unq+"");
		map.put("pass",pass);
		
		int cnt_pass = reviewService.selectReviewPass(map);
		
		if(cnt_pass == 0) {
			msg = "pass_fail";
		} else {
			//삭제 서비스
			// 본데이터 삭제
			int result = reviewService.deleteReviewboard(vo);
			// 본데이터의 코멘트 삭제
			int p_unq = vo.getUnq(); 
			//본문 unq값을 p_unq 변수로 만들어주
			int result2 = reviewService.deleteCommentALL(p_unq);
			
			if(result == 0) {
				msg = "delete_fail";
			} 
		}
		
		return msg;
	}
	
	@RequestMapping("commentSave.do")
	@ResponseBody
	public String insertComment(CommentVO vo ) 
										throws Exception {
		//저장 서비스 실행
		String result = reviewService.insertComment(vo);
		
		String message = "";
		if(result == null) {
			message = "ok";
		}
		
		
		return message;
	}
	
	@RequestMapping("commentModify.do")
	@ResponseBody
	public String updateComment(CommentVO vo ) 
										throws Exception {
		
		String message = "ok";
		int cnt_pass = reviewService.selectCommentPass(vo);
		
		if(cnt_pass == 0) {
			message = "pass_fail";
		} else {
	
			//변경처리 서비스 실행
			int result = reviewService.updateComment(vo);
	
			if(result == 0) {
				message = "save_fail";
			} 
			
		}
		
		return message;
	}
	
	@RequestMapping("commentDelete.do")
	@ResponseBody
	public String deleteComment(CommentVO vo ) 
									throws Exception {
		String message = "ok";
		
		//비밀번호 일치
		int cnt_pass = reviewService.selectCommentPass(vo);
		
		//삭제 서비스 
		if(cnt_pass == 0) {
			message = "pass_fail";
		} else {
			int result = reviewService.deleteComment(vo);
			System.out.println(result);
			if(result == 0) {
				message = "save_fail";
			}
		}
		return message;
	}
	
}
