package com.bit.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.app.vo.ReplyVO;

@Repository
public class ReplyDAO {
	@Autowired
	SqlSession ss;
	
	// ´ñ±Û list
    public List<ReplyVO> list(int bno){
    	System.out.println("=========´ñ±Ûlist DAO=========");
    	 return ss.selectList("replylist", bno);
    }
    // ´ñ±ÛÀÔ·Â
    public void create(ReplyVO vo) {
    	System.out.println("===========´ñ±Û insert DAO============");
         ss.insert("replyinsert", vo);
    }
    // ´ñ±Û¼öÁ¤
    public void update(ReplyVO vo) {
    	
    }
    // ´ñ±Û»èÁ¦
    public void delete(Integer rno) {
    	
    }
}
