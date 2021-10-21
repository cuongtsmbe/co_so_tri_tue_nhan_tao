/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaBinhNuoc;

/**
 *
 * @author phanh
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.s;

/**
 *
 * @author phanh
 */

import BaBinhNuoc.BaBinhNuoc_truoc_sau;
import static java.lang.System.exit;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class XuLyBaBinhNuoc {
        //Danh sách tất cả cách co the xay với 3 bình nước 
	public LinkedList<BaBinhNuoc_truoc_sau> adj;  
        //danh sach tat ca dinh
        public LinkedList<BaBinhNuoc> list_point; 
        // danh sách kề
        private ArrayList<Integer>[] adjList;
        public int GiaiPhap=0;
        public int lit=4;
	XuLyBaBinhNuoc()
        {
            this.adj = new LinkedList<>();
            this.list_point=new LinkedList<>();
     
        }
	//add LinkedList<BaBinhNuoc>adj;
	 void addEdge(BaBinhNuoc_truoc_sau w)
        {
            if(!this.is_exist(w)){
                this.adj.add(w);
            }
            
        }
         public void add_list_points(){
             //đỉnh không đc trùng nhau
             int lengthW=this.adj.size();

             for(int i=0;i<lengthW;i++){
                 BaBinhNuoc w=new BaBinhNuoc(this.adj.get(i).binh_sau_1,this.adj.get(i).binh_sau_2,this.adj.get(i).binh_sau_3);
                 
                 if(this.position_point_in_list(w)==-1){
                        this.list_point.add(w);
                } 
             }
//             System.out.println("So dinh : "+this.list_point.size());
             this.print_point();
            this.initAdjList();
         }
         public void print_point(){
              System.out.println("------point------");
              int length=this.list_point.size();
              for(int i=0;i<length;i++){    
                    System.out.println("-"+i);
                    this.list_point.get(i).Print();
                    System.out.println();

              }
         }
 
         private void print_adjlist(){
             int v=this.adjList.length;
             System.out.println("DS adjList:");
              for (int i = 0; i < v; i++) {
                   System.out.println(this.adjList[i]);
                }
               System.out.println("End DS adjList:");
         }
         //khoi tao danh sach ke
          private void initAdjList()
            {
                int v=this.list_point.size();
                adjList = new ArrayList[v];

                for (int i = 0; i < v; i++) {
                    adjList[i] = new ArrayList<>();
                }
                
                add_values_to_AdjList();
            }
          private int position_point_in_list(BaBinhNuoc w){
              int length_point=this.list_point.size();
              for(int i=0;i<length_point;i++){
                  if(this.list_point.get(i).is_equal(w)){
                      return i;
                  }
              }
            return -1;
          }
          //đưa vào danh sách kề
          void add_values_to_AdjList(){
              int length_adj=this.adj.size();
              int length_point=this.list_point.size();
              for(int i=0;i<length_point;i++){
                   for(int j=0;j<length_adj;j++){
                       if(this.adj.get(j).IsChild(this.list_point.get(i).binh1, this.list_point.get(i).binh2, this.list_point.get(i).binh3)){
                           //vì danh sách đỉnh không bị trùng nên sách kề sẽ không trùng
                           BaBinhNuoc w=this.adj.get(j).get_binh_sau(); 
                           int pos=position_point_in_list(w);
                           if(pos==-1){
                               System.out.println("ERROR POSITION IN LIST");
                               exit(0);
                           }
                           this.adjList[i].add(pos);
                       }
                   }
              }
          }
          
        void getvalue()
        {	
            System.out.println("--TAT CA TRANG THAI--");
            int i =0;
           for (BaBinhNuoc_truoc_sau log : this.adj) {
               
               System.out.println("Trang thai : "+i);
               i++;
                log.print_data_Status();
                System.out.println("");
           }
        }
        public boolean is_exist(BaBinhNuoc_truoc_sau bn)
        {	
            for (BaBinhNuoc_truoc_sau obj : this.adj) {
                if(obj.is_equal_status(bn)){
                    return true;
                }
            }
            return false;

        }
        public void ThucHienDoNuoc(){
            
            BaBinhNuoc_truoc_sau Babinhnuoc=new BaBinhNuoc_truoc_sau();
            this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc.binh_truoc_1,Babinhnuoc.binh_truoc_2,Babinhnuoc.binh_truoc_3,Babinhnuoc.binh_sau_1,Babinhnuoc.binh_sau_2,Babinhnuoc.binh_sau_3));
                 BaBinhNuoc_truoc_sau BabinhnuocTemp=new BaBinhNuoc_truoc_sau();
                 for (int i = 0; i < this.adj.size(); i++) { 
                     if(this.adj.get(i).KiemTraThoaMan()){
                         continue;
                     }
                     // System.out.println("THUC HIEN DO NUOC");
                     //save trang trang thai ban dau cua binh nuoc
                    BabinhnuocTemp.assign_Value_BaBinhNuoc(this.adj.get(i).binh_sau_1, this.adj.get(i).binh_sau_2,this.adj.get(i).binh_sau_3, this.adj.get(i).binh_sau_1, this.adj.get(i).binh_sau_2,this.adj.get(i).binh_sau_3);
                    
                    
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    Babinhnuoc.Full_1();   
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc) );
                    Babinhnuoc.assignW(BabinhnuocTemp);

                    Babinhnuoc.Full_2();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);

                    Babinhnuoc.Full_3();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    
                    Babinhnuoc.Empty_1();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);

                    Babinhnuoc.Empty_2();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    
                    Babinhnuoc.Empty_3();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);

                    Babinhnuoc._1To2();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    
                    Babinhnuoc._1To3();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    
                    Babinhnuoc._2To1();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    
                    Babinhnuoc._2To3();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                 
                    Babinhnuoc._3To1();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
                    
                    Babinhnuoc._3To2();
                    this.addEdge(new BaBinhNuoc_truoc_sau(Babinhnuoc));
                    Babinhnuoc.assignW(BabinhnuocTemp);
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
                System.out.println("Giai Phap: "+this.GiaiPhap);
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
	 public static void main(String args[])
	 {
		 XuLyBaBinhNuoc xuly=new XuLyBaBinhNuoc();
                 xuly.ThucHienDoNuoc();
                 xuly.getvalue();
                System.out.println("-------------------------Giai Phap bai 3 binh nuoc--------------------------- ");
                //all point 
                xuly.add_list_points();
                xuly.print_adjlist();
                for(int i=0;i<xuly.list_point.size();i++){
                    if(xuly.list_point.get(i).binh1==xuly.lit||xuly.list_point.get(i).binh2==xuly.lit||xuly.lit==xuly.list_point.get(i).binh3)
                    xuly.printAllPaths(0,i);
                }

	 }

}

