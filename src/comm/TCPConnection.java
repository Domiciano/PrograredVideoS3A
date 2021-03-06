package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPConnection extends Thread{
	
	private ServerSocket server;
	private Socket socket;
	private int puerto;
	
	public OnMessageListener listener;
	
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(puerto);
			System.out.println("Esperando un cliente");
			socket = server.accept();
			System.out.println("Cliente conectado");
			InputStream is = socket.getInputStream();
			BufferedReader breader = new BufferedReader(new InputStreamReader(is));
			
			while(true) {
				String msg = breader.readLine();
				listener.onMessage(msg);
			}
			
		}catch(IOException ex) {
			
		}
	}
	
	public void setListener(OnMessageListener listener) {
		this.listener = listener;
	}
	
	public interface OnMessageListener{
		public void onMessage(String msg);
	}
	
	

}
