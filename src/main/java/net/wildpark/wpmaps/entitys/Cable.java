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

/**
 *
 * @author Zekart
 */
@Entity
@Table(name = "cable")
@XmlRootElement

public class Cable implements Serializable {

    @JoinTable(name = "clutch_has_cable", joinColumns = {
        @JoinColumn(name = "cable_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "clutch_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Clutch> clutchCollection;

    @OneToMany(mappedBy = "cabelId")
    private Collection<Pillar> pillarCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "CAPACITY")
    private String capacity;
    @Size(max = 255)
    @Column(name = "INPLACE")
    private String inplace;
    @Column(name = "LENGTHCABLE")
    private Integer lengthcable;
    @Size(max = 255)
    @Column(name = "MARKING")
    private String marking;
    @Column(name = "MODULECOUNT")
    private Integer modulecount;
    @Size(max = 255)
    @Column(name = "OUTPLACE")
    private String outplace;
    @Size(max = 255)
    @Column(name = "PRODUCTION")
    private String production;
    @JoinColumn(name = "FIBER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Fiber fiberId;

    public Cable() {
    }

    public Cable(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getInplace() {
        return inplace;
    }

    public void setInplace(String inplace) {
        this.inplace = inplace;
    }

    public Integer getLengthcable() {
        return lengthcable;
    }

    public void setLengthcable(Integer lengthcable) {
        this.lengthcable = lengthcable;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Integer getModulecount() {
        return modulecount;
    }

    public void setModulecount(Integer modulecount) {
        this.modulecount = modulecount;
    }

    public String getOutplace() {
        return outplace;
    }

    public void setOutplace(String outplace) {
        this.outplace = outplace;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
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
        if (!(object instanceof Cable)) {
            return false;
        }
        Cable other = (Cable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.wildpark.wpmaps.entitys.Cable[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Pillar> getPillarCollection() {
        return pillarCollection;
    }

    public void setPillarCollection(Collection<Pillar> pillarCollection) {
        this.pillarCollection = pillarCollection;
    }

    @XmlTransient
    public Collection<Clutch> getClutchCollection() {
        return clutchCollection;
    }

    public void setClutchCollection(Collection<Clutch> clutchCollection) {
        this.clutchCollection = clutchCollection;
    }
    
}
