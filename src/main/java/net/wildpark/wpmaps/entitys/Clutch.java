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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Zekart
 */
@Entity
@Table(name = "clutch")

public class Clutch implements Serializable {

    @Lob
    @Column(name = "CONDITIONS")
    private byte[] conditions;
    @ManyToMany(mappedBy = "clutchCollection")
    private Collection<Cable> cableCollection;
    @OneToMany(mappedBy = "clutchId")
    private Collection<Pillar> pillarCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "INPUTS")
    private Integer inputs;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COUNTCASSETS")
    private Integer countcassets;
    @Size(max = 255)
    @Column(name = "INFO")
    private String info;

    public Clutch() {
    }

    public Clutch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInputs() {
        return inputs;
    }

    public void setInputs(Integer inputs) {
        this.inputs = inputs;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountcassets() {
        return countcassets;
    }

    public void setCountcassets(Integer countcassets) {
        this.countcassets = countcassets;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        if (!(object instanceof Clutch)) {
            return false;
        }
        Clutch other = (Clutch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.wildpark.wpmaps.entitys.Clutch[ id=" + id + " ]";
    }


    @XmlTransient
    public Collection<Pillar> getPillarCollection() {
        return pillarCollection;
    }

    public void setPillarCollection(Collection<Pillar> pillarCollection) {
        this.pillarCollection = pillarCollection;
    }


    @XmlTransient
    public Collection<Cable> getCableCollection() {
        return cableCollection;
    }

    public void setCableCollection(Collection<Cable> cableCollection) {
        this.cableCollection = cableCollection;
    }

    public byte[] getConditions() {
        return conditions;
    }

    public void setConditions(byte[] conditions) {
        this.conditions = conditions;
    }
    
}
