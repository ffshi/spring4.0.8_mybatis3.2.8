package com.innovate.cms.modules.data.entity;

import java.io.Serializable;

public class WXConfigToJson implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String url = "";
	private String jsapi_ticket = "";
	private String nonceStr = "";
	private String timestamp = "";
	private String signature = "";
	
	public WXConfigToJson()
	{
		super();
	}
	
	public WXConfigToJson(String url, String jsapi_ticket, String nonceStr, String timestamp, String signature)
	{
		super();
		this.url = url;
		this.jsapi_ticket = jsapi_ticket;
		this.nonceStr = nonceStr;
		this.timestamp = timestamp;
		this.signature = signature;
	}
	
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getJsapi_ticket()
	{
		return jsapi_ticket;
	}
	public void setJsapi_ticket(String jsapi_ticket)
	{
		this.jsapi_ticket = jsapi_ticket;
	}
	public String getNonceStr()
	{
		return nonceStr;
	}
	public void setNonceStr(String nonceStr)
	{
		this.nonceStr = nonceStr;
	}
	public String getTimestamp()
	{
		return timestamp;
	}
	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}
	public String getSignature()
	{
		return signature;
	}
	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	@Override
	public String toString()
	{
		return "WXConfigToJson [url=" + url + ", jsapi_ticket=" + jsapi_ticket + ", nonceStr=" + nonceStr + ", timestamp="
				+ timestamp + ", signature=" + signature + "]";
	}
	
}
