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
public class puzzels {
    int[][] matrix=new int[3][3];
   // int[][] matrix ={{2,8,3},{1,6,4},{7,0,5}};
    int wrong_num_of_vertices;
    int number_of_steps;
    puzzels Prev;
    public puzzels(){}


    public  puzzels(puzzels Prev,int[][] matrix,int wrong_num_of_vertices,int number_of_steps){
         this.Prev=Prev;
         
          for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
		 {
		    this.matrix[i][j]=matrix[i][j];
		 }
	    
	   }
         this.number_of_steps=number_of_steps;
         this.wrong_num_of_vertices=this.wrong_num_of_vertices;
    }
    public puzzels(int[][] Target_matrix){
        this.number_of_steps=0;
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
		 {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Matrix["+i+"]["+j+"]:");
                    int number_scan= s.nextInt();
		    matrix[i][j]=number_scan;
		 }
	    
	   }
        
        this.wrong_num_of_vertices=0;
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
                 {
		    if(this.matrix[i][j]!=0&&this.matrix[i][j]!=Target_matrix[i][j]){
                        this.wrong_num_of_vertices++;
                    }
		 }
	    
	   }
        this.Prev=new puzzels();
    }

  
    
 
    public void create_puzzels(puzzels Prev,int matrix[][],int wrong_num_of_vertices,int number_of_steps){
         this.Prev=Prev;
     
         
          for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
		 {
		    this.matrix[i][j]=matrix[i][j];
		 }
	    
	   }
              
              
         this.number_of_steps=number_of_steps;
         this.wrong_num_of_vertices=this.wrong_num_of_vertices;
    }
    

    public void set_matrix(){
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
		 {
                    Scanner s = new Scanner(System.in);
                    System.out.println("Matrix["+i+"]["+j+"]:");
                    int number_scan= s.nextInt();
		    matrix[i][j]=number_scan;
		 }
	    
	   }
    }
    public void set_matrix(int matrix[][]){
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
                 {
		    this.matrix[i][j]=matrix[i][j];
		 }
	    
	   }
    }
    
    public void set_Prev(){
        this.Prev=this;
    }
    
    public void set_Prev(puzzels Prev){
        puzzels temp=new puzzels();
        temp.create_puzzels(Prev.get_Prev(),Prev.get_matrix(),Prev.get_wrong_num_of_vertices(),Prev.get_number_of_steps());
        this.Prev=temp;
        }
    
   
    
    public void set_wrong_num_of_vertices(int Target_matrix[][]){
        this.wrong_num_of_vertices=0;
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
                 {
		    if(this.matrix[i][j]!=0&&this.matrix[i][j]!=Target_matrix[i][j]){
                        this.wrong_num_of_vertices++;
                    }
		 }
	    
	   }
    }

    public void set_number_of_steps(){
        this.number_of_steps++;
    }
    public int get_wrong_num_of_vertices(){
        return this.wrong_num_of_vertices;
    }
    public int get_number_of_steps(){
        return this.number_of_steps;
    }
    public puzzels get_Prev(){
        return this.Prev;
    }
    public boolean is_matrix_start(){
        return this.number_of_steps==0;
    }
    public int[][] get_matrix(){
        return this.matrix;
    }
    public void show_matrix(){
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print("  " + matrix1[j] + "    ");
            }
            System.out.println();
        }
    }
    public int get_x_position_0(){
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
                 {
		    if(matrix[i][j]==0){
                        return i;
                    }
                      
		 }
               
	   }
        return -1;
    }
    
     public int get_y_position_0(){
        for (int i = 0; i < matrix.length; i++)
	    {
		 for (int j = 0; j < matrix[i].length; j++)
                 {
		    if(matrix[i][j]==0){
                        return j;
                    }
                      
		 }
               
	   }
        return -1;
    }
    
     
     public puzzels move_left(int i,int j,int[][] target_matrix,puzzels parent){
         
         puzzels T=new puzzels(this.Prev,this.matrix,this.wrong_num_of_vertices,this.number_of_steps+1);
             T.matrix[i][j]=T.matrix[i][j-1];
             T.matrix[i][j-1]=0;
             T.set_wrong_num_of_vertices(target_matrix);
             T.set_Prev(parent);
         return T;
     }
     
    public puzzels move_right(int i,int j,int[][] target_matrix,puzzels parent){
           puzzels T=new puzzels(this.Prev,this.matrix,this.wrong_num_of_vertices,this.number_of_steps+1);
             T.matrix[i][j]=T.matrix[i][j+1];
             T.matrix[i][j+1]=0;
              T.set_wrong_num_of_vertices(target_matrix);
               T.set_Prev(parent);
             return T;

     }
    
    public puzzels move_top(int i,int j,int[][] target_matrix,puzzels parent){
         puzzels T=new puzzels(this.Prev,this.matrix,this.wrong_num_of_vertices,this.number_of_steps+1);
             T.matrix[i][j]=T.matrix[i-1][j];
             T.matrix[i-1][j]=0;
              T.set_wrong_num_of_vertices(target_matrix);
             T.set_Prev(parent);
           return T;
     }
    public puzzels  move_down(int i,int j,int[][] target_matrix,puzzels parent){
        puzzels T=new puzzels(this.Prev,this.matrix,this.wrong_num_of_vertices,this.number_of_steps+1);
         
             T.matrix[i][j]=T.matrix[i+1][j];
             T.matrix[i+1][j]=0;
              T.set_wrong_num_of_vertices(target_matrix);
              T.set_Prev(parent);
            return T;
     }
    public int get_evaluation(){
        return this.number_of_steps+this.wrong_num_of_vertices;
    }
    public boolean is_target_matrix(){
        if(this.wrong_num_of_vertices==0){
            return true;
        }
        return false;
    }
    
    public boolean is_matrix(puzzels sc){
        int[][] matrix=sc.get_matrix();
        int lt=matrix.length;
        for (int i = 0; i < lt; i++)
	    {
		 for (int j = 0; j < lt; j++)
                 {
		    if(matrix[i][j]!=this.matrix[i][j]){
                        return false;
                    }
                      
		 }
               
	   }
        return true;
    }
    
}
