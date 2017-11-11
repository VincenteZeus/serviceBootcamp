package com.bootcamp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tp_livrable")
public class Livrable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="l'attribut nom doit etre renseigne")
    @Column(length = 20)
    private String nom;
    
    @NotNull(message="l'attribut dateDebut doit etre renseigne")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeDebut;
    
    @NotNull(message="l'attribut dateFin doit etre renseigne")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeFin;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projet", referencedColumnName = "id")
    private Projet projet;
    
    @OneToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateurPerformance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }
    
    
}
