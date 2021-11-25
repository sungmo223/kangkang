package egov.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egov.service.EmpService;
import egov.service.EmpVO;
import egovframework.example.sample.service.EgovSampleService;

@Controller
public class EmpController {

	@Resource(name="empService")
	private EmpService empService;
	
	/** EgovSampleService */
	/* dept controller 데려온것 */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;
	
	@RequestMapping(value="empList.do")
	public String selectEmpList(EmpVO vo, Model model) throws Exception {
		
		int page_no = vo.getPage_no();
		int s_no= (page_no-1)*10 +1;
		int e_no= s_no + (10-1);
		
		vo.setS_no(s_no);
		vo.setE_no(e_no);
		
		
		
		
		List<?> list = empService.selectEmpList(vo);
		int total = empService.selectEmpTotal();
		int total_page = (int) Math.ceil((double) total/10);
		
		//출력 페이지(시작)번호 
		int rownum = total - (page_no-1)*10;
		
		//화면으로 보내려면 model에 태워야됨. ("변수이름", 변수값)
		model.addAttribute("list",list);		
		model.addAttribute("total",total);
		model.addAttribute("total_page",total_page);
		model.addAttribute("rownum",rownum);
		
		
		
		return "emp/empList";
	}
	
	
	@RequestMapping(value="empWrite.do")
	public String empWrite(Model model) throws Exception {
		
		int empno = empService.selectEmpEmpno();
	
		
		List<?> deptList = sampleService.selectDeptList();
		List<?> jobList = empService.selectEmpJobList();
		
		model.addAttribute("empno",empno);
		model.addAttribute("deptList",deptList);
		model.addAttribute("jobList",jobList);
		
		return "emp/empWrite";
	}
	@RequestMapping(value="empWriteSave.do")
	public String insertEmp(EmpVO vo) throws Exception {
		// 사용자가 저장한 데이터가 vo에 담겨져있어서 가져와야됨
		String hiredate = vo.getHiredate();
		
		if(hiredate != null & !hiredate.equals("")) {
			String[] array = hiredate.split("/");
			hiredate = array[2]+"/"+array[0]+"/"+array[1];
		}
		// 바꾼 변수 세팅해야됨 !
		vo.setHiredate(hiredate);
		
		
		
		String result = empService.insertEmp(vo);
		
		if(result == null ) {
			System.out.println("== 저장성공 ==");
		} else {
			System.out.println("== 저장실패 ==");
		}
		return "redirect:empList.do";
	}
	
	@RequestMapping (value="empModify.do") 
	public String selectEmpDetail(int empno, Model model) throws Exception {
		EmpVO vo = empService.selectEmpDetail(empno);
		
		List<?> deptList = sampleService.selectDeptList();
		List<?> jobList = empService.selectEmpJobList();
		
	
		
		model.addAttribute("vo",vo);
		model.addAttribute("deptList",deptList);
		model.addAttribute("jobList",jobList);
		return "emp/empModify";
	}
	
	@RequestMapping (value="empModifySave.do")
	public String updateEmp(EmpVO vo) throws Exception {
		int result = empService.updateEmp(vo);
		
		if(result == 1) {
			System.out.println("수정처리 완료");
		} else {
			System.out.println("수정처리 실패");
		}
		
		return "redirect:empList.do";
	}
	
	@RequestMapping ("empDelete.do")
	public String deleteEmp(int empno) throws Exception {
		int result = empService.deleteEmp(empno);
		if(result == 1) {
			System.out.println("삭제처리 완료");
		} else {
			System.out.println("삭제처리 실패");
		}
		
		return "redirect:empList.do";
	}
	
	
	
	
	
}
