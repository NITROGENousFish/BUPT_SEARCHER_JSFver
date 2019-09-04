/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lizon
 */
@Entity
@Table(name = "currentsearch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currentsearch.findAll", query = "SELECT c FROM Currentsearch c")
    , @NamedQuery(name = "Currentsearch.findByLogId", query = "SELECT c FROM Currentsearch c WHERE c.currentsearchPK.logId = :logId")
    , @NamedQuery(name = "Currentsearch.findByOrderSearch", query = "SELECT c FROM Currentsearch c WHERE c.currentsearchPK.orderSearch = :orderSearch")})
public class Currentsearch implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CurrentsearchPK currentsearchPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "log_id", referencedColumnName = "log_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Searchlog searchlog;

    public Currentsearch() {
    }

    public Currentsearch(CurrentsearchPK currentsearchPK) {
        this.currentsearchPK = currentsearchPK;
    }

    public Currentsearch(CurrentsearchPK currentsearchPK, String description) {
        this.currentsearchPK = currentsearchPK;
        this.description = description;
    }

    public Currentsearch(int logId, int orderSearch) {
        this.currentsearchPK = new CurrentsearchPK(logId, orderSearch);
    }

    public CurrentsearchPK getCurrentsearchPK() {
        return currentsearchPK;
    }

    public void setCurrentsearchPK(CurrentsearchPK currentsearchPK) {
        this.currentsearchPK = currentsearchPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Searchlog getSearchlog() {
        return searchlog;
    }

    public void setSearchlog(Searchlog searchlog) {
        this.searchlog = searchlog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currentsearchPK != null ? currentsearchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currentsearch)) {
            return false;
        }
        Currentsearch other = (Currentsearch) object;
        if ((this.currentsearchPK == null && other.currentsearchPK != null) || (this.currentsearchPK != null && !this.currentsearchPK.equals(other.currentsearchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Currentsearch[ currentsearchPK=" + currentsearchPK + " ]";
    }
    
}
