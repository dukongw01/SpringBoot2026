package com.green;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController {
	
	@GetMapping("/old-url")
	public String oldPage(RedirectAttributes re) {
		//리다이렉트 시점에서 딱 한 번만 사용할 데이터를 임시로 보관함
		re.addFlashAttribute("msg","이전 주소에서 자동으로 이동됐습니다.");
		//uew-url 주소로 리다이렉트 하라는 뜻 = 새로운 주소로 이동해
		return "redirect:/new-url";
	}
//	@GetMapping("/new-url")
//	public String newPage() {
//		//new-page-view.html
//		return "redirect:/new-page-view";
//	}
	
}
