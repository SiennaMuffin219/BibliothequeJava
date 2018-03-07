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
    private MembreBibliotheque membreQuiReserve = null, membreQuiEmprunte = null;
    
    private int nbEnPlace, nbEmprunte, nbPileRetour, nbSectionReservation;
    
    public DocBibliotheque(String codeArchivage, String titre, String auteur, int annee)
    {    
        this.codeArchivage = codeArchivage;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.status = "EnPlace";
    }
    
    public boolean emprunter(MembreBibliotheque membre)
    {
        if (this.estEnPlace() || this.estEnSectionReservation())
        {            
            if (this.estEnPlace())
            {
                nbEnPlace--;
                membreQuiReserve = membre;
            }
            else
            {
                if (getMembreQuiEmprunte().equals(membre))
                {
                    nbSectionReservation--;
                    membreQuiEmprunte = membre;
                    membreQuiReserve = null;
                }
                else
                {
                    return false;
                }
            }
            
            nbEmprunte++;
            this.status = "EmprunteNonReserve";
            return true;
        }
        return false;
    }
    
    public boolean reserver(MembreBibliotheque membre)
    {
        if (this.estEmprunte())
        {
            this.status = "ReserveEtEmprunte";
            membreQuiEmprunte = membre;
            return true;
        }
        return false;
    }
    
    public boolean annulerReservation(MembreBibliotheque membre)
    {
        if (getMembreQuiReserve().equals(membre))
        {
            if (this.estReserve())
            {
                this.status = "EmprunteNonReserve";
                membreQuiReserve = null;
                return true;
            }
            if (this.estEnSectionReservation())
            {
                nbEmprunte--;
                this.status = "PileRetour";
                nbPileRetour++;
                membreQuiReserve = null;
                return true;
            }
        }
        return false;
    }
    
    public boolean retourner()
    {
        if (this.estEmprunte())
        {
            nbEmprunte--;
            this.status = "PileRetour";
            nbPileRetour++;
            membreQuiEmprunte = null;
            return true;
        }
        if (this.estReserve())
        {
            nbEmprunte--;
            this.status = "SectionReservation";
            nbSectionReservation++;
            membreQuiEmprunte = null;
            return true;
        }
        return false;
    }
    public boolean ranger()
    {
        if (this.estEnPileRetour())
        {
            nbPileRetour--;
            this.status = "EnPlace";
            nbEnPlace++;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        return "Document :\n\tTitre : " + this.titre + "\n\tAuteur : " + this.auteur + "\n\tAnnée : " + this.annee + "\n\tCode d'archivage : " + this.codeArchivage + "\n\tMembre qui emprunte : " + this.getMembreQuiEmprunte() + "\n\tMembre qui réserve : " + this.getMembreQuiReserve();
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
    public boolean estEnSectionReservation()
    {
        return this.status.equals("SectionReservation");
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

    public MembreBibliotheque getMembreQuiReserve() {
        return membreQuiReserve;
    }

    public MembreBibliotheque getMembreQuiEmprunte() {
        return membreQuiEmprunte;
    }
}
