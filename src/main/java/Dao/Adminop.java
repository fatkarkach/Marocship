package Dao;

import entities.ManagerENT;
import org.hibernate.Session;

import java.util.List;

public class Adminop {
    //Ajouter un Manager
    public void Add_manager(ManagerENT managerENT) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(managerENT);
            session.persist(managerENT);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    //voir les managers
    public List<ManagerENT> Voir_Managers() {
        List< ManagerENT > listOfMangers = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object

            listOfMangers = session.createQuery("from ManagerENT ").getResultList();

            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return listOfMangers;
    }

}
