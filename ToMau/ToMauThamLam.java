/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ToMau;

/**
 *
 * @author phanh
 */
public class ToMauThamLam {
      int mau=1;
     int SoDinh;
     int[] DinhMau ;
    public ToMauThamLam(){
      
    }
    public void ToMauThamLam(int[][] Arr){
       
          this.SoDinh=Arr.length;
         DinhMau= new int[SoDinh];
        int SoDinhDuocTo=0;
        
        for (int i = 0; i <SoDinh; ++i) {
            DinhMau[i]=0;
        }
        do{
            for (int i = 0; i <SoDinh; ++i) {
                if(DinhMau[i]==0&&this.DinhToDuoc(i,mau,Arr)==true){
                    DinhMau[i]=mau;
                    SoDinhDuocTo++;
                }
              }
            mau++;
        }while(SoDinhDuocTo<SoDinh);
         System.out.println("## Ket Qua To Mau Tham Lam ##");
         for (int i = 0; i <SoDinh; ++i) {
           System.out.print(DinhMau[i]+"   ");
        }
    }
    public Boolean DinhToDuoc(int pos,int color,int[][] Arr){
    //xét xem đỉnh pos có tô được màu color không
        if(DinhMau[pos]!=0){//đỉnh đã được tô
            return false;
        }
        for(int i=0;i<this.SoDinh;i++){
            if(DinhMau[i]==color){// đỉnh đã tô màu color
                if(Arr[i][pos]==1){//đỉnh pos kề đỉnh i 
                    return false;
                }
            }
        }
        return true;
    }
}
