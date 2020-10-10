package com.example.sb2;

import com.example.sb2.initializer.SecondInitializer;
import com.example.sb2.listener.SecondListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sb2.mapper")
public class Sb2Application {

	public static void main(String[] args) {
//		SpringApplication.run(Sb2Application.class, args);

//		// ctrl + alt + v 快速实例化
//		SpringApplication springApplication = new SpringApplication(Sb2Application.class);
//		// 添加系统初始化器
//		springApplication.addInitializers(new SecondInitializer());
//		springApplication.run(args);



		// 硬编码
		// 自定义监听器
		SpringApplication springApplication = new SpringApplication(Sb2Application.class);
		springApplication.addListeners(new SecondListener());
		springApplication.run(args);
	}
}
