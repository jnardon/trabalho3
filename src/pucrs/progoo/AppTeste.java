package pucrs.progoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppTeste {
	
	private static Acervo acervo;
	private static Cadastro cadastro;
	private static Emprestimos listaEmp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		acervo = new Acervo();
		cadastro = new Cadastro();
		listaEmp = new Emprestimos();
		
//		System.out.println("Usuarios:"+Usuario.getTotalUsuarios());

		cadastro.cadastrar("1", "Fulano", "01929123132");
		cadastro.cadastrar("2", "Beltrano", "82816612122");
		cadastro.cadastrar("3", "Ciclano", "91277626212");
		cadastro.cadastrar("4", "Huguinho", "28156483929");
		cadastro.cadastrar("5", "Zezinho", "71626846671");
		cadastro.cadastrar("6", "Luizinho", "77691761727");
		cadastro.ordenaNome();
		
//		System.out.println("Usuarios:"+Usuario.getTotalUsuarios());

		acervo.cadastrarLivro(new Livro(1, "O Senhor dos Anéis", "J. R. R. Tolkien", "Martins Fontes", 2000, 5));
		acervo.cadastrarLivro(new Livro(2, "A Origem das Espécies", "Charles Darwin", "Hemus", 2000, 2));
		acervo.cadastrarLivro(new Livro(3, "A Arte da Guerra", "Sun Tzu", "Pensamento", 1995, 3));
		// Exemplo do construtor sobrecarregado (assume total = 1)
		acervo.cadastrarLivro(new Livro(4, "Memórias Póstumas de Brás Cubas", "Machado de Assis", "Ática", 1998));
		acervo.cadastrarLivro(new Livro(5, "O Senhor dos Anéis", "J. R. R. Tolkien", "Martins Fontes", 1958, 1));
		acervo.ordenaTitulo();
//		acervo.ordenaCodigo();

		System.out.println("Usuários:");
		cadastro.listarTodos();

		System.out.println();
		System.out.println("Acervo:");
		acervo.listarTodos();
		
		// Exemplo: criando um empréstimo
		LocalDate dataLim = LocalDate.of(2016, 3, 23);
		LocalDate dataLim2= LocalDate.now().plusDays(7);
		System.out.println(dataLim2);
		// Não esqueça de obter uma ref. para um Usuario e Livro
		Usuario usuario = cadastro.buscarCodigo("4");
		Livro livro = acervo.buscarPorCodigo(3);
		listaEmp.criar(usuario, livro, dataLim);
		
		
		System.out.println();
		listaEmp.listarTodos();
		
		System.out.println();
		Periodico per1 = new Periodico(10, "PUCRS Informação", "EDIPUCRS", 2015, 18, 4);
		System.out.println(per1);
		per1.emprestar();
		System.out.println(per1);
		
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(12);
		lista.add(7);
		lista.add(4);
		lista.add(8);
		lista.add(2);
		lista.add(9);
		Collections.sort(lista);
		System.out.println(lista);
		
		selectUser();
	}
	private static Usuario user;
	private static void selectUser(){
		Scanner in = new Scanner(System.in);
		System.out.println("Selecione o usuario pelo seu código: ");
		
		user = cadastro.buscarCodigo(in.next());
		if(user != null){
			Emprestimos emprestimosUser = new Emprestimos();
			emprestimosUser.setEmprestimos(listaEmp.buscarPorUsuario(user));
			
			System.out.println(emprestimosUser.listarEstados());
			
			if(listaEmp.buscarPorUsuario(user).size() > 0){
				System.out.println("Se voce deseja devolver algum livro, digite o seu codigo");	
				int codigoLivro = in.nextInt();
				Livro livroDevolucao = listaEmp.get(codigoLivro).getLivro();
				
				if(livroDevolucao != null){
					listaEmp.delete(listaEmp.get(codigoLivro));
					System.out.println(livroDevolucao.getTitulo() + " devolvido pelo usuario " + user.getNome());
				} else {
					System.out.println("Livro nao existe, ou nao esta com este usuario");
				}
			}
		} else {
			System.out.println("Usuario nao existe");
		}
		
		System.out.println("Lista de livros disponiveis: ");
		acervo.listarTodos();
		System.out.println("Digite o codigo do livro que vc deseja retirar, caso queira trocar de usuario, digite 0: ");
		int codigoLivro = in.nextInt();
		if(codigoLivro!=0){
			Livro livroParaEmprestimo = acervo.buscarPorCodigo(codigoLivro);
			if(livroParaEmprestimo != null) {
				LocalDate dataLim= LocalDate.now().plusDays(7);
				listaEmp.criar(user, livroParaEmprestimo, dataLim);
				System.out.println(livroParaEmprestimo.getTitulo() + " retirado pelo usuario " + user.getNome() + " com data limite para " + dataLim);
			} else {
				System.out.println("Livro nao existe");
			}
		} else {
			selectUser();
		}
	}

}
