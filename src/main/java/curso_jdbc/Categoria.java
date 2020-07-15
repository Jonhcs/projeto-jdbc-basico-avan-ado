package curso_jdbc;

public class Categoria {
	private Long cid;
	private String nomeCategoria;
	private Long filmeId;
	
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(String nomeCategoria, Long filmeId) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.filmeId = filmeId;
	}


	public Categoria(Long cid, String nomeCategoria, Long filmeId) {
		super();
		this.cid = cid;
		this.nomeCategoria = nomeCategoria;
		this.filmeId = filmeId;
	}


	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public Long getFilmeId() {
		return filmeId;
	}
	public void setFilmeId(Long filmeId) {
		this.filmeId = filmeId;
	}
	
	
	@Override
	public String toString() {
		return "Categoria [id=" + cid + ", nomeCategoria=" + nomeCategoria + ", filmeId=" + filmeId + "]";
	}
	
	
	
}
