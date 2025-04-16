package bbs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import user.User;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class BbsDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mn");


    public String getBbsDate() {
        String date = null;
        EntityManager em = emf.createEntityManager();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);


    }

    public int getNext() {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Integer row = (Integer) em.createQuery("SELECT bbsID FROM Bbs bs ORDER BY bbsID DESC")
                    .setMaxResults(1)  // 가장 마지막 글 하나만
                    .getSingleResult();

            em.getTransaction().commit();
            return row + 1;
        } catch (NoResultException e) {
            return 1;


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }
        return -1;


    }

    public int write(String bbsTitle, String userID, String bbsContent) {
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            Bbs bbs = new Bbs();
            bbs.setBbsID(getNext());
            bbs.setBbsTitle(bbsTitle);
            bbs.setUserID(userID);
            bbs.setBbsDate(getBbsDate());
            bbs.setBbsContent(bbsContent);
            bbs.setBbsAvailable(1);
            em.persist(bbs);
            em.getTransaction().commit();
            return bbs.getBbsID();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }
        return -1;

    }

    public ArrayList<Bbs> getList(int pageNumber) {
        EntityManager em = emf.createEntityManager();
        ArrayList<Bbs> list = new ArrayList<Bbs>();
        Query query = em.createQuery(
                "SELECT b FROM Bbs b WHERE b.bbsID < :finIsh_ROW AND bbsAvailable = 1 ORDER BY b.bbsID DESC ", Bbs.class
        );

        try {
            em.getTransaction().begin();
            int finIsh_ROW = getNext() - (pageNumber - 1) * 10;
            query.setParameter("finIsh_ROW", finIsh_ROW);
            query.setMaxResults(10);
            em.getTransaction().commit();
            list.addAll(query.getResultList());


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }
        return list;
    }

    public boolean nextPage(int pageNumber) {
        EntityManager em = emf.createEntityManager();
        ArrayList<Bbs> list = new ArrayList<Bbs>();
        Query query = em.createQuery(
                "SELECT b FROM Bbs b WHERE b.bbsID < :finIsh_ROW AND bbsAvailable = 1 ORDER BY b.bbsID DESC ", Bbs.class
        );

        try {
            em.getTransaction().begin();
            int finIsh_ROW = getNext() - (pageNumber - 1) * 10;
            query.setParameter("finIsh_ROW", finIsh_ROW);
            query.setMaxResults(10);
            em.getTransaction().commit();
            list.addAll(query.getResultList());
            if (list.isEmpty()) {
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
        }
        return true;

    }

    public Bbs getBbs(int bbsID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Bbs bbs = em.find(Bbs.class, bbsID);
        if (bbs != null) {
            em.getTransaction().commit();
            //em.getTransaction().commit();
             em.close();
            return bbs;

        } else {
              em.close();
            return null;
        }


    }

    public int update(int bbsID, String bbsTitle, String bbsContent) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Bbs bbs = em.find(Bbs.class, bbsID); // 엔티티 조회
            if (bbs != null) {
                bbs.setBbsTitle(bbsTitle);
                bbs.setBbsContent(bbsContent);
                em.getTransaction().commit();
                return 1;
            } else {
                return 0; // 해당 ID 없음
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return -1;
    }
    public  int delete(int bbsID) {
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
          Bbs bbs = em.find(Bbs.class, bbsID);
           if (bbs != null) {

                bbs.setBbsAvailable(0);
                em.getTransaction().commit();
                em.close();
                return 1;
            } else {
                em.close();
                return 0; // 해당 ID 없음

            }
    }

}
