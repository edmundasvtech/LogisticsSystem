package Utilities;
import Model.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class DriverUtility {

    private EntityManagerFactory entityManagerFactory = null;

    private EntityManager getEntityManager() {

        return entityManagerFactory.createEntityManager();
    }

    public DriverUtility(EntityManagerFactory entityManagerFactory) {

        this.entityManagerFactory = entityManagerFactory;
    }

    public Driver getDriver(String email) {
        for (Driver driver : getAllDrivers()) {
            if (driver.getEmail().equals(email)) {
                return driver;
            }
        }
        return null;
    }

    public List<Driver> getAllDrivers() {
        EntityManager entityManager = getEntityManager();

        try {
            CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
            criteriaQuery.select(criteriaQuery.from(Driver.class));
            Query query = entityManager.createQuery(criteriaQuery);

            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
