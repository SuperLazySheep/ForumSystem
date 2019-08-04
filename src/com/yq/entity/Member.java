package com.yq.entity;

import java.util.Date;

public class Member {
	private int memberid;
	private String membername;
	private String memberpwd;
	private String membericon;
	private String membercity;
	private String membergender;
	private String memberprovince;
	private int isadmin;
	private int ispass;
	private int ispower;
	private Date regdate;
	
	public Member() {
		super();
	}
	
	
	public Member(String membername) {
		super();
		this.membername = membername;
	}


	public Member(String membername, String memberpwd, String membericon, String membercity, String membergender,
			String memberprovince) {
		super();
		this.membername = membername;
		this.memberpwd = memberpwd;
		this.membericon = membericon;
		this.membercity = membercity;
		this.membergender = membergender;
		this.memberprovince = memberprovince;
	}

	public String getMemberprovince() {
		return memberprovince;
	}

	public void setMemberprovince(String memberprovince) {
		this.memberprovince = memberprovince;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberpwd() {
		return memberpwd;
	}

	public void setMemberpwd(String memberpwd) {
		this.memberpwd = memberpwd;
	}

	public String getMembericon() {
		return membericon;
	}

	public void setMembericon(String membericon) {
		this.membericon = membericon;
	}

	
	public String getMembercity() {
		return membercity;
	}

	public void setMembercity(String membercity) {
		this.membercity = membercity;
	}

	public String getMembergender() {
		return membergender;
	}

	public void setMembergender(String membergender) {
		this.membergender = membergender;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	public int getIspass() {
		return ispass;
	}

	public void setIspass(int ispass) {
		this.ispass = ispass;
	}

	public int getIspower() {
		return ispower;
	}

	public void setIspower(int ispower) {
		this.ispower = ispower;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
}
