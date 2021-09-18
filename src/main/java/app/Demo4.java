package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo4 {
	
	public static void main(String[] args) {
		//1. Especificar la conexión de BD que vamos a utilizar
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. obtener el DAO		
		EntityManager em = fabrica.createEntityManager();
		
		//3. Procesos... obtener toda la información del usuario con determinado código
		Usuario u = em.find(Usuario.class, 11);	
		
		if(u == null) {
			System.out.println("Usuario NO existe");
		} else {
			System.out.println("Usuario encontrado: " + u.getNombre());
			System.out.println(u);
		}		
		em.close();
		
	}

}
