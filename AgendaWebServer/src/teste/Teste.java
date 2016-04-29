package teste;

import modelo.Agenda;
import modelo.Contato;
import principal.AgendaService;

public class Teste {

	private static AgendaService as;
	private static Agenda agenda;

	
	public static void main(String[] args) {
		as = new AgendaService();
		agenda = new Agenda();
		System.out.println(as.listarContatos());
		
		Contato c = new Contato();
		c.setNome("maria");
		c.setCPF("111");
		c.setEmail("maria@");
		c.setTelefone("99990002");
		
		System.out.println(as.editarContato("123",agenda.contatoToString(c)));
		
	}

}
