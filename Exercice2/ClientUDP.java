package Exercice2;

import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            // Création d'un objet voiture
            voiture voiture = new voiture("SUV", "BMW");
            
            // Sérialisation de l'objet voiture
            // Cela permettra de sérialiser l'objet voiture et de le stocker dans la mémoire sous forme de tableau d'octets.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //crée un nouvel objet ObjectOutputStream qui sera utilisé pour écrire des objets Java dans un flux de sortie (stream).
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // Sérialisation de l'objet voiture et écriture dans le flux de sortie objet (oos)
            oos.writeObject(voiture);
            //récupérer les données sérialisées de l'objet voiture sous forme d'un tableau d'octets
            byte[] data = baos.toByteArray();
            // Envoi de l'objet sérialisé au serveur via UDP
            // Adresse IP du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost"); 
            // Création d'une socket
            DatagramSocket socket = new DatagramSocket();
            //numéro de port
            int port =12345;
            // Création d'un paquet contenant les données à envoyer
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, port ); 
            //l'envoi des données au serveur spécifié par l'adresse IP et le numéro de port.
            socket.send(packet); 
            System.out.println("Objet voiture envoyé au serveur.");
            // Fermeture de la socket
            socket.close(); 
         // Capture toute exception d'entrée/sortie qui peut survenir lors de l'exécution des opérations de lecture ou d'écriture sur les flux de données, ou lors de la communication via le réseau.
        } catch (IOException e) {
        	// Affiche l'erreur complète sur la sortie standard d'erreur, ce qui permet de déboguer plus facilement en connaissant la nature et le contexte de l'erreur.
            e.printStackTrace(); 
        }

    }
}
