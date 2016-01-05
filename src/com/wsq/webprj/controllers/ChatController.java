package com.wsq.webprj.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/chat/")
public class ChatController {
	
	@RequestMapping("chat")
	public String chat() throws IOException
	{
		
		return "chat/chat";
	}
}
