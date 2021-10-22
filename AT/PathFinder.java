/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AT;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author phanh
 */
public class PathFinder {
    //danh sach cac diem duoc them vao 
    private final LinkedList<Point> point_list;
    //open_list danh sach cac diem se duoc duyet, sap tang dan theo dist
    private final LinkedList<Point> open_list;
    private final LinkedList<Point> closed_list;
    private String name_point_end;
    private String name_point_start;
    PathFinder(){
        open_list = new LinkedList<>();
        closed_list= new LinkedList<>();
        point_list=new LinkedList<>();
    }
    public void set_name_start_end_point(String start,String end){
        this.name_point_end=end;
        this.name_point_start=start;
    }
    //position Point sẽ được thêm ( dist nho hon dist Point dau tien trong open_list)
    public int pos_in_open_list(Point w){
        LinkedList<Point> lis=this.open_list;
        int lt=lis.size();
        for(int i=0;i<lt;i++){
            if(lis.get(i).getDist()>w.getDist()){
                return i;
            }
        }
        return lis.size()-1;
    }
    
    
    public void add_open_list(Point w){
        int pos;
        if(this.open_list.isEmpty()){
        pos=0;
        }else{
        pos = this.pos_in_open_list(w);
        }
        this.open_list.add(pos,w);
        
    }
    
    public void add_closed_list(Point w){
        this.closed_list.add(w);
        
    }
    
    public void add_point_list(Point w){
        this.point_list.add(w);
        
    }
    

    
    public String get_name_point_end(){
        return this.name_point_end;
    }
    
    public boolean is_exist_in_closed_list(String w){
        int lt =this.closed_list.size();
        for(int i=0;i<lt;i++){
            if(this.closed_list.get(i).getNamePoint().equals(w)){
                return true;
            }
        }
        return false;
    }
    //thuc hien AT
    public void perform(){

        int lt =this.point_list.size();        
        if(this.open_list.isEmpty()){
            for(Point T :this.point_list){
                if(T.is_equal(this.name_point_start)){
                    this.open_list.add(T);
                    break;
                }
            }
        }
  
        for(int x=0;x<this.open_list.size();x=0){
            Point TempP=new Point(this.open_list.get(x));
            if(!this.is_exist_in_closed_list(TempP.getNamePoint())){
                   this.add_closed_list(new Point(TempP));
                    this.open_list.remove();
            }else{
                continue;
            }

            for(int i=0;i<lt;i++){
                   if(this.point_list.get(i).is_node_current(TempP)||!this.point_list.get(i).is_equal_parent(TempP.getNamePoint())){continue;}
                   if(this.is_exist_in_closed_list(this.point_list.get(i).getNamePoint())){
                      continue; 
                   }
                   //increase dist 
                   double oo=TempP.getDist()+this.point_list.get(i).getDist();
                   add_open_list(new Point(TempP.getNamePoint(),this.point_list.get(i).getNamePoint(),oo));
      
            }

            if(this.closed_list.get(this.closed_list.size()-1).is_equal(this.get_name_point_end())){
                       return;
            }
 
        }
    }
    public void out_list_point(){
        this.point_list.forEach(T -> {
            T.out_point_screen();
        });
    }
     public void out_list_open(){
         this.open_list.forEach(T -> {
             T.out_point_screen();
        });
    }
     public void out_list_closed(){
         this.closed_list.forEach(T -> {
             T.out_point_screen();
        });
    }
    //in ra trong so cua dinh 
    public double in_trongso(String bef,String cur){
        for(Point T : this.point_list){
            if(T.is_equal(cur)&&T.is_equal_parent(bef)){
                return T.getDist();
            }
        }
        return -1;
    }
    //duong di tu dinh dau den dinh cuoi
    public void out_path_screen(){
        String at=this.name_point_end;
         if(this.closed_list.isEmpty()){return;}
        do{
            for(Point T : this.closed_list){
                if(T.is_equal(at)){
                    System.out.print(T.getNamePoint() + " <-- " + this.in_trongso(T.getParentPoint(),T.getNamePoint())+" -- ");
                    at=T.getParentPoint();
                    break;
                }
            }
           
        }while(!at.equals(this.name_point_start));
        System.out.print(at);
        
    }
    public static void main(String args[])
    {
        PathFinder PF=new PathFinder();
      
        PF.add_point_list(new Point("S","A",100));
        PF.add_point_list(new Point("S","B",17));
        PF.add_point_list(new Point("S","C",1));
        PF.add_point_list(new Point("S","D",1));
        PF.add_point_list(new Point("A","E",1));
        PF.add_point_list(new Point("E","K",1));
        PF.add_point_list(new Point("K","O",1));
        PF.add_point_list(new Point("O","Q",1));
        PF.add_point_list(new Point("Q","Z",1));
        PF.add_point_list(new Point("Q","T",1));
        PF.add_point_list(new Point("T","U",1));
        PF.add_point_list(new Point("U","V",1));
        PF.add_point_list(new Point("B","F",1));
        PF.add_point_list(new Point("C","G",10));
        PF.add_point_list(new Point("C","H",20));
        PF.add_point_list(new Point("G","L",1));
        PF.add_point_list(new Point("H","M",1));
        PF.add_point_list(new Point("D","I",12));
        PF.add_point_list(new Point("D","J",1));
        PF.add_point_list(new Point("J","N",1));
        PF.add_point_list(new Point("N","P",1));
        PF.add_point_list(new Point("P","R",1));
        
        
        Scanner ip= new Scanner(System.in);
        System.out.println("Nhap dinh xuat phat: ");
        String dinhdau = ip.nextLine().toUpperCase();
        System.out.println("Nhap dinh dich: ");
        String dinhcuoi = ip.nextLine().toUpperCase();
        //them dinh goc cho tree
        PF.add_point_list(new Point("",dinhdau,0));
        PF.set_name_start_end_point(dinhdau,dinhcuoi);
        PF.perform();
        System.out.println("---Duong di ngan nhat:");
        PF.out_path_screen();

    }
    
    
}
