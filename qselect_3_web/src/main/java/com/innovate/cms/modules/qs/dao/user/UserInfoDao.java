/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.dao.user;

import org.apache.ibatis.annotations.Param;

import com.innovate.cms.common.persistence.CrudDao;
import com.innovate.cms.common.persistence.annotation.MyBatisDao;
import com.innovate.cms.modules.qs.entity.user.UserInfo;

/**
 * 用户其他信息管理DAO接口
 * @author gaoji
 * @version 2015-12-21
 */
@MyBatisDao
public interface UserInfoDao extends CrudDao<UserInfo> {
	/**
	 * 
	 * @Title: saveReport
	 * @Description: 新增举报
	 * @param uid
	 * @param qid    返回类型 void
	 *
	 */
	public void saveReport(@Param("uid") String uid, @Param("qid") int qid);
	/**
	 * 
	 * @Title: saveFeedback
	 * @Description: 新增反馈
	 * @param uid
	 * @param content
	 * @param mobile    返回类型 void
	 *
	 */
	public void saveFeedback(@Param("uid") String uid,@Param("content") String content, @Param("mobile") String mobile);
	/**
	 * 
	 * @Title: getDefaultPageNo
	 * @Description: 查询默认新用户历史做题页结果
	 * @return    返回类型 UserInfo
	 *
	 */
	public UserInfo getDefaultPageNo();
	/**
	 * 
	 * @Title: getHistoryPageNo
	 * @Description: 查询所有频道历史做题页结果
	 * @param uid
	 * @return    返回类型 UserInfo
	 *
	 */
	public UserInfo getHistoryPageNo(@Param("uid") String uid);
	/**
	 * 
	 * @Title: updateDefaultPageNo
	 * @Description: 更新历史记录页
	 * @param newHistoryPageNo
	 * @return    返回类型 Object
	 *
	 */
	public int updateDefaultPageNo(@Param("historyPageNo") String newHistoryPageNo,@Param("uid") String uid);
	/**
	 * 插入默认历史记录页
	 * @Title: insertDefaultPageNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param defaultPageNo
	 * @param uid
	 * @return    返回类型 int
	 *
	 */
	public int insertDefaultPageNo(@Param("historyPageNo")  String defaultPageNo,@Param("uid")  String uid);
}