/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.entity.weixin;

import org.hibernate.validator.constraints.Length;

import com.innovate.cms.common.persistence.DataEntity;

/**
 * 微信账号管理Entity
 * @author gaoji
 * @version 2016-02-29
 */
public class WeixinUser extends DataEntity<WeixinUser> {
	
	private static final long serialVersionUID = 1L;
	private String openid;		// 用户的唯一标识
	private String nickname;		// 用户昵称
	private String sex;		// 用户的性别
	private String province;		// 省份
	private String city;		// 城市
	private String country;		// 国家
	private String headimgurl;		// 用户头像
	private String privilege;		// 用户特权信息
	private String unionid;		// UnionID机制
	private String accessToken;		// 网页授权接口调用凭证,与基础支持的access_token不同
	private String refreshToken;		// 用户刷新access_token
	private String lang;		// 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	private String expiresIn;		// access_token接口调用凭证超时时间，单位（秒）
	
	public WeixinUser() {
		super();
	}

	public WeixinUser(String id){
		super(id);
	}

	@Length(min=1, max=64, message="用户的唯一标识长度必须介于 1 和 64 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=64, message="用户昵称长度必须介于 0 和 64 之间")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=2, message="用户的性别长度必须介于 0 和 2 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=20, message="省份长度必须介于 0 和 20 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=20, message="城市长度必须介于 0 和 20 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=20, message="国家长度必须介于 0 和 20 之间")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Length(min=0, max=1000, message="用户头像长度必须介于 0 和 1000 之间")
	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	@Length(min=0, max=1000, message="用户特权信息长度必须介于 0 和 1000 之间")
	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	@Length(min=0, max=100, message="UnionID机制长度必须介于 0 和 100 之间")
	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Length(min=0, max=300, message="网页授权接口调用凭证,与基础支持的access_token不同长度必须介于 0 和 300 之间")
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Length(min=0, max=300, message="用户刷新access_token长度必须介于 0 和 300 之间")
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	@Length(min=0, max=10, message="返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语长度必须介于 0 和 10 之间")
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	@Length(min=0, max=11, message="access_token接口调用凭证超时时间，单位（秒）长度必须介于 0 和 11 之间")
	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}