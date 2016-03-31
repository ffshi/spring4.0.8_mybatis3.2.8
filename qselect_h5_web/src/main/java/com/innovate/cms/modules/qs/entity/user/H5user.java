package com.innovate.cms.modules.qs.entity.user;

import com.innovate.cms.common.persistence.DataEntity;

/**
 * 
 * @author shifangfang
 *
 */
public class H5user extends DataEntity<H5user> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String openid;
	private String pic;
	private String nickName;

	public H5user() {
		super();
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
