/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.service.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.cms.common.persistence.Page;
import com.innovate.cms.common.service.CrudService;
import com.innovate.cms.common.utils.StringUtils;
import com.innovate.cms.modules.qs.entity.user.UserInfo;
import com.innovate.cms.modules.qs.dao.user.UserInfoDao;

/**
 * 用户其他信息管理Service
 * @author gaoji
 * @version 2015-12-21
 */
@Service
@Transactional(readOnly = true)
public class UserInfoService extends CrudService<UserInfoDao, UserInfo> {

	public UserInfo get(String id) {
		return super.get(id);
	}
	
	public List<UserInfo> findList(UserInfo userInfo) {
		return super.findList(userInfo);
	}
	
	public Page<UserInfo> findPage(Page<UserInfo> page, UserInfo userInfo) {
		return super.findPage(page, userInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(UserInfo userInfo) {
		if (StringUtils.isBlank(userInfo.getId()))	
		{
			userInfo.setIsNewRecord(true);
		}else {
			userInfo.setIsNewRecord(false);
		}
		super.save(userInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(UserInfo userInfo) {
		super.delete(userInfo);
	}
	
	/**
	 * 
	 * @Title: saveReport
	 * @Description: 保存举报信息
	 * @param uid	 用户ID
	 * @param qid   问题ID    
	 *
	 */
	@Transactional(readOnly = false)
	public void saveReport(String uid, int qid)
	{
		super.dao.saveReport(uid,qid);
	}
	
	/**
	 * 
	 * @Title: saveFeedback
	 * @Description: 保存反馈信息
	 * @param uid       用户ID
	 * @param content   反馈内容
	 * @param mobile    反馈人手机号
	 *
	 */
	@Transactional(readOnly = false)
	public void saveFeedback(String uid, String content, String mobile)
	{
		super.dao.saveFeedback(uid,content,mobile);
	}
	/**
	 * 
	 * @Title: getHistoryPageNo
	 * @Description: 查询历史做题页
	 * @param uid
	 * @return    返回类型 UserInfo
	 *
	 */
	public UserInfo getHistoryPageNo(String uid)
	{
		return super.dao.getHistoryPageNo(uid);
	}
	/**
	 * 
	 * @Title: getDefaultPageNo
	 * @Description: 查询默认做题页
	 * @return    返回 类似 1,1,1,1,1,的结果 
	 *
	 */
	public String getDefaultPageNo()
	{
		return super.dao.getDefaultPageNo().getHistoryPageNo();
	}
	/**
	 * 更新最新做题记录
	 * @Title: updateDefaultPageNo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param newHistoryPageNo    返回类型 void
	 *
	 */
	@Transactional(readOnly = false)
	public void updateDefaultPageNo(String newHistoryPageNo,String uid)
	{
		super.dao.updateDefaultPageNo(newHistoryPageNo, uid);
	}
	/**
	 * 
	 * @Title: insertDefaultPageNo
	 * @Description: 插入某用户ID 的 历史做题页
	 * @param defaultPageNo
	 * @param uid    返回类型 void
	 *
	 */
	@Transactional(readOnly = false)
	public void insertDefaultPageNo(String defaultPageNo, String uid)
	{
		super.dao.insertDefaultPageNo(defaultPageNo, uid);
	}


	
}