package com.green;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class adresscontroller {
	
	//heap 메모리에 주소 데이터를 담을 리스트가 필요
	//arraylist<e>
	private List<arDTO> addressList = new ArrayList<>();
	
	//1.주소록 목록 화면
	@GetMapping("/address")
	public String list(Model model) {
		model.addAttribute("list", addressList);
		return "address-list";
	}
	
	//2. 주소 등록 화면
	@PostMapping("/add-address")
	public String addr(arDTO adto) {
		//삽입 메서드 : add(value)
		addressList.add(adto);
		return "redirect:/address";
	}

}
