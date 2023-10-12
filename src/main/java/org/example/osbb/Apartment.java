package org.example.osbb;

import javax.persistence.*;

@Entity
@Table(name = "apartaments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartaments")
    private Long id;

    @Column(name = "number_apartaments")
    private Integer numberApartaments;

    @Column(name = "square")
    private Double square;

    @ManyToOne
    @JoinColumn(name = "buildings_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "id_apartment_teants")
    private ApartmentTenant apartmentTenant;

    // Гетери та сетери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return numberApartaments;
    }

    public void setNumber(Integer number) {
        this.numberApartaments = number;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public ApartmentTenant getApartmentTenant() {
        return apartmentTenant;
    }

    public void setApartmentTenant(ApartmentTenant apartmentTenant) {
        this.apartmentTenant = apartmentTenant;
    }
}
