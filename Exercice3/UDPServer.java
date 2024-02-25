package ex3;

import java.net.*;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Création d'une socket UDP
            DatagramSocket serverSocket = new DatagramSocket(1250);
            //crée un tableau de bytes nommé buffer avec une taille de 1024 octets. Ce tableau est utilisé pour stocker les données reçues du client
            byte[] receiveData = new byte[1024];
            // Déclaration d'un tableau de bytes pour stocker les données à envoyer au serveur
            byte[] sendData;
            
            while (true) {
                // Préparation du paquet pour recevoir les données
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                // Réception du paquet
                serverSocket.receive(receivePacket);
                
                // Récupération de l'adresse IP de l'émetteur
                InetAddress IPAddress = receivePacket.getAddress();
                // Récupération du port de l'émetteur
                int port = receivePacket.getPort();
                
                // Récupération de la date et de l'heure actuelle
                String datetime = new Date().toString();
                
                // Conversion de la date et de l'heure en tableau de bytes
                sendData = datetime.getBytes();
                
                // Création du paquet pour envoyer les données
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                
                // Envoi du paquet
                serverSocket.send(sendPacket);
            }
            
        } 
        //indiquer que le code à l'intérieur du bloc "try" peut générer une exception de type "Exception" ou de toute sous-classe de "Exception", et qu'il doit être géré dans ce bloc de code.
        catch (Exception e) {
        	//intercepter n'importe quelle exception qui est une sous-classe de la classe Exception
            e.printStackTrace();
        }
    }
}
