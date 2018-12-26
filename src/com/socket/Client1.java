package com.socket;

/**
 * TODO: SOCKET CLIENT TASK1 (SEND STRING TO SERVER AND SAVE IN FILE)
 * @author zulkarnaen
 */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client1 {

	//TODO: Membuat variable
	private static SocketAddress address;
	private static Socket socket;
	private static ObjectOutputStream os;
	
	public static void main(String[] args) {
		
		// TODO: Konek ke Server dengan ip dan port berikut
		System.out.println("===================SOCKETClient=================");
		String ip = "127.0.0.1";
		int port = 5555;

		// TODO: deklarasi address dan socket
		address = new InetSocketAddress(ip, port);
		socket = new Socket();

		// TODO: Metode try catch untuk mengirim string ke socket SERVER
		try {
			socket.connect(address);
			System.out.println("Terhubung!");
			os = new ObjectOutputStream(socket.getOutputStream());

			//TODO: Kirim STRING
			String msg = "3,MLPT1,14/12/2018 10:35:53,6 \n" 
						+ "4,MLPT2,14/12/2018 10:35:53,7 \n"
						+ "5,MLPT3,14/12/2018 10:35:53,6 \n"
						+ "6,MLPT4,14/12/2018 10:35:53,7 \n"
						+ "7,MLPT5,14/12/2018 10:35:53,6 \n"
						+ "8,MLPT6,14/12/2018 10:35:53,7 \n"
						+ "9,MLPT7,14/12/2018 10:35:53,6 \n"
						+ "10,MLPT8,14/12/2018 10:35:53,7 \n"
						+ "11,MLPT9,14/12/2018 10:35:53,6 \n"
						+ "12,MLPT0,14/12/2018 10:35:53,7 \n"
						+ "13,MLPT11,14/12/2018 10:35:53,6 \n"
						+ "14,MLPT12,14/12/2018 10:35:53,7 \n"
						+ "15,MLPT13,14/12/2018 10:35:53,6";

			//TODO: Membuat objectoutputstream untuk buat writeobject pada string msg
			os.writeObject(msg);

			//TODO: Menutup objectoutputstream dan socket
			os.close();
			socket.close();
			System.out.println("Socket dihentikan.");
			
			//TODO: Membuat Exception agar error dapat diketahui
		} catch (IOException e) {
			System.out.println("Terjadi Error: " + e.getMessage());
		}
	}

}
