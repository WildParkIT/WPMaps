/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.pageControllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import net.wildpark.wpmaps.entitys.Pillar;
import net.wildpark.wpmaps.enums.HouseOwner;
import net.wildpark.wpmaps.enums.HouseType;
import net.wildpark.wpmaps.enums.ObjectType;
import net.wildpark.wpmaps.enums.PillarCapacity;
import net.wildpark.wpmaps.facades.MapFacade;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import net.wildpark.wpmaps.enums.PillarOwner;
import net.wildpark.wpmaps.enums.PillarType;
import net.wildpark.wpmaps.enums.PillarMaterial;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.Polyline;


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
    private PillarCapacity capacityPillar;
    private ObjectType obj_type;
    private HouseType typeOfHouse;
    private HouseOwner ownerofHouse;
    
    private int id;
    private Boolean capacityCabel;
    
    private int zoomMap = 13;
    private boolean showMarker = false; 
    

    private double lat;     
    private double lng;
    private List<Pillar> list; 
     
    Pillar pillar = new Pillar();
    Pillar selectedPillar = new Pillar();
    
    TraceController trace = new TraceController();
    
    List<LatLng> coord = new ArrayList<>();
    List<Marker> markers;   
   
//
    @PostConstruct
    public void init() {
        model = new DefaultMapModel();
        list = mapFacade.findAll();        
        for (Pillar e:list) {
            model.addOverlay(new Marker(new LatLng(e.getLat(), e.getLng()),String.valueOf(e.getId()),e,"../resources/marker/"+e.getOwner()+"/"+e.getCapacityPillar()+".png"));                
        }   
    }

    public void addMarker() {
        
        pillar.setLat(lat);
        pillar.setLng(lng);
        pillar.setNumbertranspotrstation(numberStation);
        pillar.setTransportstation(transportStation);
        pillar.setOwner(owner);
        pillar.setType(typePillar);
        pillar.setMatheriallPillar(matheriallPillar);
        pillar.setCapacityPillar(capacityPillar);

        mapFacade.create(pillar);
        
        id = pillar.getId();
        marker = new Marker(new LatLng(lat, lng), String.valueOf(id),pillar,"../resources/marker/"+pillar.getOwner()+"/"+pillar.getCapacityPillar().toString()+".png" );
        model.addOverlay(marker);
        //list.clear();
        init();
        //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("@all");
    }
    
    public void deleteMarker(){        
        //selectedPillar = (Pillar) marker.getData();
//        System.out.println("Select id  " + selectedPillar.getId());
        pillar = mapFacade.find(selectedPillar.getId());
        if(pillar != null){            
            mapFacade.remove(pillar);
            //list.clear();
            init();
            //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("@all");
        }
    }
       

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();   
        selectedPillar = (Pillar) marker.getData(); 
        System.out.println("go");
    }
   
    
    public void connectPillar(){
        Polyline polyline = new Polyline();
        
        polyline.setStrokeWeight(2);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(1);
        
        coord.add(new LatLng(selectedPillar.getLat(), selectedPillar.getLng()));

        
//        LatLng  coord1 = new LatLng(selectedPillar.getLat(), selectedPillar.getLng());
//        LatLng coord2 = new LatLng(selectedPillar.getLat(), selectedPillar.getLng());
        
//        polyline.getPaths().add(coord1);
//        polyline.getPaths().add(coord2);

        if (coord.size()==2) {
            for (LatLng en : coord ){
                System.out.println(en);
                polyline.getPaths().add(en);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Режим соединения", "Успешно"));
            model.addOverlay(polyline);
            RequestContext.getCurrentInstance().update("gmap");
            coord.clear();                   
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Режим добавления", "Выберите 2 маркер"));            
        }          
    }
    

    public void changePillar(){        
        id = (Integer) marker.getData();
        pillar = mapFacade.find(id);
        
        System.out.println("Id: " + id);             
    }
    
    public void onStateChange(StateChangeEvent event){
        
        zoomMap = event.getZoomLevel();  
        
        System.out.println("zoom : " + zoomMap);
        if(zoomMap >= 14){
            showMarker = true;             
        }else{
            showMarker = false;
          
        }
        for (Marker m : markers) {
            m.setVisible(showMarker);

        } 

        System.out.println("marker" + markers);

    }
    
    public HouseType[] getHouseType() {
        return HouseType.values();
    }
    public HouseOwner[] getHouseOwner() {
        return HouseOwner.values();
    }    
    public ObjectType[] getObjectType() {
        return ObjectType.values();
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
    public PillarCapacity[] getPillarCapacity() {
        return PillarCapacity.values();
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

    public PillarCapacity getCapacityPillar() {
        return capacityPillar;
    }

    public void setCapacityPillar(PillarCapacity capacityPillar) {
        this.capacityPillar = capacityPillar;
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

    public int getZoomMap() {
        return zoomMap;
    }

    public ObjectType getObj_type() {
        return obj_type;
    }

    public void setObj_type(ObjectType obj_type) {
        this.obj_type = obj_type;
    }

    public HouseType getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(HouseType typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public HouseOwner getOwnerofHouse() {
        return ownerofHouse;
    }

    public void setOwnerofHouse(HouseOwner ownerofHouse) {
        this.ownerofHouse = ownerofHouse;
    }



    
    
   
    
  
}
