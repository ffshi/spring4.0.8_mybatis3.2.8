package com.innovate.cms.modules.common.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @ClassName: BackInfo
 * @Description: 统一返回对象
 * @author gaoji gaoji_cyou-inc_com
 * @date 2015年12月28日 下午2:11:32
 *
 * @param <T> 泛型对象
 */
public class BackInfo<T> implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 返回代码
	 */
	private int stateCode;
	/**
	 * 返回信息
	 */
	private String retMsg;
	/**
	 * 总页数
	 */
	private int  totalResult;
	/**
	 * 集合数据
	 */
	private List<T> data;

	public void setStateCode(int stateCode)
	{
		this.stateCode = stateCode;
	}

	public int getStateCode()
	{
		return this.stateCode;
	}

	public void setRetMsg(String retMsg)
	{
		this.retMsg = retMsg;
	}

	public String getRetMsg()
	{
		return this.retMsg;
	}

	public List<T> getData()
	{
		return data;
	}

	public void setData(List<T> data)
	{
		this.data = data;
	}

	public int getTotalResult()
	{
		return totalResult;
	}

	public void setTotalResult(int totalResult)
	{
		this.totalResult = totalResult;
	}

	

	
	
}