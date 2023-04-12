package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NotificationRequestDto;
import com.example.demo.dto.PnsRequest;
import com.example.demo.dto.SubscriptionRequestDto;
import com.example.demo.service.FCMService;
import com.google.firebase.messaging.BatchResponse;

@RestController
public class PushNotificationController {
	
		
	
	 	@Autowired
	    private FCMService fcmService;

	    @PostMapping("/send-notification")
	    public ResponseEntity<BatchResponse> sendSampleNotification(@RequestBody PnsRequest pnsRequest) {
			String token = pnsRequest.getToken();
			String title = pnsRequest.getTitle();
			String message = pnsRequest.getMessage();
	        return new ResponseEntity<BatchResponse>(fcmService.pushNotification(pnsRequest), HttpStatus.OK);
	    }
	    
	    @PostMapping("/receive-notification")
	    public void receiveNotification(@RequestBody Map<String, Object> payload) {
	        System.out.println("Received notification:");
	        System.out.println(payload);
	    }
	   

}
