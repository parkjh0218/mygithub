package com.bit.app.service;

import java.util.List;

import com.bit.app.vo.GuestbookVO;

public interface GuestbookService {

	public List<GuestbookVO> getList(int start, int end);
	
	public int insert(GuestbookVO vo);
	
	public GuestbookVO select(int no);
   ////////////////////////////////////////여기서부터! 	
	public int update (GuestbookVO vo);
	
	public int delete (GuestbookVO vo);
	
	public int countBook() ;
	
}
