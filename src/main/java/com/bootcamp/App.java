package com.bootcamp;

import com.bootcamp.jpa.entities.User;
import com.bootcamp.jpa.repositories.UserRepository;
import com.bootcamp.rest.otherClasses.UserManager;
import com.bootcamp.rest.security.JavaJsonWebToken;
import java.sql.SQLException;

public class App 
{
    
        
    public static void main( String[] args ) throws SQLException{
        
        methode();
        
        JavaJsonWebToken jwt = new JavaJsonWebToken();
        String iat = "Dieu", subject ="fefe";
        long tm = 900000; // 15 min
        
        jwt.createJWT(iat,subject,tm);
        System.out.println("\n Token: "+jwt.getToken());
        
        jwt.parseJWT(jwt.getToken());
        System.out.println("\n Valide");
              
    }
    
    public static void methode() throws SQLException{
        UserRepository ur = new UserRepository("tpJpa-mysql");
        UserManager um = new UserManager();
    
        User user0 = ur.findById(1);
        User user1 = ur.findById(2);
        
        um.setUser(user0);
        
        
    }
    /*
    private User returnUser0() throws SQLException{
        return this.ur.findById(1);
    }
    
     private User returnUser1() throws SQLException{
        return this.ur.findById(2);
    }
     
     public void login(User user){
         this.um.setUser(user);
     }*/
}
