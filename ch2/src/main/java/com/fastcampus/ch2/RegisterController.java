package com.fastcampus.ch2;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//프로그램 등록
@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println(conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
//		binder.setValidator(new Uservalidator());			// UserValidator를 webDataBinder의 로컬 validator로 등록
//		binder.addValidators(new Uservalidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList="validatorList);
	}
	
	// URL 연결
	 @RequestMapping(value="/register/add", method= {RequestMethod.POST, RequestMethod.POST})
	public String register() {
		return "registerForm";		// WEB-INF/views/regusterForm.jsp
	}
	
	// URL 연결
	// @RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		// 수동검증 - Validator를 직접 생성하고, validate()를 직접 호출
//		Uservalidator userValidator = new Uservalidator();
//		userValidator.validate(user, result);			// BindingResult는 Errors의 자손

		// User 객체를 검증한 결과 에러가 있으면, registerForm를 이용해서 에러를 보여줘야 함
		if (result.hasErrors()) {
			return "regusterForm";
		}
		
		
		
		// 1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
//			//return "redirect:/register/add?msg=" + msg;			// URL 재작성 : rewriting
//		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
