package com.socket;

/**
 * TODO: SOCKET SERVER TASK1 (SEND STRING TO SERVER AND SAVE IN FILE)
 * @author zulkarnaen
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	// TODO: Membuat variable
	private static ServerSocket serverSocket;
	private static Socket client;
	private static ObjectInputStream ois;

	public static void main(String[] args) throws IOException {
		
		System.out.println("==================SOCKETServer===================");

		try {
			//TODO: Membuat socket baru dengan socket 5555
			serverSocket = new ServerSocket(5555);
			System.out.println("Menunggu Client...");
			
			//TODO: Socket client jika diterima
			client = serverSocket.accept();
			System.out.println("Client Terhubung!");
			
			//TODO: objectinputstream baru dengan client(socket) mengambil inputstream
			ois = new ObjectInputStream(client.getInputStream());

			//TODO: string msg itu adalah hasil dari objectinputstream dari client
			String msg = (String) ois.readObject();
			System.out.println("\n======== Ada Pesan Data ========");
			System.out.println("======== Data yang Masuk ======="  + "\n" + msg + "\n"
							 + "================================ \n ");

			// TODO: data client masuk kedalam file server
			File file = new File("D:/zServer/Task1.csv");
			
			//TODO: setelah didapat filenya lalu melakukan manipulasi masukan ke DATABASE
			SendCSVtoDatabase.readCsv();
			SendCSVtoDatabase.readCsvUsingLoad();
			
			//TODO: Hasil nya di olah
			FileOutputStream fis = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fis);
			Writer w = new BufferedWriter(osw);
			
			//TODO: Menulis hasil message
			w.write(msg);
			w.close();
			
			//TODO: Memutuskan semua jalur
			ois.close();
			client.close();
			System.out.println("Client ditutup.\n");

			serverSocket.close();
			System.out.println("Server ditutup.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
