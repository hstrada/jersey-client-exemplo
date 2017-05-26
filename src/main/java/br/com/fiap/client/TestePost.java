package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class TestePost {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		Aluno a = new Aluno(7.5,"Jos� Pequeno","28SCJ");
		
		WebTarget webTarget = client.target("http://localhost:8080/ExemploJersey").path("alunos");
		
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
		
		javax.ws.rs.core.Response response = invocationBuilder.post(Entity.entity(a, MediaType.APPLICATION_XML));
		
		Retorno r = response.readEntity(Retorno.class);
		
		System.out.println(r.getMensagem());
	}

}
