/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private int id;
    private String transportstation;
    private int numbertranspotrstation;
    private PillarOwner owner;
    private PillarType type;
    private PillarMaterial matheriallPillar;
    private Double lat;
    private Double lng;
    
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





    
}
