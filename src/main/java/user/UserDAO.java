package user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.mindrot.jbcrypt.BCrypt;
import user.security.PasswordUtil;
import util.JpaUtil;

public class UserDAO {
    private EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public int login(String userID, String password) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.userID = :userID ", User.class);
            query.setParameter("userID", userID);


            User user = query.getSingleResult();
            String stored = user.getUserPassword();
            boolean ok = stored != null && BCrypt.checkpw(password, stored);
            return ok ? 1 : 0;//1이면 로그인 성공

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
        try {
            tx.begin();
            user.setUserPassword(PasswordUtil.hash(user.getUserPassword()));
            em.persist(user);
            tx.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            em.close();
        }


    }
}
