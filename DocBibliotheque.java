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
public class DocBibliotheque
{
    private int annee;
    private String codeArchivage, titre, auteur;
    private String status;
    
    public DocBibliotheque(String codeArchivage, String titre, String auteur, int annee)
    {
        this.codeArchivage = codeArchivage;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.status = "EnPlace";
    }
    
    public boolean emprunter()
    {
        if (this.estEnPlace() || this.estEnAttente())
        {
            this.status = "EmprunteNonReserve";
            return true;
        }
        return false;
    }
    public boolean reserver()
    {
        if (this.estEmprunte())
        {
            this.status = "ReserveEtEmprunte";
            return true;
        }
        return false;
    }
    public boolean annulerReservation()
    {
        if (this.estReserve())
        {
            this.status = "EmprunteNonReserve";
            return true;
        }
        if (this.estEnAttente())
        {
            this.status = "PileRetour";
            return true;
        }
        return false;
    }
    public boolean retourner()
    {
        if (this.estEmprunte())
        {
            this.status = "PileRetour";
            return true;
        }
        if (this.estReserve())
        {
            this.status = "PileReservation";
            return true;
        }
        return false;
    }
    public boolean ranger()
    {
        if (this.estEnPileRetour())
        {
            this.status = "EnPlace";
            return true;
        }
        return false;
    }

    public String getStatus()
    {
        return this.status;
    }
    public boolean estEnPlace()
    {
        return this.status.equals("EnPlace");
    }
    public boolean estEmprunte()
    {
        return this.status.equals("EmprunteNonReserve");
    }
    public boolean estReserve()
    {
        return this.status.equals("ReserveEtEmprunte");
    }
    public boolean estEnPileRetour()
    {
        return this.status.equals("PileRetour");
    }
    public boolean estEnAttente()
    {
        return this.status.equals("PileReservation");
    }
    
    public String getCodeArchivage()
    {
        return this.codeArchivage;
    }
    public String getTitre()
    {
        return this.titre;
    }
    public String getAuteur()
    {
        return this.auteur;
    }
    public int getAnnee()
    {
        return this.annee;
    }
    
    public void setCodeArchivage(String codeArchivage)
    {
        this.codeArchivage = codeArchivage;
    }
    public void setTitre(String titre)
    {
        this.titre = titre;
    }
    public void setAuteur(String auteur)
    {
        this.auteur = auteur;
    }
    public void setAnnee(int annee)
    {
        this.annee = annee;
    }
}
