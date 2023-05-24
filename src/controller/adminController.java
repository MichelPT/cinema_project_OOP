package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.adminModel;
import model.editModel;
import model.loginModel;
import view.adminViewSeats;
import view.editingView;
import view.loginView;
//import view.admin.AdminView;
//import view.admin.ChangePassView;
//import view.admin.DataParkingView;

public class adminController extends DefaultTableModel implements ActionListener {

    adminModel model;
    adminViewSeats view;

    public adminController(adminModel model, adminViewSeats view) {
        super(model.readAllData(), adminModel.HEADER);
        this.model = model;
        this.view = view;

        if (model.readAllData().length > 0) {
            view.getTable().setModel(adminController.this);
//            adminView.table.setModel((new JTable(dataUser, adminView.getHeader())).getModel());
        } else {
            System.out.println("No data yet!");
        }

        view.getButton().addActionListener(this);
        view.getLogoutButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getButton()) {
            editModel emodel = new editModel();
            editingView eview = new editingView();
            editingController econtroller = new editingController(emodel, eview);
        } else if (e.getSource() == view.getLogoutButton()) {
            loginModel lmodel = new loginModel();
            loginView lview = new loginView();
            loginController lcontroller = new loginController(lmodel, lview);
        }
        view.dispose();
//        throw new UnsupportedOperationException("Not supported yet."); Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
