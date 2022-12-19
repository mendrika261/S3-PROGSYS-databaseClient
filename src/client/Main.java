package client;

import client.display.Color;
import client.exception.ArgumentMissingException;
import client.exception.InvalidHostnameException;
import client.exception.InvalidPortException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ArgumentMissingException, InvalidHostnameException, InvalidPortException {
        if(args.length!=2)
            throw new ArgumentMissingException();

        verifyArgs(args[0], args[1]);

        System.out.println("-- Client --");

        try {
            Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            long start, end;

            while (true) {
                System.out.print("Requête >> ");
                String query = scanner.nextLine();

                start = System.currentTimeMillis();

                dataOutputStream.writeUTF(Formatter.removeDuplicatePunctuation(query));
                String serverMessage = dataInputStream.readUTF();
                if (serverMessage.equalsIgnoreCase("EXIT")) break;

                System.out.println(serverMessage);

                end = System.currentTimeMillis();

                System.out.println(Color.YELLOW + "Transfert and process Time: " + (end - start) + "ms" + Color.RESET);
                System.out.println();
            }

        } catch (SocketException | UnknownHostException | EOFException e) {
            if(e.getMessage() !=null && e.getMessage().equals("Connection reset"))
                System.out.println(Color.YELLOW + "\tLe serveur s'est arrêté, attendez la maintenance" + Color.RESET);
            else
                System.out.println(Color.YELLOW + "\tLe serveur demandé est indisponible" + Color.RESET);
        } catch (Exception e) {
            System.out.println(Color.YELLOW + "\tUn erreur s'est produit! Réessayer ulterierement" + Color.RESET);
            System.exit(0);
        } finally {
            System.out.println("-- Fin client --");
        }
    }

    static void verifyArgs(String host, String port) throws InvalidHostnameException, InvalidPortException {
        if(!isValidHost(host)) throw new InvalidHostnameException();
        if(!isValidNumber(port, 4) && !isValidNumber(port, 5)) throw new InvalidPortException();
    }

    static boolean isValidHost(String host) {
        String[] parts = host.split("\\.");
        if(parts.length != 4) return false;
        for (String part:parts)
            if(!isValidNumber(part, 3) && !isValidNumber(part, 2) && !isValidNumber(part, 1)) return false;
        return true;
    }

    static boolean isValidNumber(String port, int length) {
        if(port.length() != length) return false;
        try {
            Integer.parseInt(port);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
