/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ToMau;


import java.util.LinkedList;

/**
 *
 * @author phanh
 */
public class SXThuTuKetHopThamLam {
     int mau=1;
     int SoDinh;
     int[] DinhBac ;//array lưu bậc của đỉnh ứng với index
     int[] DinhMau ;//array lưu màu được tô cho đỉnh
     public LinkedList<DinhAndBac> list_dinh=new LinkedList();
    public SXThuTuKetHopThamLam(){
      
    }
    public int Bac(int pos,int[][] Arr){
        //bậc của đỉnh
        int bac=0;
         for (int i = 0; i <SoDinh; ++i) {
            if(Arr[pos][i]==1){
                bac++;
            }
        }
         return bac;
    }
    public int pos_add_Dinh(int bac){
         int lt=this.list_dinh.size();
                    for(int i=0;i<lt;i++){
                        if(bac>list_dinh.get(i).getbac()){
                            return i;
                        }
                    }
                    return lt;
    }
     public void add_Dinh(){
        //Đưa vào list đỉnh và bậc tương ứng sắp xếp giảm theo bậc 
        for (int i = 0; i <SoDinh; ++i) {
            this.list_dinh.add(pos_add_Dinh(DinhBac[i]),new DinhAndBac(i,DinhBac[i]));
        }
         int lt=this.list_dinh.size();
      
        System.out.println();
    }
    public void ToMauThuTuThamLam(int[][] Arr){
        this.SoDinh=Arr.length;
        DinhBac= new int[SoDinh];
         DinhMau= new int[SoDinh];
        int SoDinhDuocTo=0;
        //Tất cả đỉnh chưa được tô
        for (int i = 0; i <SoDinh; ++i) {
            DinhMau[i]=0;
            DinhBac[i]=this.Bac(i,Arr);
        }
        this.add_Dinh();
        do{
             int lt=this.list_dinh.size();
              for(int i=0;i<lt;i++){
                if(DinhMau[this.list_dinh.get(i).getdinh()]==0&&this.DinhToDuoc(this.list_dinh.get(i).getdinh(),mau,Arr)==true){
                    DinhMau[this.list_dinh.get(i).getdinh()]=mau;
                    SoDinhDuocTo++;
                }
                
              }
            mau++;
        }while(SoDinhDuocTo<SoDinh);
         System.out.println();
         System.out.println("## Ket Qua To Mau Thu Tu + Tham Lam ##");
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
