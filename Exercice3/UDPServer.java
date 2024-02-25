package ex3;

import java.net.*;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Cr�ation d'une socket UDP
            DatagramSocket serverSocket = new DatagramSocket(1250);
            //cr�e un tableau de bytes nomm� buffer avec une taille de 1024 octets. Ce tableau est utilis� pour stocker les donn�es re�ues du client
            byte[] receiveData = new byte[1024];
            // D�claration d'un tableau de bytes pour stocker les donn�es � envoyer au serveur
            byte[] sendData;
            
            while (true) {
                // Pr�paration du paquet pour recevoir les donn�es
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                // R�ception du paquet
                serverSocket.receive(receivePacket);
                
                // R�cup�ration de l'adresse IP de l'�metteur
                InetAddress IPAddress = receivePacket.getAddress();
                // R�cup�ration du port de l'�metteur
                int port = receivePacket.getPort();
                
                // R�cup�ration de la date et de l'heure actuelle
                String datetime = new Date().toString();
                
                // Conversion de la date et de l'heure en tableau de bytes
                sendData = datetime.getBytes();
                
                // Cr�ation du paquet pour envoyer les donn�es
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                
                // Envoi du paquet
                serverSocket.send(sendPacket);
            }
            
        } 
        //indiquer que le code � l'int�rieur du bloc "try" peut g�n�rer une exception de type "Exception" ou de toute sous-classe de "Exception", et qu'il doit �tre g�r� dans ce bloc de code.
        catch (Exception e) {
        	//intercepter n'importe quelle exception qui est une sous-classe de la classe Exception
            e.printStackTrace();
        }
    }
}
