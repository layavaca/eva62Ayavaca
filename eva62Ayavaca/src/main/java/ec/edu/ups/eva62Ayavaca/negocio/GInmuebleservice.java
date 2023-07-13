package ec.edu.ups.eva62Ayavaca.negocio;

import java.util.List;

import ec.edu.ups.eva62Ayavaca.modelo.*;
import ec.edu.ups.eva62Ayavaca.servicios.*;
import ec.edu.ups.eva62Ayavaca.servicios.Error;
import ec.edu.ups.eva62Ayavaca.datos.*;
import ec.edu.ups.eva62Ayavaca.negocio.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class GInmuebleservice {
	@Inject
	private InmuebleDao daoInmueble;
	@Inject
	private GestionInmueble gestionInmueble;
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Inmueble misdatos(){
		Inmueble p = new Inmueble();
		p.setSerie("9876543210");
		p.setDetalle("vidrio");
		p.setMarca("rialto");
		p.setDescripcion("Estante");
		p.setPeso("25kg");
		return p;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarInmueble(Inmueble inmueble) {
		try {
			gestionInmueble.guardarInmueble(inmueble);
			return Response.status(Response.Status.OK).entity(inmueble).build();
		} catch (Exception e) {
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("error al guardar:"+ e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inmueble> getListadoPersona(){
		return daoInmueble.getAll();
	
	}
	

}
