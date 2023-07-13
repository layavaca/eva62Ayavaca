package ec.edu.ups.eva62Ayavaca.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.eva62Ayavaca.modelo.Inmueble;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


	@Stateless
	public class InmuebleDao  implements Serializable{

		private static final long serialVersionUID = 1L;
		@PersistenceContext
		private EntityManager em;
		
		public void insert(Inmueble inmueble) {
			em.persist(inmueble);
		}
		
		public void update(Inmueble inmueble) {
			em.merge(inmueble);
		}
		
		public Inmueble read(String serie) {
			Inmueble p = em.find(Inmueble.class, serie);
			return p;
		}
		
		public void delete(String serie) {
			Inmueble p = em.find(Inmueble.class, serie);
			em.remove(p);
		}
		
		public List<Inmueble> getAll(){
			String jpql = "SELECT p FROM Inmueble p";
			Query q = em.createQuery(jpql);
			return q.getResultList();
		}
	}





