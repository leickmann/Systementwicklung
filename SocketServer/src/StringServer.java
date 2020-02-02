import java.io.*;
import java.net.*;
import java.util.Scanner;

public class StringServer {
	
	private static void handleConnection(Socket client) throws IOException {
		Scanner in = new Scanner(client.getInputStream());
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		
		String str = in.nextLine();
		
		out.println(str);
	}

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3141);
		
		while (true) {
			Socket client = null;
			
			try {
				client = server.accept();
				handleConnection(client);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				if (client != null)
					try {
						client.close();
					}catch (IOException e ) {}
			}
		}
	}

}
