package com.bit.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bit.app.vo.BoardVO;

public interface BoardService {
    //작성
    public void create(BoardVO vo) throws Exception;
    //상세보기
    public BoardVO read(int bno) throws Exception;
    //수정
    public void update(BoardVO vo) throws Exception;
    //삭제
    public void delete(int bno) throws Exception;
    //전체 list
  //  public List<BoardVO> listAll() throws Exception;
    //조회
    public void increaseViewcnt(int bno, HttpSession session) throws Exception;
    
    //search(검색)
    //페이징 , 검색옵션, 키워드 검색 
    public List<BoardVO> listAll(int start, int end, String search, String keyword) throws Exception;
    //레코드 갯수 
    public int countArticle(String search, String keyword) throws Exception;
    //
    
    
}
