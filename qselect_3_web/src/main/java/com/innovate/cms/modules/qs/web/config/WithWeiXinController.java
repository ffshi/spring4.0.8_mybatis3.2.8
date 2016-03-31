package com.innovate.cms.modules.qs.web.config;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.ocs.OcsClient;
import com.aliyun.ocs.OcsException;
import com.aliyun.ocs.OcsOptions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.innovate.cms.common.config.Global;
import com.innovate.cms.common.mapper.BeanMapper;
import com.innovate.cms.common.mapper.JsonMapper;
import com.innovate.cms.common.service.WeiXinService;
import com.innovate.cms.common.utils.HttpClientUtil;
import com.innovate.cms.common.utils.StrUtil;
import com.innovate.cms.common.web.BaseController;
import com.innovate.cms.modules.common.entity.BackInfo;
import com.innovate.cms.modules.data.entity.WXConfigToJson;
import com.innovate.cms.modules.qs.entity.weixin.WeixinUser;
import com.innovate.cms.modules.qs.service.weixin.WeixinUserService;
/**
 * 微信相关开发Controller
 * 
 * @author gaoji
 * @version 2015-12-21
 */
@Controller
@RequestMapping(value = "/api")
public class WithWeiXinController extends BaseController
{
	private static WXConfigToJson wToJson = new WXConfigToJson();
	private static Map<String, String> ret  = Maps.newHashMap();
	@Autowired
	private WeixinUserService weixinUserService;
	
	@RequestMapping(value = "/v1/getWXConfig", method = RequestMethod.GET)
	public @ResponseBody String getWXConfig(HttpServletRequest request, HttpServletResponse response)
	{
		String callback = request.getParameter("callback");
		String url = request.getParameter("url");
		BackInfo<WXConfigToJson> backInfo= new BackInfo<WXConfigToJson>();
		if (StrUtil.isBlank(url)||StrUtil.isBlank(callback))
		{
			backInfo.setStateCode(Global.int300209);
			backInfo.setRetMsg(Global.str300209);
		}else {
			String ACCESSTOKEN = "";
			String JSAPITICKET = "";
			List<WXConfigToJson> data =Lists.newArrayList();
			//WXConfigToJson wToJson = new WXConfigToJson();
			OcsClient ocs = Global.getOcsClient();
			OcsOptions options = Global.getOcsOptions();
			int num = Global.getLength();
			
			logger.debug("ocs=[{}],options=[{}],num[{}]",ocs,options,num);
			try
			{
				ACCESSTOKEN = (String)ocs.syncGet(Global.ACCESSTOKEN + num, options).getValue();
				JSAPITICKET = (String)ocs.syncGet(Global.JSAPITICKET + num, options).getValue();
				logger.debug("ACCESSTOKEN=[{},{}],JSAPITICKET=[{},{}]",Global.ACCESSTOKEN+ num,ACCESSTOKEN,Global.JSAPITICKET+ num,JSAPITICKET);
				logger.debug("getError:[{}],getStatus[{}]",ocs.syncGet(Global.JSAPITICKET + num, options).getError(),ocs.syncGet(Global.JSAPITICKET + num, options).getStatus());
			
			} catch (OcsException e1)
			{
				logger.debug("获取值错误：",e1.getMessage());
			}
			ret = WeiXinService.sign(JSAPITICKET, url);
			wToJson.setUrl(url);
			try
			{
				if (ret.size()>0)
				{
					BeanMapper.copy(ret, wToJson);
					logger.debug("BeanMapper.copy:{}复制成功",wToJson.toString());
				}else {
					logger.debug("ret:{}参数不全",ret.toString());
				}
			} catch (Exception e)
			{
				logger.debug("BeanMapper.copy:{}失败",e.getMessage());
				backInfo.setStateCode(Global.int300301);
				backInfo.setRetMsg(Global.str300301);
			}
			// 添加对象
			data.add(wToJson);
			backInfo.setStateCode(Global.intYES);
			backInfo.setRetMsg(Global.SUCCESS);
			backInfo.setData(data);
		}
		return JsonMapper.getInstance().toJsonP(callback, backInfo);
	}
	
