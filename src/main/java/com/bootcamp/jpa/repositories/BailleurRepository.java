package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Bailleur;
import java.util.List;
import javax.persistence.Query;


public class BailleurRepository extends BaseRepository<Bailleur> {

    public BailleurRepository(String unitPersistence) {
        super(unitPersistence, Bailleur.class);
    }
        
       public  List<Bailleur> getBailleurOfProgramme(long id){
           String str ="SELECT b FROM Bailleur b\n" +
                         "JOIN b.programmes bp JOIN bp.programme p WHERE p.id =:identifiant";
           Query query = getEntityManager().createQuery(str);
           query.setParameter("identifiant", id);
           return query.getResultList();
       }
       
       public  List<Bailleur> getBailleurOfProjet(long id){
           String str ="SELECT DISTINCT b FROM Bailleur b\n" +
                         "JOIN b.projets bp JOIN p WHERE p.id =:identifiant";
           Query query = getEntityManager().createQuery(str);
           query.setParameter("identifiant", id);
           return query.getResultList();
       }
       
    }

