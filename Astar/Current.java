
package co_so_tri_tue_nhan_tao.Astar;

import java.util.ArrayList;


public class Current {
    int hx; //h(x)
    String name;
    int gx; //g(x)
    Current Prev=null;
    ArrayList<Child> list_adjacent_vertex=new ArrayList<>();
    public Current(){}
    public Current(String name,int hx){
        this.name=name;
        this.hx=hx;
        this.gx=0;
    }
    public int get_hx(){
        return hx;
    }
    public int get_gx(){
        return gx;
    }
    public String get_name(){
        return name;
    }
    public void set_gx(int A){
        this.gx=A;
    }
    public int get_fx(){
        return this.gx+this.hx;
    }
    public ArrayList<Child> get_list_child(){
        return this.list_adjacent_vertex;
    }
    public void add_adjacent_vertex(String name,int kc){
        list_adjacent_vertex.add(new Child(name,kc));
    }
    
     
}
