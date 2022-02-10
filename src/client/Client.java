package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 6000);
			
			OutputStream os = socket.getOutputStream();
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(os));
			
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				String line = scanner.nextLine()+"\n";
				bwriter.write(line);
				bwriter.flush();
			}
			
		}catch(IOException ex) {
			
		}

	}

}
