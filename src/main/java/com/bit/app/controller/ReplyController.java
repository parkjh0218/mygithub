package com.bit.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.app.service.ReplyService;
import com.bit.app.vo.ReplyVO;

 @Controller
 @RequestMapping("/reply")
 public class ReplyController {
 @Autowired
 ReplyService rs;
 
 //¥Ò±€ ¿‘∑¬
 @RequestMapping(value="/insert", method=RequestMethod.POST)
 @ResponseBody
 public String insert(@ModelAttribute ReplyVO vo, HttpSession session){	 
	 System.out.println("=========¥Ò±€ insert controller========");
     //String userId = (String) session.getAttribute("userId");
     //vo.setReplyer(userId);
	 System.out.println(vo.getContent());	 
	 System.out.println(vo.getB_no());
     rs.create(vo);
     return null;
 }
 
 //¥Ò±€ ∏Ò∑œ // view ∏Æ≈œ 
 @RequestMapping(value="/list/{no}", method=RequestMethod.GET)
 public ModelAndView list(@PathVariable("no") int b_no){
	 System.out.println("================¥Ò±€LIST Controller======================");
     List<ReplyVO> list = rs.list(b_no);
     // ∫‰¿Ã∏ß ¡ˆ¡§
     ModelAndView mav = new ModelAndView();
     mav.setViewName("/replylist");//replylist.jsp
     // ∫‰ø° ¿¸¥ﬁ«“ µ•¿Ã≈Õ ¡ˆ¡§
     mav.addObject("list", list);
     System.out.println("SIZE ::" +list.size());
     return mav;
 }
  
}
