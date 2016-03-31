package com.innovate.cms.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import com.innovate.cms.common.mapper.JsonMapper;
import com.innovate.cms.common.utils.BodyReaderHttpServletRequestWrapper;
import com.innovate.cms.common.utils.HttpHelperUtils;
import com.innovate.cms.modules.common.entity.BackInfo;
import com.thoughtworks.xstream.mapper.Mapper.Null;

/**
 * Servlet Filter implementation class SignFilter
 */

public class SignFilter extends  OncePerRequestFilter   {
	
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("unused")
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException
	{
		// 不过滤的uri  
        //String[] notFilter =  new String[] {"/config/channel", "/config/time", "/user/report", "/isToken","/opt/openQuestions"}; 
		 // boolean doFilter = true;  // 是否过滤  
        
        String url = request.getRequestURI(); 				// 请求的url  
        //头文件中参数
        String timestamp = request.getHeader("Sign-Param");
        String sign = request.getHeader("Sign");
        String uid = request.getHeader("Uid");
        String _sign = "";			 // 本地计算sign
        boolean doSendError = false; // 是否返回错误   
        StringBuilder sb = new StringBuilder();     //拼接的Builder
        
        // 1.看数据是否被篡改  （列表内的只看篡改） POST 或者 PUT 有body数据
        if (RequestMethod.POST.toString().equalsIgnoreCase(request.getMethod())||RequestMethod.PUT.toString().equalsIgnoreCase(request.getMethod()))
		{
        	HttpServletRequest requestWrapper  = new BodyReaderHttpServletRequestWrapper(request);
        	String body = HttpHelperUtils.getBodyString(requestWrapper);
        	BackInfo<?> backInfo = new BackInfo<Null>();
 
        	
        	// 根据上面一系列校验返回错误信息
        	if(doSendError){
        		String json = JsonMapper.getInstance().toJson(backInfo);
				HttpHelperUtils.pwJson(response,json);
				return;
        	}else {
        		chain.doFilter(requestWrapper, response);
			}
		}else {
			chain.doFilter(request, response);
		}
	}
	
}
