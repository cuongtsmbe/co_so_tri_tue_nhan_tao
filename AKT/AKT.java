/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co_so_tri_tue_nhan_tao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author phanh
 */
public class AKT {
    List<puzzels> List_open_8_puzzels =new ArrayList<>();
    int[][] Target_matrix={{1,2,3},{4,5,6},{7,8,0}};
    puzzels puzzels_start;
    List<puzzels> List_close_8_puzzels=new ArrayList<>();
    public AKT(){
        this.puzzels_start=new puzzels(this.Target_matrix);
    }
    //them thu tu nho->lon
    public void add_open_list_8_puzzels(puzzels sc){
        if(is_in_close_list(sc)){return;}
        if(this.List_open_8_puzzels.isEmpty()){         
                this.List_open_8_puzzels.add(sc);
        }else{
                 int lt=this.List_open_8_puzzels.size();
                for (int i = 0; i < lt ; i++) {
			if(this.List_open_8_puzzels.get(i).get_evaluation()>sc.get_evaluation()){
                            this.List_open_8_puzzels.add(i,sc);
                        }
		}   
        }  
    }
    
    public void add_close_list_8_puzzels(puzzels sc){
        if(!is_in_close_list(sc)){
            this.List_close_8_puzzels.add(sc);
        }
    }
    public boolean is_in_close_list(puzzels sc){
        int lt=this.List_close_8_puzzels.size();
        
        for(int i=0;i<lt;i++){
            if(this.List_close_8_puzzels.get(i).is_matrix(sc)){
                return true;
            }
        }
        return false;
    }
    public puzzels get_first_in_list_open_8_puzzels(){
        if(this.List_open_8_puzzels.isEmpty()){ System.out.println("khong lay duoc"); return new puzzels();}
        puzzels Prev=this.List_open_8_puzzels.get(0);
        this.List_open_8_puzzels.remove(0);

        return Prev;
    }
    public void show_path(puzzels sc){
        System.out.println("Duong di: ");
        while(!sc.is_matrix_start()){
            sc.show_matrix();
            System.out.println();
            sc=sc.Prev;
        }
        
        this.puzzels_start.show_matrix();
    }
    
    public void AKT(){
        boolean is_had_path=true;
        this.add_open_list_8_puzzels(this.puzzels_start);
         puzzels T=new puzzels();
        while(!this.List_open_8_puzzels.isEmpty()){
             T=this.get_first_in_list_open_8_puzzels();
            if(T.is_target_matrix()){
                 System.out.println();
                 is_had_path=true;
                break;
            }
            this.add_close_list_8_puzzels(new puzzels(T.Prev,T.matrix,T.wrong_num_of_vertices,T.number_of_steps));
            int i=T.get_x_position_0();//vi tri so 0 tai i
            int j=T.get_y_position_0();//vi tri so 0 tai j
            if(j>0){
                add_open_list_8_puzzels(T.move_left(i, j,this.Target_matrix,T));  
            }
            if(j<2){
                add_open_list_8_puzzels(T.move_right(i, j,this.Target_matrix,T));
            }
            if(i>0){
                add_open_list_8_puzzels(T.move_top(i, j,this.Target_matrix,T));
            }
            if(i<2){
                add_open_list_8_puzzels(T.move_down(i, j,this.Target_matrix,T));
            }
            is_had_path=false;
        }
   //    if(is_had_path){
        this.show_path(T);
//       }else{
//           System.out.println("khong co duong di");
//       }
    }
    
    public static void main(String[] args) {
        AKT akt=new AKT();
        akt.AKT();
        
    }
}
