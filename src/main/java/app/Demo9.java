package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo9 {
	
	public static void main(String[] args) {
		//1. Especificar la conexión de BD que vamos a utilizar
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. obtener el DAO		
		EntityManager em = fabrica.createEntityManager();
		
		//3. Procesos... obtener toda la información del usuario con determinado código
		// Usuario u = em.find(Usuario.class, 11);
		//3. Validar usando el usuario y clave
		
		String sql = "{call usp_validaAcceso (:usr, :cla)}";
		// TypedQuery<Usuario> query2 = em.createQuery(sql, Usuario.class); TypeQuery es solo para JPA
		Query query2 = em.createNativeQuery(sql, Usuario.class); // El Query lo podemos ver como un Objeto
		query2.setParameter("xusr", "U002@gmail.com");
		query2.setParameter("xcla", "10002");
		
		Usuario u = null;
		try {
			u = (Usuario)query2.getSingleResult();
		} catch (NoResultException e) {			
			
		}
				
		if(u == null) {
			System.out.println("Usuario NO existe");
		} else {
			System.out.println("Usuario encontrado: " + u.getNombre());
			System.out.println(u);
		}		
		em.close();
		
	}

}
