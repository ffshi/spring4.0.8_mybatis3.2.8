package com.innovate.cms.modules.qs.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.cms.common.service.CrudService;
import com.innovate.cms.modules.qs.dao.user.H5qgroupDao;
import com.innovate.cms.modules.qs.entity.user.H5qgroup;

@Service
@Transactional(readOnly = true)
public class H5qgroupService extends CrudService<H5qgroupDao, H5qgroup> {

	public H5qgroup findGroupByGid(int gid) {
		return super.dao.findGroupByGid(gid);
	}

}
