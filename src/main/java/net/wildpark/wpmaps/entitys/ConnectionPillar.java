/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.wildpark.wpmaps.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zekart
 */
@Entity
@Table(name = "connection_pillar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConnectionPillar.findAll", query = "SELECT c FROM ConnectionPillar c")
    , @NamedQuery(name = "ConnectionPillar.findById", query = "SELECT c FROM ConnectionPillar c WHERE c.id = :id")
    , @NamedQuery(name = "ConnectionPillar.findByTypeconnection", query = "SELECT c FROM ConnectionPillar c WHERE c.typeconnection = :typeconnection")})
public class ConnectionPillar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TYPECONNECTION")
    private Integer typeconnection;
    @JoinColumn(name = "PILLARIN", referencedColumnName = "ID")
    @ManyToOne
    private Pillar pillarin;
    @JoinColumn(name = "PILLAROUT", referencedColumnName = "ID")
    @ManyToOne
    private Pillar pillarout;

    public ConnectionPillar() {
    }

    public ConnectionPillar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeconnection() {
        return typeconnection;
    }

    public void setTypeconnection(Integer typeconnection) {
        this.typeconnection = typeconnection;
    }

    public Pillar getPillarin() {
        return pillarin;
    }

    public void setPillarin(Pillar pillarin) {
        this.pillarin = pillarin;
    }

    public Pillar getPillarout() {
        return pillarout;
    }

    public void setPillarout(Pillar pillarout) {
        this.pillarout = pillarout;
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
        if (!(object instanceof ConnectionPillar)) {
            return false;
        }
        ConnectionPillar other = (ConnectionPillar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.wildpark.wpmaps.entitys.ConnectionPillar[ id=" + id + " ]";
    }
    
}
