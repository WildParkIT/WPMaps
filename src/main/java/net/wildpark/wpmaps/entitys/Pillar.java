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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import net.wildpark.wpmaps.enums.PillarCapacity;
import net.wildpark.wpmaps.enums.PillarMaterial;
import net.wildpark.wpmaps.enums.PillarOwner;
import net.wildpark.wpmaps.enums.PillarType;

/**
 *
 * @author Zekart
 */

@Entity
@Table(name = "pillar")


public class Pillar implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LAT")
    private double lat;
    @Column(name = "LNG")
    private double lng;
    @Column(name = "MATHERIALLPILLAR")
    private PillarMaterial matheriallPillar;
    @Column(name = "NUMBERTRANSPOTRSTATION")
    private int numbertranspotrstation;
    @Column(name = "OWNER")
    private PillarOwner owner;
    @Size(max = 255)
    @Column(name = "TRANSPORTSTATION")
    private String transportstation;
    @Column(name = "TYPE")
    private PillarType type;
    @Lob
    @Column(name = "PHOTOPILLAR")
    private byte[] photopillar;
    @Column(name = "CAPACITYPILLAR")
    private PillarCapacity capacityPillar;
    @OneToMany(mappedBy = "pillarin")
    private Collection<ConnectionPillar> connectionPillarCollection;
    @OneToMany(mappedBy = "pillarout")
    private Collection<ConnectionPillar> connectionPillarCollection1;
    
    @JoinColumn(name = "CABEL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cable cabelId;
    @JoinColumn(name = "CLUTCH_ID", referencedColumnName = "ID")
    @ManyToOne
    private Clutch clutchId;

    
    
    public Pillar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransportstation() {
        return transportstation;
    }

    public void setTransportstation(String transportstation) {
        this.transportstation = transportstation;
    }

    public int getNumbertranspotrstation() {
        return numbertranspotrstation;
    }

    public void setNumbertranspotrstation(int numbertranspotrstation) {
        this.numbertranspotrstation = numbertranspotrstation;
    }

    public PillarOwner getOwner() {
        return owner;
    }

    public void setOwner(PillarOwner owner) {
        this.owner = owner;
    }

    public PillarType getType() {
        return type;
    }

    public void setType(PillarType type) {
        this.type = type;
    }

    public PillarMaterial getMatheriallPillar() {
        return matheriallPillar;
    }

    public void setMatheriallPillar(PillarMaterial matheriallPillar) {
        this.matheriallPillar = matheriallPillar;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public PillarCapacity getCapacityPillar() {
        return capacityPillar;
    }

    public void setCapacityPillar(PillarCapacity capacityPillar) {
        this.capacityPillar = capacityPillar;
    }
    
    

    public Cable getCabelId() {
        return cabelId;
    }

    public void setCabelId(Cable cabelId) {
        this.cabelId = cabelId;
    }

    public Clutch getClutchId() {
        return clutchId;
    }

    public void setClutchId(Clutch clutchId) {
        this.clutchId = clutchId;
    }
    
    @Override
    public String toString() {
        return "net.wildpark.wpmaps.entitys.Pillar[ id=" + id + " ]";
    }


    @XmlTransient
    public Collection<ConnectionPillar> getConnectionPillarCollection() {
        return connectionPillarCollection;
    }

    public void setConnectionPillarCollection(Collection<ConnectionPillar> connectionPillarCollection) {
        this.connectionPillarCollection = connectionPillarCollection;
    }

    @XmlTransient
    public Collection<ConnectionPillar> getConnectionPillarCollection1() {
        return connectionPillarCollection1;
    }

    public void setConnectionPillarCollection1(Collection<ConnectionPillar> connectionPillarCollection1) {
        this.connectionPillarCollection1 = connectionPillarCollection1;
    }







    
}
