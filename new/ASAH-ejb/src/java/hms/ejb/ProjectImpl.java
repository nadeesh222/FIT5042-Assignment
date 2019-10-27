/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.ejb;

import hms.entities.Project;
import hms.interfaces.ProjectInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Nadeesh
 */
@Stateless

public class ProjectImpl implements ProjectInt {

    @PersistenceContext(unitName = "HMS-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addProject(Project project) {

        List<Project> projects = getAllProjectsDesc();

        project.setProjid(findMaxProjectId() + 1);

        entityManager.persist(project);

    }

    @Override
    public int diactivateProject(int donId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> getAllProjectsDesc() {
        List<Project> donList = null;
        try {

            //empList 
            donList = entityManager.createNamedQuery("Project.findAllDesc").getResultList();

        } catch (Exception ex) {
            String y = "";
        }
        return donList;

    }

    @Override
    public List<Project> getAllProjectsAsc() {
        List<Project> donList = null;
        try {

            //empList 
            donList = entityManager.createNamedQuery("Project.findAllAsc").getResultList();

        } catch (Exception ex) {
            String y = "";
        }
        return donList;

    }
    
    
    @Override
public void searchProjectDetails(String qry){
 Query query = entityManager.createNamedQuery("Project.searchproject");
        query.setParameter("qry", qry);
        
         List s=query.getResultList();
         String d="";
        
}
        
        
        
        
        
    @Override
    public int findMaxProjectId() {
        int maxid = 0;
        try {
            maxid = Integer.parseInt(entityManager.createNamedQuery("Project.findmaxId").getSingleResult().toString());
        } catch (Exception ex) {

        }
        return maxid;
    }

    @Override
    public void updateProject(Project project) {
        entityManager.merge(project);

    }

}
