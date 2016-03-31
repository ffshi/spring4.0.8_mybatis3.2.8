package com.innovate.cms.modules.qs.dao.user;

import org.apache.ibatis.annotations.Param;

import com.innovate.cms.common.persistence.CrudDao;
import com.innovate.cms.common.persistence.annotation.MyBatisDao;
import com.innovate.cms.modules.qs.entity.user.H5qgroup;

@MyBatisDao
public interface H5qgroupDao extends CrudDao<H5qgroup> {

	
	public H5qgroup findGroupByGid(@Param("id")  int gid);

}
