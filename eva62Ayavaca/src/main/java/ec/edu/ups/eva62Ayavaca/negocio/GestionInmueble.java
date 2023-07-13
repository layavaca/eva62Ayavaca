package ec.edu.ups.eva62Ayavaca.negocio;

import ec.edu.ups.eva62Ayavaca.datos.InmuebleDao;
import ec.edu.ups.eva62Ayavaca.modelo.Inmueble;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionInmueble {
	
	@Inject
	private InmuebleDao daoInmueble;
	public void guardarInmueble(Inmueble inmueble) throws Exception {
		if(!this.isCedulaValida(inmueble.getSerie()))
			throw new Exception("serie incorrecta");
		if(daoInmueble.read(inmueble.getSerie())== null) {
			try {
				daoInmueble.insert(inmueble);
			
			} catch (Exception e) {
				throw new Exception("Error al insertar:" + e.getMessage());
				// TODO: handle exception
			}
			}else {				
				try {
					daoInmueble.update(inmueble);
				} catch (Exception e) {
					throw new Exception("Error al actualizar:" + e.getMessage());
					// TODO: handle exception
			}
		}
	}
	
	public boolean isCedulaValida(String serie ) {
		return serie.length()== 10;
	}
	
	public void guardarInmueble(String serie,String peso,
			String marca, String detalle, String descripcion) {}
	
}

