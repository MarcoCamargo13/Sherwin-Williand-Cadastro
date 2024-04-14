package br.com.sher.cadastro.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import br.com.sher.cadastro.enuns.TipoEstadoCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = -4486741433631755249L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpjCpf;
	private Integer status;
	
	private Set<String> telefone = new HashSet<>();

	public Cliente() {

	}

	public Cliente(Long id, String razaoSocial, String nomeFantasia, String cnpjCpf, TipoEstadoCliente status, String telefone) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpjCpf = cnpjCpf;
		this.status = status.getCod();
	}

	public Set<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(TipoEstadoCliente status) {
		this.status = status.getCod();
	}

	public TipoEstadoCliente getStatus() {
		return TipoEstadoCliente.toEnum(status);
	}

	public Long getId() {
		return id;
	}

	public void setCodigo(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
