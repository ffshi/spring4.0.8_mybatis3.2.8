package com.innovate.cms.modules.qs.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.innovate.cms.common.persistence.CrudDao;
import com.innovate.cms.common.persistence.annotation.MyBatisDao;
import com.innovate.cms.modules.qs.entity.user.H5match;

/**
 * 
 * @ClassName: H5matchDao
 * @Description: 保存做题百分比结果
 * @author gaoji gaoji_cyou-inc_com
 * @date 2016年3月25日 下午2:42:04
 *
 */
@MyBatisDao
public interface H5matchDao extends CrudDao<H5match> {
	/**
	 * 
	 * @Title: saveH5match
	 * @Description: 保存做题对比百分比结果
	 * @param h5match
	 *            返回类型 void
	 *
	 */
	public void saveH5match(H5match h5match);

	public int isMatched(@Param("gid") int gid, @Param("fopenid") String fopenid, @Param("openid") String opendid);

	public List<H5match> findAll(H5match match);

}
