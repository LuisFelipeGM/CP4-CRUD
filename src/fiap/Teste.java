/* Daniel Henrique Alcantara Oliveira Martins  RM: 94615
* Luís Felipe Garcia Menezes  RM: 94051
* Pedro Victor Saraiva de Sá  RM: 93627
*/

package fiap;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.*;

public class Teste {

	public static void main(String[] args) {
		String escolha = "sim";
		int opcao;

		while (escolha.equalsIgnoreCase("sim")) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n(1) Inserir \n(2) Alterar \n(3) Excluir \n(4) Lista de Filmes"));
				switch (opcao) {
				case 1:
					inserirFilme();
					listaFilme();
					break;
				case 2:
					alterarFilme();
					listaFilme();
					break;
				case 3:
					excluirFilme();
					listaFilme();
					break;
				case 4:
					listaFilme();
					break;
				default:
					System.out.println("Escolha incorreta de classe!");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar? (sim ou não)");
		}	

	}
	
	private static void inserirFilme() {
		Connection con = Conexao.abrirConexao();
		
		Filme fil = new Filme();
		FilmeDAO fdao = new FilmeDAO(con);
		String titulo, codigo, genero, produtora;
		
		try {
			codigo = JOptionPane.showInputDialog("Codigo do filme: ");
			titulo = JOptionPane.showInputDialog("Titulo do filme: ");
			genero = JOptionPane.showInputDialog("Genero do filme: ");
			produtora = JOptionPane.showInputDialog("produtora do filme: ");
			fil.setCodigo(codigo);
			fil.setTitulo(titulo);
			fil.setGenero(genero);
			fil.setProdutora(produtora);
			
			System.out.println(fdao.inserir(fil));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Conexao.fecharConexao(con);
	}
	
	private static void alterarFilme() {
		Connection con = Conexao.abrirConexao();
		
		Filme fil = new Filme();
		FilmeDAO fdao = new FilmeDAO(con);
		String titulo, codigo, genero, produtora;
		
		try {
			codigo = JOptionPane.showInputDialog("Codigo do filme: ");
			titulo = JOptionPane.showInputDialog("Titulo do filme: ");
			genero = JOptionPane.showInputDialog("Genero do filme: ");
			produtora = JOptionPane.showInputDialog("produtora do filme: ");
			fil.setCodigo(codigo);
			fil.setTitulo(titulo);
			fil.setGenero(genero);
			fil.setProdutora(produtora);
			
			System.out.println(fdao.alterar(fil));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Conexao.fecharConexao(con);
	}
	
	private static void excluirFilme() {
		Connection con = Conexao.abrirConexao();
		
		Filme fil = new Filme();
		FilmeDAO fdao = new FilmeDAO(con);
		String codigo;
		
		try {
			codigo = JOptionPane.showInputDialog("Codigo do filme: ");
			fil.setCodigo(codigo);

			System.out.println(fdao.excluir(fil));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Conexao.fecharConexao(con);
	}
	
	private static void listaFilme() {
		Connection con = Conexao.abrirConexao();
		
		FilmeDAO fdao = new FilmeDAO(con);
		ArrayList<Filme> lista = fdao.listarTodos();
		String dados = "Lista dos Filmes:\n\n";
		if (lista != null) {
			for (Filme filme : lista) {
				dados += "Codigo: " + filme.getCodigo() + "\n";
				dados += "Titulo: " + filme.getTitulo() + "\n";
				dados += "Genero: " + filme.getGenero() + "\n"; 
				dados += "Produtora: " + filme.getProdutora() + "\n\n";
			}
			JOptionPane.showMessageDialog(null, dados);
		}
		
		Conexao.fecharConexao(con);
	}
}