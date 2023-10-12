package org.example.osbb;

import javax.persistence.*;

@Entity
@Table(name = "people_rols")
public class PeopleRole {

    @Id
    @Column(name = "id_people_rols")
    private Long id;

    @Column(name = "rois")
    private String rois;

    // Гетери та сетери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRois() {
        return rois;
    }

    public void setRois(String rois) {
        this.rois = rois;
    }
}
