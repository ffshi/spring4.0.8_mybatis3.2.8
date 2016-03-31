package com.innovate.cms.modules.data.entity;

import java.io.Serializable;

public class MatchResultToJson implements Serializable{

	private static final long serialVersionUID = 1L;

	private String fopenidName; //

	private String fopenidPic;

	private double matchResult;

	public MatchResultToJson() {
		super();
	}

	public MatchResultToJson(String fopenidName, String fopenidPic, double matchResult) {
		super();
		this.fopenidName = fopenidName;
		this.fopenidPic = fopenidPic;
		this.matchResult = matchResult;
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

	public double getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(double matchResult) {
		this.matchResult = matchResult;
	}
}
