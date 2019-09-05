/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 22236
 */
@Embeddable
public class CurrentsearchPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "log_id")
    private int logId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_search")
    private int orderSearch;

    public CurrentsearchPK() {
    }

    public CurrentsearchPK(int logId, int orderSearch) {
        this.logId = logId;
        this.orderSearch = orderSearch;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getOrderSearch() {
        return orderSearch;
    }

    public void setOrderSearch(int orderSearch) {
        this.orderSearch = orderSearch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) logId;
        hash += (int) orderSearch;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrentsearchPK)) {
            return false;
        }
        CurrentsearchPK other = (CurrentsearchPK) object;
        if (this.logId != other.logId) {
            return false;
        }
        if (this.orderSearch != other.orderSearch) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.CurrentsearchPK[ logId=" + logId + ", orderSearch=" + orderSearch + " ]";
    }
    
}
