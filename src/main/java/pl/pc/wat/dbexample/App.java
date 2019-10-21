package pl.pc.wat.dbexample;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {
    
    private static String persistanceUnitName = "pl.pc.wat_DBExample_jar_1.0-SNAPSHOTPU";
    private static String criterionForResult2 = "Yolo";
    private static String criterionForResult3 = "Yolo";
    private static String criterionForResult4 = "Yolo";
    private static String criterionForResult5 = "Yolo";
    public static void main(String[] args) {
        EntityManager dbm = Persistence.createEntityManagerFactory(persistanceUnitName).createEntityManager();
        
        List<T1> result1 = dbm.createNamedQuery("T1.findAll").getResultList();
        
        for(T1 partRes : result1)
            System.out.println(partRes.getC1Strings());
        
        T1 result2 = dbm.find(T1.class, criterionForResult2);
        
        System.out.println(result2.getC2Int());
        
        List<T1> result3 = dbm.createQuery("select c from T1 c where c.c1Strings like :myparam")
                .setParameter("myparam", criterionForResult3)
                .getResultList();
        
        for(T1 partRes : result3)
            System.out.println(partRes.getC1Strings() + " "+ partRes.getC2Int());
        
        T1 res4 = dbm.find(T1.class, criterionForResult4);
        
        res4.setC2Int(res4.getC2Int()+7);
        dbm.getTransaction().begin();
        dbm.persist(res4);
        dbm.getTransaction().commit();
        //Usuwanie encji
        /*
        T1 res5 = dbm.find(T1.class, criterionForResult5);
        dbm.getTransaction().begin();
        dbm.remove(res5);
        dbm.getTransaction().commit();
        */
    }
}
