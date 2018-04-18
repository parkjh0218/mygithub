package com.bit.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bit.app.dao.BoardDAO;
import com.bit.app.vo.BoardVO;

@Repository
@Service
public class BoardServiceimpl implements BoardService{
@Autowired
BoardDAO dao;

@Override
public void create(BoardVO vo) throws Exception {
	// TODO Auto-generated method stub
	dao.create(vo);
}

@Override
public BoardVO read(int no) throws Exception {
	// TODO Auto-generated method stub
	 return dao.read(no);
}

@Override
public void update(BoardVO vo) throws Exception {
	// TODO Auto-generated method stub
     dao.update(vo);
}

@Override
public void delete(int no) throws Exception {
	// TODO Auto-generated method stub
	dao.delete(no);

}

//@Override
//public List<BoardVO> listAll() throws Exception {
//	// TODO Auto-generated method stub
//	   return dao.listAll();
//}

@Override
public void increaseViewcnt(int no, HttpSession session) throws Exception {
	// TODO Auto-generated method stub
	 long update_time = 0;
     long current_time = System.currentTimeMillis();
     if(current_time - update_time > 5*1000){
         dao.increaseViewcnt(no);
         // 세션에 시간을 저장 : "update_time_"+no -> 다른변수와 중복되지 않게 
         session.setAttribute("update_time_"+no, current_time);
         
     }

}

//search
//paging
@Override
public List<BoardVO> listAll(int start, int end,String search, String keyword) throws Exception {
	System.out.println("======BOARD LIST service======");
 return dao.listAll(start, end, search, keyword);
}

//레코드 개수 
@Override
public int countArticle(String search, String keyword) throws Exception {
 return dao.countArticle(search, keyword);
}




}
