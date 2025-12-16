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
                socket = server.accept(); // <-- Se bloquea esperando hasta que un cliente se conecte
                System.out.println("Cliente conectado");

                // Simulamos un bloqueo añadiendo un delay de 15 segundos
                Thread.sleep(15000); // Simula un bloqueo del servidor

                // Obtiene la petición del cliente
                in = new DataInputStream(socket.getInputStream());
                // Envía la respuesta al cliente
                out = new DataOutputStream(socket.getOutputStream());

                // Lee el mensaje del cliente
                String mensaje = in.readUTF();
                System.out.println("Mensaje recibido: " + mensaje);

                // Envía la respuesta al cliente
                out.writeUTF("Hola cliente, te saludo desde el servidor");

                // Cierra los flujos de datos
                out.close();
                in.close();

                // Cierra el socket
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
