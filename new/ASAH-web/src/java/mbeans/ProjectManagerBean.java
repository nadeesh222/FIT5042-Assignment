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
import java.util.Iterator;
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

    private Integer projid;
    private String name;
    private String description;
    private Double budget;
    private controllers.Donor donid;
    @EJB
    ProjectInt projectInt;

    private ArrayList<Project> projects;

    public ProjectManagerBean() {
    }

    public Integer getProjid() {
        return projid;
    }

    public void setProjid(Integer projid) {
        this.projid = projid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public controllers.Donor getDonid() {
        return donid;
    }

    public void setDonid(controllers.Donor donid) {
        this.donid = donid;
    }

    public void addProject(String name, String description, Double budget, Donor donid) {

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

    
   
    public ArrayList<Project> searchProjectData(String pname, String dname) {
        
        try{

            projects = new ArrayList<Project>();

            List list = projectInt.searchProjectDetails(pname, dname);

            if (list != null) {
                
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        Project p = (Project) list.get(i);
                        // Project p=i.next();
                        projects.add(p);

                    } else {
                        return null;
                    }

                }
             
        }
            
        }
        catch(Exception ex){}
        return projects;
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
