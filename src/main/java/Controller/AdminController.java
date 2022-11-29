package Controller;

import Dao.LoginDAO;
import Dao.SessionUtil;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.Serializable;

@Named("user")
@SessionScoped

public class AdminController implements Serializable {
    private int id;
    private String email;
    private String password;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//valider login
    public String validateUsernamePassword() throws Exception {
        System.out.println(this.email);
        System.out.println(this.password);
        boolean valid = LoginDAO.loginAdmin(email,password);
        if (valid) {
            HttpSession session = (HttpSession) SessionUtil.getCurrentSession();
            session.setAttribute("Admin", email);
           return "DashboardAdmin";

        } else {
            return "index";
        }
    }
    //logout
    //logout event, invalidate session
    public String logout() throws Exception {
        HttpSession session = (HttpSession) SessionUtil.getCurrentSession();
        session.invalidate();
        return "index";
    }
    //add manager

}
