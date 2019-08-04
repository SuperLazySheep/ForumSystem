package com.yq.dao;

import java.util.List;

import com.yq.entity.Member;
import com.yq.entity.Reply;
import com.yq.entity.Topic;

public interface MemberDao{
	
	//增加用户
	public int insertMember(Member member);
	//查询用户
	public List searchMember(String name,String pass);
	//index界面查找
	public List getForcum();//大版块
	public List getBoard();//小版块
	public List gettotal();//数量
	public List gettotal2();
	//list界面
	public List getSticker(String doardid);//主帖子
	//post界面
	public List getMember(String membername);
	public int insertTopic(Topic topic);//添加帖子
	//detail界面
	public List getTopic(String tid);
	public List getreplyMem(String tid);//显示回复
	//reply界面
	public int insertReply(Reply r);
}
