/*
 * @(#)A.java V2.0 2015年4月24日
 * @Title: HttpClientUtils.java 
 * @Package com.iokbl.www.commons.util 
 * @version V2.0

 */
package com.visionet.project.base.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



/**
 * Http请求工具类
 * 
 * @ClassName: HttpClientUtils
 * 
 */
public class HttpClientUtils {
	/**
	 * @Description httpPost请求
	 * @param url
	 * @param params
	 * @params charset
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String httpPost(String url, Map<String, String> params,
			String charset) throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		if (params != null && !params.isEmpty()) {
			List<NameValuePair> ps = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				ps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(ps, charset));
			httpPost.addHeader("Content-type",
					"application/x-www-form-urlencoded");
		}
		CloseableHttpResponse response = httpClient.execute(httpPost);
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("调用接口[" + url + "]异常，HTTP响应状态码为"
					+ response.getStatusLine().getStatusCode());
		} else {
			String result = EntityUtils.toString(response.getEntity(), charset);
			response.close();
			return result;
		}
	}

	/**
	 * httpPost请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	public static String httpPost(String url, String json, String charset)
			throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		/*if (CommonsUtil.isNotNull(json)) {*/
			httpPost.setEntity(new StringEntity(json, charset));
			httpPost.addHeader("Content-type", "application/json");
		/*}*/
		System.out.println("url:" + url);
		System.out.println("json:" + json);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		String header="";
		Map<String,Object> maps = new HashedMap<>();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("调用接口[" + url + "]异常，HTTP响应状态码为"
					+ response.getStatusLine().getStatusCode());
		} else {
			String result = EntityUtils.toString(response.getEntity(), charset);
			if(url==UrlUtil.URL+"/api/user/authentication/v2" || url ==UrlUtil.URL+"/api/signup/v2"){
			Header[] headers=response.getAllHeaders();
//			for(int i =0;i<headers.length;i++){
//				System.out.println(headers[i].toString());
//			}
			header=headers[8].toString();
			maps.put("head", header);
			String results=result.substring(1, result.length()-1);
			String subhead=header.substring(13);
			String endResults="{"+results+","+"\""+"X-AUTH-TOKEN"+"\""+":"+"\""+subhead+"\""+"}";
			response.close();
			return endResults;
			}
			response.close();
			return result;
		}
	}
	
	public static String httpPostToken(String url, String json, String charset,String token)
			throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		/*if (CommonsUtil.isNotNull(json)) {*/
		httpPost.addHeader("Content-type", "application/json");
		httpPost.addHeader("X-AUTH-TOKEN", token);
			httpPost.setEntity(new StringEntity(json, charset));
			
		/*}*/
		System.out.println("url:" + url);
		System.out.println("json:" + json);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		String header="";
		Map<String,Object> maps = new HashedMap<>();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("调用接口[" + url + "]异常，HTTP响应状态码为"
					+ response.getStatusLine().getStatusCode());
		} else {
			String result = EntityUtils.toString(response.getEntity(), charset);
			if(url=="http://8dianhou.careerfrog.com.cn/api/user/authentication/v2" || url =="http://8dianhou.careerfrog.com.cn/api/signup/v2"){
			Header[] headers=response.getAllHeaders();
			
			header=headers[8].toString();
			maps.put("head", header);
			String results=result.substring(1, result.length()-1);
			String subhead=header.substring(13);
			String endResults="{"+results+","+"\""+"X-AUTH-TOKEN"+"\""+":"+"\""+subhead+"\""+"}";
			
			response.close();
			return endResults;
			}
			response.close();
			return result;
		}
	}
	public static String httpPostToken(String url, String json,String token) throws Exception {
		return httpPostToken(url, json, "UTF-8",token);
	}
	/**
	 * httpPost请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String httpPost(String url, String json) throws Exception {
		return httpPost(url, json, "UTF-8");
	}

	/**
	 * httpPost请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String httpPost(String url, Map<String, String> params)
			throws Exception {
		return httpPost(url, params, "UTF-8");
	}

	/**
	 * 
	 * @Title: httpPost2Json
	 * @Description: httpPost请求返回对象转换jsonObject
	 * @modifier
	 * @modifydate
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static JSONObject httpPost2Json(String url,
			Map<String, String> params) throws Exception {
		return JSONObject.fromObject(httpPost(url, params));
	}

	/**
	 * 
	 * @Title: httpPost2Json
	 * @Description: httpPost请求返回对象转换jsonObject
	 * @modifier
	 * @modifydate
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static JSONArray httpPost2Array(String url,
			Map<String, String> params) throws Exception {
		return JSONArray.fromObject(httpPost(url, params));
	}

	/**
	 * 
	 * @Title: httpPost2Json
	 * @Description: httpPost请求返回对象转换jsonObject
	 * @modifier
	 * @modifydate
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static JSONObject httpPost2Json(String url, String jsonObject)
			throws Exception {
		return JSONObject.fromObject(httpPost(url, jsonObject));
	}

	/**
	 * 
	 * @Title: httpPost2Json
	 * @Description: httpPost请求返回对象转换jsonObject
	 * @modifier
	 * @modifydate
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static JSONArray httpPost2Array(String url, String jsonObject)
			throws Exception {
		return JSONArray.fromObject(httpPost(url, jsonObject));
	}

	/**
	 * @Description get请求接口,返回接口响应结果
	 * @param url 接口地址
	 * @param params 接口参数
	 * @param charset 响应结果字符编码
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static String get(String url, Map<String, Object> params,
			String charset) throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		StringBuilder uri = new StringBuilder(url);
		if (params != null && !params.isEmpty()) {
			if (url.indexOf('?') > 0) {
				uri.append("&");
			} else {
				uri.append("?");
			}
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (entry.getValue() != null) {
					String value = entry.getValue().toString();
					uri.append(entry.getKey()).append("=");
					/*if (CommonsUtil.isContainsChinese(value)) {*/
						value = URLEncoder.encode(value, "UTF-8");
					/*}*/
					uri.append(value).append("&");
				}
			}
			uri.deleteCharAt(uri.length() - 1);
		}
		System.out.println("url:"+uri.toString());
		HttpGet httpGet = new HttpGet(uri.toString());
		CloseableHttpResponse response = httpClient.execute(httpGet);
		String result = EntityUtils.toString(response.getEntity(), charset);
		response.close();
		httpClient.close();
		return result;
	}

	/**
	 * @Description get请求接口,返回接口响应结果
	 * @param url 接口地址
	 * @param params 接口参数
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static String get(String url, Map<String, Object> params)
			throws Exception {
		return get(url, params, "UTF-8");
	}
	public static String getToken(String url, Map<String, Object> params,
			String charset,String token) throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		StringBuilder uri = new StringBuilder(url);
		System.out.println("url:"+url);
		System.out.println("params:"+params);
		if (params != null && !params.isEmpty()) {
			if (url.indexOf('?') > 0) {
				uri.append("&");
			} else {
				uri.append("?");
			}
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (entry.getValue() != null) {
					String value = entry.getValue().toString();
					uri.append(entry.getKey()).append("=");
					/*if (CommonsUtil.isContainsChinese(value)) {*/
						value = URLEncoder.encode(value, "UTF-8");
					/*}*/
					uri.append(value).append("&");
				}
			}
			uri.deleteCharAt(uri.length() - 1);
		}
		HttpGet httpGet = new HttpGet(uri.toString());
		httpGet.addHeader("X-AUTH-TOKEN", token);
		System.out.println(uri.toString());
		CloseableHttpResponse response = httpClient.execute(httpGet);
