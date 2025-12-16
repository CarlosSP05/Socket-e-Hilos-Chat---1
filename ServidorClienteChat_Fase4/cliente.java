package org.socket.t1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {

        final String HOST = "localhost";  // También puedes usar "127.0.0.1"
        final int PUERTO = 5225;

        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            Socket socket = new Socket(HOST, PUERTO);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String mensaje;

            // Bucle de conversación
            while (true) {
                System.out.print("Escribe un mensaje: ");
                mensaje = scanner.nextLine();
                out.writeUTF(mensaje); // Envía el mensaje al servidor

                // Si el cliente escribe "FIN", termina la conversación
                if (mensaje.equalsIgnoreCase("FIN")) break;

                // Recibe la respuesta del servidor
                System.out.println("Servidor: " + in.readUTF());
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
