package org.example.data;

import org.example.osbb.*;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class QueryExecutor {

    public static List<Object[]> executeQuery(EntityManager em) {
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
        return em.createQuery(criteriaQuery).getResultList();
    }
}
