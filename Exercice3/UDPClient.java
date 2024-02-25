package ex3;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Cr�ation d'une socket UDP
            DatagramSocket clientSocket = new DatagramSocket();
            
            // Adresse IP du serveur
            InetAddress serverIPAddress = InetAddress.getByName("localhost");
            
            // Port du serveur
            int serverPort = 1250;
            
            // Donn�es � envoyer
            byte[] sendData = new byte[1024];
            // Donn�es � recevoir
            byte[] receiveData = new byte[1024];
            
            // Envoi du datagramme au serveur
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverPort);
            //envoyer le datagramme pr�par� sendPacket vers le serveur.
            clientSocket.send(sendPacket);
            
            // Pr�paration du paquet pour recevoir la r�ponse
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            // R�ception de la r�ponse du serveur
            clientSocket.receive(receivePacket);
            
            // Conversion des donn�es re�ues en cha�ne de caract�res
            String response = new String(receivePacket.getData());
            
            // Affichage de la r�ponse
            System.out.println("R�ponse du serveur : " + response.trim());
            
            // Fermeture de la socket
            clientSocket.close();
        }
        //indiquer que le code � l'int�rieur du bloc "try" peut g�n�rer une exception de type "Exception" ou de toute sous-classe de "Exception", et qu'il doit �tre g�r� dans ce bloc de code.
        catch (Exception e) {
        	//intercepter n'importe quelle exception qui est une sous-classe de la classe Exception
            e.printStackTrace();
        }
    }
}

