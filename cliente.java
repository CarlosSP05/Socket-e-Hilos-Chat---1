package org.socket.t1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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

            // Enviar un mensaje al servidor
            out.writeUTF("Hola servidor, te saludo desde el cliente");

            // Recibir respuesta del servidor
            String mensaje = in.readUTF();
            System.out.println("Mensaje recibido: " + mensaje);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
