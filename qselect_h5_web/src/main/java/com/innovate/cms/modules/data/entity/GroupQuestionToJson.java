package com.innovate.cms.modules.data.entity;

import java.io.Serializable;

public class GroupQuestionToJson implements Serializable {

	private static final long serialVersionUID = 1L;

	// private int qid; // 问题ID

	private String description; // 问题内容

	private String qa; // 选项A

	private String qb; // 选项B

	public GroupQuestionToJson() {
		super();
	}

	public GroupQuestionToJson(int qid, String description, String qa, String qb) {
		super();
		// this.qid = qid;
		this.description = description;
		this.qa = qa;
		this.qb = qb;
	}

	


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
