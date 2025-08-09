package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Mn");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void close() {
         if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
