package pucrs.progoo;

public class Usuario implements Comparable<Usuario> {

	private String codigo;
	private String nome;
	private String cpf;
	private static int totalUsuarios = 0;

	public Usuario(String codigo, String nome, String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		totalUsuarios++;
	}
	
	public static int getTotalUsuarios() {
		return totalUsuarios;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	@Override
	public String toString() {
		return String.format("%-5s: %-20s %-12s",
				codigo, nome, cpf);
	}

	@Override
	public int compareTo(Usuario o) {
		return nome.compareTo(o.nome);
	}
}
