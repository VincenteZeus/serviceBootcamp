package com.bootcamp.jpa.entities;

import com.bootcamp.jpa.enums.TypeBailleur;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tp_bailleur")
@DiscriminatorValue("bailleur")
public class Bailleur extends Personne{
    
    @Enumerated(EnumType.STRING)
    @NotNull(message="le type doit etre defini")
    private TypeBailleur typeBailleur;
    
    @ManyToMany(mappedBy = "bailleurs")
    private List<Projet> projets = new ArrayList<Projet>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bailleur")
    private List<BailleurProgramme> programmes = new ArrayList<BailleurProgramme>();  
    
    // consructeur

    public Bailleur() {
        this.setNom("nomParDefaut");
        this.typeBailleur = TypeBailleur.GOUVERNEMENT;
    }
    
    
    public TypeBailleur getTypeBailleur() {
        return typeBailleur;
    }

    public void setTypeBailleur(TypeBailleur typeBailleur) {
        this.typeBailleur = typeBailleur;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<BailleurProgramme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<BailleurProgramme> programmes) {
        this.programmes = programmes;
    }
    
    
}
