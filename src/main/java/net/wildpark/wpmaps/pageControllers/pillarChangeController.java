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
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import net.wildpark.wpmaps.entitys.Pillar;
import net.wildpark.wpmaps.facades.MapFacade;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Zekart
 */
@Named(value = "pillarChangeController")
@Dependent
public class pillarChangeController implements Serializable {
    private List<Pillar> list; 
    @EJB
    private MapFacade mapFacade;
    /**
     * Creates a new instance of pillarChangeController
     */
    public pillarChangeController() {
    }
    
    @PostConstruct
    public void init() {

        list = mapFacade.findAll();

    }

    public List<Pillar> getList() {
        return list;
    }

    public void setList(List<Pillar> list) {
        this.list = list;
    }
    
    
    
}
