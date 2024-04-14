package br.com.sher.cadastro.enuns;

public enum TipoEstadoCliente {
	INATIVO(0, "INATIVO"), ATIVO(1, "ATIVO");

	private int cod;
	private String descricao;

	private TipoEstadoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TipoEstadoCliente toEnum(Integer cod) {
		if(cod ==null) {
			return null;
		}
		for (TipoEstadoCliente x : TipoEstadoCliente.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido");
	}
	
}
