package org.example;

import org.example.data.QueryExecutor;
import org.example.data.ResultsWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("osbb3PU");
        EntityManager em = emf.createEntityManager();

        List<Object[]> results = null;

        try {
            results = QueryExecutor.executeQuery(em);

            ResultsWriter.writeResultsToFile(results, "filtered_results.txt");

        } finally {
            em.close();
            emf.close();
        }
    }
}
