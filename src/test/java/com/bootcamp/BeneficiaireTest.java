/*
 * Bignon
 */
package com.bootcamp;

import com.bootcamp.jpa.entities.Beneficiaire;
import com.bootcamp.jpa.repositories.BeneficiaireRepository;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.testng.annotations.Test;

public class BeneficiaireTest {
    @Test
    public void createBeneficiaireTest() throws ParseException, SQLException{
        // creation d'un premier beneficiaire
        Beneficiaire b1 = new Beneficiaire();
        b1.setNom("grav");
        
        BeneficiaireRepository br1 = new BeneficiaireRepository("tpJpa-mysql");
        br1.create(b1);
        
        
        // creation d'un deuxieme beneficiaire
        Beneficiaire b2 = new Beneficiaire();
        b2.setNom("bello");
        BeneficiaireRepository br2 = new BeneficiaireRepository("tpJpa-mysql");
        br2.create(b2);
        
    }
    
    // test du update et du findByProperty
    @Test
   public void updateBeneficiaireTest() throws SQLException{
       BeneficiaireRepository br = new BeneficiaireRepository("tpJpa-mysql");
        List<Beneficiaire> b = br.findByProperty("nom", "bello");
        Beneficiaire b0=b.get(0);
        b0.setNom("agaman");
        br.update(b0);
   } 
   
   // test du delete de beneficiaire en memme temp que le findByProperty
    @Test
    public void deleteBeneficiaireTest() throws SQLException{
        BeneficiaireRepository br = new BeneficiaireRepository("tpJpa-mysql");
        List<Beneficiaire> b = br.findByProperty("nom", "agaman");
        Beneficiaire b0=b.get(0);
        br.delete(b0);     
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        BeneficiaireRepository br = new BeneficiaireRepository("tpJpa-mysql");
        br.findAll();
    }
}
