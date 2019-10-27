/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.interfaces;

import hms.entities.Donor;
import hms.entities.Project;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Nadeesh
 */
@Remote
public interface ProjectInt {

    void addProject(Project project);

    void updateProject(Project project);

    int diactivateProject(int projId);

    List<Project> getAllProjectsDesc();

    List<Project> getAllProjectsAsc();

    int findMaxProjectId();
    List searchProjectDetails(String pname,String dname);
}
