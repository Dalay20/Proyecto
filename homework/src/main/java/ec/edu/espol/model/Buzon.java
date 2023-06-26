
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Buzon {  
    List<Mail> mails = new  LinkedList<>();
    public Buzon(){
        mails= new LinkedList<>();
    }
    public List<Mail>getMails(){
        return mails;
    }
    public void setMails(List<Mail> mails){
      this.mails=mails;
    }
public String toString(){
    StringBuilder u;
    u= new StringBuilder();
    u.append("(");
    for (int i=0;i<mails.size();i++){
        u.append("Mail#").append(i+1).append(":").append(mails.get(1));
        if (i<mails.size()-1);{
        u.append(",");
    }
        append(")");
        
    }
        return null;
}

    private void append(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   
