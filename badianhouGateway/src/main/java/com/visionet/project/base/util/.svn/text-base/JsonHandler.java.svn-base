package com.visionet.project.base.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author huwk
 * @note json帮助类
 */
public class JsonHandler {
	/**
	 * @param obj 对象
	 * @return 返回对象的json
	 */
	public static String objectToJson(Object obj ){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	/**
	 * 
	 * @param obj
	 * @param newChar
	 * @return
	 */
	public static String objectToJson(Object obj,String newChar){
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json.replace("payload", newChar);
	}
	/**
	 * 把model对象转换成JSONObject.
	 * @param obj model对象
	 * @return JSONObject
	 */
	public static JSONObject toJSONObject(Object obj){
	    return JSONObject.fromObject(obj);
	}
	/**
	 * 把集合类型的转换成JSONArray.
	 * @param obj 集合类型的
	 * @return JSONArray
	 */
	public static JSONArray toJSONArrayList(Object obj){
	    return JSONArray.fromObject(obj);
	}
	
	/**
	 * @param jsonStr
	 * @param clazz
	 * @return 返回对象
	 */
	public static Object jsonToObject(String jsonStr ,Class<?> clazz){
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, clazz);
	}
	
	public static Object JSONToObject(String jsonStr ,Class<?> clazz){
		JSONObject jsonobject = JSONObject.fromObject(jsonStr);
		return JSONObject.toBean(jsonobject, clazz);
	}
	
	/**
	 * @param map
	 * @return 把map转成String
	 */
	public static String MapToJson(Map<String, ? extends Object> map){
		Gson gson = new Gson();
		return gson.toJson(map);
	}
	/**
	 * @param jsonStr json串
	 * @return 把json转成map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseHeadJSON2Map(String jsonStr){
		
		String newJsonStr = CharUtil.textToUtf8(jsonStr);
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(newJsonStr);
        JSONObject jsonBody = json.getJSONObject("head");
        
        for(Object k : jsonBody.keySet()){
            Object v = jsonBody.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseHeadJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	/**
	 * @param jsonStr json串
	 * @return 把json转成map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr){
		String newJsonStr = CharUtil.textToUtf8(jsonStr);
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(newJsonStr);
        JSONObject jsonBody = json.getJSONObject("body");
        
        for(Object k : jsonBody.keySet()){
            Object v = jsonBody.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	
	public static Map<String, Object> json2Map(String jsonStr){
		String newJsonStr = CharUtil.textToUtf8(jsonStr);
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(newJsonStr);
        JSONObject jsonBody = json.getJSONObject("body");
        for(Object k : jsonBody.keySet()){
            Object v = jsonBody.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Object> list = new ArrayList<>();
                Iterator<?> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    Object json2 = it.next();
                    list.add(json2);
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	public static Map<String, Object> json2MapHead(String jsonStr){
		String newJsonStr = CharUtil.textToUtf8(jsonStr);
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(newJsonStr);
        JSONObject jsonBody = json.getJSONObject("head");
        for(Object k : jsonBody.keySet()){
            Object v = jsonBody.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Object> list = new ArrayList<>();
                Iterator<?> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    Object json2 = it.next();
                    list.add(json2);
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	public static Map<String, Object> json2MapResult(String jsonStr){
		String newJsonStr = CharUtil.textToUtf8(jsonStr);
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(newJsonStr);
        JSONObject jsonBody = json.getJSONObject("X-AUTH-TOKEN");
        for(Object k : jsonBody.keySet()){
            Object v = jsonBody.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Object> list = new ArrayList<>();
                Iterator<?> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    Object json2 = it.next();
                    list.add(json2);
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	
	/**
	 * 把json转换成list
	 * @param json
	 * @return
	 */
	public static List<Long>  Json2List( String json){
		Gson gson = new Gson();
		List<Long> jts = gson.fromJson(json, new TypeToken<List<Long>>(){}.getType());
		return jts;
	}

	/**
	 * 把json转换成list
	 * @param json
	 * @return
	 */
	public static Map<String,List<String>>  Json2Listerer( String json){
		Gson gson = new Gson();
		Map<String,List<String>> jts = gson.fromJson(json, new TypeToken<Map<String,List<String>>>(){}.getType());
		return jts;
	}
	
	/**
	 * 把json转换成list<Object>
	 * @param <T>
	 * @param json
	 * @return
	 */
	public static <T> T json2ObjList(String json, TypeToken<T> t){
		Gson gson = new Gson();
		T jts = gson.fromJson(json, t.getType());
		return jts;
	}
	
	public static void main(String[] args) {
		String nn = "[{\"ctcId\":\"5445545454\",\"otherParam\":\"传下来的扩展参数\"}]";
		JSONArray j  = toJSONArrayList(nn);
		if(j!=null){
			for(int i=0;i<j.size();i++){ 
				JSONObject jo = JSONObject.fromObject(j.get(i)); 
					System.out.println(jo.getLong("ctcId"));
				} 
			
		}
	}

}
