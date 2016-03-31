package com.innovate.cms.modules.qs.dao.user;

import java.util.List;

import com.innovate.cms.common.persistence.CrudDao;
import com.innovate.cms.common.persistence.annotation.MyBatisDao;
import com.innovate.cms.modules.data.entity.GroupQuestionToJson;
import com.innovate.cms.modules.qs.entity.user.H5question;

@MyBatisDao
public interface H5questionDao extends CrudDao<H5question> {

	public List<GroupQuestionToJson> findQuestionList(String[] qids);

}
