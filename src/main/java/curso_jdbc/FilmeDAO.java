package curso_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
	
	private Connection conn;
	
	public FilmeDAO() {
		conn = SingleConnection.getConnetion();
	}
	
	public List<Filme> listarTodos() throws SQLException {
		List<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "SELECT * FROM filme";
		PreparedStatement listar = conn.prepareStatement(sql);
		ResultSet res = listar.executeQuery();
		
		while(res.next()) {
			filmes.add(new Filme(res.getLong("id"), res.getString("nome")));
		}
		
		return filmes;
	}
	
	public void salvar(Filme filme) {
		try {
			String sql = "INSERT INTO filme (id, nome) VALUES(?,?)";
			PreparedStatement inserir = conn.prepareStatement(sql);
			inserir.setLong(1, filme.getId());
			inserir.setString(2, filme.getNome());
			inserir.executeUpdate();
			System.out.println("Salvou com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Filme procurarId(Long id) throws SQLException {
		String sql = "select * from filme where id = ?";
		PreparedStatement procurar = conn.prepareStatement(sql);
		procurar.setLong(1, id);
		
		ResultSet res = procurar.executeQuery();
		Filme filme = null;
		
		while(res.next()) {
			filme = new Filme( res.getLong("id"), res.getString("nome"));
		}
		return filme;
	}
	
	public void atualizar(Filme filmeAntigo, Filme filmeNovo) throws SQLException {
		String sql = "UPDATE filme SET nome = ? WHERE id = ?";
		PreparedStatement atualizar = conn.prepareStatement(sql);
		atualizar.setString(1, filmeNovo.getNome());
		atualizar.setLong(2, filmeNovo.getId());
		atualizar.executeUpdate();
		System.out.println("Atualizado com sucesso");
	}
	
	public void delete(Filme filme) throws SQLException {
		String sql = "DELETE FROM filme WHERE id = ?";
		PreparedStatement deletar = conn.prepareStatement(sql);
		deletar.setLong(1, filme.getId());
		deletar.executeUpdate();
	}
	
}
