package com.bit.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bit.app.dao.GuestbookDAO;
import com.bit.app.vo.GuestbookVO;

@Repository
@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	GuestbookDAO dao;
	
	
	@Override
	public List<GuestbookVO> getList(int start, int end) {
		// TODO Auto-generated method stub
		System.out.println("======GUESTBOOK LIST service======");
		
		return dao.getList(start, end);
	}


	@Override
	public int insert(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return dao.insert(vo);
	}


	@Override
	public GuestbookVO select(int no) {
		// TODO Auto-generated method stub
		
		
		return dao.select(no);
	}


	@Override
	public int update(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}


	@Override
	public int delete(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return dao.delete(vo);
	}


	@Override
	public int countBook() {
		// TODO Auto-generated method stub
		return dao.countBook();
	}

	
	
	
}
