package com.green.carproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.carproduct.mapper.CarProductMapper;

@Service
public class CarProductService {
	
	//CarProductMapper를 @Autowride로 의존객체 삽입
	//의존객체를 삽입 안할 시 cartproduct-mapper.xml의 SQL문을 사용불가
	
	@Autowired
	CarProductMapper carProductmapper;
	
	//메소드는 CarProductMapper인터페이스의 메소드 복사 붙여넣기
	public List<CarProductDTO> getAllCarProduct(){
		return carProductmapper.getAllCarProduct();
	}
	
}
