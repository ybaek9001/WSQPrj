package com.newlecture.webprj.chatservice;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket extends Thread{
	
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private Scanner nscan;
	private PrintWriter nout;
	
	private ReceiveListener receiveListener;
	private boolean isRun=true;
	
	public void setReceiveListener(ReceiveListener receiveListener) {
		this.receiveListener = receiveListener;
	}

	public ClientSocket(String ip, int port) throws IOException
	{
		socket=new Socket(ip, port);
		System.out.println("connected from...."
				+socket.getRemoteSocketAddress().toString());
		init(socket);
	}
	
	private void init(Socket socket) throws IOException {
		
		this.socket=socket;
		is=socket.getInputStream();
		nscan=new Scanner(is);
		os=socket.getOutputStream();
		nout=new PrintWriter(os,true);
		
		start();
	}

	public ClientSocket(Socket socket) throws IOException {
		//���� ����(�����ڿ� �ٽ� �������ִ� 1:1 ����)�� ����:��/��� ��Ʈ�� ���� ����	
		init(socket);
	}
	
	@Override
	public void run() {
		
		// ���� �̺κ��� ������ �� ����
		// �� ���� ĸ�� �̿��ڰ� �Ʒ��κ��� ä���
		
		//runListener.OnRun();
		while(isRun)
		{
			String echo=nscan.nextLine(); // ������ �޾���. ���� ���ұ�?
			
			if(receiveListener!=null)
				receiveListener.OnReceive(echo);
			if(echo.equals("bye"))
				break;
		}
		/*Scanner scan=new Scanner(System.in);
		System.out.println("msg:");
		String msg=scan.nextLine();
		nout.println(msg);
		String echo=nscan.nextLine();
		System.out.println(echo);*/
		
		nout.close();
		nscan.close();
		
		try {
			os.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void send(String msg) {
		// TODO Auto-generated method stub
		nout.println(msg);
	}

	public void close() {
		// TODO Auto-generated method stub
		isRun=false;
	}
}
