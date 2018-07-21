package com.ghosh.jaagteyRahoWebServces.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gupshup")
public class GupshupController {

	@RequestMapping(value = "/receivedMsg", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
	public void getuser(
			@RequestParam(name = "phonecode", required = false) String phonecode,
			@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "location", required = false) String location,
			@RequestParam(name = "carrier", required = false) String carrier,
			@RequestParam(name = "content", required = false) String content,
			@RequestParam(name = "msisdn", required = false) String msisdn,
			@RequestParam(name = "timestamp", required = false) String timestamp) {

		System.out.println("Received message jhahahahahahah");

		System.out.println("phonecode is [" + phonecode + "]");
		System.out.println("keyword is [" + keyword + "]");
		System.out.println("location is [" + location + "]");
		System.out.println("carrier is [" + carrier + "]");
		System.out.println("content is [" + content + "]");
		System.out.println("msisdn is [" + msisdn + "]");
		System.out.println("timestamp is [" + timestamp + "]");

	}
}
