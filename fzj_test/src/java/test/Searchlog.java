/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lizon
 */
@Entity
@Table(name = "searchlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Searchlog.findAll", query = "SELECT s FROM Searchlog s")
    , @NamedQuery(name = "Searchlog.findByLogId", query = "SELECT s FROM Searchlog s WHERE s.logId = :logId")
    , @NamedQuery(name = "Searchlog.findBySearchword", query = "SELECT s FROM Searchlog s WHERE s.searchword = :searchword")
    , @NamedQuery(name = "Searchlog.findByTime", query = "SELECT s FROM Searchlog s WHERE s.time = :time")
    , @NamedQuery(name = "Searchlog.findByIp", query = "SELECT s FROM Searchlog s WHERE s.ip = :ip")})
public class Searchlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "log_id")
    private Integer logId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "searchword")
    private String searchword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ip")
    private String ip;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "searchlog")
    private Collection<Currentsearch> currentsearchCollection;

    public Searchlog() {
    }

    public Searchlog(Integer logId) {
        this.logId = logId;
    }

    public Searchlog(Integer logId, String searchword, Date time, String ip) {
        this.logId = logId;
        this.searchword = searchword;
        this.time = time;
        this.ip = ip;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getSearchword() {
        return searchword;
    }

    public void setSearchword(String searchword) {
        this.searchword = searchword;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Currentsearch> getCurrentsearchCollection() {
        return currentsearchCollection;
    }

    public void setCurrentsearchCollection(Collection<Currentsearch> currentsearchCollection) {
        this.currentsearchCollection = currentsearchCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Searchlog)) {
            return false;
        }
        Searchlog other = (Searchlog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Searchlog[ logId=" + logId + " ]";
    }
    
}
