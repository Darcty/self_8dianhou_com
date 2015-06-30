package com.visionet.project.platform.answer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visionet.project.base.util.HttpClientUtils;
import com.visionet.project.base.util.JsonHandler;
import com.visionet.project.base.util.UrlUtil;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	/**
	 * 5.1 获取问答列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAnswerList")
	public String getAnswerList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			String p_size=(String) map.get("p_size");
			System.out.println(p_size);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1,10";
			}
			if(p_size.trim()==null || "".equals(p_size.trim())){
				p_size="10";
			}
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/questions?sid="+sid+"&p_size="+p_size, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 5.2 搜索问题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchQuestion")
	public String searchQuestion(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			String q=(String) map.get("q");
			System.out.println(q);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1,10";
			}
			if(q.trim()==null || "".equals(q.trim())){
				q="咨询";
			}
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/question/search?sid="+sid+"&q="+q, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.3 根据问题ID获取问题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getQuestionById")
	public String getQuestionById(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String questionId=(String) map.get("questionId");
			System.out.println(questionId);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/question/"+questionId, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.4 根据回答ID获取回答
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAnswerById")
	public String getAnswerById(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String answerId=(String) map.get("answerId");
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/answer/"+answerId, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.5 根据回答ID获取评论列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCommentList")
	public String getCommentList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String answerId=(String) map.get("answerId");
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/question/"+answerId+"/comments", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.6	获取其他问题列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getOtherAnswer")
	public String getOtherAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String answerId=(String) map.get("answerId");
			System.out.println(answerId);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/qa/answer/"+answerId+"/other-answers", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.7 提交评论
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/putComment")
	public String putComment(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/qa/answer/comment", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.8  点赞或者取消点赞
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPraise")
	public String getPraise(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/qa/answer/rank", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.9  收藏问题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/enshrineAnswer")
	public String enshrineAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/qa/answer/favorite", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.10  获取我的回答列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyAnswerList")
	public String getMyAnswerList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			String status=(String) map.get("status");
			System.out.println(status);
			String p_size=(String) map.get("p_size");
			System.out.println(p_size);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1";
			}
			if(p_size.trim()==null || "".equals(p_size.trim())){
				p_size="10";
			}
			if(status.trim()==null || "".equals(status.trim())){
				status="all";
			}
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/my-answers?sid="+sid+"&p_size="+p_size+"&status="+status, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.11 获取我的问题列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyQuestionList")
	public String getMyQuestionList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			String p_size=(String) map.get("p_size");
			System.out.println(p_size);
			String status=(String) map.get("status");
			System.out.println(status);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1";
			}
			if(p_size.trim()==null || "".equals(p_size.trim())){
				p_size="10";
			}
			if(status.trim()==null || "".equals(status.trim())){
				status="all";
			}
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/my-questions?sid="+sid+"&p_size="+p_size+"&status="+status, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.12  提交问题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/commitQuestion")
	public String commitQuestion(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/question", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.13  修改问题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeQuestion")
	public String changeQuestion(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String questionId=(String) map.get("questionId");
			System.out.println(questionId);
			map.remove("questionId");
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/question/"+questionId, info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.14  提交回答
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/commitAnswer")
	public String commitAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/answer", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.15 修改回答
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeAnswer")
	public String changeAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String answerId=(String) map.get("answerId");
			map.remove("answerId");
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/answer/"+answerId, info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 5.16  获取我收藏的问题列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyCollectQuestion")
	public String getMyCollectQuestion(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			String p_size=(String) map.get("p_size");
			System.out.println(p_size);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1,10";
			}
			if(p_size.trim()==null || "".equals(p_size.trim())){
				p_size="10";
			}
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/my-favorite-answers?sid="+sid+"&p_size="+p_size, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 5.17 获取热门问题标签
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHotTag")
	public String getHotTag(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String count=(String) map.get("count");
			System.out.println(count);
			if(count.trim()==null || "".equals(count.trim())){
				count="8";
			}
//			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
//			System.out.println(mapHead);
//			String token=(String) mapHead.get("X-AUTH-TOKEN");
//			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/question/hot-tags?count="+count, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 5.18 获取是否点赞及收藏回答列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPraiseAnswer")
	public String getPraiseAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/qa/answer/favorites-ranks", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 5.19 取消收藏
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/removeAnswer")
	public String removeAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String answerId=(String) map.get("answerId");
			System.out.println(answerId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpDelete(UrlUtil.URL+"/api/qa/answer/favorite/"+answerId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 5.20 获取问题详情及回答列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDetail")
	public String getDetail(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String questionId=(String) map.get("questionId");
			System.out.println(questionId);
//			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
//			System.out.println(mapHead);
//			String token=(String) mapHead.get("X-AUTH-TOKEN");
//			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/qa/question/"+questionId, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
}
