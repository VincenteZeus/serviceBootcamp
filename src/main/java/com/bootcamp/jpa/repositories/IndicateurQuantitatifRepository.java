
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.IndicateurQuantitatif;
import java.util.List;
import javax.persistence.Query;

public class IndicateurQuantitatifRepository extends BaseRepository<IndicateurQuantitatif>{
  
    public IndicateurQuantitatifRepository(String unitPersistence) {
        super(unitPersistence, IndicateurQuantitatif.class);
    }
    
    public List<IndicateurQuantitatif> findByObject(IndicateurQuantitatif iq){
            String nom = iq.getNom(); 
            String propriete = iq.getPropriete();
            int valeur = iq.getValeur();
            
            String str = "select obj from IndicateurQualitatif obj where obj.nom="+nom+" andWhere obj.propriete="+propriete+" andWhere obj.valeur="+valeur;
            Query query = getEntityManager().createQuery(str);
             List<IndicateurQuantitatif> result = query.getResultList();
          
            return result;
    }
}
