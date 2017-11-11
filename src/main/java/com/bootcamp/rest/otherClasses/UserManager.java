/*
 *Bignon
 */
package com.bootcamp.rest.otherClasses;

import com.bootcamp.jpa.entities.User;

public class UserManager {
    
    User user = new User();	
    public void setUser(User u){
		this.user = u;
}
	public User getUser(){
		return this.user;
	}
}
