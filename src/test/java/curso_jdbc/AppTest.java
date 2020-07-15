package curso_jdbc;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void listar() throws SQLException {
    	BeanFilmeCategoriaDAO dao = new BeanFilmeCategoriaDAO();
    	
    	List<BeanFilmeCategoria> bfc = dao.procurarId(11L);
    	
    	for (BeanFilmeCategoria beanFilmeCategoria : bfc) {
			System.out.println(beanFilmeCategoria);
		}
    	
    }
}
