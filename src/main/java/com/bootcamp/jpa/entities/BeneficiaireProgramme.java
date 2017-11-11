
package com.bootcamp.jpa.entities;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tp_beneficiaire_has_programme")
public class BeneficiaireProgramme implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     
    @NotNull(message="l'attribut typeBeneficiaire doit etre renseigne")
    @Column(length = 20)
     private String typeBenefice;

    // avec beneficiaire
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "beneficiaire_id", referencedColumnName = "id")
     private Beneficiaire beneficiaire;
    
    // avec programme
     @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "programme_id", referencedColumnName = "id")
     private Programme programme;
     
    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeBenefice() {
        return typeBenefice;
    }

    public void setTypeBenefice(String typeBenefice) {
        this.typeBenefice = typeBenefice;
    }
         
}
