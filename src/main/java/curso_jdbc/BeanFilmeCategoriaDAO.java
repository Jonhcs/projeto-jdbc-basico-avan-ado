package curso_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanFilmeCategoriaDAO {
	
	private Connection conn;
	
	public BeanFilmeCategoriaDAO() {
		conn = SingleConnection.getConnetion();
	}
	
	public List<BeanFilmeCategoria> procurarId(Long id) throws SQLException {
		
		List<BeanFilmeCategoria> beanFilmeCategoria = new ArrayList<BeanFilmeCategoria>();
		String sql = " select nome_categoria, nome from categoria as c inner join filme as f ";
		sql += "on c.filme_id = f.id where f.id = " + id;
		
		PreparedStatement procurar = conn.prepareStatement(sql);
		ResultSet res = procurar.executeQuery();
		
		while(res.next()) {
			BeanFilmeCategoria filmeCategoria = new BeanFilmeCategoria();
			filmeCategoria.setNomeCategoria(res.getString("nome_categoria"));
			filmeCategoria.setNomeFilme(res.getString("nome"));
			beanFilmeCategoria.add(filmeCategoria);
		}
		
		return beanFilmeCategoria;
	}
}
