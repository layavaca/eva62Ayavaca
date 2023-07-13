package ec.edu.ups.eva62Ayavaca.negocio;

import java.util.List;

import ec.edu.ups.eva62Ayavaca.datos.InmuebleDao;
import ec.edu.ups.eva62Ayavaca.modelo.Inmueble;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DemoDatos {
	
	@Inject
	private InmuebleDao daoInmueble;
	
	@PostConstruct
	public void init() {
		System.out.println("Evalucion 2");
		System.out.println("1 Inmueble");
		Inmueble i = new Inmueble();		
		i.setSerie("0123456789");
		i.setDescripcion("Mesa");
		i.setDetalle("Madera");
		i.setMarca("Colinial");
		i.setPeso("20kg");
		daoInmueble.insert(i);
		
		System.out.println("2 Inmueble");
		Inmueble i1 = new Inmueble();		
		i1.setSerie("0123456780");
		i1.setDescripcion("silla");
		i1.setDetalle("Madera");
		i1.setMarca("Colinial");
		i1.setPeso("5kg");
		daoInmueble.insert(i1);
		
		System.out.println("3 Inmueble");
		Inmueble i2 = new Inmueble();		
		i2.setSerie("0123456781");
		i2.setDescripcion("Stante");
		i2.setDetalle("Madera");
		i2.setMarca("Colinial");
		i2.setPeso("25kg");
		daoInmueble.insert(i2);
		
		
		//Actualizar un registro
		Inmueble ia = new Inmueble();
		ia.setSerie("0123456789");
		ia.setDescripcion("armario");
		daoInmueble.update(ia);
				
		
		System.out.print("todas la personas mundo -----");
		
		List<Inmueble> inmuebles = daoInmueble.getAll();
		for(Inmueble inm: inmuebles) {
			System.out.println(inm);
		}
		
		
	}
	

}
