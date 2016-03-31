package com.innovate.cms.common.test;




public class MyTest
{
		/*private static String getUpToken(){
			final Auth auth = Auth.create("Ql1NUEjLl_r1z0MzejvC8zzvAIo_MQZdvzaOP8ui", "AQTV4-VylgcGqlao30dtrp1qjYWDp14ux1Yb6Ysk");
		    return auth.uploadToken("qselect");
		}*/
	
		public static void main(String[] args)
		{
			
		/*	String aaa = "D.   DDDD              dd      的";
			String text = "";
			text = Encodes.escapeHtml(aaa);
			System.err.println(text);
			text = Encodes.urlEncode(aaa);
			System.err.println(text);
			text = Encodes.encodeHex(("=="+aaa).getBytes());
			System.err.println(text);
			text = StringEscapeUtils.escapeJava(aaa);
			System.err.println(text);
			text = StringEscapeUtils.escapeJson(aaa);
			System.err.println(text);
			*/
			
					
					
					
			
		/*	aaa = "%E7%8E%B0%E5%9C%A8%20%20%E5%99%A2%E5%99%A2%20%20%E4%BD%A0%E6%9D%A5%E4%BA%86%20%20%20%20";
			text = Encodes.urlDecode(aaa);
			System.err.println(text);
			aaa="%E7%8E%B0%E5%9C%A8++%E5%99%A2%E5%99%A2++%E4%BD%A0%E6%9D%A5%E4%BA%86++++";
			text = Encodes.urlDecode(aaa);
			System.err.println(text);*/
		/*	String input = "\u8be5\u53d1\u751f\u0020\u8bf4\u7684\u0026\u006c\u0074\u003b\u0026\u0023\u0033\u0039\u003b\u0026\u0067\u0074\u003b";
			
			System.err.println(StringEscapeUtils.unescapeJava(input));
			System.err.println(StringEscapeUtils.unescapeJson(input));
			*/
			
			//Random random = new Random(Global.LENGTH);
			/*for (int i = 0; i < 1000; i++)
			{
				int  a = Global.getLength();
				if (a == 10)
				{
					System.err.println("sssssssssssss"+a);
				}else {
					System.err.println(a);
				}
				
				//System.err.println(Math.abs(random.nextInt()));
			}*/
				/*	String aString  = "bbb";
					String aString0 = "aaa1";
			
					if (aString0.equals("aaa"))
					{
						System.err.println(1);
					}else if (aString.equals("bbb")) {
						System.err.println(2);
					}else if (aString.equals("ccc")) {
						System.err.println(3);
					}else {
						System.err.println(4);
					}
			
					if (true)
					{
						System.err.println("执行");
					}*/
			
			
			//System.err.println(getUpToken());
			
			/*UploadManager uploadManager = new UploadManager();
			class MyRet {
			    public long fsize;
			    public String key;
			    public String hash;
			    public int width;
			    public int height;
			}
			
		        Response res;
				try
				{
					res = uploadManager.put("C:\\Users\\gaoji\\Pictures\\0506.jpg","0506.jpg",getUpToken());
					MyRet ret = res.jsonToObject(MyRet.class);
					System.err.println(res.toString());
				    System.err.println(res.bodyString());
				} catch (com.innovate.cms.common.qiniu.common.QiniuException e)
				{
					res = e.response;
			        // 请求失败时简单状态信息
			        System.err.println(res.toString());
			    
				}
		        */
		       
		   
			/*
			System.err.println(EnumArea.valueOf("hn".toLowerCase()).toString());;
			
			System.err.println(!"-21".equals("-1") && "-12".trim().length() != 32);
			
			
			System.err.println(IdGen.uuid());
			String old = "123456";
			String newString = "";
			newString = SystemService.entryptPassword(old);
			System.err.println(newString);
			System.err.println(SystemService.validatePassword("1234567", newString));*/
			//System.err.println(6%10);
			/*int[] id  = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
			for (int ii = 0; ii < id.length; ii++)
			{
				
			
			 int c = 32;
			 int[] intRet = new int[c];
             int intRd = 0; //存放随机数
             int count = 0; //记录生成的随机数个数
             int flag = 0; //是否已经生成过标志
             while(count<c){
                  Random rdm = new Random(System.currentTimeMillis());
                  intRd = Math.abs(rdm.nextInt())%32+30;
                  for(int i=0;i<count;i++){
                      if(intRet[i]==intRd){
                          flag = 1;
                          break;
                      }else{
                          flag = 0;
                      }
                  }
                  if(flag==0){
                      intRet[count] = intRd;
                      count++;
                  }
         }
        //for(int t=0;t<c;t++){
         //   System.out.println(t+"->"+intRet[t]);
        //}
        String aa ="update `questions_info` SET "
        		+"`q_num`="+intRet[0]
        				+",`man`="+intRet[1]
        				+",`woman`="+intRet[2]
        				+",`hb`="+intRet[3]
        				+",`db`="+intRet[4]
        				+",`hd`="+intRet[5]
        				+",`zn`="+intRet[6]
        				+",`xb`="+intRet[7]
        				+",`xn`="+intRet[8]
        				+",`hmt`="+intRet[9]
        				+",`birth40`="+intRet[10]
        				+",`birth50`="+intRet[11]
        				+",`birth60`="+intRet[12]
        				+",`birth70`="+intRet[13]
        				+",`birth80`="+intRet[14]
        				+",`birth85`="+intRet[15]
        				+",`birth90`="+intRet[16]
        				+",`birth95`="+intRet[17]
        				+",`birth00`="+intRet[18]
        				+",`aries`="+intRet[19]
        				+",`taurus`="+intRet[20]
        				+",`gemini`="+intRet[21]
        				+",`cancer`="+intRet[22]
        				+",`leo`="+intRet[23]
        				+",`virgo`="+intRet[24]
        				+",`libra`="+intRet[25]
        				+",`scorpio`="+intRet[26]
        				+",`sagittarius`="+intRet[27]
        				+",`capricorn`="+intRet[28]
        				+",`aquarius`="+intRet[29]
        				+",`pisces`="+intRet[30]
        				+" where `id`="+id[ii]+" and answer=1;";               
        				  
        
					        System.out.println(aa);
        
        
        
			}*/
		/*	System.err.println(StrUtil.isPositiveNum(""));
			System.ersr.println(StrUtil.isPositiveNum("00"));
			System.err.println(StrUtil.isPositiveNum("000"));
			System.err.println(StrUtil.isPositiveNum("01"));
			System.err.println(StrUtil.isPositiveNum("1"));
			System.err.println(StrUtil.isPositiveNum("2"));
			System.err.println(StrUtil.isPositiveNum("3"));
			System.err.println(StrUtil.isPositiveNum("4"));
			System.err.println(StrUtil.isPositiveNum("7222222"));*/
			/*System.err.println("测试="+Digests.md5("c4ca4238a0b923820dcc509a6f75849b"));
			//String aaaaString = "D:\\workspace\\cms\\src\\main\\webapp\\WEB-INF\\classes\\mappings\\modules\\test\\TestDao.xml".replaceAll("\\\\", "/");
			
			 * String content = "ZZZaaabbbccc中文1234"; Pattern pattern = Pattern.compile("classes\\.+\\\\");
			 
			// System.err.println(aaaaString);
			//String xxxxxxxxx = "Could not read JSON: Can not construct instance of java.lang.Integer from String value 's': not a valid Integer value\n at [Source: org.apache.catalina.connector.CoyoteInputStream@2f5f0fe4; line: 5, column: 16] (through reference chain: com.cyou.social.web.report.model.UserReg[\"expiresIn\"]); nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Can not construct instance of java.lang.Integer from String value 's': not a valid Integer value\n at [Source: org.apache.catalina.connector.CoyoteInputStream@2f5f0fe4; line: 5, column: 16] (through reference chain: com.cyou.social.web.report.model.UserReg[\"expiresIn\"])";
			String xxx2 = "Could not read JSON: Can not construct instance of java.lang.Integer from String value 's': not a valid Integer value\n at [Source: org.apache.catalina.connector.CoyoteInputStream@54847678; line: 5, column: 15] (through reference chain: com.cyou.social.web.report.model.UserReg[\"expiresIn\"]); nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Can not construct instance of java.lang.Integer from String value 's': not a valid Integer value\n at [Source: org.apache.catalina.connector.CoyoteInputStream@54847678; line: 5, column: 15] (through reference chain: com.cyou.social.web.report.model.UserReg[\"expiresIn\"])";
			String xxx3 ="Could not read JSON: Unexpected character (',' (code 44)): was expecting double-quote to start field name\n at [Source: org.apache.catalina.connector.CoyoteInputStream@5d5df07c; line: 5, column: 14]; nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character (',' (code 44)): was expecting double-quote to start field name\n at [Source: org.apache.catalina.connector.CoyoteInputStream@5d5df07c; line: 5, column: 14]";
			// get demo 正则查找匹配的第一个字符串
	*/		//String resultGet = ReUtil.get("/classes/\\w*/", aaaaString, 0);
			// System.err.println(resultGet);
			// String resultExtractMulti = ReUtil.extractMulti("(\\w)aa(\\w)", content, "$1-$2");
			//String resultExtractMulti = ReUtil.extractMulti("/classes/(\\w*)/", aaaaString, "$1");
			// System.err.println(resultExtractMulti);
			//System.err.println(xxxxxxxxx.replaceAll(".*\\..*\\..*\\[", "[")+"\n------");
			//System.err.println(xxx2.replaceAll(".*\\..*\\..*\\[", "["));
			
			//String xx = ReUtil.extractMulti(".*Exception: (.*): not.*\\[\"(.*)\"\\]\\)", xxxxxxxxx, "$1 <--字段--> \"$2\"");
			//System.err.println(xxx2.substring(0,150)+"\n---------------");
			
			//String xx1 = ReUtil.extractMulti("(^.*)\\n at (\\[.*$)", xxx3.substring(0,150), "$1");
			/*String md55= "/i/login{\"account\":\"9F9D2A036F06C0EAB1B98E69130F2A98\",\"accessToken\":\"9D5C622FBB111F56D3C17A2500060154\",\"userType\":\"1\",\"os\":\"android\",\"expiresIn\":7776000,\"headPortrait\":\"http://www.yiihuu.com/static/images/works/arrow_bg.png\",\"nickname\":\"小花\"}1450695642191-1-1";
			String md555="/u/updateUserInfo{\"uid\":\"016310225dc92c8db14ef55d1ee7d37a\",\"nickname\":\"小花\",\"headPortrait\":\"1304720150806\",\"constellation\":\"aries\",\"birthday\":\"1988-05-06\",\"sex\":\"1\",\"areaName\":\"华北\",\"areaProvince\":\"北京\",\"areaCity\":\"西城\"}1450780755529016310225dc92c8db14ef55d1ee7d37ae1aff99f2c7edcbdf6babcb459c285f1";
			String md556="{\"uid\":\"016310225dc92c8db14ef55d1ee7d37a\",\"nickname\":\"小花\",\"headPortrait\":\"1304720150806\",\"constellation\":\"aries\",\"birthday\":\"1988-05-06\",\"sex\":\"1\",\"areaName\":\"华北\",\"areaProvince\":\"北京\",\"areaCity\":\"西城\"}";
			String loginString = "{\"account\":\"9F9D2A036F06C0EAB1B98E69130F2A98\",\"accessToken\":\"9D5C622FBB111F56D3C17A2500060154\",\"userType\":\"1\",\"os\":\"android\",\"expiresIn\":7776000,\"headPortrait\":\"http://www.yiihuu.com/static/images/works/arrow_bg.png\",\"nickname\":\"小花\"}";
			String key = "0695642191";
			String iv  = "2015123100000000";
			String abc = "12345777";*/
			
			//System.err.println("2c7edcbdf6babcb4 = "+Encodes.encodeHex("2c7edcbdf6babcb4".getBytes()));
			/*try
			{
				
				//System.err.println(Encodes.encodeHex(Digests.md5(md55.getBytes("utf-8"))));
				//System.err.println(Encodes.encodeBase64(Digests.md5(md55.getBytes("utf-8"))));
				//System.err.println(Encodes.encodeHex(Encodes.decodeBase64("Gs9kcEQ+sVuwPtyMFMqKxA==")));
				//System.err.println(Encodes.encodeBase64("U2FsdGVkX18K4T22E8KCX5/KxcRhLer3cYItKVlSLx+bKwUc6Qclwj8vsDAyRBqnjiz8ja3b4f/t/zzNpSp5NK0oUZTjGzTHDHli7QuwqLxPSaVAPPcpQXDdowkbWFhEu9jNR/Fd3nQIJ/XGx8crQhJmVmrfu/hbuimnY8UQ3Kw+fn/M3zBeje9vu4U3LrFxgGpSLYzdnxx6538xXBY042XLDmCszz6aa+25JgTRmOAJc4SCKPvi+ri+SAhLw7XVd1FSOITO88J2Eet46y4cRFX9EHKpzhxdrYulNJQeyNb03ThQl++8uBFh9G3XNMjdUbKFBDg44YiZWZP6c43H7A=="));
				//String secretKey  = Encodes.encodeHex(Digests.md5(key.getBytes("utf-8")));
				String secretKey  = "e1aff99f2c7edcbdf6babcb459c285f1";
				//String inputBase64 = "";
				
				System.err.println(secretKey.substring(8, 24));
				
				
				
				String aes = Cryptos.aesEncryptToBase64(abc, secretKey.substring(8, 24), iv.getBytes());
				
				String jiemi =Cryptos.aesDecryptByBase64(aes, secretKey.substring(8, 24), iv.getBytes());
				
				System.err.println(Encodes.encodeHex(Digests.md5(md55.getBytes("utf-8"))));
				
				//System.err.println(System.currentTimeMillis());
				//String aes = Cryptos.aesEncrypt("abc",secretKey);
				
				System.err.println("secretKey32="+secretKey);
				System.err.println("secretKey16="+secretKey.substring(8, 24));
				System.err.println("IV="+Encodes.encodeHex(new IvParameterSpec(iv.getBytes()).getIV()));
				System.err.println("加密="+aes);
				System.err.println("\n解密="+jiemi);
				
				System.err.println("1450695642191".substring(3, 13));
				
				
				
				//System.err.println("generateAesKeyString="+Cryptos.generateAesKeyString());
				
				//System.err.println("encodeHex="+Encodes.encodeHex(Encodes.decodeHex("616765616531316661")));
				//System.err.println("encodeHex="+Encodes.encodeHex("ageae11fa".getBytes()));
				//System.err.println(URLDecoder.decode("{\"account\":\"9F9D2A036F06C0EAB1B98E69130F2A98\",\"accessToken\":\"9D5C622FBB111F56D3C17A2500060154\",\"userType\":\"1\",\"os\":\"android\",\"expiresIn\":7776000,\"headPortrait\":\"http://www.yiihuu.com/static/images/works/arrow_bg.png\",\"nickname\":\"小花\"}", "utf-8"));
			} catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  */

		}

	}

