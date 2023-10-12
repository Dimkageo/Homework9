package org.example;

import org.example.osbb.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("osbb3PU");
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
            Root<ApartmentOwner> ownerRoot = criteriaQuery.from(ApartmentOwner.class);
            Join<ApartmentOwner, PeopleRole> peopleRoleJoin = ownerRoot.join("peopleRole");
            Join<ApartmentOwner, Apartment> apartmentJoin = ownerRoot.join("apartment");
            Join<Apartment, Building> buildingJoin = apartmentJoin.join("building");
            Join<Apartment, ApartmentTenant> apartmentTenantJoin = apartmentJoin.join("apartmentTenant");

            criteriaQuery.multiselect(
                    ownerRoot.get("fullName"),
                    ownerRoot.get("email"),
                    peopleRoleJoin.get("rois"),
                    apartmentJoin.get("numberApartaments"),
                    apartmentJoin.get("square"),
                    buildingJoin.get("address"),
                    buildingJoin.get("houseNumber"),
                    apartmentTenantJoin.get("fullNameTeants"),
                    apartmentTenantJoin.get("rightOfWay")
            );

            List<Object[]> results = em.createQuery(criteriaQuery).getResultList();

            for (Object[] result : results) {
                String fullName = (String) result[0];
                String email = (String) result[1];
                String roleName = (String) result[2];
                Integer numberApartaments = (Integer) result[3];
                Double square = (Double) result[4];
                String address = (String) result[5];
                String houseNumber = (String) result[6];
                String fullNameTeants = (String) result[7];
                Boolean rightOfWay = (Boolean) result[8];

                if (fullName.equals(fullNameTeants) && rightOfWay){
                    System.out.println(fullName + ", " + email + ", " + roleName + ", №" + numberApartaments + ", "
                            + square+ "м², " + address + ", " + houseNumber);
                }
            }

        } finally {
            em.close();
            emf.close();
        }
    }
}
