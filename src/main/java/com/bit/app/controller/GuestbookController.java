package com.bit.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.app.service.BoardPage;
import com.bit.app.service.GuestbookService;
import com.bit.app.vo.GuestbookVO;

 @Controller
 @RequestMapping("/guestbook")
 public class GuestbookController {
 @Autowired
 GuestbookService gs;
 
	 @RequestMapping(value="/insert", method=RequestMethod.POST)
	 public String insert(@ModelAttribute GuestbookVO vo){
		 System.out.println("=========방명록 insert controller========");
		 System.out.println(vo.getId());
		 System.out.println(vo.getPw());	 
		 System.out.println(vo.getContent());
		 System.out.println(gs.insert(vo));
	
	     return "redirect:/guestbook/list";
	 }
	  
	 
	 //@RequestParam(defaultValue = "1") int curpage)
	 @RequestMapping("/list")
	 public ModelAndView list(Model model, @RequestParam(defaultValue = "1") int curpage)
			 throws Exception {

		 System.out.println("================방명록LIST Controller======================");
		 int count = gs.countBook();
		 System.out.println(count);
		 
		//PAGE
			BoardPage bp = new BoardPage(count,curpage);
			int start = bp.getPageBegin();
			int end = bp.getPageEnd();			
		 
		List<GuestbookVO> list = gs.getList(start, end);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count); 
		//page
		map.put("bp", bp);
				
		ModelAndView mav = new ModelAndView();	
		
		mav.addObject("map", map); 
		mav.setViewName("/guestbook"); //boardlist.jsp로 
		
		return mav;
	 }
	 
	 @RequestMapping("/checkpw" )
	public String checkpw(@RequestParam int no, @RequestParam int check, Model model) {
		 
		 Map<String, Object> m = new HashMap<String, Object>();
		 
		 m.put("no", no);
		 m.put("check", check);
		 
		 
		 model.addAttribute("m", m);

		 return "checkpw";
	 }
	 
	 @RequestMapping("/modifyform")
	 public String modifyform (Model model, @ModelAttribute GuestbookVO vo) 
	 {
		 System.out.println("여기 오냐"+ vo.getNo());
		GuestbookVO gvo = gs.select(vo.getNo());
		if(vo.getPw().equals(gvo.getPw()))
		{
			model.addAttribute("gvo", gvo);
			return "modify";
		}

		return "close";	
	 }
	 
//	 @RequestMapping(value = "/modifyform2" , method = RequestMethod.POST)
//	 public String modifyform2 (@ModelAttribute GuestbookVO gvo) 
//	 {
//		 System.out.println("이거뜨면 넘어온거");
//		 return null;
//	 }
//	 
	
	 	
	 
	 @RequestMapping("/modify")
	 public String modify(@ModelAttribute GuestbookVO vo, Model model)
	 {
		 System.out.println("객체 받아왔냐"+ vo.getNo()+ vo.getId());
		 
		 System.out.println("수정된 객체 수: " + gs.update(vo));
		 

		 return "close";
		 
	 }
	 
	 @RequestMapping("/deleteform")
	 public String deleteform (Model model, @RequestParam int no, @RequestParam String pw) 
	 {
		 System.out.println("이거뜨면 넘어온거"+no);
		GuestbookVO gvo = gs.select(no);
		if(pw.equals(gvo.getPw()))
		{
			System.out.println("삭제된 객체 수: " + gs.delete(gvo));
			return "redirect:/guestbook/list";
		}
		 
		 return "redirect:/guestbook/list";
	 }	 
	
}
