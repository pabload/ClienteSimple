
package ejemplocliente1;

import java.io.*;
import java.net.*;

public class EjemploCliente1 {

    public static void main(String[] args) {
        String ip = args[0];
        int puerto = Integer.valueOf(args[1]);
        String mensaje = args[2];
        crearSocketCliente(ip, puerto, mensaje);
    }
    public static void crearSocketCliente(String ip, int puerto,String mensaje){
        try {
            Socket socket = null;
            socket = new Socket(ip, puerto);
            EscribirMensaje(socket, mensaje);
        } catch (IOException e) {
            System.out.println("Error al crear el socket " + e.toString());
            System.exit(1);
        }
    }
    public static void EscribirMensaje(Socket socket,String mensaje){
        PrintWriter escritor = null;
        try {
            escritor = new PrintWriter(socket.getOutputStream(), true);
            escritor.println(mensaje);
            cerrarSocket(socket);
        } catch (IOException e) {
            System.out.println("Error al escribir mensaje " + e.toString());
            System.exit(2);
        }
    }
    public static void cerrarSocket(Socket socket){
         try{
            socket.close();
        }catch(IOException e){
            System.out.println("Error al cerrar socket " + e.toString());
            System.exit(3);
        }
    }
    

}
