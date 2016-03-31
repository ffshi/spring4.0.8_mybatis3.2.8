package com.innovate.cms.modules.common.entity;

import java.io.Serializable;

/**
 * 记录是否做过题组
 * 
 * @author shifangfang
 *
 */
public class BackInfoMatch<T> extends BackInfo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DONE = 1;
	public static final int UNDO = 0;
	// 是否做过题组0:没做过 1：做过
	private int isMatched;

	public BackInfoMatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIsMatched() {
		return isMatched;
	}

	public void setIsMatched(int isMatched) {
		this.isMatched = isMatched;
	}

}
