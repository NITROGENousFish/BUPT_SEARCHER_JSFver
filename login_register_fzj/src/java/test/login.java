/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;
import java.lang.System;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;
import test_bean.UserFacade;
/**
 *
 * @author 22236
 */
@Named
@RequestScoped
public class login {
    @EJB
     private test_bean.UserFacade uc;
     private DataModel items = null;
    private String email;
    private String passwd;
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPasswd(){
        return passwd;
    }
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
    
    public String login(){
       
       
     UserFacade uf  = new UserFacade();
     uf.login(email);
      return "newxhtml";
    }
    
}
