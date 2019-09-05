/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 22236
 */
@Entity
@Table(name = "prefersettings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prefersettings.findAll", query = "SELECT p FROM Prefersettings p")
    , @NamedQuery(name = "Prefersettings.findByUserId", query = "SELECT p FROM Prefersettings p WHERE p.userId = :userId")
    , @NamedQuery(name = "Prefersettings.findByBackgroundId", query = "SELECT p FROM Prefersettings p WHERE p.backgroundId = :backgroundId")
    , @NamedQuery(name = "Prefersettings.findByIsUseJs", query = "SELECT p FROM Prefersettings p WHERE p.isUseJs = :isUseJs")})
public class Prefersettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "background_id")
    private int backgroundId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_use_js")
    private int isUseJs;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Prefersettings() {
    }

    public Prefersettings(Integer userId) {
        this.userId = userId;
    }

    public Prefersettings(Integer userId, int backgroundId, int isUseJs) {
        this.userId = userId;
        this.backgroundId = backgroundId;
        this.isUseJs = isUseJs;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public int getIsUseJs() {
        return isUseJs;
    }

    public void setIsUseJs(int isUseJs) {
        this.isUseJs = isUseJs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prefersettings)) {
            return false;
        }
        Prefersettings other = (Prefersettings) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Prefersettings[ userId=" + userId + " ]";
    }
    
}
