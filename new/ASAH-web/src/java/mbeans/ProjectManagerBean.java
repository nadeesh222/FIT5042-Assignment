/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import hms.entities.Donor;
import hms.entities.Project;
import hms.interfaces.ProjectInt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Nadeesh
 */

@ManagedBean(name = "projectManagerBean")
@SessionScoped
public class ProjectManagerBean implements Serializable {

    @EJB
    ProjectInt projectInt;

    private ArrayList<Project> projects;

    public ProjectManagerBean() {

    }

    public void addProject(String name,String description, Double budget, Donor donid) {

        try {

            Project p = new Project();
            p.setName(name);
            p.setDescription(description);
            p.setBudget(budget);
            p.setDonid(donid);
            p.setStatus(1);
          
            projectInt.addProject(p);
            setProjects(null);//to reload all projects fromm database
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getAllProjects() {
        try {

            if (projects == null) {
                List<Project> l = projectInt.getAllProjectsDesc();

                projects = new ArrayList<Project>();

                if (l != null) {
                    for (int i = 0; i < l.size(); i++) {
                        projects.add(l.get(i));
                    }

                    return projects;
                } else {
                    return null;
                }

            }
            return projects;

        } catch (Exception ex) {
            Logger.getLogger(ProjectManagerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void cancelAction(Project d) {
        d.setEditable(false);

        d.setUpdateButtonOn(false);
        d.setEditButtonOn(true);

    }

    public void updateAction(Project d) {
        d.setEditable(false);
        d.setUpdateButtonOn(false);
        d.setEditButtonOn(true);
        projectInt.updateProject(d);//Updating the donor
    }

    public void deleteAction(Project d) {
        if (d != null) {
            d.setEditable(false);
            d.setUpdateButtonOn(false);
            d.setEditButtonOn(true);
            d.setStatus(0);
            projectInt.updateProject(d);//Updating the donor
            setProjects(null);
        }
    }

    public void editAction(Project d) {
        if (d != null) {
            d.setEditable(true);
            d.setUpdateButtonOn(true);
            d.setEditButtonOn(false);
        }
    }

   

}
