/*
 * Bignon
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Fournisseur;
import com.bootcamp.jpa.repositories.FournisseurRepository;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.testng.annotations.Test;

public class FournisseurTest {
    @Test
    public void createFournisseurTest() throws ParseException, SQLException{
        // creation d'un premier fournisseur
        Fournisseur f1 = new Fournisseur();
        f1.setNom("fefe");
        FournisseurRepository br1 = new FournisseurRepository("tpJpa-mysql");
        br1.create(f1);
        
        
        // creation d'un deuxieme fournisseur
        Fournisseur f2 = new Fournisseur();
        f2.setNom("darex");
        FournisseurRepository br2 = new FournisseurRepository("tpJpa-mysql");
        br2.create(f2);
        
    }
    
    // test du update et du findByProperty
    @Test
   public void updateFournisseurTest() throws SQLException{
       FournisseurRepository fr = new FournisseurRepository("tpJpa-mysql");
        List<Fournisseur> f = fr.findByProperty("nom", "fefe");
        Fournisseur f0=f.get(0);
        f0.setNom("agodotodji");
        fr.update(f0);
   } 
   
   // test du delete de fournisseur en memme temp que le findByProperty
    @Test
    public void deleteFournisseurTest() throws SQLException{
        FournisseurRepository br = new FournisseurRepository("tpJpa-mysql");
        List<Fournisseur> b = br.findByProperty("nom", "darex");
        Fournisseur b0=b.get(0);
        br.delete(b0);     
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        FournisseurRepository br = new FournisseurRepository("tpJpa-mysql");
        br.findAll();
    }
}
