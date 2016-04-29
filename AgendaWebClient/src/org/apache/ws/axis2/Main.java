package org.apache.ws.axis2;

import java.rmi.RemoteException;

import principal.AgendaServiceStub;
import principal.AgendaServiceStub.AdicionarContato;
import principal.AgendaServiceStub.BuscarContato;
import principal.AgendaServiceStub.EditarContato;
import principal.AgendaServiceStub.ListarContatos;
import principal.AgendaServiceStub.RemoverContato;


public class Main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		AgendaServiceStub agendaStub = new AgendaServiceStub();
		Controlador cont = new Controlador();
		while(true){
			
			/*
			"1 - Inserir Contato"
			"2 - Excluir Contato"
			"3 - Editar Contato"
			"4 - Buscar Contato"
			"5 - Listar Contato"
			*/
			cont.Menu();
			int op = cont.getOpcao();
			
			//Inserir Contato
			if(op == 1){
				String contato = new String();
				contato = cont.receberDadosContato();
				AdicionarContato add = new AdicionarContato();
				add.setContato(contato);
				String result = agendaStub.adicionarContato(add).get_return();
				System.out.println(result);
			}
			
			//Excluir Contato
			else if(op == 2){
				String contato = new String(cont.receberDadosContato());
				RemoverContato rmv = new RemoverContato();
				rmv.setContato(contato);
				String result = agendaStub.removerContato(rmv).get_return();
				System.out.println(result);
			}
			
			//Editar Contato
			else if(op == 3){
				String cpf = new String();
				cpf = cont.receberCpf();
				String contato = new String();
				contato = cont.receberDadosContato();
				EditarContato edt = new EditarContato();
				edt.setC(contato);
				edt.setCpf(cpf);
				String result = agendaStub.editarContato(edt).get_return();
				System.out.println(result);
			}
			
			//Buscar Contato
			else if(op == 4){
				String cpf = new String();
				cpf = cont.receberCpf();
				BuscarContato bc = new BuscarContato();
				bc.setCpf(cpf);
				String result = agendaStub.buscarContato(bc).get_return();
				System.out.println(result);
			}
			
			//Listar Contatos
			else if(op == 5){
				ListarContatos list = new ListarContatos();
				String result = agendaStub.listarContatos(list).get_return();
				System.out.println(result);
			}
			op = 0;
		}
	}
}


