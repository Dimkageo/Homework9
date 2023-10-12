package org.example.osbb;

import javax.persistence.*;

@Entity
@Table(name = "apartment_owners")
public class ApartmentOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment_owners")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "people_rols_id")
    private PeopleRole peopleRole;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    // Гетери та сетери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PeopleRole getPeopleRole() {
        return peopleRole;
    }

    public void setPeopleRole(PeopleRole peopleRole) {
        this.peopleRole = peopleRole;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
