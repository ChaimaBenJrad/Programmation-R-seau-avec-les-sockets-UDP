package ex3;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Création d'une socket UDP
            DatagramSocket clientSocket = new DatagramSocket();
            
            // Adresse IP du serveur
            InetAddress serverIPAddress = InetAddress.getByName("localhost");
            
            // Port du serveur
            int serverPort = 1250;
            
            // Données à envoyer
            byte[] sendData = new byte[1024];
            // Données à recevoir
            byte[] receiveData = new byte[1024];
            
            // Envoi du datagramme au serveur
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverPort);
            //envoyer le datagramme préparé sendPacket vers le serveur.
            clientSocket.send(sendPacket);
            
            // Préparation du paquet pour recevoir la réponse
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            // Réception de la réponse du serveur
            clientSocket.receive(receivePacket);
            
            // Conversion des données reçues en chaîne de caractères
            String response = new String(receivePacket.getData());
            
            // Affichage de la réponse
            System.out.println("Réponse du serveur : " + response.trim());
            
            // Fermeture de la socket
            clientSocket.close();
        }
        //indiquer que le code à l'intérieur du bloc "try" peut générer une exception de type "Exception" ou de toute sous-classe de "Exception", et qu'il doit être géré dans ce bloc de code.
        catch (Exception e) {
        	//intercepter n'importe quelle exception qui est une sous-classe de la classe Exception
            e.printStackTrace();
        }
    }
}

