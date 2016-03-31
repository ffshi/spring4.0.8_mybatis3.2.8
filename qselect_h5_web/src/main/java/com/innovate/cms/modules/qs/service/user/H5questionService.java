package com.innovate.cms.modules.qs.service.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.cms.common.service.CrudService;
import com.innovate.cms.modules.data.entity.GroupQuestionToJson;
import com.innovate.cms.modules.qs.dao.user.H5questionDao;
import com.innovate.cms.modules.qs.entity.user.H5question;
@Service
@Transactional(readOnly = true)
public class H5questionService  extends CrudService<H5questionDao, H5question> {

	public List<GroupQuestionToJson> findQuestionList(String[] qids) {
		// TODO Auto-generated method stub
		return super.dao.findQuestionList(qids);
	}

}
