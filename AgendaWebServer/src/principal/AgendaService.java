package principal;

import java.util.ArrayList;

import conexao.Banco;
import modelo.Agenda;
import modelo.Contato;

public class AgendaService {

	private Agenda agenda;
	private Banco banco;
	
	public AgendaService(){
		this.agenda = new Agenda();
		this.banco = new Banco();
	}
	
	public String adicionarContato(String contato) {
		Contato c = this.agenda.stringToContato(contato);
		if(this.banco.buscarContato(c.getCPF()) == null){
			this.banco.incluirContato(c.getNome(), c.getEmail(), c.getTelefone(), c.getCPF());		
			banco.desconectar();
			return "Contato adicionado com sucesso\n";
		}
		else{
			banco.desconectar();
			return "Contato ja existe na agenda\n";
		}
	}

	public String removerContato(String contato) {
		Contato c = this.agenda.stringToContato(contato);
		if(this.banco.buscarContato(c.getCPF()) != null){
			this.banco.excluirContato(c.getCPF());
			banco.desconectar();
			return "Contato removido com sucesso\n";
		}
		else{
			banco.desconectar();
			return "Contato nao encontrado\n";
		}
	}
	
	public String buscarContato(String cpf) {
		Contato c = this.banco.buscarContato(cpf);
		if(c != null){
			banco.desconectar();
			return this.agenda.contatoToString(c);
		}
		else{
			banco.desconectar();
			return "Contato nao encontrado\n";
		}
	}

	public String editarContato(String cpf, String c) {
		Contato cEdicao = this.banco.buscarContato(cpf);
		Contato c1 = new Contato();
		c1 = agenda.stringToContato(c);
		if(cEdicao != null){
			this.banco.editarContato(cpf, c1.getNome(), c1.getEmail(), c1.getTelefone(), c1.getCPF());
			banco.desconectar();
			return "Contato editado com sucesso\n";

		}
		else{
			banco.desconectar();
			return "Contato nao encontrado\n";
		}
		
	}

	public String listarContatos() {
		
		StringBuilder sb = new StringBuilder();
		String agend = new String("Nome \t | CPF \t | Email \t | Telefone \n\n");
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		contatos = banco.listarContatos();
		sb.append(agend);
		for(Contato c: contatos){
			sb.append(c.getNome());
			sb.append("\t | ");
			sb.append(c.getCPF());
			sb.append("\t | ");
			sb.append(c.getEmail());
			sb.append("\t | ");
			sb.append(c.getTelefone());
			sb.append("\n");
		}
		return sb.toString();
	}
}
