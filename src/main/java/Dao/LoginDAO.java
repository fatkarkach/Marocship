package Dao;
import entities.Admin;
import org.hibernate.Session;

public class LoginDAO {

    public static Boolean loginAdmin(String email, String password) {
        System.out.println("jat 3amra :"+email);
        System.out.println("jat 3amra :"+password);
        Admin adminENT = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            adminENT = (Admin) session.createQuery("SELECT U FROM Admin U WHERE U.email = :email and U.password=:password").setParameter("email", email).setParameter("password", password).uniqueResult();
            if (adminENT != null) {
                return true;
            }
            session.persist(adminENT);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return false;
    }
}
