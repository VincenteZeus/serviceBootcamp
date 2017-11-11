package com.bootcamp.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tp_fournisseur")
@DiscriminatorValue("fournisseur")
public class Fournisseur extends Personne{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fournisseur")
    private List<FournisseurProgramme> programmes = new ArrayList<FournisseurProgramme>();
    
    @ManyToMany(mappedBy = "fournisseurs")
    private List<Projet> projets = new ArrayList<Projet>();

    public List<FournisseurProgramme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<FournisseurProgramme> programmes) {
        this.programmes = programmes;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    
}
