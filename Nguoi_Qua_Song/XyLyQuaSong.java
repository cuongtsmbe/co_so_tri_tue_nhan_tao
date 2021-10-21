/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nguoi_Qua_Song;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phanh
 */

public class XyLyQuaSong {
    public int MaxDinh=15;
    public LinkedList<Nguoi_Soi_Ngo_Ga> list_point;
    //danh sach cac dinh ke
    private ArrayList<Integer>[] adjList;
    
    public int GiaiPhap=0;
    XyLyQuaSong(){
        this.list_point=new LinkedList<>();
        this.initAdjList();
    } 
    private void initAdjList()
    {
                int v=this.MaxDinh;
                adjList = new ArrayList[v];

                for (int i = 0; i < v; i++) {
                    adjList[i] = new ArrayList<>();
                }
                
    }
    public int is_exist_in_list_point(Nguoi_Soi_Ngo_Ga w){
        int lengthListPoint=this.list_point.size();
        for(int i=0;i<lengthListPoint;i++){
            if(this.list_point.get(i).is_equal(w)){
                return i;
            }
        }
        return -1;
    }
    //thực hiện them vao danh sach dinh (list_point) and danh sach ke (adjList)
    public void addWithPos(Nguoi_Soi_Ngo_Ga w,int pos){
                //    w.Print();
          if(is_exist_in_list_point(w)==-1){
//          if(this.list_point.size()>99){return;}
                this.list_point.add(w);
                /*danh sách kê(adjList) tại vị trí i sẽ đc thêm vào vị trí của đỉnh mới thêm vào list_point*/
                this.adjList[pos].add(this.list_point.size()-1);
            }else{
              //Đỉnh đã có trong danh sách kề với đỉnh đang xét
              int p=is_exist_in_list_point(w);
              if(this.adjList[pos].indexOf(p)==-1&&pos!=p){
                this.adjList[pos].add(p);
              }
            }
    }
    
    //xử lý để thêm vào danh sách đỉnh (list_point) và danh ssachs kề
    public void Add_list_point_and_adjList(){
        if(list_point.isEmpty()){
            list_point.add(new Nguoi_Soi_Ngo_Ga());
        }
        //Them dinh cua do thi vao danh sach(moi dinh chi xuat hien 1  lan)
        Nguoi_Soi_Ngo_Ga NSG=new Nguoi_Soi_Ngo_Ga();
        for(int i=0;i<this.list_point.size();i++){
            
            NSG.assignBy(new Nguoi_Soi_Ngo_Ga(this.list_point.get(i)));
            
            if(NSG.IsFalseCondition()){
                continue;
            }
            
           // System.out.println("asdasd");
            NSG.NguoiGa_Qua();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
            
            NSG.NguoiGa_Ve();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
            
            NSG.NguoiNgo_Qua();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
            
            NSG.NguoiNgo_Ve();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
            
            NSG.Nguoi_Ve();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
            
            NSG.NguoiSoi_Qua();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
            
            NSG.NguoiSoi_Ve();
            this.addWithPos(new Nguoi_Soi_Ngo_Ga(NSG),i);
            NSG.assignBy(this.list_point.get(i));
        }
    }
    
     public void printAllPaths(int s, int d)
        {   
            boolean[] isVisited = new boolean[this.list_point.size()];
            ArrayList<Integer> pathList = new ArrayList<>();
            pathList.add(s);

            printAllPathsUtil(s, d, isVisited, pathList);
        }
        
        private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList)
        {
            if (u.equals(d)) {
                //localPathList.add(d);
                //System.out.println(localPathList);
                this.GiaiPhap++;
                System.out.println("Giai Phap : "+this.GiaiPhap);
                for(int a=0;a<localPathList.size();a++){
                       this.list_point.get(localPathList.get(a)).Print();
                }
                System.out.println();
                return;
            }

            isVisited[u] = true;

            for (Integer i : adjList[u]) {
                if (!isVisited[i]) {
                    localPathList.add(i);
                    printAllPathsUtil(i, d, isVisited, localPathList);
                    localPathList.remove(i);
                }
            }
            isVisited[u] = false;
        }
        public void inra_list_point(){
            System.out.println("Danh sach dinh: ");
            int length_point=this.list_point.size();
            for(int i=0;i<length_point;i++){
                System.out.println("Dinh : "+i);
                this.list_point.get(i).Print();
                System.out.println();
            }
        }
        public void inra_adjList(){
            System.out.println("Danh sach ke: ");
            int length=this.adjList.length;
            for(int i=0;i<length;i++){
                System.out.println(this.adjList[i]);
            }
        }
         public static void main(String args[])
	 {
		XyLyQuaSong xuly=new XyLyQuaSong();
                xuly.Add_list_point_and_adjList();
                System.out.println("-------Giai Phap bai qua song Thu tu :(Ga,Ngo,Soi,Nguoi)------ ");
            //in ra danh sách tất cả đỉnh
            //    xuly.inra_list_point();
                System.out.println();
            //in ra danh sách kề
            //    xuly.inra_adjList();
                xuly.printAllPaths(0,13);

	 }
}
