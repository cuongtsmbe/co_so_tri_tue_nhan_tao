
package co_so_tri_tue_nhan_tao.Astar;

import java.util.ArrayList;
import java.util.LinkedList;


public class AStar {
    ArrayList<Current> List_Point=new ArrayList<>();
    LinkedList<Current> Open=new LinkedList<>();
    LinkedList<Current> Closed=new LinkedList<>();
    public void add_List_Point(Current A){
        this.List_Point.add(A);
    }
    public void Astar(String start,String end){
         System.out.println("Path is:");
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
                  
                    System.out.print(A.get_name()+" <- ");
                      A=A.Prev;
                       
                }while(A!=null);
             

                System.out.println("Start");
                 System.out.println("g(x):"+this.Open.get(0).get_gx());
                break;
            }
            this.Open.remove(0);//xoa khỏi open
            for(Child ch:Temp.get_list_child()){
                //thêm đỉnh mới vào open
                int pos_in_list_point=this.pos_in_list_point(ch.get_name());
                //cập nhật gx lại cho điểm hiện tại
                 if(this.is_closed(this.List_Point.get(pos_in_list_point))==0){
                        continue ;
                    }
                    if(this.is_open(this.List_Point.get(pos_in_list_point))==0){
                        continue ;
                    }
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
        
         Current A=new Current("A",366);
         A.add_adjacent_vertex("Z",75);
         A.add_adjacent_vertex("S",140);
         A.add_adjacent_vertex("T",118);
         
         Current B=new Current("B",0);
         B.add_adjacent_vertex("U",85);
         B.add_adjacent_vertex("G",90);
         B.add_adjacent_vertex("P",101);
         B.add_adjacent_vertex("F",211);
         
         Current C=new Current("C",160);
         C.add_adjacent_vertex("P",138);
         C.add_adjacent_vertex("R",146);
         C.add_adjacent_vertex("D",120);
         
         Current D=new Current("D",242);
         D.add_adjacent_vertex("M",75);
         D.add_adjacent_vertex("C",120);
         
         Current E=new Current("E",161);
         E.add_adjacent_vertex("H",86);
         
         Current F=new Current("F",178);
         F.add_adjacent_vertex("S",99);
         F.add_adjacent_vertex("B",211);
         
         Current G=new Current("G",77);
         G.add_adjacent_vertex("B",90);
         
         Current H=new Current("H",151);
         H.add_adjacent_vertex("U",98);
         H.add_adjacent_vertex("E",86);
         
         Current I=new Current("I",226);
         I.add_adjacent_vertex("N",87);
         I.add_adjacent_vertex("V",92);
         
         Current L=new Current("L",244);
         L.add_adjacent_vertex("T",111);
         L.add_adjacent_vertex("M",70);
         
         Current M=new Current("M",241);
         M.add_adjacent_vertex("L",70);
         M.add_adjacent_vertex("D",75);
         
         Current N=new Current("N",234);
         N.add_adjacent_vertex("I",87);
         
         Current O=new Current("O",380);
         O.add_adjacent_vertex("Z",71);
         O.add_adjacent_vertex("S",151);
         
         Current P=new Current("P",98);
         P.add_adjacent_vertex("R",97);
         P.add_adjacent_vertex("C",138);
         P.add_adjacent_vertex("B",101);
       
         Current R=new Current("R",193);
         R.add_adjacent_vertex("S",80);
         R.add_adjacent_vertex("P",97);
         R.add_adjacent_vertex("C",146);
         
         Current S=new Current("S",253);
         S.add_adjacent_vertex("O",151);
         S.add_adjacent_vertex("A",140);
         S.add_adjacent_vertex("F",99);
         S.add_adjacent_vertex("R",80);
         
         Current T=new Current("T",329);
         T.add_adjacent_vertex("A",118);
         T.add_adjacent_vertex("L",111);
         
         Current U=new Current("U",80);
         U.add_adjacent_vertex("V",142);
         U.add_adjacent_vertex("H",98);
         U.add_adjacent_vertex("B",85);
         
         Current V=new Current("V",199);
         V.add_adjacent_vertex("I",92);
         V.add_adjacent_vertex("U",142);
        
         Current Z=new Current("Z",374);
         Z.add_adjacent_vertex("O",71);
         Z.add_adjacent_vertex("A",75);
         
         astar.add_List_Point(A);
         astar.add_List_Point(B);
         astar.add_List_Point(C);
         astar.add_List_Point(D);
         astar.add_List_Point(E);
         astar.add_List_Point(F);
         astar.add_List_Point(G);
         astar.add_List_Point(H);
         astar.add_List_Point(I);
         astar.add_List_Point(L);
         astar.add_List_Point(M);
         astar.add_List_Point(N);
         astar.add_List_Point(O);
         astar.add_List_Point(P);
         astar.add_List_Point(R);
         astar.add_List_Point(S);
         astar.add_List_Point(T);
         astar.add_List_Point(U);
         astar.add_List_Point(V);
         astar.add_List_Point(Z);
     
         astar.Astar("A","B");
     }
}
