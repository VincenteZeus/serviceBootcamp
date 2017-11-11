
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Fournisseur;
import java.util.List;
import javax.persistence.Query;

public class FournisseurRepository  extends BaseRepository<Fournisseur>{
    
    public FournisseurRepository(String unitPersistence) {
        super(unitPersistence, Fournisseur.class);
    }
        
public  List<Fournisseur> getFournisseurOfProgramme(long id){
           String str ="SELECT DISTINCT f FROM Fournisseur f\n" +
                         "JOIN f.programmes fp JOIN fp.programme p WHERE p.id =:identifiant";
           Query query = getEntityManager().createQuery(str);
           query.setParameter("identifiant", id);
           return query.getResultList();
       }

public  List<Fournisseur> getFournisseurOfProjet(long id){
           String str ="SELECT DISTINCT f FROM Fournisseur f\n" +
                         "JOIN f.projets p  WHERE p.id =:identifiant";
           Query query = getEntityManager().createQuery(str);
           query.setParameter("identifiant", id);
           return query.getResultList();
       }
}
