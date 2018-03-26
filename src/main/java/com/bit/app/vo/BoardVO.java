package com.bit.app.vo;

import java.sql.Timestamp;

public class BoardVO {
 private int no;
 private String title;
 private String content;
 private String id;
 private Timestamp timestamp;
 private int hit;
 
 //댓글에 대한 내용
 
 private String username; 
 private int replycount;
 
 
 
  BoardVO(){}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getReplycount() {
	return replycount;
}

public void setReplycount(int replycount) {
	this.replycount = replycount;
}

public int getNo() {
	return no;
}

public void setNo(int no) {
	this.no = no;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Timestamp getTimestamp() {
	return timestamp;
}

public void setTimestamp(Timestamp timestamp) {
	this.timestamp = timestamp;
}

public int getHit() {
	return hit;
}

public void setHit(int hit) {
	this.hit = hit;
}


  
}