//		response.addHeader("X-AUTH-TOKEN", token);
//		HttpClientUtils request = new HttpClientUtils();
		
		String result = EntityUtils.toString(response.getEntity(), charset);
		response.close();
		httpClient.close();
		return result;
	}

	/**
	 * @Description get请求接口,返回接口响应结果
	 * @param url 接口地址
	 * @param params 接口参数
	 * @return
	 * @throws org.apache.http.client.ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static String getToken(String url, Map<String, Object> params,String token)
			throws Exception {
		return getToken(url, params, "UTF-8",token);
	}
	
	/**
	 * http put 
	 * @param url
	 * @param json
	 * @param charset
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String httpPut(String url, String json, String charset,String token)
			throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//		HttpPost httpPost = new HttpPost(url);
		HttpPut httpPut = new HttpPut(url);
		/*if (CommonsUtil.isNotNull(json)) {*/
		httpPut.setEntity(new StringEntity(json, charset));
		httpPut.addHeader("Content-type", "application/json");
		httpPut.addHeader("X-AUTH-TOKEN", token);
		/*}*/
		System.out.println("url:" + url);
		System.out.println("json:" + json);
		CloseableHttpResponse response = httpClient.execute(httpPut);
		String header="";
		Map<String,Object> maps = new HashedMap<>();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("调用接口[" + url + "]异常，HTTP响应状态码为"
					+ response.getStatusLine().getStatusCode());
		} else {
			String result = EntityUtils.toString(response.getEntity(), charset);
			if(url=="http://8dianhou.careerfrog.com.cn/api/user/authentication/v2" || url =="http://8dianhou.careerfrog.com.cn/api/signup/v2"){
			Header[] headers=response.getAllHeaders();
			
			header=headers[8].toString();
			maps.put("head", header);
			String results=result.substring(1, result.length()-1);
			String subhead=header.substring(13);
			String endResults="{"+results+","+"\""+"X-AUTH-TOKEN"+"\""+":"+"\""+subhead+"\""+"}";
			response.close();
			return endResults;
			}
			response.close();
			return result;
		}
	}
	public static String httpPut(String url, String json,String token) throws Exception {
		return httpPut(url, json, "UTF-8",token);
	}
	/**
	 * http delete 请求
	 * @param url
	 * @param json
	 * @param charset
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String httpDelete(String url, String json, String charset,String token)
			throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//		HttpPost httpPost = new HttpPost(url);
//		HttpPut httpPut = new HttpPut(url);
		HttpDelete httpDelete = new HttpDelete(url);
		/*if (CommonsUtil.isNotNull(json)) {*/
