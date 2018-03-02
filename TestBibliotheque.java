/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotheque;

/**
 *
 * @author p1700007
 */
public class TestBibliotheque {
    public static void main(String[] args) {
        DocBibliotheque livre1 = new DocBibliotheque("004. 178 K20PM", "Introduction à Java", "J. Leblanc", 2015);
        DocBibliotheque livre2 = new DocBibliotheque("967. 4987 T248O", "Structure de Données", "M. Machin", 2013);
        DocBibliotheque livre3 = new DocBibliotheque("42424242", "La vie, l'univers et tout le reste", "Douglas Adams", 2005);
        DocBibliotheque livre4 = new DocBibliotheque("1337", "1337", "M. 1337", 1337);
        
        livre3.emprunter();
        livre3.reserver();
        System.out.println("livre3 peut être rangé ? " + livre3.ranger());
        livre3.retourner();
        
        System.out.println("livre4 en place ? " + livre4.estEnPlace());
        livre4.emprunter();
        livre4.reserver();
        System.out.println("livre4 emprunté ? " + livre4.estEmprunte());
        System.out.println("livre4 reservé ? " + livre4.estReserve());
        livre4.annulerReservation();
        System.out.println("livre4 reservé ? " + livre4.estReserve());
        livre4.retourner();
        livre4.ranger();
        System.out.println("livre4 en place ? " + livre4.estEnPlace());
        
        System.out.println("livre1.codeArchivage: " + livre1.getCodeArchivage());
        System.out.println("livre2.codeArchivage: " + livre2.getCodeArchivage());
        System.out.println("livre1.titre: " + livre1.getTitre());
        System.out.println("livre2.titre: " + livre2.getTitre());
        System.out.println("livre1.auteur: " + livre1.getAuteur());
        System.out.println("livre2.auteur: " + livre2.getAuteur());

        livre1.setTitre("Introduction à JavaLand");
        System.out.println("livre1.titre: " + livre1.getTitre());
        livre1.setAuteur("Friedrich Nietzsche");
        System.out.println("livre1.auteur: " + livre1.getAuteur());

        System.out.println("livre1.annee: " + livre1.getAnnee());
        System.out.println("livre2.annee: " + livre2.getAnnee());
        livre1.setAnnee(livre1.getAnnee()+42);
        livre2.setAnnee(livre2.getAnnee()+1337);
        System.out.println("livre1.annee: " + livre1.getAnnee());
        System.out.println("livre2.annee: " + livre2.getAnnee());
        
        MembreBibliotheque membre1 = new MembreBibliotheque("42", "42", "42", "42");
        System.out.println(membre1.getNumAbonne());
        MembreBibliotheque membre2 = new MembreBibliotheque("42", "42", "42", "42");
        System.out.println(membre2.getNumAbonne());
    }
}
