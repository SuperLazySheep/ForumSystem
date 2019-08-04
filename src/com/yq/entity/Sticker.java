package com.yq.entity;

public class Sticker {
	private int topicid;
	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}

	private String boardname;
	private int boardid;
	private String topicCaption;
	private String lastReplyUser;

	public Sticker() {
		super();
	}

	public String getBoardname() {
		return boardname;
	}

	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public String getTopicCaption() {
		return topicCaption;
	}

	public void setTopicCaption(String topicCaption) {
		this.topicCaption = topicCaption;
	}

	public String getLastReplyUser() {
		return lastReplyUser;
	}

	public void setLastReplyUser(String lastReplyUser) {
		this.lastReplyUser = lastReplyUser;
	}

}
