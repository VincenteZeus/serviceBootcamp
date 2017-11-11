/*
 * Bignon
 */


package com.bootcamp;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.entities.Programme;
import com.bootcamp.json.jsonClasses.ClassesToJson;
import com.bootcamp.json.jsonClasses.JsonArrayToJava;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import org.testng.annotations.Test;

public class JsonTest {
    @Test
    public void bailleurJsonTest() throws SQLException, IOException{
        // Instanciation de ClassesToJson
        ClassesToJson c = new  ClassesToJson();
        
        // creation de bailleur
        Bailleur b = new Bailleur();
        //Serealisation avec la methode cree a cet effet
        c.convertObjectToJson(Bailleur.class, c);
                   
    }
    
    @Test
    public void ProgrammeJsonTest() throws SQLException, IOException{
        // Instanciation de ClassesToJson
        ClassesToJson c = new  ClassesToJson();
        
        // creation de bailleur
        Programme b = new Programme();
        //Serealisation avec la methode cree a cet effet
        c.convertObjectToJson(Programme.class, c);
        
            
    }
}
