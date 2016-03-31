package com.innovate.cms.modules.qs.entity.user;

import java.util.Date;

import com.innovate.cms.common.persistence.DataEntity;

/**
 * 
 * @author shifangfang
 *
 */
public class H5qgroup extends DataEntity<H5qgroup> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mysqlid;
	private String questions;
	private String title;
	private String description;
	private Date createTime;

	public H5qgroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMysqlid() {
		return mysqlid;
	}

	public void setMysqlid(int mysqlid) {
		this.mysqlid = mysqlid;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
