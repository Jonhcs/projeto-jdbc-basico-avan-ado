package curso_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {

		FilmeDAO dao = new FilmeDAO();
		Scanner in = new Scanner(System.in);
		System.out.println("================Menu================");
		System.out.println("1 - Listar os Filmes");
		System.out.println("2 - Criar novo filme");
		System.out.println("3 - Atualizar Filme");
		System.out.println("4 - Deletar filme");
		System.out.println("================Menu================");
		int opcao = in.nextInt();
		in.nextLine();

		switch (opcao) {
		case 1:
			ArrayList<Filme> filmes = (ArrayList<Filme>) dao.listarTodos();
			
			for (Filme filme : filmes) {
				System.out.println("Id" + filme.getId());
				System.out.println("Id" + filme.getNome());
			}
			break;
		case 2:
			Filme filme = new Filme();
			System.out.println("Qual o id do filme? ");
			Long id = in.nextLong();
			in.nextLine();
			System.out.println("Qual o nome do filme? ");
			String nome = in.nextLine();
			filme.setId(id);
			filme.setNome(nome);
			dao.salvar(filme);
			
			break;
		case 3:
			System.out.println("Qual o id do filme para atualizar? ");
			Long atualizarId = in.nextLong();
			in.nextLine();
			
			Filme filmeExiste = dao.procurarId(atualizarId);
			
			if (filmeExiste != null) {
				System.out.println("Qual novo nome do filme para atualizar? ");
				String nomeNovo = in.nextLine();
				Filme novoFilme = new Filme(filmeExiste.getId(),nomeNovo);
				dao.atualizar(filmeExiste, novoFilme);
				
				System.out.println("Atualizado");
			}else {
				System.out.println("Esse filme não existe no banco, favor digitar outro ID");
			}
			
			break;
		case 4:
			System.out.println("Qual o id do filme para deletar? ");
			Long deletarId = in.nextLong();
			in.nextLine();
			
			Filme filmeDeletar = dao.procurarId(deletarId);
			
			if (filmeDeletar != null) {
				dao.delete(filmeDeletar);
				System.out.println("Filme deletado");
			}else {
				System.out.println("Filme deletado");
			}
			break;

		default:
			System.out.println("Opação inválida");
			break;
		}
	}
}
