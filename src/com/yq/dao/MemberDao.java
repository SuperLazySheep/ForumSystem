package com.yq.dao;

import java.util.List;

import com.yq.entity.Member;
import com.yq.entity.Reply;
import com.yq.entity.Topic;

public interface MemberDao{
	
	//�����û�
	public int insertMember(Member member);
	//��ѯ�û�
	public List searchMember(String name,String pass);
	//index�������
	public List getForcum();//����
	public List getBoard();//С���
	public List gettotal();//����
	public List gettotal2();
	//list����
	public List getSticker(String doardid);//������
	//post����
	public List getMember(String membername);
	public int insertTopic(Topic topic);//�������
	//detail����
	public List getTopic(String tid);
	public List getreplyMem(String tid);//��ʾ�ظ�
	//reply����
	public int insertReply(Reply r);
}
