package Exercice2;

import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            // Cr�ation d'un objet voiture
            voiture voiture = new voiture("SUV", "BMW");
            
            // S�rialisation de l'objet voiture
            // Cela permettra de s�rialiser l'objet voiture et de le stocker dans la m�moire sous forme de tableau d'octets.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //cr�e un nouvel objet ObjectOutputStream qui sera utilis� pour �crire des objets Java dans un flux de sortie (stream).
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // S�rialisation de l'objet voiture et �criture dans le flux de sortie objet (oos)
            oos.writeObject(voiture);
            //r�cup�rer les donn�es s�rialis�es de l'objet voiture sous forme d'un tableau d'octets
            byte[] data = baos.toByteArray();
            // Envoi de l'objet s�rialis� au serveur via UDP
            // Adresse IP du serveur
            InetAddress serverAddress = InetAddress.getByName("localhost"); 
            // Cr�ation d'une socket
            DatagramSocket socket = new DatagramSocket();
            //num�ro de port
            int port =12345;
            // Cr�ation d'un paquet contenant les donn�es � envoyer
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, port ); 
            //l'envoi des donn�es au serveur sp�cifi� par l'adresse IP et le num�ro de port.
            socket.send(packet); 
            System.out.println("Objet voiture envoy� au serveur.");
            // Fermeture de la socket
            socket.close(); 
         // Capture toute exception d'entr�e/sortie qui peut survenir lors de l'ex�cution des op�rations de lecture ou d'�criture sur les flux de donn�es, ou lors de la communication via le r�seau.
        } catch (IOException e) {
        	// Affiche l'erreur compl�te sur la sortie standard d'erreur, ce qui permet de d�boguer plus facilement en connaissant la nature et le contexte de l'erreur.
            e.printStackTrace(); 
        }

    }
}
