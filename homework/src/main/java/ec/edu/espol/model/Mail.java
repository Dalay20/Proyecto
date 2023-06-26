
package ec.edu.espol.model;

import java.util.Scanner;



public class Mail {
    private String correo_origen;
    private String correo_destino;
    private String titulo;
    private String mensaje;

    public Mail(String correo_origen, String correo_destino, String titulo, String mensaje) {
        this.correo_origen = correo_origen;
        this.correo_destino = correo_destino;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public Mail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCorreo_origen() {
        return correo_origen;
    }

    public void setCorreo_origen(String correo_origen) {
        this.correo_origen = correo_origen;
    }

    public String getCorreo_destino() {
        return correo_destino;
    }

    public void setCorreo_destino(String correo_destino) {
        this.correo_destino = correo_destino;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return String.format("from:"+correo_origen+", to:"+correo_destino+", tittle: "+titulo+", message:"+ mensaje);
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
        final Mail other = (Mail) obj;
        return((this.correo_origen.equals(other.correo_origen))&&(this.correo_destino.equals(other.correo_destino))&&(this.titulo.equals(other.titulo))&&(this.mensaje.equals(other.mensaje)));
        }
    public static Mail nextMail(Scanner sc){
        String de;
        String para;
        String titulo;
        String mensaje;
        System.out.println("Correo por:");
        de = sc.nextLine();
        System.out.println("Correo para:");
        para = sc.nextLine();
        System.out.println("Titulo:");
        titulo = sc.nextLine();
        System.out.println("Mensaje:");
        mensaje = sc.nextLine();
        return new Mail(de,para,titulo,mensaje);
    }
    
}
