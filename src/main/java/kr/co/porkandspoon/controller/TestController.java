package kr.co.porkandspoon.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	// pw 암호화, 복호화 시 사용
	@Autowired PasswordEncoder encoder;
	
	@RequestMapping(value="/")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
	
	@PostMapping(value="/login")
	public Map<String, Object> login(@RequestParam Map<String, String> data){
		
		logger.info("data => " + data);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);

		return response;
	}
}
