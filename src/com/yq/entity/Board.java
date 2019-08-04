package com.yq.entity;

import java.util.Date;

public class Board {
	private int boardid;
	private String boardName;
	private Date creatDate;
	private int forcumid;
	private int memberid;
	public Board() {
		super();
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public int getForcumid() {
		return forcumid;
	}
	public void setForcumid(int forcumid) {
		this.forcumid = forcumid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	
	
}
