/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zekart
 */
@Entity
@Table(name = "sleeve")
@XmlRootElement

public class Sleeve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INDICATION")
    private Double indication;
    @Column(name = "TYPESLEEVE")
    private Double typesleeve;
    @OneToMany(mappedBy = "sleeveId")
    private Collection<Fiber> fiberCollection;
    @JoinColumn(name = "FIBER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Fiber fiberId;

    public Sleeve() {
    }

    public Sleeve(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getIndication() {
        return indication;
    }

    public void setIndication(Double indication) {
        this.indication = indication;
    }

    public Double getTypesleeve() {
        return typesleeve;
    }

    public void setTypesleeve(Double typesleeve) {
        this.typesleeve = typesleeve;
    }

    @XmlTransient
    public Collection<Fiber> getFiberCollection() {
        return fiberCollection;
    }

    public void setFiberCollection(Collection<Fiber> fiberCollection) {
        this.fiberCollection = fiberCollection;
    }

    public Fiber getFiberId() {
        return fiberId;
    }

    public void setFiberId(Fiber fiberId) {
        this.fiberId = fiberId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sleeve)) {
            return false;
        }
        Sleeve other = (Sleeve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.wildpark.wpmaps.entitys.Sleeve[ id=" + id + " ]";
    }
    
}
