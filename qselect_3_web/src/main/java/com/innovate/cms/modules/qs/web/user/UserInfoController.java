/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.web.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovate.cms.common.config.Global;
import com.innovate.cms.common.utils.ReUtil;
import com.innovate.cms.common.utils.StrUtil;
import com.innovate.cms.common.web.BaseController;
import com.innovate.cms.modules.common.entity.BackInfo;
import com.innovate.cms.modules.qs.service.user.UserInfoService;
import com.thoughtworks.xstream.mapper.Mapper.Null;

/**
 * 用户相关接口管理Controller
 * 
 * @author gaoji
 * @version 2015-12-21
 */
@Controller
@RequestMapping(value = "/api")
public class UserInfoController extends BaseController
{

	@Autowired
	private UserInfoService userInfoService;
	
	
	/**
	 * 举报
	 * @Title: saveReport
	 * @Description: 
	 * @param map
	 * @param request
	 * @param response
	 * @return    返回类型 BackInfo<?>
	 *
	 */
	@RequestMapping(value = "/v1/user/report", method = RequestMethod.POST)
	public @ResponseBody BackInfo<?> saveReport(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
	{
		String uid = map.get("uid");
		String qid = map.get("qid");
		BackInfo<?> backInfo = new BackInfo<Null>();
		if (!uid.equals("-1")&&(StrUtil.isBlank(uid)|| StrUtil.isBlank(qid) || uid.trim().length() != 32))
		{
			backInfo.setStateCode(Global.int300209);
			backInfo.setRetMsg(Global.str300209);
			return backInfo;
		}
		try
		{
			userInfoService.saveReport(uid,Integer.parseInt(qid));
			backInfo.setStateCode(Global.intYES);
			backInfo.setRetMsg(Global.SUCCESS);
		} catch (Exception e)
		{
			logger.debug("保存举报信息失败[saveReport]"+e.getMessage());
			backInfo.setStateCode(Global.int300302);
			backInfo.setRetMsg(Global.str300302);
		}
		
		return backInfo;
	}
	/**
	 * 反馈
	 * @Title: saveFeedback
	 * @Description: 
	 * @param map
	 * @param request
	 * @param response
	 * @return    返回类型 BackInfo<?>
	 *
	 */
	@RequestMapping(value = "/v1/user/feedback", method = RequestMethod.POST)
	public @ResponseBody BackInfo<?> saveFeedback(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
	{
		// TODO see saveFeedback 反馈不登陆也行
		String uid = map.get("uid");
		String content = map.get("content");
		String mobile = StrUtil.isBlank(map.get("mobile"))? "" : map.get("mobile");
		BackInfo<?> backInfo = new BackInfo<Null>();
		if (uid.equals("-1")||StrUtil.isBlank(content)|| uid.trim().length() != 32)
		{
			backInfo.setStateCode(Global.int300209);
			backInfo.setRetMsg(Global.str300209);
			return backInfo;
		}
		try
		{
			userInfoService.saveFeedback(uid,content,mobile);
			backInfo.setStateCode(Global.intYES);
			backInfo.setRetMsg(Global.SUCCESS);
		} catch (Exception e)
		{
			logger.debug("保存反馈信息失败[saveFeedback]"+e.getMessage());
			backInfo.setStateCode(Global.int300302);
			backInfo.setRetMsg(Global.str300302);
		}
		return backInfo;
	}
	

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public @ResponseBody BackInfo<?> exp(HttpMessageNotReadableException ex)
	{
		String retMsg = ReUtil.extractMulti("(^.*)\\n at (\\[.*$)", ex.getMessage().substring(0, 150), "$1");

		BackInfo<?> backError = new BackInfo<Null>();
		if (StrUtil.isEmpty(retMsg))
		{
			logger.info("参数错误" + retMsg);
			retMsg = Global.ERROR;
		}
		backError.setRetMsg(retMsg);
		backError.setStateCode(Global.int300301);
		return backError;
	}

}