package com.innovate.cms.common.utils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper
{
	private final byte[] body;

	public BodyReaderHttpServletRequestWrapper(HttpServletRequest request)  throws IOException 
	{
		super(request);
		body = HttpHelperUtils.getBodyString(request).getBytes(Charset.forName("UTF-8"));
	}
	
	public BodyReaderHttpServletRequestWrapper(HttpServletRequest request,String jmbody)  throws IOException 
	{
		super(request);
		body = jmbody.getBytes(Charset.forName("UTF-8"));
	}
	
	public BufferedReader getReader() throws IOException
	{
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
	
	public ServletInputStream getInputStream() throws IOException {
	        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
	        
	        ServletInputStream servletInputStream = new ServletInputStream() {
				@Override
				public int read() throws IOException
				{
					// TODO Auto-generated method stub
					return bais.read();
				}
			};
	       return servletInputStream;
	 }
	
}
