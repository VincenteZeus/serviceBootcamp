/*
 * Bignon
 */

package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.enums.TypeBailleur;
import com.bootcamp.jpa.repositories.BailleurRepository;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.Test;

public class BailleurTest {
    @Test
    public void createBailleurTest() throws SQLException{
        // creation d'un premier bailleur
        Bailleur b1 = new Bailleur();
        b1.setNom("grace");
        b1.setTypeBailleur(TypeBailleur.PRIVE);
        BailleurRepository br1 = new BailleurRepository("tpJpa-mysql");
        br1.create(b1);
        
        
        // creation d'un deuxieme baillleur
        Bailleur b2 = new Bailleur();
        b2.setNom("hilaire");
        b2.setTypeBailleur(TypeBailleur.PRIVE);
        BailleurRepository br2 = new BailleurRepository("tpJpa-mysql");
        br2.create(b2);
    }
     // test du update et du findByProperty
    @Test
   public void updateBailleurTest() throws SQLException{
       BailleurRepository br = new BailleurRepository("tpJpa-mysql");
        List<Bailleur> b = br.findByProperty("nom", "hilaire");
        Bailleur b0=b.get(0);
        b0.setNom("kaka");
        br.update(b0);
   } 
   
   // test du delete de fournisseur en memme temp que le findByProperty
    @Test
    public void deleteBailleurTest() throws SQLException{
        BailleurRepository br = new BailleurRepository("tpJpa-mysql");
        List<Bailleur> b = br.findByProperty("nom", "kaka");
        Bailleur b0=b.get(0);
        br.delete(b0);     
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        BailleurRepository br = new BailleurRepository("tpJpa-mysql");
        br.findAll();
    }
}
