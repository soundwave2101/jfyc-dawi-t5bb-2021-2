package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo8 {
	
	public static void main(String[] args) {
		//1. Especificar la conexión de BD que vamos a utilizar
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. obtener el DAO		
		EntityManager em = fabrica.createEntityManager();
		
		//3. Procesos... obtener toda la información del usuario con determinado código
		// Usuario u = em.find(Usuario.class, 11);
		//3. Validar usando el usuario y clave
		
		String sql = "Select u from Usuario u where u.usuario = :xusr and u.clave= :xcla";
		TypedQuery<Usuario> query2 = em.createQuery(sql, Usuario.class);
		query2.setParameter("xusr", "U002@gmail.com");
		query2.setParameter("xcla", "10002");
		
		Usuario u = null;
		try {
			u = query2.getSingleResult();
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
