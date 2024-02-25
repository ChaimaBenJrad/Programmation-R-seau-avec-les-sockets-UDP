package Exercice2;

import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            int port = 12345; // Num�ro de port � �couter
            // Cr�ation d'une socket �coutant sur le port sp�cifi�
            DatagramSocket socket = new DatagramSocket(port); 
            //cr�e un tableau de bytes nomm� buffer avec une taille de 1024 octets. Ce tableau est utilis� pour stocker les donn�es re�ues du client
            byte[] buffer = new byte[1024];
            // Cr�ation d'un DatagramPacket pour recevoir les donn�es du client.
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // Attente de la r�ception de donn�es du client
            socket.receive(packet);
            
            // D�s�rialisation de l'objet voiture
            // Cr�e un nouvel objet ByteArrayInputStream en utilisant le tableau de bytes "buffer" comme source de donn�es.
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            // Cr�e un flux de lecture d'objets pour d�s�rialiser des objets � partir du flux de bytes fourni par 'bais'
            ObjectInputStream ois = new ObjectInputStream(bais);
            // D�s�rialisation de l'objet voiture � partir des donn�es re�ues du client
            voiture voiture = (voiture) ois.readObject();
            
            // Traitement de l'objet re�u
            System.out.println("Voiture re�ue du client : " + voiture.getType() + " " + voiture.getModel());
            
            // Modification de la quantit� de carburant dans la voiture c�t� serveur
            voiture.setCarburant(50); // Par exemple, 50 litres
            
            System.out.println("Quantit� de carburant modifi�e c�t� serveur : " + voiture.getCarburant());
            // Fermeture de la socket
            socket.close(); 
            //capturer et g�rer les exceptions IOException et ClassNotFoundException
        } catch (IOException | ClassNotFoundException e) {
        	//afficher les d�tails de l'exception qui a �t� lev�e pendant l'ex�cution du programme
            e.printStackTrace();
        }
    }
}
