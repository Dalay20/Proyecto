package ec.edu.espol.model;

import java.util.Scanner;

 public class Vector2D {
    private double x;
    private double y;
    
     public Vector2D( double x){
     this.x = x;
     this.y = 0;
 }
     public Vector2D (double x, double y){
     this.x=x;
     this.y=y;  
 }
     //getter y seeter
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
   
    public Vector2D sumar(Vector2D vec){
        double x1=this.x+vec.getX();
        double y1=this.y+vec.getY();
        return new Vector2D(x1,y1);  
    }
    public Vector2D restar(Vector2D vec){
        double x1=this.x-vec.getX();
        double y1=this.y-vec.getY();
        return new Vector2D(x1,y1);  
    }    
    public double modulo(){
        return Math.sqrt((Math.pow(x, 2))+(Math.pow(y, 2)));
    }
    public Vector2D vunitario(){
        double modulo=modulo();
        double x1=x/modulo;
        double y1=y/modulo;
        return new Vector2D(x1,y1);
    }
    
    
    @Override
    public String toString(){
       return "v=("+this.x+","+this.y+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//self check-- el obejto que estoy comparando es el unico que estoy enviando 
            return true;
        }
        if (obj == null) {//null check
            return false;
        }
        if (getClass() != obj.getClass()) {//compara las clases -- class check
            return false;
        }
        final Vector2D other = (Vector2D) obj;
        return 
                (this.x== other.x)&&(this.y==other.y);
    }
    //se ejecuta almenos una vez el codigo
    public static Vector2D leerTeclado(Scanner sc){
        double x=0;
        double y=0;
        do{
        System.out.println("Ingrese en valor de x");
        x= sc.nextDouble();
        System.out.println("Ingrese en valor de y");
        y=sc.nextDouble();
        
        }while(x<0 || y<0);
        System.out.println("ok");
        return new Vector2D(x,y);
    }
        
    
    }
