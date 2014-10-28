package edu.ulima.ws;

import edu.ulima.entidad.Amigo;
import edu.ulima.entidad.Compadre;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@WebService(serviceName = "MiAmigos")
public class MiAmigos {
    

    @WebMethod(operationName = "grabarAmigos")
    public boolean grabarAmigos(@WebParam(name = "amigo") String amigo, @WebParam(name = "compadre1") String compadre1, @WebParam(name = "compadre2") String compadre2, @WebParam(name = "compadre3") String compadre3) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU-1");
        EntityManager em = emf.createEntityManager();
        
        Amigo a = new Amigo();
        Compadre c1 = new Compadre();
        Compadre c2 = new Compadre();
        Compadre c3 = new Compadre();
        
        a.setNombre(amigo);
        c1.setNombre(compadre1);
        c2.setNombre(compadre2);
        c3.setNombre(compadre3);
        
        List<Compadre> l = new ArrayList<>();
        l.add(c1);
        l.add(c2);
        l.add(c3);
        a.setCompadres(l);
        
        c1.setAmigo(a);
        c2.setAmigo(a);
        c3.setAmigo(a);
        
        boolean ok =false;
        em.getTransaction().begin();
        try{
            em.persist(a);
            em.flush();
            em.getTransaction().commit();
            ok=true;
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        
        return ok;
    }

}
