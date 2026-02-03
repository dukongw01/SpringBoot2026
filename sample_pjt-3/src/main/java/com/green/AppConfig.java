package com.green;

import org.springframework.context.annotation.Bean;

public class AppConfig {
	
	@Bean
	MemberService memberservice = new MemberService();
	memberservice.singUpConfirm(mdto);
	
}
