package com.niit.shoppingkart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.shoppingkart.dao.UserDAO;
import com.niit.shoppingkart.model.UserDetails;


@Component
public class RegistrationHandler {
		@Autowired
		private UserDAO userDAO;
	
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
			if(status =="success")
			{
				System.out.println(userDetails.getId());
				
				userDAO.saveOrUpdate(userDetails);
				
			}
			return status;
		}
		
	

}