	@RequestMapping(value = "/v2/oauth2/weixin", method = RequestMethod.GET)
	public @ResponseBody String getOauth2ByWeiXin(HttpServletRequest request, HttpServletResponse response)
	{
		//String callback = request.getParameter("callback");
		String callback = request.getParameter("callback");
		String  code  = request.getParameter(Global.WX_CODE);
		// String  state = request.getParameter(Global.WX_STATE);
		// 初始化获取access_token的链接
		String  get_access_token_url = Global.getAccessTokenUrl(Global.WX_APPID, Global.WX_SECRET, code);
		
		// 第二步：通过code换取网页授权access_token
		String     jsonStr 	= HttpClientUtil.doGet(get_access_token_url);  	// 发送get请求
		JSONObject jsObj 	= JSONObject.parseObject(jsonStr);				// 对象转换
		
		String errcode  = jsObj.getString(Global.WX_ERRCODE);
		if (StrUtil.isNotBlank(errcode))
		{
			//如果有错误打印出来
			logger.debug("错误代码：{}",jsonStr);
			return JsonMapper.getInstance().toJson(jsObj);
		}else {
			//如果没有错误 把所有值取出来
			String access_token = jsObj.getString(Global.WX_ACCESS_TOKEN);
			String openid 		= jsObj.getString(Global.WX_OPENID);
			String expires_in	= jsObj.getString(Global.WX_EXPIRES_IN);
			String refresh_token= jsObj.getString(Global.WX_REFRESH_TOKEN);
			String unionid		= jsObj.getString(Global.WX_UNIONID);	
			String lang 		= Global.WX_ZH_CN;  // 默认 
			//------------------------------------------------------
			String user_nickname 	= "";
			String user_sex 		= "";
			String user_province 	= "";
			String user_city 		= "";
			String user_country 	= "";
			String user_headimgurl 	= "";
			// 初始化获取userinfo的链接
			String  get_userinfo_url = Global.getUserinfo(access_token, openid, lang);
			String  jsonStr2 	= HttpClientUtil.doGet(get_userinfo_url);	// 发送get请求
			JSONObject jsObj2 	= JSONObject.parseObject(jsonStr2);			// 对象转换
			String  errcode2  	= jsObj2.getString(Global.WX_ERRCODE);
			if (StrUtil.isNotBlank(errcode2))
			{
				//如果有错误打印出来
				logger.debug("错误代码：{}",jsonStr2);
				return JsonMapper.getInstance().toJson(jsObj2);
			}else {
				//如果没有错误 把所有值取出来
				user_nickname 	= jsObj2.getString(Global.WX_NICKNAME);
				user_sex 		= jsObj2.getString(Global.WX_SEX);
				user_province 	= jsObj2.getString(Global.WX_PROVINCE);
				user_city 		= jsObj2.getString(Global.WX_CITY);
				user_country 	= jsObj2.getString(Global.WX_COUNTRY);
				user_headimgurl = jsObj2.getString(Global.WX_HEADIMGURL);
			}
			
			WeixinUser weixinUser = null;
			//查询用户是否存在 如果不存在创建一个用户
			weixinUser = weixinUserService.getByOpenid(openid);
			if (null == weixinUser)
			{
				weixinUser = new WeixinUser();
			}
			weixinUser.setOpenid(openid);
			weixinUser.setNickname(user_nickname);
			weixinUser.setSex(user_sex);
			weixinUser.setProvince(user_province);
			weixinUser.setCity(user_city);
			weixinUser.setCountry(user_country);
			weixinUser.setHeadimgurl(user_headimgurl);
			weixinUser.setUnionid(unionid);
			weixinUser.setAccessToken(access_token);
			weixinUser.setRefreshToken(refresh_token);
			weixinUser.setLang(lang);
			weixinUser.setExpiresIn(expires_in);
			//创建一个 用户（可以添加消息队列） 如果不存在新增 如果存在更新
			weixinUserService.save(weixinUser);
			logger.debug("用户数据：{}",weixinUser.toString());
			//return JsonMapper.getInstance().toJson(jsObj2);
			return JsonMapper.getInstance().toJsonP(callback, jsObj2);
		}
	}
	
	@RequestMapping(value = "/v2/oauth2/qq", method = RequestMethod.GET)
	public @ResponseBody String getOauth2ByQQ(HttpServletRequest request, HttpServletResponse response)
	{
		String user_nickname 	= request.getParameter(Global.QQ_NICKNAME);
		String user_sex 		= request.getParameter(Global.QQ_SEX);
		String user_province 	= request.getParameter(Global.QQ_PROVINCE);
		String user_city 		= request.getParameter(Global.QQ_CITY);
		String user_country 	= "中国";
		String user_headimgurl 	= request.getParameter(Global.QQ_HEADIMGURL);
		
		String access_token 	= request.getParameter(Global.QQ_ACCESS_TOKEN);
		String openid 			= request.getParameter(Global.QQ_OPENID);
		String expires_in		= request.getParameter(Global.QQ_EXPIRES_IN);
		String refresh_token	= "";
		String unionid			= "";
		String lang 			= Global.WX_ZH_CN;  // 默认 
		String _sign 			= "cXNlbGVjdDIwMTYzMTU="; //qselect2016315
		String sign   			= request.getHeader("sign");
		Map<String, String> map  = Maps.newHashMap();
		
		if (StrUtil.isBlank(access_token)||StrUtil.isBlank(openid)
				||StrUtil.isBlank(user_nickname)||StrUtil.isBlank(user_headimgurl)||!_sign.equals(sign))
		{
			map.put("ret", Global.int300209+"");
			map.put("msg", Global.str300209);
			return JsonMapper.getInstance().toJson(map);
		}else {
			WeixinUser weixinUser = null;
			//查询用户是否存在 如果不存在创建一个用户
			/*
			if (StrUtil.isBlank(user_sex))
			{
				user_sex = "0";
			}else {
				user_sex = "男".equals(user_sex)? "1" : "2";
			}*/
			try
			{
				weixinUser = weixinUserService.getByOpenid(openid);
				if (null == weixinUser)
				{
					weixinUser = new WeixinUser();
				}
				weixinUser.setOpenid(openid);
				weixinUser.setNickname(user_nickname);
				weixinUser.setSex(user_sex);
				weixinUser.setProvince(user_province);
				weixinUser.setCity(user_city);
				weixinUser.setCountry(user_country);
				weixinUser.setHeadimgurl(user_headimgurl);
				weixinUser.setUnionid(unionid);
				weixinUser.setAccessToken(access_token);
				weixinUser.setRefreshToken(refresh_token);
				weixinUser.setLang(lang);
				weixinUser.setExpiresIn(expires_in);
				//创建一个 用户（可以添加消息队列） 如果不存在新增 如果存在更新
				weixinUserService.save(weixinUser);
				logger.debug("用户数据：{}",weixinUser.toString());
				map.put("ret", "0");
				map.put("msg", Global.SUCCESS);
			} catch (Exception e)
			{
				map.put("ret", Global.int300301+"");
				map.put("msg", Global.str300301);
				e.printStackTrace();
			}
			return JsonMapper.getInstance().toJson(map);
			
		}
		
		
	}

}
