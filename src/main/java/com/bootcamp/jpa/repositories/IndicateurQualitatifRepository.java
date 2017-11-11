
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.IndicateurQualitatif;
import java.util.List;
import javax.persistence.Query;

public class IndicateurQualitatifRepository extends BaseRepository<IndicateurQualitatif>{
  
    public IndicateurQualitatifRepository(String unitPersistence) {
        super(unitPersistence, IndicateurQualitatif.class);
    }
    
    public List<IndicateurQualitatif> findByObject(IndicateurQualitatif iq){
            String nom = iq.getNom(); 
            String propriete = iq.getPropriete();
            String valeur = iq.getValeur();
            
            String str = "select obj from IndicateurQualitatif obj WHERE obj.nom="+nom+" AND obj.propriete="+propriete+" AND obj.valeur="+valeur;
            Query query = getEntityManager().createQuery(str);
             List<IndicateurQualitatif> result = query.getResultList();
          
            return result;
    }
    
    
}
