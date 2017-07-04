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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import net.wildpark.wpmaps.enums.FiberType;

/**
 *
 * @author Zekart
 */
@Entity
@Table(name = "fiber")
@XmlRootElement

public class Fiber implements Serializable {

    @JoinTable(name = "fiber_sleeve", joinColumns = {
        @JoinColumn(name = "Fiber_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "sleeve_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Sleeve> sleeve1Collection;
    @OneToMany(mappedBy = "fiberId")
    private Collection<Cable> cableCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ADDRESSOWNER")
    private String addressowner;
    @Size(max = 255)
    @Column(name = "INDICATIONREFLECTOR")
    private String indicationreflector;
    @Column(name = "NUMBER")
    private Integer number;
    @Column(name = "TYPEFIBER")
    private FiberType typefiber;
    @JoinColumn(name = "SLEEVE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Sleeve sleeveId;
    @OneToMany(mappedBy = "fiberId")
    private Collection<Sleeve> sleeveCollection;

    public Fiber() {
    }

    public Fiber(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressowner() {
        return addressowner;
    }

    public void setAddressowner(String addressowner) {
        this.addressowner = addressowner;
    }

    public String getIndicationreflector() {
        return indicationreflector;
    }

    public void setIndicationreflector(String indicationreflector) {
        this.indicationreflector = indicationreflector;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public FiberType getTypefiber() {
        return typefiber;
    }

    public void setTypefiber(FiberType typefiber) {
        this.typefiber = typefiber;
    }


    public Sleeve getSleeveId() {
        return sleeveId;
    }

    public void setSleeveId(Sleeve sleeveId) {
        this.sleeveId = sleeveId;
    }

    @XmlTransient
    public Collection<Sleeve> getSleeveCollection() {
        return sleeveCollection;
    }

    public void setSleeveCollection(Collection<Sleeve> sleeveCollection) {
        this.sleeveCollection = sleeveCollection;
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
        if (!(object instanceof Fiber)) {
            return false;
        }
        Fiber other = (Fiber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.wildpark.wpmaps.entitys.Fiber_1[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Sleeve> getSleeve1Collection() {
        return sleeve1Collection;
    }

    public void setSleeve1Collection(Collection<Sleeve> sleeve1Collection) {
        this.sleeve1Collection = sleeve1Collection;
    }

    @XmlTransient
    public Collection<Cable> getCableCollection() {
        return cableCollection;
    }

    public void setCableCollection(Collection<Cable> cableCollection) {
        this.cableCollection = cableCollection;
    }
    
}
