package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo3 {
	
	public static void main(String[] args) {
		//1. Especificar la conexión de BD que vamos a utilizar
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. obtener el DAO		
		EntityManager em = fabrica.createEntityManager();
		
		//3. Procesos... Eliminar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(11);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("tatakae@gmail.com");
		u.setClave("12345");
		u.setFnacim("2020/09/12");
		u.setTipo(1);
		u.setEstado(1);
		// reg, act, elim --> Transacciones
		em.getTransaction().begin();
		//Eliminar
		em.remove(u); //Elimina registro.
		em.getTransaction().commit();
		System.out.println("Eliminación Ok");
		em.close();
		
	}

}
