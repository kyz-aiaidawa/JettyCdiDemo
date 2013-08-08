/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room.system.jetty9demo.cdi;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author lisa
 */
@SessionScoped
@Named
public class CdiSessionBean implements Serializable {

    private String name;
    

    public CdiSessionBean() {
       
    }

    @PostConstruct
    public void init() {
      
        this.name = "session scoped cdi ";
       
    }
  
    public void addName(String str){
        this.name +=  str; 
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
