/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ToMau;

/**
 *
 * @author phanh
 */
public class DinhAndBac {
    int dinh;
    int bac;
    public DinhAndBac(int dinh,int bac){
        this.dinh=dinh;
        this.bac=bac;
    }
    public int getdinh(){
        return this.dinh;
    }
    public int getbac(){
        return this.bac;
    } 
    public void giambac(){
        this.bac--;
    }
    public void setdinh(int dinh){
         this.dinh=dinh;
    }
    public void setbac(int bac){
         this.bac=bac;
    }
    public void set(int dinh,int bac){
        this.setdinh(dinh);
        this.setbac(bac);
    }
}
