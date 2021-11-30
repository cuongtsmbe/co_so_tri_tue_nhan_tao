
package co_so_tri_tue_nhan_tao.Astar;


public class Child {
    String name;
    int kc;//k cách so với đỉnh trước
    public Child(String name,int kc){
        this.name=name;
        this.kc=kc;
    }
    public String get_name(){
        return name;
    }
    public int get_kc(){
        return kc;
    }
}
