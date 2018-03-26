package com.bit.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.app.service.BoardPage;
import com.bit.app.service.BoardService;
import com.bit.app.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
 
	@Autowired
	BoardService bs;
    
    //게시글 작성
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write(){
    	System.out.println("=======wirtejsp로이동 ======");
        return "/write"; // write.jsp로 이동
    }
    
    //게시글 작성처리
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(@ModelAttribute BoardVO vo) throws Exception{
    	System.out.println("======게시글 작성 컨트롤러 =====");
        bs.create(vo);
        return "redirect:list";
    }
    
    //상세내용,조회수 증가
    @RequestMapping(value="/view/{no}", method=RequestMethod.GET)
    public ModelAndView view(@PathVariable("no") int no, HttpSession session) throws Exception{    	
        // 조회수 증가 처리
        bs.increaseViewcnt(no, session);
        ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("/detail");
        // 뷰에 전달할 데이터
        mav.addObject("vo", bs.read(no));
        return mav;
    }
    
    //게시글 수정   
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO vo) throws Exception{
    	System.out.println("========게시글 수정 컨트롤러=========");
        bs.update(vo);
        
        return "redirect:list";
    }
    
    // 게시글 삭제
    @RequestMapping("/delete")
    public String delete(@RequestParam int no) throws Exception{
        bs.delete(no);
        return "redirect:list";
    }
        
    //게시글 전체 list & Search list 
    @RequestMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue = "all") String search,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int curpage			
			) throws Exception {
    	
    	System.out.println("======BOARD LIST Controller======");
    	
		// 게시글 갯수
		int count = bs.countArticle(search, keyword);    	
		
	    //PAGE
		BoardPage bp = new BoardPage(count,curpage);
		int start = bp.getPageBegin();
		int end = bp.getPageEnd();				
		
    	//게시글 list
		List<BoardVO> list = bs.listAll(start,end, search, keyword);
								
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); // list
		map.put("count", count); // 레코드의 갯수
		map.put("search", search); // 검색옵션
		map.put("keyword", keyword); // 검색키워드
		//page
		map.put("bp", bp);
				
		ModelAndView mav = new ModelAndView();		
		mav.addObject("map", map); 
		mav.setViewName("/boardlist"); //boardlist.jsp로 
		return mav;
	}

}
