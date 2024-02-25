package Exercice2;

import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            int port = 12345; // Numéro de port à écouter
            // Création d'une socket écoutant sur le port spécifié
            DatagramSocket socket = new DatagramSocket(port); 
            //crée un tableau de bytes nommé buffer avec une taille de 1024 octets. Ce tableau est utilisé pour stocker les données reçues du client
            byte[] buffer = new byte[1024];
            // Création d'un DatagramPacket pour recevoir les données du client.
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // Attente de la réception de données du client
            socket.receive(packet);
            
            // Désérialisation de l'objet voiture
            // Crée un nouvel objet ByteArrayInputStream en utilisant le tableau de bytes "buffer" comme source de données.
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            // Crée un flux de lecture d'objets pour désérialiser des objets à partir du flux de bytes fourni par 'bais'
            ObjectInputStream ois = new ObjectInputStream(bais);
            // Désérialisation de l'objet voiture à partir des données reçues du client
            voiture voiture = (voiture) ois.readObject();
            
            // Traitement de l'objet reçu
            System.out.println("Voiture reçue du client : " + voiture.getType() + " " + voiture.getModel());
            
            // Modification de la quantité de carburant dans la voiture côté serveur
            voiture.setCarburant(50); // Par exemple, 50 litres
            
            System.out.println("Quantité de carburant modifiée côté serveur : " + voiture.getCarburant());
            // Fermeture de la socket
            socket.close(); 
            //capturer et gèrer les exceptions IOException et ClassNotFoundException
        } catch (IOException | ClassNotFoundException e) {
        	//afficher les détails de l'exception qui a été levée pendant l'exécution du programme
            e.printStackTrace();
        }
    }
}
