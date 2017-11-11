/*
 * Bignon
 */
package com.bootcamp.rest.controller;

import com.bootcamp.jpa.entities.IndicateurPerformance;
import com.bootcamp.jpa.entities.IndicateurQualitatif;
import com.bootcamp.jpa.entities.IndicateurQuantitatif;
import com.bootcamp.jpa.repositories.IndicateurPerformanceRepository;
import com.bootcamp.jpa.repositories.IndicateurQualitatifRepository;
import com.bootcamp.jpa.repositories.IndicateurQuantitatifRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/indicateur/performance")
public class IndicateurPerformanceRestController {
    IndicateurPerformanceRepository ipr = new IndicateurPerformanceRepository("tpJpa-mysql");
    IndicateurQualitatifRepository iQualir = new IndicateurQualitatifRepository("tpJpa-mysql");
    IndicateurQuantitatifRepository iQuantir = new IndicateurQuantitatifRepository("tpJpa-mysql");


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)//ou @Produces("application/json")
    public Response getAll() {
        
        try {
            List<IndicateurPerformance> liste = ipr.findAll();
            return Response.status(200).entity(liste).build();
        } catch (Exception e) {
            return Response.status(404).entity("Pas d'enregistrement !").build();
            //e.printStackTrace();
         }
        
    }
   
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") int valeur) throws SQLException {
            
             try {
            IndicateurPerformance ip = ipr.findById(valeur);
            return Response.status(200).entity(ip).build();
        } catch (Exception e) {
            return Response.status(404).entity("Pas d'enregistrement à ce id!").build();
         }
    }
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IndicateurPerformance ip) throws SQLException {
        /*
        try {
            ipr.create(ip);
            return Response.status(200).entity("Bien Creer").build();
        } catch (Exception e) {
            return Response.status(404).entity("Erreur lors de la creation"+e).build();
        }*/
        
        boolean boolQuanti = false;
        boolean boolQuali = false;
        
        
        List<IndicateurQualitatif> listOfQuali = ip.getIndicateurQualitatifs();
            boolQuali = isIndicateurQualitatifExist(listOfQuali);
            
            List<IndicateurQuantitatif> listOfQuanti = ip.getIndicateurQuantitatifs();
            boolQuanti = isIndicateurQuantitatifExist(listOfQuanti);
            
            if(boolQuali && boolQuanti){
                 try {         
            
            ip.setIndicateurQualitatifs(listOfQuali);
            ip.setIndicateurQuantitatifs(listOfQuanti);
            
            ipr.create(ip);
        return Response.status(200).entity("Bien Creer, les deux existaient deja").build();
        } catch (Exception e) {
            return Response.status(404).entity("Erreur lors de la creation"+e).build();
        }
            }else if(!boolQuali && boolQuanti){
                List<IndicateurQualitatif> newliste = new ArrayList<IndicateurQualitatif>();
                try {
                    for (IndicateurQualitatif indicateurQualitatif : listOfQuali) {
                         iQualir.update(indicateurQualitatif);
                         newliste.add(indicateurQualitatif);
                    }
            ip.setIndicateurQualitatifs(newliste);
            ip.setIndicateurQuantitatifs(listOfQuanti);
            ipr.create(ip);    
        return Response.status(200).entity("Bien Creer, Qualitatif n'existait pas").build();
        } catch (Exception e) {
            return Response.status(404).entity("Erreur lors de la creation"+e).build();
        }
            }else if(boolQuali && !boolQuanti){
            List<IndicateurQuantitatif> newliste = new ArrayList<IndicateurQuantitatif>();
            try {
                    for (IndicateurQuantitatif indicateurQuantitatif : listOfQuanti) {
                         iQuantir.update(indicateurQuantitatif);
                         newliste.add(indicateurQuantitatif);
                    }
            ip.setIndicateurQuantitatifs(newliste);
            ip.setIndicateurQualitatifs(listOfQuali);
            ipr.create(ip);    
        return Response.status(200).entity("Bien Creer, Quantitatif n'existait pas").build();
        } catch (Exception e) {
            return Response.status(404).entity("Erreur lors de la creation"+e).build();
        }
            }else{
                List<IndicateurQualitatif> newlisteQuali = new ArrayList<IndicateurQualitatif>();
                List<IndicateurQuantitatif> newlisteQuanti = new ArrayList<IndicateurQuantitatif>();
                try {
                    for (IndicateurQualitatif indicateurQualitatif : listOfQuali) {
                         iQualir.update(indicateurQualitatif);
                         newlisteQuali.add(indicateurQualitatif);
                    }
            ip.setIndicateurQualitatifs(newlisteQuali);
            
            for (IndicateurQuantitatif indicateurQuantitatif : listOfQuanti) {
                         iQuantir.update(indicateurQuantitatif);
                         newlisteQuanti.add(indicateurQuantitatif);
                    }
            ip.setIndicateurQuantitatifs(newlisteQuanti);
            
            ipr.create(ip);
        return Response.status(200).entity("Bien Creer, Qualitatif et Quantitatif n'existaient pas").build();
        } catch (Exception e) {
            return Response.status(404).entity("Erreur lors de la creation de l'un ou l'autre"+e).build();
        }
                    

            }
       
    }
    

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(IndicateurPerformance ip) throws SQLException {
        try {
            ipr.update(ip);
            return Response.status(200).entity("Mise à jour bien faite").build();
        } catch (Exception e) {
            return Response.status(404).entity("Un probleme lors de la mise à jour").build();
        }
        
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int valeur) throws SQLException {  
        IndicateurPerformance ip;     
        try {
            ip = ipr.findById(valeur);
            ipr.delete(ip);
            return Response.status(200).entity("Le Programme d'id: "+valeur+" a bien été supprimé").build();
        } catch (Exception e) {
            return Response.status(404).entity("Un probleme lors de la suppression du programme d'id "+valeur).build();
        }
        
    }
    
    // verifier si indicateurQuantitatif existe
    public Boolean isIndicateurQuantitatifExist(List<IndicateurQuantitatif> indicateurQuantitatifs){
        Boolean bool = false;
        List<Boolean> fin = new ArrayList<Boolean>();
        List<Boolean> suite = new ArrayList<Boolean>();
        for (IndicateurQuantitatif indicateurQuantitatif : indicateurQuantitatifs) {
            List<IndicateurQuantitatif> liste = iQuantir.findByObject(indicateurQuantitatif);
            if(liste.isEmpty()){
            fin.add(true);
            suite.add(false);
        }else{
           fin.add(true);
            suite.add(true);
            }
        }
        
        if(fin.equals(suite))
        bool = true;
        
        return bool;
    }
    
    // verify if indicateurQualitation exists
    public Boolean isIndicateurQualitatifExist(List<IndicateurQualitatif> indicateurQualitatifs){
        Boolean bool = false;
        List<Boolean> fin = new ArrayList<Boolean>();
        List<Boolean> suite = new ArrayList<Boolean>();
        for (IndicateurQualitatif indicateurQualitatif : indicateurQualitatifs) {
            List<IndicateurQualitatif> liste = iQualir.findByObject(indicateurQualitatif);
            if(liste.isEmpty()){
            fin.add(true);
            suite.add(false);
        }else{
           fin.add(true);
            suite.add(true);
            }
        }
        
        if(fin.equals(suite))
        bool = true;
        
        return bool;
    }
    
    public Boolean isQualiExiste(List<IndicateurQualitatif> indicateurQualitatifs){
        
        boolean bool = false;
        List<IndicateurQualitatif> liste = iQualir.findAll();
        if(liste.contains(indicateurQualitatifs)){
            bool = true;
        }
        
        return bool;
    }
}
