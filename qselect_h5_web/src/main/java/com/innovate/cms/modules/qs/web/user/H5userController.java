/**
 * Copyright &copy; 2012-2014 <a href="https://www.changyou.com/gaoji/cms">cms</a> All rights reserved.
 */
package com.innovate.cms.modules.qs.web.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovate.cms.common.config.Global;
import com.innovate.cms.common.mapper.JsonMapper;
import com.innovate.cms.common.utils.ReUtil;
import com.innovate.cms.common.utils.StrUtil;
import com.innovate.cms.common.web.BaseController;
import com.innovate.cms.modules.common.entity.BackInfo;
import com.innovate.cms.modules.common.entity.BackInfoMatch;
import com.innovate.cms.modules.data.entity.GroupQuestionToJson;
import com.innovate.cms.modules.qs.entity.user.H5match;
import com.innovate.cms.modules.qs.entity.user.H5qgroup;
import com.innovate.cms.modules.qs.service.user.H5matchService;
import com.innovate.cms.modules.qs.service.user.H5qgroupService;
import com.innovate.cms.modules.qs.service.user.H5questionService;
import com.thoughtworks.xstream.mapper.Mapper.Null;

/**
 * 用户相关接口管理Controller
 * 
 * @author gaoji
 * @version 2015-12-21
 */
@Controller
@RequestMapping(value = "/api")
public class H5userController extends BaseController {

	@Autowired
	private H5matchService h5matchService;
	@Autowired
	private H5qgroupService h5qgroupService;
	@Autowired
	private H5questionService h5questionService;

	/**
	 * 获取匹配结果
	 * 
	 * 提交分享人openid，做题人fopenid，题组 shareId，
	 * 
	 * 暂时不分页一页数据：pageSize 第几页:pageNum 给出一个是否做过该题的标识，告诉前端进入做题也还是进入分享页
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/user/h5match", method = RequestMethod.GET)
	public @ResponseBody String h5match(HttpServletRequest request, HttpServletResponse response) {
		String callback = request.getParameter("callback");
		String openid = request.getParameter("openid");
		String fopenid = request.getParameter("fopenid");
		String gid = request.getParameter("gid");
		// BackInfo<H5match> backInfo = new BackInfo<H5match>();
		BackInfoMatch<H5match> backInfo = new BackInfoMatch<H5match>();
		// String shareId = request.getParameter("shareId");
		try {
			int num = h5matchService.isMatched(Integer.parseInt(gid), fopenid, openid);
			if (num > 0) {
				// 做过
				backInfo.setIsMatched(BackInfoMatch.DONE);
			} else {
				backInfo.setIsMatched(BackInfoMatch.UNDO);
			}
			H5match match = new H5match();
			// match.setShareId(shareId);
			match.setOpenid(openid);
			match.setFopenid(fopenid);
			match.setGid(Integer.parseInt(gid));

			List<H5match> resH5matchs = h5matchService.findAll(match);
			backInfo.setStateCode(Global.intYES);
			backInfo.setRetMsg(Global.SUCCESS);
			backInfo.setData(resH5matchs);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("[H5userController - h5match()接口报错：{}]", e.getMessage());
			backInfo.setRetMsg(Global.ERROR);
			backInfo.setStateCode(Global.intNO);
		}

		return JsonMapper.getInstance().toJsonP(callback, backInfo);
	}

	/**
	 * 获取题组 gid ,openid,fopenid
	 * 
	 * @Title: qgroup
	 * @Description: 获取题组
	 * @param request
	 * @param response
	 * @return 返回类型 String
	 *
	 */
	@RequestMapping(value = "/v1/user/qgroup", method = RequestMethod.GET)
	public @ResponseBody String qgroup(HttpServletRequest request, HttpServletResponse response) {
		String callback = request.getParameter("callback");
		String gid = request.getParameter("gid"); // 分享者id
		BackInfo<GroupQuestionToJson> backInfo = new BackInfo<GroupQuestionToJson>();

		List<GroupQuestionToJson> data = null;
		try {

			H5qgroup group = h5qgroupService.findGroupByGid(Integer.parseInt(gid));
			String str = group.getQuestions();
			String[] qids = str.split(",");

			data = h5questionService.findQuestionList(qids);
			backInfo.setRetMsg(Global.SUCCESS);
			backInfo.setStateCode(Global.intYES);
			backInfo.setData(data);

		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("[H5userController - qgroup()接口报错：{}]", e.getMessage());
			backInfo.setRetMsg(Global.ERROR);
			backInfo.setStateCode(Global.intNO);
		}
		return JsonMapper.getInstance().toJsonP(callback, backInfo);
	}

	/**
	 * 存储做题结果
	 * 
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/user/h5saveMatch", method = RequestMethod.GET)
	public @ResponseBody String saveMatch(HttpServletRequest request, HttpServletResponse response) {
		String callback = request.getParameter("callback");

		String baseOpenid = request.getParameter("baseOpenid"); // 分享者id
		String childOpenid = request.getParameter("childOpenid");// 被分享者id
		String baseName = request.getParameter("baseName"); // 分享者昵称
		String childName = request.getParameter("childName");// 被分享者昵称
		String baseImg = request.getParameter("baseImg"); // 分享者头像
		String childImg = request.getParameter("childImg");// 被分享者头像
		String matchResult = request.getParameter("matchResult"); // 被分享者与分享者的匹配结果
																	// 小数点表示
		String gid = request.getParameter("gid"); // 分享题组ID
		//String shareId = request.getParameter("shareId"); // 分享ID

		BackInfo<?> backInfo = new BackInfo<Null>();
		try {
			H5match h5match = new H5match();
			h5match.setGid(Integer.parseInt(gid));
			//h5match.setShareId(shareId);
			h5match.setOpenid(baseOpenid);
			h5match.setOpenidName(baseName);
			h5match.setOpenidPic(baseImg);
			h5match.setFopenid(childOpenid);
			h5match.setFopenidName(childName);
			h5match.setFopenidPic(childImg);
			h5match.setMatchResult(Float.parseFloat(matchResult));
			h5match.setCreateTime(new Date());

			h5matchService.saveH5match(h5match); // 保存操作
			backInfo.setRetMsg(Global.SUCCESS);
			backInfo.setStateCode(Global.intYES);
		} catch (Exception e) {
			logger.debug("[H5userController - saveMatch()接口报错：{}]", e.getMessage());
			backInfo.setRetMsg(Global.ERROR);
			backInfo.setStateCode(Global.intNO);
		}
		return JsonMapper.getInstance().toJsonP(callback, backInfo);
	}

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public @ResponseBody BackInfo<?> exp(HttpMessageNotReadableException ex) {
		String retMsg = ReUtil.extractMulti("(^.*)\\n at (\\[.*$)", ex.getMessage().substring(0, 150), "$1");

		BackInfo<?> backError = new BackInfo<Null>();
		if (StrUtil.isEmpty(retMsg)) {
			logger.info("参数错误" + retMsg);
			retMsg = Global.ERROR;
		}
		backError.setRetMsg(retMsg);
		backError.setStateCode(Global.int300301);
		return backError;
	}

}