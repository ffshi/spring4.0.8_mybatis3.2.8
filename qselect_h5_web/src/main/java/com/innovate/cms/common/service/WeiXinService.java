package com.innovate.cms.common.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.innovate.cms.common.config.Global;
import com.innovate.cms.common.security.Digests;
import com.innovate.cms.common.utils.Encodes;
import com.innovate.cms.common.utils.HttpUtils;

public class WeiXinService
{
    // private static	Logger logger =  Logger.getLogger(WeiXinService.class);
	/**
	 * 
	 * @Title: getAccessToken
	 * @Description: 获取微信 AccessToken jsapi_ticket的有效期为7200秒
	 * @param appId
	 * @param secret
	 * @return    返回类型 String
	 *
	 */
	public static String getAccessTokenJson(String appId, String secret)
	{
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
		return HttpUtils.doHttpGet(url);
	}
	/**
	 * 
	 * @Title: getApiTicket
	 * @Description: 获取 jsapi_ticket jsapi_ticket的有效期为7200秒
	 * @param accessToken
	 * @return    返回类型 String
	 *
	 */
	public static String getApiTicketJson(String accessToken) {
         String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";
         return HttpUtils.doHttpGet(url);
	}
	/**
	 * 
	 * @Title: sign
	 * @Description: 签名算法 map
	 * @param jsapi_tickets
	 * @param url
	 * @return    返回类型 Map<String,String>
	 *
	 */
	public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = Global.getNoncestr();
        String timestamp = Global.getTimestamp();
        String string1="";
        String signature = "";

        string1 = "jsapi_ticket=" + jsapi_ticket + 
        		  "&noncestr=" + nonce_str + 
        		  "&timestamp=" + timestamp + 
        		  "&url=" + url;
        try
		{
			signature = Encodes.encodeHex(Digests.sha1(string1.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
	}
}
