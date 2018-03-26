package com.bit.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.app.vo.BoardVO;

@Repository
public class BoardDAO {
    @Autowired
    SqlSession ss;
	//작성
    public void create(BoardVO vo) throws Exception {
    	System.out.println("======게시글 작성 DAO =====");
    	ss.insert("boardinsert", vo);
    }
    //상세
    public BoardVO read(int bno) throws Exception {
    	System.out.println("==============================readDAO===============================");
        return ss.selectOne("boardview", bno);
    }
    //수정    
    public void update(BoardVO vo) throws Exception {
    	ss.update("boardupdate", vo);
    }
    //삭제    
    public void delete(int bno) throws Exception {
    	ss.delete("boarddelete",bno);
    }
//    //전체 list    
//    public List<BoardVO> listAll() throws Exception {
//    	System.out.println("==============================DAO ===============================");
//        return ss.selectList("boardlistAll");
//    }
    //조회수 증가    
    public void increaseViewcnt(int no) throws Exception {
    	System.out.println("==============================조회수DAO ===============================");
    	ss.update("boardincreaseViewcnt", no);
    }
    
    
    //Search
    //페이징
    //게시글 목록 ==> 검색옵션, 키워드
    
    public List<BoardVO> listAll(int start, int end ,String search, String keyword) throws Exception{
    	System.out.println("======BOARD LIST dao======");
    	Map<String, Object> map = new HashMap<String,Object>();
        map.put("search", search);
        map.put("keyword", keyword);
        //페이징 
        map.put("start",start);
        map.put("end", end);
        
        return ss.selectList("boardlistAll", map);

    }
    //게시글 레코드 갯수
    public int countArticle(String search, String keyword) throws Exception{
    	System.out.println("=====SEARCHcount DAO  ===== ");
    	 Map<String, String> map = new HashMap<String, String>();
    	    map.put("search", search);
    	    map.put("keyword", keyword);
    	    return ss.selectOne("boardcountArticle", map);

    }
}
