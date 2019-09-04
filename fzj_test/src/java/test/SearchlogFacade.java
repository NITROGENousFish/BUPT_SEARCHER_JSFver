/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lizon
 */
@Stateless
public class SearchlogFacade extends AbstractFacade<Searchlog> {

    @PersistenceContext(unitName = "fzj_testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SearchlogFacade() {
        super(Searchlog.class);
    }
    
}
