package com.mycompany.project.travel.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.project.travel.model.Criteria;
import com.mycompany.project.travel.model.PageMakerDTO;
import com.mycompany.project.travel.model.VO;
import com.mycompany.project.travel.service.TestService;

@Controller
public class HomeController {
	@Autowired
	private TestService testservice;
	@Autowired
	private SqlSession sqlSesstion;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String home(Model model, Criteria cri) {
		
		return "travel/travelHome";
		
	}
	
	@RequestMapping(value ="/leg", method = RequestMethod.GET)
	public String leg(Model model, Criteria cri) {

		return "travel/leg";
		
	}
	@RequestMapping(value ="/eye", method = RequestMethod.GET)
	public String eye(Model model, Criteria cri) {

		return "travel/eye";
		
	}
	@RequestMapping(value ="/ears", method = RequestMethod.GET)
	public String ears(Model model, Criteria cri) {
	
		
		return "travel/ears";
		
	}
	@ResponseBody
	@RequestMapping(value ="/ajaxLeg", method = RequestMethod.POST)
	public HashMap<String, Object> ajaxLeg(Model model, HttpServletRequest request, Criteria cri) {
			HashMap<String, Object> result = new HashMap<String, Object>();
			VO vo = new VO();
			List<VO> list = sqlSesstion.selectList("FreeBoardMapper.legList",vo);
			result.put("list", list);
			
			return result;
	}
	
	@ResponseBody
	@RequestMapping(value ="/ajaxHome", method = RequestMethod.POST)
	public HashMap<String, Object> ajaxHome(Model model, HttpServletRequest request, Criteria cri) {
			HashMap<String, Object> result = new HashMap<String, Object>();
			VO vo = new VO();
			List<VO> list = sqlSesstion.selectList("FreeBoardMapper.list",vo);
			result.put("list", list);
			
			return result;
	}
	
	@ResponseBody
	@RequestMapping(value ="/ajaxKeyword", method = RequestMethod.POST)
	public HashMap<String, Object> ajaxTest(Model model, HttpServletRequest request, Criteria cri) {
			HashMap<String, Object> result = new HashMap<String, Object>();
			String keyword = request.getParameter("keyword");
			VO vo = new VO();
			vo.setKeyword(keyword);
			List<VO> list = sqlSesstion.selectList("FreeBoardMapper.keyword",vo);
			result.put("list", list);
		
			return result;
	
	}
	
	
}
