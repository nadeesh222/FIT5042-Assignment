/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 

/**
 *
 * @author Nadeesh
 */

@ManagedBean(name = "utilityManagerBean")
@SessionScoped
public class UtilityManagerBean {
    
    
    
    
    public void  logout() {
    FacesContext context=FacesContext.getCurrentInstance();
    context.getExternalContext().invalidateSession();
    try{
    
    context.getExternalContext().redirect("faces/index.xhtml");
    }
    catch(Exception ex){
    
    }
    }
}
