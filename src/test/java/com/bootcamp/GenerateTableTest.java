package com.bootcamp;

import java.sql.SQLException;
import java.text.ParseException;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.Properties;


public class GenerateTableTest {

    @Test
    public void generateTables() throws ParseException, SQLException{
        Persistence.generateSchema("tpRest-mysql", new Properties());
        //Persistence.generateSchema("tpRest-derby", new Properties());
    }
    
	
}
