/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AT;

/**
 *
 * @author phanh
 */
public class Point {
    private String ParentPoint;
    private String NamePoint;
    private double dist ;
   
    
    Point(Point w){
        this.ParentPoint=w.ParentPoint;
        this.NamePoint=w.NamePoint;
        this.dist=w.dist;
        
    }
    
    Point(String ParentPoint,String NamePoint,double dist){
        this.ParentPoint=ParentPoint;
        this.NamePoint=NamePoint;
        this.dist=dist;
       
    }
    
    public void setParentPoint(String w){
        this.ParentPoint=w;
    }
    public String getParentPoint(){
        return this.ParentPoint;
    }
    
    public void setDist(double w){
        this.dist=w;
    }
    public double getDist(){
        return this.dist;
    }
    
    public void setNamePoint(String NamePoint){
        this.NamePoint=NamePoint;
    }
    
    public boolean is_equal(String w){
        return this.NamePoint.equals(w);
    }
    public boolean is_equal_parent(String w){
        return this.ParentPoint.equals(w);
    }
    
    public boolean is_node_current(Point w){
        return this.ParentPoint.equals(w.ParentPoint)&&this.NamePoint.equals(w.NamePoint);
    }
    public void out_point_screen(){
        System.out.println("("+this.ParentPoint+","+this.getNamePoint()+","+this.dist+") ");
    }
    public String getNamePoint(){
        return this.NamePoint;
    }
    
}
