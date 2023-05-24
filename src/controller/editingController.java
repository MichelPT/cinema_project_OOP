/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.adminModel;
import model.editModel;
import view.adminViewSeats;
import view.editingView;

/**
 *
 * @author Michel
 */
public class editingController implements ActionListener {

    editModel model;
    editingView view;
    String movieBefore[] = new String[4];

    public editingController(editModel model, editingView view) {
        this.model = model;
        this.view = view;
        for (int i = 1; i < 4; i++) {
            view.setTextField(i, model.setMovie(i));
            movieBefore[i] = model.setMovie(i);
        }
        view.getButton().addActionListener(this);
        view.getButtonExit().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getButton()) {
            String status = "Update Success";
            for (int i = 1; i < 4; i++) {
                String newName = view.getTextField(i).getText();
                if ("".equals(newName)) {
                    status = "Empty";
                } else {
                    model.editMovie(i, newName);
                    if (!movieBefore[i].equalsIgnoreCase(newName)) {
                        model.resetStudio(i);
                    }
                }
            }
            if ("Empty".equals(status)) {
                JOptionPane.showMessageDialog(null, "Blank fields would take previous values!");
            } else {
                JOptionPane.showMessageDialog(null, "Update Success");
            }
        } else if (e.getSource() == view.getButtonExit()) {
            adminModel amodel = new adminModel();
            adminViewSeats aview = new adminViewSeats();
            adminController acontroller = new adminController(amodel, aview);
            view.dispose();
        }

//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
