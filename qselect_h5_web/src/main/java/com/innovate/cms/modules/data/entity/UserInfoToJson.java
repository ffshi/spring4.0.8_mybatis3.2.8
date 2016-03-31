package com.innovate.cms.modules.data.entity;

import java.io.Serializable;
import java.util.Date;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserInfoToJson implements Serializable
{
	
	 
	private static final long serialVersionUID = 1L;
	/**
	 * 本地用户编号
	 */
	@Mapping("id")
	private String uid;
	/**
	 * 第三方唯一用户
	 */
	private String account;
	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 用户头像
	 */
	private String headPortrait;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 星座
	 */
	private String constellation;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 归属区域
	 */
	private String areaName;
	/**
	 * 归属省会
	 */
	private String areaProvince;
	/**
	 * 归属市级城市
	 */
	private String areaCity;

	public UserInfoToJson()
	{
		super();
	}
	
	public UserInfoToJson(String uid, String account, String userType, String headPortrait, String sex, String loginName,
			String mobile, String name, String constellation, Date birthday, String nickname, String email, String areaName,
			String areaProvince, String areaCity)
	{
		super();
		this.uid = uid;
		this.account = account;
		this.userType = userType;
		this.headPortrait = headPortrait;
		this.sex = sex;
		this.loginName = loginName;
		this.mobile = mobile;
		this.name = name;
		this.constellation = constellation;
		this.birthday = birthday;
		this.nickname = nickname;
		this.email = email;
		this.areaName = areaName;
		this.areaProvince = areaProvince;
		this.areaCity = areaCity;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getUid()
	{
		return this.uid;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getAccount()
	{
		return this.account;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	public String getUserType()
	{
		return this.userType;
	}

	public void setHeadPortrait(String headPortrait)
	{
		this.headPortrait = headPortrait;
	}
	/**
	 * 修改链接
	 * @Title: getHeadPortrait
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return    返回类型 String
	 *
	 */
	public String getHeadPortrait()
	{
		String imgUrl = this.headPortrait;
		return imgUrl;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getLoginName()
	{
		return this.loginName;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getMobile()
	{
		return this.mobile;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setConstellation(String constellation)
	{
		this.constellation = constellation;
	}

	public String getConstellation()
	{
		return this.constellation;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBirthday()
	{
		return this.birthday;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getNickname()
	{
		return this.nickname;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}

	public String getAreaName()
	{
		return this.areaName;
	}

	public void setAreaProvince(String areaProvince)
	{
		this.areaProvince = areaProvince;
	}

	public String getAreaProvince()
	{
		return this.areaProvince;
	}

	public void setAreaCity(String areaCity)
	{
		this.areaCity = areaCity;
	}

	public String getAreaCity()
	{
		return this.areaCity;
	}
}
