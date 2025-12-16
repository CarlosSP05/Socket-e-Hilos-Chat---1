package org.socket.t1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class GestorCliente implements Runnable {
    private Socket socket;

    public GestorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            String mensaje;
            boolean salir = false;
            while (!salir) {
                mensaje = in.readUTF();
                System.out.println("Mensaje recibido: " + mensaje);

                // Si el cliente envía "FIN", termina la conversación
                if (mensaje.equalsIgnoreCase("FIN")) {
                    salir = true;
                    out.writeUTF("Sesión terminada. ¡Hasta luego!");
                } 
                // Si el cliente envía "TIME", responder con la hora
                else if (mensaje.equalsIgnoreCase("TIME")) {
                    out.writeUTF("La hora actual es: " + java.time.LocalTime.now());
                } 
                // Comportamiento predeterminado
                else {
                    out.writeUTF("Respuesta: " + mensaje);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class server {
    public static void main(String[] args) {
        final int PUERTO = 5225;
        try (ServerSocket server = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Cliente conectado");

                // Crear y lanzar un hilo para manejar al cliente
                Thread hilo = new Thread(new GestorCliente(socket));
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
