package app;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Usuario;

public class Demo6 {
	
	public static void main(String[] args) {
		//1. Especificar la conexión de BD que vamos a utilizar
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. obtener el DAO		
		EntityManager em = fabrica.createEntityManager();
		
		//3. Listado de los usuarios
		TypedQuery<Usuario> query = em.createQuery("Select u from Usuario u", Usuario.class);
		List<Usuario> lstUsuarios = query.getResultList();
		System.out.println("Cantidad de usuarios: " + lstUsuarios.size());
		
		if(lstUsuarios.size()==0) {
			System.out.println("Listado vacío");
		} else {
			for(Usuario u : lstUsuarios) {
				System.out.println(">>> " + u);
			}
		}
		
		//listado con parámetros -- listado de los usuarios tipo1
		
		String sql = "Select u from Usuario u where u.tipo = :xtipo";
		TypedQuery<Usuario> query2 = em.createQuery(sql, Usuario.class);
		query2.setParameter("xtipo", 1);
		List<Usuario> lstUsuarios2 = query2.getResultList();		
		System.out.println("Cantidad de usuarios tipo 1: " + lstUsuarios2.size());
		if(lstUsuarios.size()==0) {
			System.out.println("Listado de usuarios tipo 1");
		} else {
			for(Usuario u : lstUsuarios2) {
				System.out.println(">>> " + u);
			}
		}
		
		
	}

}
