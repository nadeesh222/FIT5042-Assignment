/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.ejb;

import hms.entities.Project;
import hms.interfaces.ProjectInt;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
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
    public List<Project[]> searchProjectDetails(String pname, String dname) {
        //Query query = entityManager.createQuery("SELECT p.name ,p.description,d.name,p.budget FROM  HMSDB.PROJECT p,HMSDB.Donor d where p.donid=d.donid and  (upper(p.name) like '%:pname%' or upper(p.description) like '%:pname%') and  upper(d.name)like '%:dname%'");

          List<Project[]> results = null;
      
        try{
        try {
            pname = pname.trim();
            dname = dname.trim();
            String q = "SELECT p  FROM Project p,p.donid d ";
            String where = "";

            if (pname.length() > 0 && dname.length() > 0) {

                where = " where ( p.name LIKE CONCAT('%',:pname,'%') ) and (p.donid.name   LIKE CONCAT('%',:dname,'%') ) ";
            } else if (pname.length() > 0) {
                where = " where ( p.name LIKE CONCAT('%',:pname,'%')  )   ";

            }
                else if (dname.length() > 0) {
                where = " where ( p.donid.name LIKE CONCAT('%',:dname,'%') )   ";

            }
            q=q+where;
            Query query = entityManager.createQuery(q);
            if(pname.length()>0){
            
            query.setParameter("pname", pname);
            }
            
            if(dname.length()>0){
            query.setParameter("dname", dname);
            }
            results = query.getResultList();
            int b = 10;
        } catch (Exception ex) {

            String y = "";

        }
        
}
catch(Exception ex){
String s="";
}
        return results;

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
