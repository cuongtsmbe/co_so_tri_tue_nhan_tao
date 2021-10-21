/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nguoi_Qua_Song;

/**
 *
 * @author phanh
 */
public class Nguoi_Soi_Ngo_Ga {
    	public int Nguoi;
	public int Ga;
        public int Ngo;
        public int Soi;
        public boolean is_equal(Nguoi_Soi_Ngo_Ga w){
             return w.Nguoi==this.Nguoi&&w.Ga==this.Ga&&w.Ngo==this.Ngo&&w.Soi==this.Soi;
          }
        Nguoi_Soi_Ngo_Ga(){
             this.Nguoi=1;
             this.Ga=1;
             this.Ngo=1;
             this.Soi=1;
         }
        Nguoi_Soi_Ngo_Ga(Nguoi_Soi_Ngo_Ga w){
             this.Nguoi=w.Nguoi;
             this.Ga=w.Ga;
             this.Ngo=w.Ngo;
             this.Soi=w.Soi;
        }
        
        public void NguoiGa_Qua(){
            if(this.Nguoi==0){return;}
            this.Nguoi=0;
            this.Ga=0;
        }
        public void NguoiGa_Ve(){
            if(this.Nguoi==1){return;}
            this.Nguoi=1;
            this.Ga=1;
        }
        public void NguoiNgo_Qua(){
            if(this.Nguoi==0){return;}
            this.Nguoi=0;
            this.Ngo=0;
        }
        public void NguoiNgo_Ve(){
            if(this.Nguoi==1){return;}
            this.Nguoi=1;
            this.Ngo=1;
        }
        public void Nguoi_Ve(){
            if(this.Nguoi==1){return;}
            this.Nguoi=1;
        }
//        public void Nguoi_Qua(){
//            this.Nguoi=0;
//        }
         public void NguoiSoi_Qua(){
            if(this.Nguoi==0){return;}
            this.Nguoi=0;
            this.Soi=0;
        }
        public void NguoiSoi_Ve(){
            if(this.Nguoi==1){return;}
            this.Nguoi=1;
            this.Soi=1;
        }
        
        public void assignBy(Nguoi_Soi_Ngo_Ga w){
             this.Nguoi=w.Nguoi;
             this.Ga=w.Ga;
             this.Ngo=w.Ngo;
             this.Soi=w.Soi;
        }
        public void Print(){
            System.out.print(" ("+this.Ga+","+this.Ngo+","+this.Soi+","+this.Nguoi+")");
        }
        
        public boolean IsFalseCondition(){
            if(this.Ga==0&&this.Ngo==0&&this.Nguoi==0&&this.Soi==0){
                return true;
            }
            if(this.Ga==1&&this.Ngo==1&&this.Nguoi==0){
                return true;
            }
            if(this.Ga==1&&this.Soi==1&&this.Nguoi==0){
                return true;
            }
            if(this.Ga==0&&this.Soi==0&&this.Nguoi==1){
                return true;
            }
            if(this.Ga==0&&this.Ngo==0&&this.Nguoi==1){
                return true;
            }
            
            return false;
        }
}
