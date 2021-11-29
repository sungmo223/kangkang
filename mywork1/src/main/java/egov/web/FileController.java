package egov.web;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
	

	
	@RequestMapping("fileboardWrite.do")
	public String fileboardWrite() throws Exception {
		
		return "admin/fileWrite";
	}
	
	@RequestMapping("fileBoardWriteSave.do")
	@ResponseBody
	public String insertFileboard(MultipartHttpServletRequest multiRequest) 
													throws Exception {
		
		// fileupload 메소드 호출
		fileupload(multiRequest);
		
		
		return "";
	}
	
									// 자료저장 구조를 가지고있는 Class
	public static String fileupload(MultipartHttpServletRequest multiRequest) 
													throws Exception {
		
		MultipartFile file;
		// directory 경로
	    String save_dir = "/Users/ksr/Documents/upload";
	    String save_file  = "";
	   
	    /* 클래스는 실행하는 즉시 메모리화. 
	     {a.jpg} {b.jpg} 라는 데이터가 올라오면  맵형태로 저장됨! 
	     --> {"aaa": dsfjlkwjesdlk.xcxxvc, a.jpg , 98byte , image } , {"bbsd": sajflsdkf.xxxs, b.jpg , 100byte, image }
	    	
	    */
	    Map<String, MultipartFile> files = multiRequest.getFileMap();
	      						//getFileMap을 통해 map에 담긴내용을 가지고 옴 
	   
	    
	    /* map안의 내용들을 꺼낼때는 iterator 사용 
	     	-- 불규칙한 map의 key를 가져옴 (배열은 자리의번호인 0,1,2...등으로 규칙적)
	    */										
	    								// itr의 값이 key! 
	    Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
	    			//hasNext() : 존재유무를 물음 
	    while (itr.hasNext()) {						
	    							//.next() : 내용을 가지고옴.
	        Entry<String, MultipartFile> entry = itr.next();
	        file = entry.getValue();
	     // 맵의 내용을 물리적인요소로 인식하게 해주는 ? 파일의 대한 인식 
	        //copy를 위한 if문 
	        					
	        if (!"".equals(file.getOriginalFilename())) {
	           save_file = save_dir + "/" + file.getOriginalFilename();
	        //             디렉토리에......메소드를통해 오리지널 파일이름인 a.jpg가저옴.
	           file.transferTo(new File(save_file));
	           		// save_file의 경로로 이동(복사). 
	         }
	      }
		
	    
		return "";
	}
	
	
	
}
