package egov.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egov.service.NBoardService;
import egov.service.NBoardVO;

@Controller
public class NBorardController {

	@Resource(name = "nboardService") 
						//impl의 service이름과 동일해야함 ! 
	NBoardService nboardService;
	
	@RequestMapping("/admin_nBoardList.do")
	public String admin_nBoardList(NBoardVO vo, Model model) throws Exception {
		
		int page_no = vo.getPage_no();
		int s_no = (page_no-1)*10 +1;
		int e_no = s_no +(10-1);
	
		
		vo.setS_no(s_no);
		vo.setE_no(e_no);
		
		
		
		List<?> list = nboardService.selectNBoardList(vo);
		int total = nboardService.selectNBoardTotal(vo);
		int total_page = (int) Math.ceil((double)total/10);
							
		int rownum = total - (page_no-1)*10;
		
		
		model.addAttribute("s_field",vo.getS_field());
		model.addAttribute("s_text",vo.getS_text());
		model.addAttribute("list",list);
		model.addAttribute("total",total);
		model.addAttribute("total_page",total_page);
		model.addAttribute("rownum",rownum);
		return "admin/nBoardList";
	}
	
	@RequestMapping("/admin_nBoardWrite.do")
	public String admin_nBoardWrite() {
		
		
		
		return "admin/nBoardWrite";
	}
	
	@RequestMapping("/admin_nBoardWriteSave.do")
	@ResponseBody   
	// 주소이외의 것을 전송할때 이 어노테이션 필요 
	public String admin_nBoardWriteSave(NBoardVO vo) throws Exception {
		
		String result = nboardService.insertNBoard(vo);
		
		String message = "ok";
		if(result != null) {
			message = "error";
		}
		
		return message;
	}
	
	
	@RequestMapping("/admin_nBoardModify.do")
	public String admin_nBoardModify(NBoardVO vo, Model model) throws Exception {
		
		NBoardVO vo1 = nboardService.selectNBoardDetail(vo);
		nboardService.updateNBoardHits(vo);
		
		int before = 10;
		int next = 13;
		
		
		
		
		
		model.addAttribute("vo",vo1);
		
		
		return "admin/nBoardModify";
	}
	
	
	@RequestMapping("/admin_nBoardModifySave.do")
	@ResponseBody
	public String admin_nBoardModifySave(NBoardVO vo) throws Exception {
		int result = nboardService.updateNBoard(vo);
		
		String message = "ok";
		
		if(result != 1) {
			message = "error";
		}
		//System.out.println(message);
		return message;
		
	}
	
	
	
	
	@RequestMapping("/admin_nBoardDelete.do")
	@ResponseBody
	public String admin_nBoardDelete(NBoardVO vo) throws Exception {
		
		int result = nboardService.deleteNBoard(vo);
		String message = "ok";
		
		if(result != 1) {
			message = "error";
		}
		//System.out.println(message);
		
		return message;
	}
	
	@RequestMapping("/admin_nBoardAllDelete.do")
	@ResponseBody
	public String admin_nBoardAllDelete(String datas) throws Exception {
					//화면에서 datas 넘어오고있음. 
		//System.out.println(datas);
	
		/* 방법1. 기존에 있는 서비스 사용해서 단건으로 반복 
		NBoardVO vo = new NBoardVO();	
		String[] array = datas.split(",");
		//System.out.println(array.length); // 배열갯수확인. 
		int count = 0;
		for(int i=0; i<array.length; i++) {
			vo.setUnq(Integer.parseInt(array[i]));
			nboardService.deleteNBoard(vo);
			count++;
		}
		*/
		
		/* 방법2. 한번에 하나의 sql로 일괄삭제 */
		NBoardVO vo = new NBoardVO();	
		
		datas = datas.substring(0, datas.length()-1);
		//System.out.println(datas);
		
		
		int result = nboardService.deleteNBoardAll(datas);
		
		
		return result+"";
		
	}
	
	
}
