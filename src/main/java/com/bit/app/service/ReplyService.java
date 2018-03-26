package com.bit.app.service;

import java.util.List;

import com.bit.app.vo.ReplyVO;

public interface ReplyService {

    // ´ñ±Ûlist
    public List<ReplyVO> list(int bno);
    // ´ñ±Û»ðÀÔ
    public void create(ReplyVO vo);
    // ´ñ±Û¼öÁ¤
    public void update(ReplyVO vo);
    // ´ñ±Û»èÁ¦
    public void delete(int rno);
    
}