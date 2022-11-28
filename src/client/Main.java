package client;

import client.display.Color;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        System.out.println("-- Client --");

        Scanner scanner = new Scanner(System.in);
        long start, end;

        while(true) {
            System.out.print("Requête >> ");
            String query = scanner.nextLine();

            start = System.currentTimeMillis();

            dataOutputStream.writeUTF(query);
            String serverMessage = dataInputStream.readUTF();
            if(serverMessage.equals("exit")) {
                socket.close();
                break;
            }

            System.out.println(serverMessage);

            end = System.currentTimeMillis();

            System.out.println(Color.YELLOW + "Transfert and process Time: "+(end-start)+"ms" + Color.RESET);
            System.out.println();
        }

        System.out.println("-- Fin client --");
    }
}
