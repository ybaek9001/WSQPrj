package com.newlecture.webprj.chatservice;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@ServerEndpoint("/content/chatserver")
public class ChatServerEndPoint{
	private static Set<Session> clients =
			Collections.synchronizedSet(new HashSet <Session>());
	
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config){
		System.out.println("접속되었습니다");
		clients.add(session);
	}
	
	@OnMessage
	public void onTextMessage(Session session, String data) throws IOException, ParseException{
		System.out.println(data);
		
		JSONParser jsonParser = new JSONParser();
        //JSON데이터를 넣어 JSON Object 로 만들어 준다.
        JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
        
        String uid = (String)jsonObject.get("uid");
        String msg = (String)jsonObject.get("msg");
        
        System.out.println(
        		String.format("uid:%s, msg:%s\n", uid, msg));
        
		for(Session s:clients)
			s.getBasicRemote().sendText(data);
	}
	
	@OnClose
	public void onClose(Session session){
		clients.remove(session);
		System.out.println("접속이 끊겼습니다");
		
	}
}
