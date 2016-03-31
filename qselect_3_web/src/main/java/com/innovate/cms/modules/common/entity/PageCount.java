package com.innovate.cms.modules.common.entity;

import java.io.Serializable;

public class PageCount  implements Serializable
{
	
	
	private static final long serialVersionUID = 1L;
	/**
     * 总条数
     */
    protected int totalCount;
    
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
    
}
