/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co_so_tri_tue_nhan_tao.Astar;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author phanh
 */
public class AStar {
    ArrayList<Current> List_Point=new ArrayList<>();
    LinkedList<Current> Open=new LinkedList<>();
    LinkedList<Current> Closed=new LinkedList<>();
    public void add_List_Point(Current A){
        this.List_Point.add(A);
    }
    public void Astar(String start,String end){
        for(Current p:this.List_Point)  {
            if(p.get_name().equals(start)){
                this.add_to_open(p);
                break;
            }  
        } 
        int pos,i=0;
        Current Temp=new Current();
    
        while(i<this.Open.size()){
            i=0;
            if(this.Open.isEmpty()){
                System.out.println("Open isEmpty");
                break;
            }
            Temp=this.Open.get(0);//lưu lại 
            this.add_to_closed(this.Open.get(0));
            if(this.Open.get(0).get_name().equals(end)){
                Current A=this.Open.get(0);
                do{
                    System.out.print(A.get_name()+"  ");
                      A=A.Prev;
                }while(A!=null);
                System.out.println();
                 System.out.println("Search path:"+this.Open.get(0).get_gx());
                break;
            }
            this.Open.remove(0);//xoa khỏi open
            for(Child ch:Temp.get_list_child()){
                //thêm đỉnh mới vào open
                int pos_in_list_point=this.pos_in_list_point(ch.get_name());
                //cập nhật gx và Prev lại cho điểm hiện tại
                this.List_Point.get(pos_in_list_point).Prev=Temp;
                this.List_Point.get(pos_in_list_point).set_gx(ch.get_kc()+Temp.get_gx());
                this.add_to_open(this.List_Point.get(pos_in_list_point));
                
            }
           
        }
        System.out.println("completed Astar");
    }
    public int is_closed(Current p){
        int lt_closed=this.Closed.size();
            for(int i=0;i<lt_closed;i++){
                if(this.Closed.get(i).get_name().equals(p.get_name())){
                    //có trong closed
                    return 0;
                }
        }
        return 1;
    }
    public void add_to_closed(Current p){
         
        if(this.is_closed(p)!=0){
            this.Closed.add(p);
        }   
    }
   
    public int pos_in_open(Current p){
       
         //position p in open
         int lt=this.Open.size();
         for(int i=0;i<lt;i++){
             if(this.Open.get(i).get_name().equals(p.get_name())){
                 return i; 
            }
         }
         return -1;
    }
    public int pos_in_list_point(String p){
         //position p in list_point
         int lt=this.List_Point.size();
         int pos=0;
         for(int i=0;i<lt;i++){
             if(this.List_Point.get(i).get_name().equals(p)){
                pos=i;
                break;
            }
         }
         return pos;
    }
    public int is_open(Current p){
       int pos=this.pos_in_open(p);
        if(pos!=-1){
                if(this.Open.get(pos).get_fx()>p.get_fx()){
                    this.Open.remove(pos);
                }else{
                    this.Open.get(pos).set_gx(p.get_gx());
                    return 0;
                }

       }        
        return 1;
    }
    public void add_to_open(Current p){
        
                if(Open.isEmpty()){
                    Open.add(p);
                }else{
                    
                    if(this.is_closed(p)==0){
                        return ;
                    }
                    if(this.is_open(p)==0){
                        return ;
                    }
                    int lt=this.Open.size();
                    for(int i=0;i<lt;i++){
                        if(p.get_fx()<Open.get(i).get_fx()){
                            this.Open.add(i, p);
                        }
                    }
                    //nếu chưa đc add( là trg hợp thêm vào cuối link)
                    if(this.Open.size()==lt){
                        this.Open.addLast(p);
                    }
                }
    }
    public static void main(String[] args){  
        AStar astar=new AStar();
         Current A=new Current("A",6);
         A.add_adjacent_vertex("B",2);
         A.add_adjacent_vertex("C",1);
         A.add_adjacent_vertex("D",3);
         Current B=new Current("B",3);
         B.add_adjacent_vertex("E",5);
         B.add_adjacent_vertex("F",4);
         Current C=new Current("C",4);
         C.add_adjacent_vertex("G",6);
         C.add_adjacent_vertex("H",3);
         Current D=new Current("D",5);
         D.add_adjacent_vertex("I",2);
         D.add_adjacent_vertex("J",4);
         Current E=new Current("E",3);
         Current F=new Current("F",1);
         F.add_adjacent_vertex("K",2);
         F.add_adjacent_vertex("L",1);
         F.add_adjacent_vertex("M",4);
         Current G=new Current("G",6);
         Current H=new Current("H",2);
         H.add_adjacent_vertex("N",2);
         H.add_adjacent_vertex("O",4);
         Current I=new Current("I",5);
         Current J=new Current("J",4);
         Current K=new Current("K",2);
         Current L=new Current("L",0);
         Current M=new Current("M",4);
         Current N=new Current("N",0);
         Current O=new Current("O",4);
         
         astar.add_List_Point(A);
         astar.add_List_Point(B);
         astar.add_List_Point(C);
         astar.add_List_Point(D);
         astar.add_List_Point(E);
         astar.add_List_Point(F);
         astar.add_List_Point(G);
         astar.add_List_Point(H);
         astar.add_List_Point(I);
         astar.add_List_Point(J);
         astar.add_List_Point(K);
         astar.add_List_Point(L);
         astar.add_List_Point(M);
         astar.add_List_Point(N);
         astar.add_List_Point(O);
       
         astar.Astar("A","K");
     }
}
