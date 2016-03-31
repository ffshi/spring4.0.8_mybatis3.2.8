/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.dao.weixin;

import org.apache.ibatis.annotations.Param;

import com.innovate.cms.common.persistence.CrudDao;
import com.innovate.cms.common.persistence.annotation.MyBatisDao;
import com.innovate.cms.modules.qs.entity.weixin.WeixinUser;

/**
 * 微信账号管理DAO接口
 * @author gaoji
 * @version 2016-02-29
 */
@MyBatisDao
public interface WeixinUserDao extends CrudDao<WeixinUser> {
	/**
	 * 
	 * @Title: getByOpenid
	 * @Description: 根据openid查询一条数据
	 * @param openid
	 * @return    返回类型 WeixinUser
	 *
	 */
	public WeixinUser getByOpenid(@Param("openid") String openid);
	
}