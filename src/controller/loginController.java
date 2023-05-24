package controller;
//
//import controller.admin.AdminController;
//import controller.employee.ParkingPageController;

import bioskopku.dbconnector;
import bioskopku.menuutama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.adminModel;
//import model.AdminModel;
import model.loginModel;
import view.adminViewSeats;
import view.loginView;
//import model.ParkingDataModel;
//import view.admin.AdminView;
//import view.employee.ParkingPageView;

public class loginController implements ActionListener {

    loginModel model;
    loginView view;

    public loginController(loginModel model, loginView view) {
        this.model = model;
        this.view = view;
        view.getLoginButton().addActionListener(this);
        view.getRegisterButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = view.getUsername();
        String password = view.getPassword();
        if (e.getSource().equals(view.getRegisterButton()) && !"".equals(username) && !"".equals(password)) {
            model.registerUser(username, password);
        } else if(e.getSource().equals(view.getLoginButton()) && !"".equals(username) && !"".equals(password)){
            if (model.loginHandler(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Success");
                if (model.isAdmin(username, password)) {
                    System.out.println("admin!");
                    adminModel aModel = new adminModel();
                    adminViewSeats aView = new adminViewSeats();
                    adminController aController = new adminController(aModel, aView);
                } else {
                    System.out.println("customer!");
                    menuutama menu = new menuutama();
                    dbconnector.username = username;
                }
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login failed, try to register your account first!");
                e.paramString();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
        }
    }

}
