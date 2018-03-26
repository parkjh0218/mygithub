package com.bit.app.vo;

import java.sql.Timestamp;

public class ReplyVO {
  private int r_no;
  private int b_no;
  private String content;  
  private String id;
  private Timestamp timestamp;
  
public int getR_no() {
	return r_no;
}
public void setR_no(int r_no) {
	this.r_no = r_no;
}
public int getB_no() {
	return b_no;
}
public void setB_no(int b_no) {
	this.b_no = b_no;
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

  
}
