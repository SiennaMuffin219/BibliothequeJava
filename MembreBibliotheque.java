/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotheque;

/**
 *
 * @author Olivier
 */
public class MembreBibliotheque
{
    private String nom, prenom, numTelephone, adresse;
    private int numAbonne;
    private static int dernierNumeroAbonne = 0;
    
    public MembreBibliotheque(String nom, String prenom, String numTelephone, String adresse)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.numTelephone = numTelephone;
        this.adresse = adresse;
        this.numAbonne = ++dernierNumeroAbonne;
    }
    
    @Override
    public String toString()
    {
        return "Membre :\n\tNom : " + this.nom + "\n\tPrénom : " + this.prenom + "\n\tNuméro de téléphone : " + this.numTelephone + "\n\tAdresse : " + this.adresse;              
    }

    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    public String getNumTelephone()
    {
        return numTelephone;
    }
    public void setNumTelephone(String numTelephone)
    {
        this.numTelephone = numTelephone;
    }
    public String getAdresse()
    {
        return adresse;
    }
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }
    public int getNumAbonne()
    {
        return numAbonne;
    }
    public void setNumAbonne(int numAbonne)
    {
        this.numAbonne = numAbonne;
    }
}
