package com.green;

import org.springframework.stereotype.Service;

public class MemberService {
	
	//멤버 서비스 클래스는 지브니스 ㄹ조직을 자성하는 크래스이다
	
	
	@Service
	public void singUpConfirm(MemberDTO mdto) {
		System.out.println("회원가입 출력화면");
		
	}

}
