package curso_jdbc;

public class BeanFilmeCategoria {
	private String nomeCategoria;
	private String nomeFilme;
	
	public BeanFilmeCategoria() {
		// TODO Auto-generated constructor stub
	}
	
	public BeanFilmeCategoria(String nomeCategoria, String nomeFilme) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.nomeFilme = nomeFilme;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	@Override
	public String toString() {
		return "Nome da Categoria=" + nomeCategoria + ", Nome do Filme=" + nomeFilme + " ";
	}
	
	
	
}
