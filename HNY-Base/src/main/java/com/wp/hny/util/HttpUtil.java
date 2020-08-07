package com.wp.hny.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
/**
 * @desc http请求工具类
 * @Author swiftwen
 * @2018年4月10日 下午3:04:43
 */
@Component
public class HttpUtil {
	
	private static Log log = LogFactory.getLog(HttpUtil.class);
	
	public void sendGetRequest(String urlStr) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(60000);
		conn.connect();
		conn.getInputStream();
	}

	/*public String getContextFullPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath();
	}*/

	/**
	 * @desc 发送get请求
	 * @param url
	 * @param headers
	 * @return 
	 * @Author swiftwen
	 * @2018年4月10日 下午3:00:25
	 */
	@SuppressWarnings("rawtypes")
	public String httpGet(String url,Map<String,String> headers) {
		String result = null;
		//增加下面两行代码
        Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
        Protocol.registerProtocol("https", myhttps);
        
		HttpClient htpc = new HttpClient();
		htpc.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
		htpc.getHttpConnectionManager().getParams().setSoTimeout(15000);
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
		if(null != headers){
			for(Entry entry : headers.entrySet()){
				getMethod.addRequestHeader(entry.getKey().toString(),entry.getValue().toString());
			}
		}
		try {
			// 执行getMethod
			int statusCode = htpc.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
				log.info("method failed" + getMethod.getStatusLine());
			}
			// 读取内容
			byte[] responseBody = getMethod.getResponseBody();
			// 处理内容
			result = new String(responseBody,"utf-8");
		} catch (HttpException e) {
			// 发生致命异常，可能是协议不对或者返回的内容有问题
			log.error("Please check your provided http address:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常
			log.error(e.getMessage());
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
		return result;
	}
	
	/**
	 * @desc 发送post请求
	 * @param url 请求url
	 * @param paramMap
	 * @param headers 请求头
	 * @param body 请求体
	 * @return 
	 * @Author swiftwen
	 * @2018年4月10日 下午3:00:36
	 */
	@SuppressWarnings("rawtypes")
	public String httpPost(String url,Map<String,String> paramMap,Map<String,String> headers,String body){
		String result = null;
		HttpClient httpc = new HttpClient();
		httpc.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		httpc.getHttpConnectionManager().getParams().setSoTimeout(5000);
		
		UTF8PostMethod postMethod = new UTF8PostMethod(url);
		postMethod.setRequestHeader("Content-Type","application/json;charset=utf-8");
		if(null != headers) {
			for(Entry entry : headers.entrySet()){
				postMethod.addRequestHeader(entry.getKey().toString(),entry.getValue().toString());
			}
		}
		if(null != paramMap) {
			for(Entry entry : paramMap.entrySet()){
				postMethod.setParameter(entry.getKey().toString(), entry.getValue().toString());
			}
		}
		//NameValuePair message = new NameValuePair("json", body);//post请求必须使用  NameValuePair 类传递参数  
		postMethod.setRequestBody(body);  
		try {
			int responseCode = httpc.executeMethod(postMethod);
			log.info("post response code : "+responseCode);
			//处理结果
			result = postMethod.getResponseBodyAsString();
			log.debug("post content : "+result);
		} catch (HttpException e) {
			//发生致命异常，可能是协议不对或者返回的内容有问题
			log.error("Please check your provided http address :"+e.getMessage());
		} catch (IOException e) {
			// 发生网络异常
			log.error(e.getMessage());
		}finally {
			// 释放连接
			postMethod.releaseConnection();
		}
		return result;
	}

	/*public static void main(String[] args) throws Exception {
		
		String url = "http://10.40.2.202/userRepair/InputSearchData/DayActiveAreaVerification";
		RepairDebtorInfoReq req = new RepairDebtorInfoReq();
		
		req.setCustomerId("810aafe6d7b6fdded9f3e0047b582e36");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		req.setCreateTime(sdf.format(new Date()).toString());
		req.setUpdateTime(sdf.format(new Date()).toString());
		req.setIdCardNo("211402197503074615");
		req.setRealName("蔡中海");
		req.setSex((byte)1);
		req.setUserSource((byte)0);
		req.setUserStatus((byte)0);
		req.setServiceId(0L);
		req.setServiceIdCardNo("411402197503074615");
		req.setServiceRealName("顶替");
		req.setServicePhoneNumber("15766086852");
		req.setPhoneNumber("15142983711");
		req.setIsRepair((byte)1);
		req.setRepairCount((byte)0);
		req.setCurrentStatus((byte)0);
		req.setRepairType((byte)0);
		
		
		String body = new JSONObject().toJSONString(req);
		System.out.println(body);
		String resp = new HttpUtil().httpPost(url, null, null, body);
		System.out.println(resp);
		
	}*/
	
	public static class UTF8PostMethod extends PostMethod{
        public UTF8PostMethod(String url){
            super(url);
        }
        @Override
        public String getRequestCharSet() {
            //return super.getRequestCharSet();
            return "UTF-8";
        }
    }
}
