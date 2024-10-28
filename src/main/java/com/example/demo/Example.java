package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Example {

	@PostMapping("/test")
	public ResponseEntity<?> demoPost(@RequestBody DemoObj demoObj) {
		String message = demoObj.getMessage();
		MyXMLService myXMLService = new MyXMLService();
		Object emp = new Employee();
		try {
			emp = myXMLService.fromXml(message, "employee.xsd");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return new ResponseEntity<>(emp.toString(), null, HttpStatus.OK);
	}

	public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}