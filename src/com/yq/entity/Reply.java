package com.yq.entity;

import java.util.Date;

public class Reply {
	private int replyid;
	private int boardid;
	private int topicid;
	private int memberid;
	private String replycontent;
	private Date publishtime;
	private Date modifytime;

	public Reply() {
		super();
	}

	public Reply(int boardid, int topicid, int memberid, String replycontent) {
		super();
		this.boardid = boardid;
		this.topicid = topicid;
		this.memberid = memberid;
		this.replycontent = replycontent;
	}

	public int getReplyid() {
		return replyid;
	}

	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}
