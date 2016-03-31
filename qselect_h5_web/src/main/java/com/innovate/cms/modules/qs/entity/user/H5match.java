package com.innovate.cms.modules.qs.entity.user;

import java.util.Date;

import com.innovate.cms.common.persistence.DataEntity;

/**
 * 
 * @author shifangfang
 *
 */
public class H5match extends DataEntity<H5match> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mysqlid;
	private int gid;
	//private String shareId;
	private String openid;
	private String openidName;
	private String openidPic;
	private String fopenid;
	private String fopenidName;
	private String fopenidPic;
	private float matchResult;
	private String matchDescription;
	// 匹配度结果类型,0：真实好友 1：虚拟/预设好友'
	private int matchTpye;
	private Date createTime;

	public H5match() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMysqlid() {
		return mysqlid;
	}

	public void setMysqlid(int mysqlid) {
		this.mysqlid = mysqlid;
	}

	/*public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
*/
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenidName() {
		return openidName;
	}

	public void setOpenidName(String openidName) {
		this.openidName = openidName;
	}

	public String getOpenidPic() {
		return openidPic;
	}

	public void setOpenidPic(String openidPic) {
		this.openidPic = openidPic;
	}

	public String getFopenid() {
		return fopenid;
	}

	public void setFopenid(String fopenid) {
		this.fopenid = fopenid;
	}

	public String getFopenidName() {
		return fopenidName;
	}

	public void setFopenidName(String fopenidName) {
		this.fopenidName = fopenidName;
	}

	public String getFopenidPic() {
		return fopenidPic;
	}

	public void setFopenidPic(String fopenidPic) {
		this.fopenidPic = fopenidPic;
	}

	public float getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(float matchResult) {
		this.matchResult = matchResult;
	}

	public String getMatchDescription() {
		return matchDescription;
	}

	public void setMatchDescription(String matchDescription) {
		this.matchDescription = matchDescription;
	}

	public int getMatchTpye() {
		return matchTpye;
	}

	public void setMatchTpye(int matchTpye) {
		this.matchTpye = matchTpye;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
