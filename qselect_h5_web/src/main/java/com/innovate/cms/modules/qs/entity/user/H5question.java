package com.innovate.cms.modules.qs.entity.user;

import java.util.Date;

import com.innovate.cms.common.persistence.DataEntity;

/**
 * 
 * @author shifangfang
 *
 */
public class H5question extends DataEntity<H5question> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mysqlid;
	private String qa;
	private String qb;
	private String description;

	private Date createTime;

	public H5question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMysqlid() {
		return mysqlid;
	}

	public void setMysqlid(int mysqlid) {
		this.mysqlid = mysqlid;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public String getQb() {
		return qb;
	}

	public void setQb(String qb) {
		this.qb = qb;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
