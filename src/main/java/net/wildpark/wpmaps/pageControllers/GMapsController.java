/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.pageControllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import net.wildpark.wpmaps.entitys.Pillar;
import net.wildpark.wpmaps.facades.MapFacade;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import net.wildpark.wpmaps.enums.PillarOwner;
import net.wildpark.wpmaps.enums.PillarType;
import net.wildpark.wpmaps.enums.PillarMaterial;

/**
 *
 * @author Panker-RDP
 */
@Named(value = "gMapsController")
@SessionScoped
public class GMapsController implements Serializable {
    
    @EJB
    private MapFacade mapFacade;
    private MapModel model;
    private Marker marker;
    private String transportStation;
    private int numberStation;
    private PillarOwner owner;
    private PillarMaterial matheriallPillar;
    private PillarType typePillar;
    private int id;
    private Boolean capacityCabel;
       
    private double lat;     
    private double lng;
    private List<Pillar> list; 

    Pillar pillar = new Pillar();
    Pillar selectedPillar = new Pillar();
   

    @PostConstruct
    public void init() {
        model = new DefaultMapModel();
        list = mapFacade.findAll();
     
        for (Pillar e:list) {
            model.addOverlay(new Marker(new LatLng(e.getLat(), e.getLng()),String.valueOf(e.getId()),e,"../resources/marker/Empty_el_tr.png"));    
        }        
        
        

    }
       
    public PillarOwner[] getPillarOwner() {
        return PillarOwner.values();
    }
    
    public PillarMaterial[] getPillarMaterial() {
        return PillarMaterial.values();
    }    
    public PillarType[] getPillarType() {
        return PillarType.values();
    }        
    
    public void addMarker() {
        
        pillar.setLat(lat);
        pillar.setLng(lng);
        pillar.setNumbertranspotrstation(numberStation);
        pillar.setTransportstation(transportStation);
        pillar.setOwner(owner);
        pillar.setType(typePillar);
        pillar.setMatheriallPillar(matheriallPillar);

        mapFacade.create(pillar);
        
        id = pillar.getId();
        marker = new Marker(new LatLng(lat, lng), String.valueOf(id),pillar,"../resources/marker/Empty_el_tr.png" );
        model.addOverlay(marker);       
        //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("@all");
    }
    
    public void deleteMarker(){        
//        selectedPillar = (Pillar) marker.getData();
//        System.out.println("Select id  " + selectedPillar.getId());
        pillar = mapFacade.find(selectedPillar.getId());
        if(pillar != null){            
            mapFacade.remove(pillar);
            init();
        }
        
        //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gmap");
    }
       

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();   
        selectedPillar = (Pillar) marker.getData();

    }
    
    
    public void changePillar(){        
        id = (Integer) marker.getData();
        pillar = mapFacade.find(id);
        
        System.out.println("Id: " + id);
//        for (Pillar e : list) {
//            if(e.getId() == id){
//                e.setTransportstation();
//                System.out.println(transportStation);
//            }
//        }                
    }
    
    
    public String changeInfoPillar(){
        return"pillarChange.xhtml?faces-redirect=true";
    }
    
    
    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }
 
    public Marker getMarker() {
        return marker;
    }       

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTransportStation() {
        return transportStation;
    }

    public void setTransportStation(String transportStation) {
        this.transportStation = transportStation;
    }

    public int getNumberStation() {
        return numberStation;
    }

    public void setNumberStation(int numberStation) {
        this.numberStation = numberStation;
    }

    public PillarOwner getOwner() {
        return owner;
    }

    public void setOwner(PillarOwner owner) {
        this.owner = owner;
    }

    public PillarMaterial getMatheriallPillar() {
        return matheriallPillar;
    }

    public void setMatheriallPillar(PillarMaterial matheriallPillar) {
        this.matheriallPillar = matheriallPillar;
    }

    public PillarType getTypePillar() {
        return typePillar;
    }

    public void setTypePillar(PillarType typePillar) {
        this.typePillar = typePillar;
    }



    public Boolean getCapacityCabel() {
        return capacityCabel;
    }

    public void setCapacityCabel(Boolean capacityCabel) {
        this.capacityCabel = capacityCabel;
    }

    public List<Pillar> getList() {
        return list;
    }

    public void setList(List<Pillar> list) {
        this.list = list;
    }

    public Pillar getSelectedPillar() {
        return selectedPillar;
    }

    public void setSelectedPillar(Pillar selectedPillar) {
        this.selectedPillar = selectedPillar;
    }
    
    
    
    
    
    
    

    
}
