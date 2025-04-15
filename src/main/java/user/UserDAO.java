package user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mn");

    public int login(String userID, String password) {
        EntityManager em = emf.createEntityManager();

        try {
                TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.userID = :userID AND u.userPassword = :userPassword", User.class);
            query.setParameter("userID", userID);
            query.setParameter("userPassword", password);

            User user = query.getSingleResult();
            return 1; // 로그인 성공
        } catch (NoResultException e) {
            return 0; // 사용자 없음 또는 비밀번호 틀림
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 오류 발생
        }

    }
    public int join(User user) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
             tx.begin();
             em.persist(user);
             tx.commit();
             return 1;
        } catch (Exception e) {
           e.printStackTrace();
            return -1;
        }finally{
            em.close();
        }



    }
}
