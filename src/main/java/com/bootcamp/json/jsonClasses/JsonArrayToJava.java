package com.bootcamp.json.jsonClasses;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @Bignon
 * @param <T>
 */
public class JsonArrayToJava<T> {
    
    public List<T> converteJsonArrayToObject(File file,Object obj) throws IOException{
        //INSTANCIATION DE ObjectMapper
    ObjectMapper om = new ObjectMapper(); 
    
         List<T> list = om.readValue(file,
        TypeFactory.defaultInstance().constructCollectionType(List.class,  
       obj.getClass()) );
         
         return list;
    }
}
