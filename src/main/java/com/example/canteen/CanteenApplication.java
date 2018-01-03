package com.example.canteen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.canteen.mapper","com.example.canteen.dao"})
public class CanteenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanteenApplication.class, args);
	}
}
