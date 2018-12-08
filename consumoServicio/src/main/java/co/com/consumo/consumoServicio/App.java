package co.com.consumo.consumoServicio;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * probar servicios rest
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String REST_URI = "http://localhost:8081/obtenerPersona";
        
        Client client = ClientBuilder.newClient();
        
        Response response = client.target(REST_URI)
        .path(String.valueOf("1037600719"))
        .request(MediaType.APPLICATION_JSON)
        .get(Response.class);
        
        System.err.println(response.getStatus()+ " "+ response.getStatusInfo());
        
        Persona persona = client.target(REST_URI)
        .path(String.valueOf("1037600719"))
        .request(MediaType.APPLICATION_JSON)
        .get(Persona.class);
        
        System.err.println(persona.getNombre()+ " "+ persona.getId());
        
        
        final String REST_URI_INSERT = "http://localhost:8081/insertarUsuario";
        
        long id = 1037600711;
        persona.setId(id);
        persona.setNombre("johanna");
        Response insert = client
        .target(REST_URI_INSERT)
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(persona, MediaType.APPLICATION_JSON));
        
        System.err.println(insert.getStatus()+ " "+ insert.getStatusInfo());
        
    }
}
