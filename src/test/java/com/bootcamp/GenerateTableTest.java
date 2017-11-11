/*
 * Bignon
 */

package com.bootcamp;

import com.bootcamp.jpa.repositories.BailleurRepository;
import java.sql.SQLException;
import java.text.ParseException;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.Properties;


public class GenerateTableTest {

    @Test
    public void generateTables() throws ParseException, SQLException{
        Persistence.generateSchema("tpJpa-mysql", new Properties());
        //Persistence.generateSchema("tpJpa-derby", new Properties());
    }
    
	
}
