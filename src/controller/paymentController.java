/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bioskopku.menuutama;
import bioskopku.pilihan;
import bioskopku.studioCode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.paymentModel;
import view.paymentView;

/**
 *
 * @author Michel
 */
public class paymentController implements ActionListener {

    int studioNum;
    paymentModel model;
    paymentView view;
    int price;
    String priceString;

    public paymentController(paymentModel model, paymentView view, int studioNum) {
        this.model = model;
        this.view = view;
        this.studioNum = studioNum;

        if (model.detectBooking()) {
            view.noBooking(studioNum);
        } else {
            switch (studioNum) {
                case 1 -> {
                    studioCode studio = studioCode.Atrium;
                    price = studio.getPrice();
                }
                case 2 -> {
                    studioCode studio = studioCode.Spherex;
                    price = studio.getPrice();
                }
                case 3 -> {
                    studioCode studio = studioCode.Galaxy;
                    price = studio.getPrice();
                }
                default ->
                    throw new AssertionError();
            }
            priceString = String.valueOf(price);
            view.getPrice().setText(priceString);
            view.getMovieLabel().setText(model.getMovieName(studioNum));
            view.getStudioLabel().setText(Integer.toString(studioNum));
            view.getSeatsLabel().setText(model.getSeats(studioNum));
            view.getTotalLabel().setText(Integer.toString(model.totalBill()));
            view.getPayButton().addActionListener(this);
            view.getCancelButton().addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getCancelButton())) {
            view.dispose();
            new pilihan(studioNum).setVisible(true);
        } else {
            int tickets = model.setSeatsPaid(studioNum);
            JOptionPane.showMessageDialog(null, "Your payment for " + tickets + " tickets has been processed successfully!");
            view.dispose();
            new menuutama().setVisible(true);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
