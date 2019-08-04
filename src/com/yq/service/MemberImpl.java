package com.yq.service;

import java.util.ArrayList;
import java.util.List;

import com.yq.dao.MemberDao;
import com.yq.entity.Board;
import com.yq.entity.Count;
import com.yq.entity.Forcum;
import com.yq.entity.Member;
import com.yq.entity.Reply;
import com.yq.entity.ReplyMem;
import com.yq.entity.Sticker;
import com.yq.entity.Test;
import com.yq.entity.Topic;

import cn.yq.dao.BaseDao;

public class MemberImpl extends BaseDao implements MemberDao {

	/**
	 * 添加用户
	 */
	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		list.add(member.getMembername());
		list.add(member.getMemberpwd());
		list.add(member.getMembericon());
		list.add(member.getMembercity());
		list.add(member.getMembergender());
		list.add(member.getMemberprovince());
		super.setParams(list);
		return super.update("insert into member value(0,?,?,?,?,?,?,1,1,1,now())");
	}

	/**
	 * 登录查询用户
	 */
	@Override
	public List searchMember(String uname, String upass) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<Object>();
		list.add(uname);
		list.add(upass);
		super.setParams(list);
		return super.query("SELECT * FROM member WHERE memberName=? AND memberPwd=?", Member.class);
	}

	/**
	 * index界面显示
	 */
	@Override
	public List getBoard() {
		// TODO Auto-generated method stub
		return super.query("SELECT * FROM board", Board.class);
	}

	@Override
	public List getForcum() {
		// TODO Auto-generated method stub
		return super.query("SELECT * FROM forcum", Forcum.class);
	}

	@Override
	public List gettotal() {
		// TODO Auto-generated method stub
		return super.query(
				"SELECT b.boardId,b.boardName,COUNT(t.boardId) total FROM topic t,board b WHERE b.boardId=t.boardId GROUP BY b.boardName",
				Count.class);
	}

	/**
	 * list界面显示
	 */
	@Override
	public List getSticker(String boardid) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList();
		list.add(boardid);
		super.setParams(list);
		return super.query(
				"SELECT b.boardName,b.boardId,t.topicCaption,t.lastReplyUser,t.topicid FROM topic t JOIN board b ON b.boardId=t.boardId AND b.boardId=?"
				,Sticker.class);
	}

	public List getBoardName(String boardid) {
		List<Object> list = new ArrayList();
		list.add(boardid);
		super.setParams(list);
		return super.query("select * from board where boardid=?", Board.class);
	}
	/**
	 * post界面显示
	 */
	@Override
	public List getMember(String membername) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList();
		list.add(membername);
		super.setParams(list);
		return super.query("select * from Member where memberName=?", Member.class) ;
	}
	public int insertTopic(Topic t) {
		List<Object> list = new ArrayList();
		list.add(t.getTopicCaption());
		list.add(t.getTopicContent());
		list.add(t.getBoardId());
		list.add(t.getMemberId());
		list.add(t.getLastReplyUser());
		super.setParams(list);
		return super.update("insert into topic values(0,?,?,?,?,0,now(),now(),?,now())");
	}	
	/**
	 * detail界面
	 */
	@Override
	public List getTopic(String tid) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList();
		list.add(tid);
		super.setParams(list);
		return super.query("select * from topic where topicId=?", Topic.class);
	}

	@Override
	public List getreplyMem(String tid) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList();
		list.add(tid);
		super.setParams(list);
		return super.query("SELECT m.memberName,m.memberIcon,m.regDate,r.replycontent,r.publishTime,r.modifytime FROM member m JOIN reply r ON m.memberId=r.memberid AND r.topicid=?"
				, ReplyMem.class);
	}
	/**
	 * reply界面
	 */
	@Override
	public int insertReply(Reply r) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList();
		list.add(r.getBoardid());
		list.add(r.getTopicid());
		list.add(r.getMemberid());
		list.add(r.getReplycontent());
		super.setParams(list);
		return super.update("insert into reply values(0,?,?,?,?,now(),now())");
	}

	@Override
	public List gettotal2() {
		// TODO Auto-generated method stub
		return super.query("SELECT t.topicId,t.boardId FROM topic t GROUP BY t.boardId;", Test.class);
	}
}
