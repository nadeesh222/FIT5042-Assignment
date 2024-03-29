/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.ejb;

import hms.entities.Donor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import hms.interfaces.DonorInt;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Nadeesh
 */
@Stateless

public class DonorImpl implements DonorInt {

    @PersistenceContext(unitName = "HMS-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addDonor(Donor donor) {

        List<Donor> donors = getAllDonorsDesc();

        donor.setDonid(findMaxDonorId() + 1);

        entityManager.persist(donor);

    }

    @Override
    public int diactivateDonor(int donId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Donor> getAllDonorsDesc() {
        List<Donor> donList = null;
        try {

            //empList 
            donList = entityManager.createNamedQuery("Donor.findAllDesc").getResultList();

        } catch (Exception ex) {
            String y = "";
        }
        return donList;

    }

    @Override
    public List<Donor> getAllDonorsAsc() {
        List<Donor> donList = null;
        try {

            //empList 
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(Donor.class);
            Root<Donor> donor = query.from(Donor.class);
            
            query.select(donor);
           
            
            query.select(builder.array(
                    donor.get("donid"),
                    donor.get("name"),
                    donor.get("address"),
                    donor.get("contactno")
            )).where(builder.equal(donor.get("status").as(Integer.class), 1));


            TypedQuery<Donor> d1 = entityManager.createQuery(query);
            //donList = (List<Donor>)entityManager.createQuery(query).getResultList();
            donList = entityManager.createNamedQuery("Donor.findAllAsc").getResultList();

        } catch (Exception ex) {
            String y = "";
        }
        return donList;

    }

    @Override
    public Donor getDonorByDonId(int donId) {

        Donor donor = new Donor();
        try {
            Query query = entityManager.createNamedQuery("Student.findByDonid");
            query.setParameter("donid", donId);
            donor = (Donor) query.getSingleResult();
        } catch (Exception ex) {

        }
        return donor;
    }

    @Override
    public int findMaxDonorId() {
        int maxid = 0;
        try {
            maxid = Integer.parseInt(entityManager.createNamedQuery("Donor.findmaxId").getSingleResult().toString());
        } catch (Exception ex) {

        }
        return maxid;
    }

    @Override
    public void updateDonor(Donor donor) {
        entityManager.merge(donor);

    }

}
