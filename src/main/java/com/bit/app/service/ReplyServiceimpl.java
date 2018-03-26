package com.bit.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.app.dao.ReplyDAO;
import com.bit.app.vo.ReplyVO;

@Service
public class ReplyServiceimpl implements ReplyService{
    @Autowired
    ReplyDAO dao;
    
    // ´ñ±Û ¸ñ·Ï
    @Override
    public List<ReplyVO> list(int b_no) {
    	System.out.println("=========== ´ñ±Û ¸®½ºÆ® service ==============");
//    	System.out.println("°Ô½Ã±Û ¹øÈ£ :  " + bno);    	
        return dao.list(b_no);
    }
    // ´ñ±Û ÀÛ¼º
    @Override
    public void create(ReplyVO vo) {
    	System.out.println("=========== ´ñ±Û ÀÛ¼º service ==============");
        dao.create(vo);
    }
    // ´ñ±Û ¼öÁ¤
    @Override
    public void update(ReplyVO vo) {
        // TODO Auto-generated method stub
 
    }
    // ´ñ±Û »èÁ¦
    @Override
    public void delete(int rno) {
        // TODO Auto-generated method stub
 
    }
}
