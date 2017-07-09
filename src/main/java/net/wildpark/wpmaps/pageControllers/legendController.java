/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.pageControllers;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author zekart
 */
@Named(value = "legendController")
@ManagedBean
@ViewScoped
public class legendController {
    private boolean showDo=true;
    private boolean showUndo=true;

    public void doAction(){
      showUndo=false;
    }

    public void undoAction(){
      showDo=false;
    }

    public boolean isShowDo() {
        return showDo;
    }

    public void setShowDo(boolean showDo) {
        this.showDo = showDo;
    }

    public boolean isShowUndo() {
        return showUndo;
    }

    public void setShowUndo(boolean showUndo) {
        this.showUndo = showUndo;
    }
    
    
    
}
