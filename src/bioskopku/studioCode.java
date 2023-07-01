/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bioskopku;

/**
 *
 * @author Michel
 */
public enum studioCode {
    Atrium(35000), Spherex(40000), Galaxy(25000);
    
    private final int price;
    private studioCode(int price){
    this.price= price;
    }

    public int getPrice() {
        return price;
    }
}
