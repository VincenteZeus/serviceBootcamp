/*
 * Bignon
 */
package com.bootcamp.json.jsonClasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class ClassesToJson {
        
    //INSTANCIATION DE ObjectMapper
    ObjectMapper om = new ObjectMapper(); 
    
    public String className;
    
    public ClassesToJson() {   
    }
    
    
   // Methode qui prend le nom du fichier selon la classe et retourne l'objet de type File
    public static File generateFile(String fileName){
        File file = new File("JsonFolder/".concat(fileName));
        return file;
    }
   
     public void convertObjectToJson(Class c, Object ec) throws IOException, SQLException{
        
        // CREATION DE L'OBJET DANS LE FICHIER projet.json
            // SERIALIZATION
         File file = generateFile(c.getSimpleName().toLowerCase()+".json");
        om.writeValue(file, ec);
        System.out.println("FICHIER  BIEN  CREER");
        
   }
     
     public String simpleConvertObjectToJson(Object ec) throws IOException, SQLException{
        
        // SEREALISATION D'UN OBJET EN JSON SANS QUE QUE CE NE SOIT DANS UN FICHIER
            // SERIALIZATION
       String result = om.writeValueAsString(ec);    
        return result;
   }
        
}