//		((HttpResponse) httpDelete).setEntity(new StringEntity(json, charset));
//		httpDelete.setEntity(new StringEntity(json, charset));
		httpDelete.addHeader("Content-type", "application/json");
		httpDelete.addHeader("X-AUTH-TOKEN", token);
		/*}*/
		System.out.println("url:" + url);
		System.out.println("json:" + json);
		CloseableHttpResponse response = httpClient.execute(httpDelete);
		String header="";
		Map<String,Object> maps = new HashedMap<>();
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			throw new Exception("调用接口[" + url + "]异常，HTTP响应状态码为"
					+ response.getStatusLine().getStatusCode());
		} else {
			String result = EntityUtils.toString(response.getEntity(), charset);
			if(url=="http://8dianhou.careerfrog.com.cn/api/user/authentication/v2" || url =="http://8dianhou.careerfrog.com.cn/api/signup/v2"){
			Header[] headers=response.getAllHeaders();
			
			header=headers[8].toString();
			maps.put("head", header);
			String results=result.substring(1, result.length()-1);
			String subhead=header.substring(13);
			String endResults="{"+results+","+"\""+"X-AUTH-TOKEN"+"\""+":"+"\""+subhead+"\""+"}";
			response.close();
			return endResults;
			}
			response.close();
			return result;
		}
	}
	public static String httpDelete(String url, String json,String token) throws Exception {
		return httpDelete(url, json, "UTF-8",token);
	}



}
