/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.pageControllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Panker-RDP
 */
@Named(value = "gMapsController")
@SessionScoped
public class GMapsController implements Serializable {
    
    private MapModel model=new DefaultMapModel();
    
    public GMapsController() {
    }
    
    public MapModel getLoginModel(){
        Marker wp=new Marker(new LatLng(46.967889, 31.978493), "Дикий Сад");
        model.getMarkers().add(wp);
        return model;
    }
    
    public MapModel getHomeModel(){
        return getLoginModel();
    }
    
    
}
