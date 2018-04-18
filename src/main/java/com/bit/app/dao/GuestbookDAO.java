package com.bit.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.app.vo.GuestbookVO;

@Repository
public class GuestbookDAO {

	@Autowired
	SqlSession ss;
	
	public List<GuestbookVO> getList(int start, int end)
	{
		System.out.println("======guestbook LIST dao======");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("start",start);
        map.put("end", end);
        
        System.out.println("이거 나오냐"+map.put("end", end));
		return ss.selectList("gListAll", map);
		
	}
	
	public int insert (GuestbookVO vo)
	{
		return ss.insert("insertbook", vo);
	}
	
	public GuestbookVO select (int no)
	{
		return ss.selectOne("selectBook", no);
	}
	
	public int update(GuestbookVO vo)
	{
		
		return ss.update("updateBook", vo);
	}
	public int delete(GuestbookVO vo)
	{
		
		return ss.delete("deleteBook", vo);
	}
	
	public int countBook()
	{
		return ss.selectOne("countBook");
	}
	
	
	
}
