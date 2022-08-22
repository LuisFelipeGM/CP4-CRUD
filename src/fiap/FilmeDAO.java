/* Daniel Henrique Alcantara Oliveira Martins  RM: 94615
* Luís Felipe Garcia Menezes  RM: 94051
* Pedro Victor Saraiva de Sá  RM: 93627
*/

package fiap;

import java.sql.*;
import java.util.*;


public class FilmeDAO {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	public String inserir(Filme filme) {
		String sql = "insert into filme(codigo, titulo, genero, produtora) values (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Filme filme) {
		String sql = "update filme set titulo = ?, genero = ?, produtora = ? where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getGenero());
			ps.setString(3, filme.getProdutora());
			ps.setString(4, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
			
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Filme filme) {
		String sql = "delete from filme where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso!";
			} else {
				return "Erro ao excluir!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Filme> listarTodos(){
		String sql = "select * from filme";
		ArrayList<Filme> listaFilme = new ArrayList<Filme>();
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			if (rs != null) {
				while(rs.next()) {
					Filme fm = new Filme();
					fm.setCodigo(rs.getString(1));
					fm.setTitulo(rs.getString(2));
					fm.setGenero(rs.getString(3));
					fm.setProdutora(rs.getString(4));
					listaFilme.add(fm);
				}
				return listaFilme;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			return null;
		}
	}

}
