package com.innovate.cms.common.utils;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

public class HttpUtils
{
	private  static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	 /**
	  * 
	  * @Title: doHttpGet
	  * @Description: 发起GET HTTP请求
	  * @param url 请求链接
	  * @return    返回类型 String
	  *
	  */
	 public static String doHttpGet(String url) {	
        return executeHttp(url, RequestMethod.GET, null);
	 }
	 /**
	  * 
	  * @Title: doHttpPost
	  * @Description: 发起POST HTTP带参数请求
	  * @param url	请求链接
	  * @param list 请求参数List集合
	  * @return    返回类型 String
	  *
	  */
	 public static String doHttpPost(String url, List<NameValuePair> list) {	
	        return executeHttp(url, RequestMethod.POST, list);
	 }
	 /**
	  * 
	  * @Title: doHttpNoParam
	  * @Description: 不带参数发起HTTP请求
	  * @param url    请求链接
	  * @param methodEnum <code>RequestMethod.POST/RequestMethod.GET</code>
	  * @return    返回类型 String
	  *
	  */
	 public static String doHttpNoParam(String url, RequestMethod methodEnum) {
         return executeHttp(url, methodEnum, null);
	 }
	 
	/**
     * @Title: executeHttp
     * @Description: Post请求调用该方法
     * @param url
     *                访问连接
     * @param methodEnum
     *                <code>RequestMethod.POST/RequestMethod.GET</code>
     * @param list
     *                List<? extends NameValuePair>
     * @return 返回类型 String 默认返回<code>"-1"</code>
     */
    private static String executeHttp(String url, RequestMethod methodEnum, List<? extends NameValuePair> list) {
            String result = "-1";
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            CloseableHttpResponse response = null;
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();
            try {
                    if (RequestMethod.GET == methodEnum) {
                            HttpGet httpGet = new HttpGet(url);
                            httpGet.setConfig(requestConfig);
                            response = httpClient.execute(httpGet);
                    } else {
                            HttpPost httpPost = new HttpPost(url);
                            httpPost.setConfig(requestConfig);
                            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                            httpPost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
                            response = httpClient.execute(httpPost);
                    }
                    HttpEntity entity = response.getEntity();
                    result = EntityUtils.toString(entity);
                    EntityUtils.consume(entity);
            } catch (ParseException e) {
            		return result;
            } catch (IOException e) {
            		return result;
            } finally {
                    try {
                    	if (null != response)
						{
                    		 response.close();
						}else {
							logger.debug("response为空");
						}
                    } catch (IOException e) {
                    	logger.debug("链接超时：{},result={}",e.getMessage(),result); 	
                    }
            }
            return result;
    }
}
