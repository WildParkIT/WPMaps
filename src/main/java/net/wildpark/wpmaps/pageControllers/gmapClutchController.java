/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.pageControllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import net.wildpark.wpmaps.entitys.Pillar;
import net.wildpark.wpmaps.facades.MapFacade;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;

/**
 *
 * @author Zekart
 */
@Named(value = "gMapsClutchController")
@SessionScoped

public class gmapClutchController implements Serializable{
   
    @EJB
    private MapFacade mapClutchFacade;
    private MapModel modelClutch;
    private List<Pillar> list; 
    
    @PostConstruct
    public void init() {       
        modelClutch = new DefaultMapModel();
        list = mapClutchFacade.findAll();        
//        for (Pillar e:list) {
//            modelClutch.addOverlay(new Marker(new LatLng(e.getLat(), e.getLng()),String.valueOf(e.getId()),e,"../resources/marker/"+e.getOwner()+"/"+e.getCapacityPillar()+".png"));                
//        } 
        //modelClutch.addOverlay(new Marker(new LatLng(selectedPillar.getLat(), selectedPillar.getLng()),String.valueOf(selectedPillar.getId()),selectedPillar,"../resources/marker/"+selectedPillar.getOwner()+"/"+selectedPillar.getCapacityPillar()+".png"));
    }
   
    public MapFacade getMapClutchFacade() {
        return mapClutchFacade;
    }

    public void setMapClutchFacade(MapFacade mapClutchFacade) {
        this.mapClutchFacade = mapClutchFacade;
    }

    public MapModel getModelClutch() {
        return modelClutch;
    }

    public void setModelClutch(MapModel modelClutch) {
        this.modelClutch = modelClutch;
    }

    public List<Pillar> getList() {
        return list;
    }

    public void setList(List<Pillar> list) {
        this.list = list;
    }

}
