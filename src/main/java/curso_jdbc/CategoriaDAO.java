package curso_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
	private Connection conn;
	
	public CategoriaDAO() {
		conn = SingleConnection.getConnetion();
	}
	
	public void salvar(Categoria categoria) {
		try {
			String sql = "INSERT INTO categoria (nome_categoria, filme_id) VALUES(?,?)";
			PreparedStatement inserir = conn.prepareStatement(sql);
			inserir.setString(1, categoria.getNomeCategoria());
			inserir.setLong(2, categoria.getFilmeId());
			inserir.executeUpdate();
			System.out.println("Salvou com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Categoria> listarTodos() throws SQLException {
		List<Categoria> categoria = new ArrayList<Categoria>();
		
		String sql = "SELECT * FROM categoria";
		PreparedStatement listar = conn.prepareStatement(sql);
		ResultSet res = listar.executeQuery();
		
		while(res.next()) {
			categoria.add(new Categoria(res.getLong("cid"), res.getString("nome_categoria"), res.getLong("filme_id")));
		}
		
		return categoria;
	}
}
