/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaBinhNuoc;

/**
 *
 * @author phanh
 */
public class BaBinhNuoc {
    	public int binh1;
	public int binh2;
        public int binh3;
          BaBinhNuoc(BaBinhNuoc w){
                    binh1=w.binh1;
                    binh2=w.binh2;
                    binh3=w.binh3;

        }
        BaBinhNuoc(int binh1,int binh2, int binh3){
                    this.binh1=binh1;
                    this.binh2=binh2;
                    this.binh3=binh3;

        }
         public boolean is_equal(BaBinhNuoc w){
             return w.binh1==binh1&&w.binh2==binh2&&w.binh3==binh3;
          }
        public void Print(){
            System.out.print(" ("+this.binh1+","+this.binh2+","+this.binh3+") ");
        }
        //thu in ra trg hop 2 binh nuoc
        public void Print_Cho_2_binh(){
            System.out.print(" ("+this.binh1+","+this.binh2+") ");
        }
}
