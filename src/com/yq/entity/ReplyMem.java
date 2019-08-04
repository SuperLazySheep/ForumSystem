package com.yq.entity;

import java.util.Date;

public class ReplyMem {
	private String membername;
	private String memberIcon;
	private Date regDate;
	private String replycontent;
	private Date publishtime;
	private Date modifytime;

	public ReplyMem() {
		super();
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberIcon() {
		return memberIcon;
	}

	public void setMemberIcon(String memberIcon) {
		this.memberIcon = memberIcon;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
