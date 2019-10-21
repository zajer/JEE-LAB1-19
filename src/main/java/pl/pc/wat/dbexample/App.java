/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pc.wat.dbexample;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Piotrek
 */
public class App {
    public static void main(String[] args) {
        System.out.println("yolo");
        
        EntityManager dbm = Persistence.createEntityManagerFactory("pl.pc.wat_DBExample_jar_1.0-SNAPSHOTPU").createEntityManager();
        
        List<T1> result1 = dbm.createNamedQuery("T1.findAll").getResultList();
        
        for(T1 partRes : result1)
            System.out.println(partRes.getC1Strings());
        
        T1 result2 = dbm.find(T1.class, new String("Yolo"));
        
        System.out.println(result2.getC2Int());
        
        List<T1> result3 = dbm.createQuery("select c from T1 c where c.c1Strings like :myparam")
                .setParameter("myparam", "Yolo")
                .getResultList();
        for(T1 partRes : result3)
            System.out.println(partRes.getC1Strings() + " "+ partRes.getC2Int());
        
        T1 res4 = dbm.find(T1.class, "Yolo");
        
        res4.setC2Int(res4.getC2Int()+7);
        dbm.getTransaction().begin();
        dbm.persist(res4);
        dbm.getTransaction().commit();
        
        
    }
}
