package pucrs.progoo;

public class Periodico implements Emprestavel {

	private int codigo;
	private String titulo;
	private String editora;
	private int ano;
	private int volume;
	private int numero;
	private boolean emprestado;

	public Periodico(int codigo, String titulo, String editora, int ano, int volume, int numero) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
		this.volume = volume;
		this.numero = numero;
		this.emprestado = false;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public int getAno() {
		return ano;
	}

	public int getVolume() {
		return volume;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public boolean isEmprestado() {
		return emprestado;
	}	

	@Override
	public String toString() {
		return String.format("%03d: %-40s %-20s %-5d %-3d %-2d - %s",
				codigo, titulo, editora, ano, numero, volume, emprestado);
	}

	@Override
	public boolean emprestar() {
		if(!emprestado) {
            emprestado = true;
            return true;
        }
        return false;
	}

	@Override
	public boolean devolver() {
		if(emprestado) {
            emprestado = false;
            return true;
        }
        return false;
	}
}
