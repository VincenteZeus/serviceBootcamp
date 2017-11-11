/*
 * Bignon
 */

package com.bootcamp;

import com.bootcamp.jpa.entities.Programme;
import com.bootcamp.jpa.repositories.ProgrammeRepository;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;


public class ProgrammeTest {
    @Test
    public void createProgrammeTest() throws SQLException, ParseException{
        
        Date dateD = new SimpleDateFormat("yyyy/MM/dd").parse("2017/01/01"); 
        Date dateF = new SimpleDateFormat("yyyy/MM/dd").parse("2017/01/15"); 
        // creation d'un fournisseur
        Programme b1 = new Programme();
        b1.setNom("gram1");
        b1.setObjectif("la vie pour la vie");
        b1.setBudgetEffectif(100);
        b1.setBudgetPrevisionnel(98);
        b1.setDateDeDebut(dateD);
        b1.setDateDeFin(dateF);
        
        ProgrammeRepository pr1 = new ProgrammeRepository("tpJpa-mysql");
        pr1.create(b1);
        
        
    }
    
  // test du findAll
    @Test
    public void findAllTest(){
        ProgrammeRepository br = new ProgrammeRepository("tpJpa-mysql");
        br.findAll();
    }
}
