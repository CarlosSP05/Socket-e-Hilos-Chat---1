package org.socket.t1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        // Declaración de ServerSocket y Socket
        ServerSocket server = null;
        Socket socket = null;

        // Declaración de flujos de datos
        DataOutputStream out = null;
        DataInputStream in = null;

        // Declaración de puerto
        final int PUERTO = 5225;

        try {
            // Inicialización del ServerSocket
            server = new ServerSocket(PUERTO);
            System.out.println("Servidor esperando conexiones...");

            // Bucle para mantener el servidor siempre a la escucha
            while (true) {
                // Espera a que un cliente realice una petición
                socket = server.accept();
                System.out.println("Cliente conectado");

                // Obtiene la petición del cliente
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                // Bucle de comunicación
                String mensaje;
                boolean salir = false;
                while (!salir) {
                    // Lee el mensaje del cliente
                    mensaje = in.readUTF();
                    System.out.println("Mensaje recibido: " + mensaje);

                    // Si el cliente escribe "FIN", se termina la conversación
                    if (mensaje.equals("FIN")) {
                        salir = true;
                    } else {
                        out.writeUTF("Respuesta: " + mensaje); // Responde al cliente
                    }
                }

                // Cierra los flujos de datos y el socket
                out.close();
                in.close();
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
