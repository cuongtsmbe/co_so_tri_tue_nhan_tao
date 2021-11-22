
package ToMau;

import java.util.LinkedList;

public class ToMauToiUu {
     int SoDinh;
     int[] DinhBac ;//array lưu bậc của đỉnh ứng với index
      int[] DinhMau ;
     public LinkedList<DinhAndBac> list_dinh=new LinkedList();
    public ToMauToiUu(){
      
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
    public void KhoiTao(int[][] Arr){
         this.SoDinh=Arr.length;
        DinhBac= new int[SoDinh];
        DinhMau= new int[SoDinh];
        for (int i = 0; i <SoDinh; ++i) {
            DinhMau[i]=0;
            DinhBac[i]=this.Bac(i,Arr);
        }
        this.add_Dinh();
    }
    public boolean is_exists_of_order_greater_than_0(){
          for (int i = 0; i <SoDinh; ++i) {
                if(this.list_dinh.get(i).getbac()>0){
                    return true;
                }
            }
          return false;
    }
    public void ToMauToiUu(int[][] Arr){
     
     this.KhoiTao(Arr);
     int mau=this.SoDinh;

      while(is_exists_of_order_greater_than_0()){
            for(int color=1;color<=mau;color++){
                if(this.DinhToDuoc(this.list_dinh.get(0).getdinh(),color,Arr)){
                    if(this.list_dinh.get(0).getbac()!=0){
                       DinhMau[this.list_dinh.get(0).getdinh()]=color;
                       this.list_dinh.get(0).setbac(0);
                       decrease_order_vertex(this.list_dinh.get(0).getdinh(),Arr);
                    }
                   
                    break;
                    
                }
            }
        
      }
      
        System.out.println();
        System.out.println("## Ket Qua To Mau Toi Uu ##");
         for (int i = 0; i <SoDinh; ++i) {
           System.out.print(DinhMau[i]+"   ");
        }
    }
    public void decrease_order_vertex(int pos,int[][] Arr){
        //giảm bậc của đỉnh kề với pos
        int lt= this.list_dinh.size();
        for(int j=0;j<lt;j++){
            if(Arr[pos][this.list_dinh.get(j).getdinh()]==1){
                if(this.list_dinh.get(j).getbac()!=0){
                this.list_dinh.get(j).giambac();
                }
            }
        }
        this.SapXepDinhGiamDan();
//         System.out.println("Hạ Bậc Đỉnh(Sắp xếp theo bậc đỉnh)");//To Mau Lan Thu n
//        for (int i = 0; i <SoDinh; ++i) {
//           System.out.print(this.list_dinh.get(i).getdinh()+"->"+this.list_dinh.get(i).getbac()+"    ");
//        }
//        System.out.println();
    }
    public void SapXepDinhGiamDan(){
        //sắp list giảm dần theo bậc của đỉnh
        int i,j;
        int lt=this.list_dinh.size();
        for (i = 0; i < lt; i++) {
            for (j = 0; j < lt-i- 1; j++) {
                if (this.list_dinh.get(j).getbac() < this.list_dinh.get(j+1).getbac()) {
                    int bac;
                    int dinh;
                    dinh = this.list_dinh.get(j).getdinh();
                    bac = this.list_dinh.get(j).getbac();
                    this.list_dinh.get(j).set(this.list_dinh.get(j+1).getdinh(),this.list_dinh.get(j+1).getbac());
                    this.list_dinh.get(j+1).set(dinh,bac);
                }
            }
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
