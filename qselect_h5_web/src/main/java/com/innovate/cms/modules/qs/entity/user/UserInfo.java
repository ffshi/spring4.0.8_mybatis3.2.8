/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.entity.user;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.innovate.cms.common.persistence.DataEntity;

/**
 * 用户其他信息管理Entity
 * @author gaoji
 * @version 2015-12-21
 */
public class UserInfo extends DataEntity<UserInfo> {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// 用户ID
	private String historyPageNo;		// 用户做的最后一题ID
	
	public UserInfo() {
		super();
	}

	public UserInfo(String id){
		super(id);
	}

	@Length(min=1, max=64, message="用户ID长度必须介于 1 和 64 之间")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@NotNull(message="用户做的最后一题ID不能为空")
	public String getHistoryPageNo()
	{
		return historyPageNo;
	}

	public void setHistoryPageNo(String historyPageNo)
	{
		this.historyPageNo = historyPageNo;
	}
}