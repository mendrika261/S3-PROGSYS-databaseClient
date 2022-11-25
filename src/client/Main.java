package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        System.out.println("-- Client --");

        Scanner scanner = new Scanner(System.in);
        long start= 0L, end= 0L;

        while(true) {
            System.out.print("Requête >> ");
            String query = scanner.nextLine();
            if(query.toLowerCase().equals("exit")) break;
            start = System.currentTimeMillis();

            dataOutputStream.writeUTF(query);
            System.out.println(dataInputStream.readUTF());

            end = System.currentTimeMillis();
            System.out.println("Transfert and process Time: "+(end-start)+"ms");
        }

        socket.close();
        System.out.println("-- Fin client --");
    }
}
