/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.pageControllers;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import net.wildpark.wpmaps.entitys.ConnectionPillar;

/**
 *
 * @author Zekart
 */
@Named(value = "traceController")
@SessionScoped

public class TraceController implements Serializable{
    private List<ConnectionPillar> listConnection;

    public List<ConnectionPillar> getListConnection() {
        return listConnection;
    }

    public void setListConnection(List<ConnectionPillar> listConnection) {
        this.listConnection = listConnection;
    }
    
    
}
