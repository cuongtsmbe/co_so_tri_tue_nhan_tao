
package HanhTrinhNguoiBanHang;

import java.util.ArrayList;
import java.util.List;

public class HTNguoiBanHang {
    int n;//số thành phố
    String DinhBatDau;
    String DinhXuatPhat;
    List<String> Tour;  //đỉnh nhỏ nhất là 0
    int MaTranChiPhi[][];
    int cost;
    public HTNguoiBanHang(int MaTran[][],String DinhBatDau){
        //nhập vào DinhBatDau>=1
        DinhBatDau=Integer.toString(Integer.parseInt(DinhBatDau)-1);
        //this.DinhBatDau >=0
        this.DinhBatDau=DinhBatDau;
        this.DinhXuatPhat=DinhBatDau;
        this.MaTranChiPhi=MaTran;
        this.n=this.MaTranChiPhi[0].length;
        this.Tour=new ArrayList<String>();
        this.cost=0;
    }
    public HTNguoiBanHang(){}
    public List<String> getTour(){
        return this.Tour;
    }
    public int getCost(){
        return this.cost;
    }
    public void GTS2(List<HTNguoiBanHang> p){
        List<String> DgDiMin;//lưu danh sách đường đi có cost nhỏ nhất
        int lt=p.size();
        int minCost;
        p.get(0).GTS1();
        minCost=p.get(0).getCost();
        DgDiMin=p.get(0).getTour();
        for(int i=1;i<lt;i++){
            p.get(i).GTS1();
            if(p.get(i).getCost()<minCost){
                minCost=p.get(i).getCost();
                DgDiMin=p.get(i).getTour();
            }
        }
        System.out.println();
        System.out.println("GTS2:\nHang trinh tot nhat:");
        int lt1=DgDiMin.size();
        for(int i=0;i<lt1;i++){
           System.out.print(Integer.parseInt(DgDiMin.get(i))+1+" -> "); 
        }
        System.out.println(Integer.parseInt(DgDiMin.get(0))+1);
        System.out.println("Hang trinh tot nhat co chi phi: "+minCost);
        
    }
    public void GTS1(){
        System.out.println("GTS1:");
        this.addtoTour(DinhBatDau);
        while(true){
            if(!KeThoaManNhoNhat(this.DinhBatDau)){
                break;
            }
        }
        this.cost=this.cost+this.MaTranChiPhi[Integer.parseInt(this.DinhBatDau)][Integer.parseInt(this.DinhXuatPhat)];
        for(int i=0;i<n;i++){
            System.out.print(Integer.toString(Integer.parseInt(this.Tour.get(i))+1)+"   ->  ");
            
        }
        
        System.out.println(Integer.toString(Integer.parseInt(this.DinhXuatPhat)+1));
        System.out.println("Chi Phi: "+this.cost);
    }
    public boolean KeThoaManNhoNhat(String dinhke){
            int mincost=0;
            String Dinhmin="";
            for(int i=0;i<n;i++){//xét min cost
              if(!this.isExistInTour(Integer.toString(i))){
                   mincost=this.MaTranChiPhi[Integer.parseInt(dinhke)][i];
                   Dinhmin=Integer.toString(i);
              }
            }
                   
            for(int i=0;i<n;i++){
                if(!this.isExistInTour(Integer.toString(i))&&this.MaTranChiPhi[Integer.parseInt(dinhke)][i]!=-1&&this.MaTranChiPhi[Integer.parseInt(dinhke)][i]<mincost){
                    mincost=this.MaTranChiPhi[Integer.parseInt(dinhke)][i];
                    Dinhmin=Integer.toString(i);
                }
            }
           
           
            if(Dinhmin.equals("")){
                return false;
            }
            this.DinhBatDau=Dinhmin;
            this.cost=this.cost+mincost;
            this.addtoTour(Dinhmin);
            return true;
    }
    public void addtoTour(String XP){
       if(!this.isExistInTour(XP)){
           this.Tour.add(XP);
       }
    }
    public boolean isExistInTour(String XP){
        //kiểm tra thành phố này đã đi hay chưa
        int length=this.Tour.size();
        for(int i=0;i<length;i++){
            if(this.Tour.get(i) != null && this.Tour.get(i).equals(XP)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int MaTranChiPhi[][]={  {-1,20,42,31,6,24},
                                {10,-1,17,6,35,18},
                                {25,5,-1,27,14,9},
                                {12,9,24,-1,30,12},
                                {14,7,21,15,-1,38},
                                {40,15,16,5,20,-1}  };
        HTNguoiBanHang BH=new HTNguoiBanHang();
        List<HTNguoiBanHang> p = new ArrayList<>();
        p.add(new HTNguoiBanHang(MaTranChiPhi,"2"));
        p.add(new HTNguoiBanHang(MaTranChiPhi,"3"));
        p.add(new HTNguoiBanHang(MaTranChiPhi,"5"));
        p.add(new HTNguoiBanHang(MaTranChiPhi,"6"));
        BH.GTS2(p);
        
    }
}
