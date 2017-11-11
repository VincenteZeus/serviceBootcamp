
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.User;
import javax.persistence.Query;

public class UserRepository extends BaseRepository<User>{
  
    public UserRepository(String unitPersistence) {
        super(unitPersistence, User.class);
    }
    
    public User findByLoginAndPwd(String login, String pwd){
         String str = "select obj FROM User obj WHERE obj.login=:param1 AND obj.pwd=:param2";
            Query query = getEntityManager().createQuery(str);
            query.setParameter("param1", login);
            query.setParameter("param2", pwd);
            
            User result = (User) query.getSingleResult();
            
            return result;
    }
}
