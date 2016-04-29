package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Contato;

/* 
 * https://jdbc.postgresql.org/download.html
 * Código oriundo de:
 * http://www.codespot.com.br/2010/conexao-com-banco-de-dados-parte-1/
 * */

public class Banco {

	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost/AgendaWebServer";
	private String user = "cephas";
	private String passw = "cephas";
	private Connection conn;

	public Banco(){
		// método construtor quando chamado já irá se conectar ao banco de dados
		try {
			Class.forName(this.driver);
			this.conn = DriverManager.getConnection(url,user,passw);
		} catch (ClassNotFoundException e){
			System.out.println("Não foi possivel encontrar " 
					+ "o driver de banco: " + e.getMessage());
		} catch(SQLException e){
			System.out.println("Erro ao conectar com o banco: " + e.getMessage());
		}
	}
	
    // inclui um contato no banco de dados
	public void incluirContato(String nome, String email, String telefone, String cpf){
		Statement stmt = null;
		// query que será executada
		String sql = "INSERT INTO Contato (nome,email,telefone,cpf) VALUES ('"+ nome + "','" + email + "','" + telefone + "','" + cpf + "')";

		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("usuário incluido com sucesso!");
		} catch(SQLException e){
			System.out.println("erro incluir usuario: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
	}
	
	// apaga um contato do banco de dados
	public void excluirContato(String cpf){		
		Statement stmt = null;
		// query que será executada
		String sql = "DELETE FROM Contato "
				+ "WHERE cpf = '" + cpf + "'" ;
		try {
			stmt = this.conn.createStatement();
			int estado = stmt.executeUpdate(sql);
		} catch(SQLException e){
			System.out.println("erro excluir usuario: " + e.getMessage());
		} finally {
			try {
				// fecha o stmt
				if(stmt != null) stmt.close();
			} catch (SQLException e){
				System.out.println("erro ao tentar fechar o stmt: " + e.getMessage());
			}
		}
	}
	
	// edita um contato do banco de dados
	public void editarContato(String cpf1, String nome, String email, String tel, String cpf){		
		excluirContato(cpf1);
		incluirContato(nome, email, tel, cpf);
	}

	// busca um contato por cpf
	public Contato buscarContato(String cpf){
        Statement stmt = null;
        ResultSet rs = null;
        // query que será executada
        String sql = "SELECT id, nome, email, telefone, cpf FROM Contato c"
        		+ " WHERE c.cpf = '" + cpf + "'";

        try {	
            // executa a query e guarda o resultado no RecordSet rs
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs  = stmt.executeQuery(sql);
           if(rs.first()){
            Contato contato = new Contato();
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setCPF(rs.getString("cpf"));
            contato.setTelefone(rs.getString("Telefone"));
            return contato;
           }

        } catch(SQLException e){
            System.out.println("erro buscando contato: " + e.getMessage());
        } finally {
            try {
                // fecha o stmt e o rs
                if(stmt != null) stmt.close();
                if(rs != null) rs.close();
            } catch (SQLException e){
                System.out.println("erro ao tentar fechar o stmt e o rs: " + e.getMessage());
            }
        }
		return null;
	}
	
	// lista os contatos cadastrados
	public ArrayList<Contato> listarContatos(){
        Statement stmt = null;
        ResultSet rs = null;
        // query que será executada
        String sql = "SELECT id, nome, email, telefone, cpf FROM Contato";

        try {
            // executa a query e guarda o resultado no RecordSet rs
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs  = stmt.executeQuery(sql);
            ArrayList<Contato> contatos  = new ArrayList<Contato>();
            // enquanto houver dados no RS, retira os campos desejados (cod_usuario, nome e email) e mostra na tela
            while(rs.next()){
                // cod_usuario, nome e email são os nomes dos campos da tabela usuario
               /* System.out.println(rs.getString("id") 
                		+ " - " + rs.getString("nome") 
                		+  " - " + rs.getString("email")
                		+  " - " + rs.getString("telefone") 
                		+  " - " + rs.getString("cpf"));*/
                Contato contato = new Contato();
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setCPF(rs.getString("cpf"));
                contato.setTelefone(rs.getString("Telefone"));
                contatos.add(contato);
            }
            if(contatos.size() > 0){          	
            	return contatos;
            }

        } catch(SQLException e){
            System.out.println("erro listando usuarios: " + e.getMessage());
        } finally {
            try {
                // fecha o stmt e o rs
                if(stmt != null) stmt.close();
                if(rs != null) rs.close();
            } catch (SQLException e){
                System.out.println("erro ao tentar fechar o stmt e o rs: " + e.getMessage());
            }
        }
		return null;
	}
		
	// desconecta do banco de dados
	public void desconectar(){
		try {
			if(this.conn != null) this.conn.close();
		} catch(SQLException e){
			System.out.println("Erro tentanto fechar a conexão com o banco: " + e.getMessage());
		}
	}
}
