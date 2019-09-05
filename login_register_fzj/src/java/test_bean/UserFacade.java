/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import test.User;
import java.util.Date;
import javax.persistence.Persistence;

/**
 *
 * @author 22236
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "test_program_6PU")
    private EntityManager em;
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User login(String x){
        User u = new User();
       emf = Persistence.createEntityManagerFactory("test_program_6PU");
       em = emf.createEntityManager();
        u = (User) em.createNamedQuery("User.findByEmail").setParameter("email",x ).getSingleResult();
        System.err.println(u.getEmail());
        return u;
    }
    
    
    
     public void register_user(String name,String email,String passwd,Date user_post_date,int sex){
        User u = new User();
        u.setName(name);
        u.setPasswd(passwd);
        u.setEmail(email);
        u.setSex(sex);
        u.setUserPostDate(user_post_date);
        this.create(u);
      }
}
