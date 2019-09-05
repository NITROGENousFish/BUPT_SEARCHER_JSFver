/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import test.Prefersettings;

/**
 *
 * @author 22236
 */
@Stateless
public class PrefersettingsFacade extends AbstractFacade<Prefersettings> {

    @PersistenceContext(unitName = "test_program_6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrefersettingsFacade() {
        super(Prefersettings.class);
    }
    
}
