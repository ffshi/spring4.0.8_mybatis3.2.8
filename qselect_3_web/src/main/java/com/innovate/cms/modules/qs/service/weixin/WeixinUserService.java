/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.service.weixin;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.cms.common.persistence.Page;
import com.innovate.cms.common.service.CrudService;
import com.innovate.cms.common.utils.StringUtils;
import com.innovate.cms.modules.qs.entity.weixin.WeixinUser;
import com.innovate.cms.modules.qs.dao.weixin.WeixinUserDao;

/**
 * 微信账号管理Service
 * @author gaoji
 * @version 2016-02-29
 */
@Service
@Transactional(readOnly = true)
public class WeixinUserService extends CrudService<WeixinUserDao, WeixinUser> {

	public WeixinUser get(String id) {
		return super.get(id);
	}
	
	public List<WeixinUser> findList(WeixinUser weixinUser) {
		return super.findList(weixinUser);
	}
	
	public Page<WeixinUser> findPage(Page<WeixinUser> page, WeixinUser weixinUser) {
		return super.findPage(page, weixinUser);
	}
	
	@Transactional(readOnly = false)
	public void save(WeixinUser weixinUser) {
		if (StringUtils.isBlank(weixinUser.getId()))	
		{
			weixinUser.setIsNewRecord(true);
		}else {
			weixinUser.setIsNewRecord(false);
		}
		super.save(weixinUser);
	}
	
	@Transactional(readOnly = false)
	public void saveWeixinUser(WeixinUser weixinUser) {
		if (StringUtils.isBlank(weixinUser.getId()))	
		{
			super.dao.insert(weixinUser);
		}else {
			super.dao.update(weixinUser);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(WeixinUser weixinUser) {
		super.delete(weixinUser);
	}

	public WeixinUser getByOpenid(String openid)
	{
		return  super.dao.getByOpenid(openid);
	}
	
}