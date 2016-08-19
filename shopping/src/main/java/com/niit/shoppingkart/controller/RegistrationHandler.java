package com.niit.shoppingkart.controller;


import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.niit.shoppingkart.model.UserDetails;


@Component
public class RegistrationHandler {
	
		public UserDetails initFlow(){
			return new UserDetails();
		}
		
		public String validateDetails(UserDetails userDetails,MessageContext messageContext){
			String status = "success";
			if(userDetails.getId().isEmpty()){
				messageContext.addMessage(new MessageBuilder().error().source(
						"userId").defaultText("UserId cannot be Empty").build());
				status = "failure";
			}
			if(userDetails.getMailID().isEmpty()){
				messageContext.addMessage(new MessageBuilder().error().source(
						"email").defaultText("Email cannot be Empty").build());
				status = "failure";
			}
			if(userDetails.getAddress()==null){
				messageContext.addMessage(new MessageBuilder().error().source(
						"age").defaultText("Age cannot be Empty").build());
				status = "failure";
			}
			return status;
		}
	

}
