package modelo;

public class Agenda {
       
    public String contatoToString(Contato c){
    	String contato = new String();
    	contato = 	c.getNome() + "-" 
    			+ 	c.getEmail() + "-" 
    			+ 	c.getCPF() + "-"
    			+ 	c.getTelefone();
    	return contato;
    }
    
    public Contato stringToContato(String c){
    	Contato contato = new Contato();
    	String partes[] = new String[4];
    	partes = c.split("-");
    	contato.setNome(partes[0]);
    	contato.setEmail(partes[1]);
    	contato.setCPF(partes[2]);
    	contato.setTelefone(partes[3]);
    	return contato;
    }
}
