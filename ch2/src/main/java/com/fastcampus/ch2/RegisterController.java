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

//���α׷� ���
@Controller
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println(conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
//		binder.setValidator(new Uservalidator());			// UserValidator�� webDataBinder�� ���� validator�� ���
//		binder.addValidators(new Uservalidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList="validatorList);
	}
	
	// URL ����
	 @RequestMapping(value="/register/add", method= {RequestMethod.POST, RequestMethod.POST})
	public String register() {
		return "registerForm";		// WEB-INF/views/regusterForm.jsp
	}
	
	// URL ����
	// @RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		// �������� - Validator�� ���� �����ϰ�, validate()�� ���� ȣ��
//		Uservalidator userValidator = new Uservalidator();
//		userValidator.validate(user, result);			// BindingResult�� Errors�� �ڼ�

		// User ��ü�� ������ ��� ������ ������, registerForm�� �̿��ؼ� ������ ������� ��
		if (result.hasErrors()) {
			return "regusterForm";
		}
		
		
		
		// 1. ��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add";
//			//return "redirect:/register/add?msg=" + msg;			// URL ���ۼ� : rewriting
//		}
		
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
