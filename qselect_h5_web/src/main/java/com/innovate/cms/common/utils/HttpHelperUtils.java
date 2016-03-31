package com.innovate.cms.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpHelperUtils
{
	private static final Logger logger = LoggerFactory.getLogger(HttpHelperUtils.class);
	/**
	 * 获取请求Body
	 * 
	 * @Title: getBodyString
	 * @Description:
	 * @param request
	 * @return 返回类型 Body String
	 *
	 */
	public static String getBodyString(HttpServletRequest request)
	{
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try
		{
			inputStream = request.getInputStream();
			InputStreamReader in = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
			reader = new BufferedReader(in);
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
		} catch (IOException e)
		{
			logger.debug(e.getMessage());
			e.printStackTrace();
		} finally
		{
			if (inputStream != null)
			{
				try
				{
					inputStream.close();
				} catch (IOException e)
				{
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
			}
			if (reader != null)
			{
				try
				{
					reader.close();
				} catch (IOException e)
				{
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return StrUtil.cleanBlank(sb.toString());
	}

	public static void pwJson(HttpServletResponse response, String json)
	{
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = null;
		try
		{
			pw = response.getWriter();
			pw.println(json);
			pw.flush();
			pw.close();
		} catch (IOException e)
		{
			logger.debug(e.getMessage());
			e.printStackTrace();
		} finally
		{
			if (pw != null)
			{
				pw.close();
			}
		}
	}
}
