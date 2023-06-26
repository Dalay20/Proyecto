
package ec.edu.espol.model;

import java.util.Scanner;

public class Array {
    private int arrent[];

    public Array(int tamano) {
        arrent=new int[tamano];   
    }
    public Array(){
        arrent= new int[10];
    }

    private Array(int[] a2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int size(){
        return arrent.length;
    }
    public Array concat(Array arreglo){
        int a1=arrent.length+arreglo.size();
        int a2[]=new int[a1];
        for (int i=0;i<arrent.length;i++){
            a2[i]=arrent[i];
        }
        int indice =arrent.length;
        for (int i=0;i<arreglo.size();i++){
            a2[indice]=arreglo.get(1);
            indice++;
        }
        return new Array(a2);
    }

    public int get(int indice) {
        if (indice>=0 && indice <arrent.length){
            return arrent[indice];
        }else{
            return -1;
    }
    
    }

    public void set(int indice,int valor){
        if (indice >=0 && indice<arrent.length)
            arrent[indice]=valor;
    }
    
    public Array (int inicio, int fina){
    if (inicio>=0 && fina>=0 && inicio<arrent.length && fina<=arrent.length && inicio<fina){
        int a1 =fina-inicio;
        int a2[]= new int [a1];
        for (int i =inicio, j=0;1<fina;i++,j++)
            a2[j]=arrent[1];
        //////////
    }
    }
    public int sum(){
        int sum =0;
        for (int elem:arrent){
            sum+=elem;    
        } return sum;
    }
    public int max(){
        int max=arrent[0];
        for (int  i =1; i<arrent.length;i++){
            if (arrent[i]>max)
                max=arrent [i];
        }
    return max;
    }
    
    public int min(){
        int min=arrent[0];
        for (int  i=1; i<arrent.length;i++){
            if (arrent[i]<min)
                min=arrent [i];
        }
    return min;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int  i=0; i<arrent.length;i++){
            sb.append(arrent[i]);
            if (1<arrent.length-1)
                sb.append(" ");
        }
     sb.append("]");
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { 
            return true;
        }
        if (obj == null) {//null check
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Array other = (Array) obj;
        if (arrent.length!= other.arrent.length){
        return false;} 
        for(int i=0;i<arrent.length;i++){
            if (arrent[i] != other.arrent[i]){
        return false;
            } 
        }return true;     
    }
    public static Array leerScanner(Scanner sc){
        System.out.println("Ingrese la dimension");
        int dimension = sc.nextInt();
        sc.nextLine();
        Array arr = new Array(dimension);
        System.out.println("Ingrese los valores");
        for (int i=0;i<dimension;i++){
            System.out.println("Elementos"+i+1+":");
            int valor=sc.nextInt();
            arr.set(i,valor);
            sc.nextLine();
        }return arr;
    }
    
}

