package org.example.osbb;

import javax.persistence.*;

@Entity
@Table(name = "apartment_teants")
public class ApartmentTenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teants")
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullNameTeants;

    @Column(name = "email")
    private String email;

    @Column(name = "right_of_way")
    private Boolean rightOfWay;

    // Гетери та сетери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullNameTeants() {
        return fullNameTeants;
    }

    public void setFullNameTeants(String fullNameTeants) {
        this.fullNameTeants = fullNameTeants;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRightOfWay() {
        return rightOfWay;
    }

    public void setRightOfWay(Boolean rightOfWay) {
        this.rightOfWay = rightOfWay;
    }
}
