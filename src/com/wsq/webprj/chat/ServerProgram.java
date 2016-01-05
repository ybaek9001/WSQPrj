package com.wsq.webprj.chat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerProgram {
	
	public ServerProgram() throws IOException {
		List<ClientSocket> clients=new ArrayList<ClientSocket>();
		Socket sock;
		
		ServerSocket svrSocket=new ServerSocket(10009);
		Date date=new Date();
		System.out.println("server started........at "+date.toString());
		
		while(true)
		{
			sock=svrSocket.accept();   //
			System.out.println("connected from...."
					+sock.getRemoteSocketAddress().toString());
			
			ClientSocket clt=new ClientSocket(sock);
			clt.setReceiveListener(new ReceiveListener() {
				
				@Override
				public void OnReceive(String echo) {
					String[] datas = echo.split("#");
					
					String msg = String.format("%s:%s\n", datas[0],datas[1]);
					System.out.println(msg);
					
					for(ClientSocket c:clients)
						c.send(echo);
					
					if(datas[1].equals("bye"))
					{
						clt.close();
					}
				}
			});
			clients.add(clt);
			System.out.println("프로그램 종료");
		}
	}
}

