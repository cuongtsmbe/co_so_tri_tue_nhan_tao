/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co_so_tri_tue_nhan_tao.Astar;

/**
 *
 * @author phanh
 */
public class Child {
    String name;
    int kc;//k cách so với đỉnh trước
    public Child(String name,int kc){
        this.name=name;
        this.kc=kc;
    }
    public String get_name(){
        return name;
    }
    public int get_kc(){
        return kc;
    }
}
