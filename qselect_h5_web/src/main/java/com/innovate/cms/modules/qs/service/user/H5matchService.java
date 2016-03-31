package com.innovate.cms.modules.qs.service.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innovate.cms.common.service.CrudService;
import com.innovate.cms.modules.qs.dao.user.H5matchDao;
import com.innovate.cms.modules.qs.entity.user.H5match;

/**
 * 
 * @ClassName: H5matchService
 * @Description: 保存做题百分比Service
 * @author gaoji gaoji_cyou-inc_com
 * @date 2016年3月25日 下午2:43:23
 *
 */
@Service
@Transactional(readOnly = true)
public class H5matchService extends CrudService<H5matchDao, H5match> {
	@Transactional(readOnly = false)
	public void saveH5match(H5match h5match) {
		super.dao.saveH5match(h5match);
	}

	public int isMatched(int gid,String fopenid,String openid) {
		return super.dao.isMatched(gid,fopenid,openid);
	}

	public List<H5match> findAll(H5match match) {

		return super.dao.findAll(match);
	}

}
