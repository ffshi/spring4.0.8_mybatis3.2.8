/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.dao.user;

import com.innovate.cms.common.persistence.CrudDao;
import com.innovate.cms.common.persistence.annotation.MyBatisDao;
import com.innovate.cms.modules.qs.entity.user.H5user;

/**
 * 用户其他信息管理DAO接口
 * 
 * @author gaoji
 * @version 2015-12-21
 */
@MyBatisDao
public interface H5userDao extends CrudDao<H5user> {
	
}