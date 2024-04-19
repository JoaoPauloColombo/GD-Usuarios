package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import utils.GerenciadorProduto;

public class HandleMenuProduto {

	Scanner sc = new Scanner(System.in);
	// Gerenciador
	GerenciadorProduto gs = new GerenciadorProduto();

	// Construtor vazio
	public HandleMenuProduto() {
		// toda vez que a classe menu, for instaciada, o nosso arquivo sera verificado
		gs.verificaECria("Produto.txt");
	}

	public void criarProduto() {
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		System.out.println("Digite o novo preço: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a nova quantidade: ");
		int quantidade = sc.nextInt();
		long id = getNextIdProduto();
		Produto u = new Produto(id,nome, preco,quantidade);
		gs.adicionarProduto(u);
	}

	public void editarProduto() {
		System.out.println("Digite o ID do Produto: ");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		System.out.println("Digite o novo preço: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a nova quantidade: ");
		int quantidade = sc.nextInt();
		gs.editarProduto(id,nome, preco,quantidade);
	}

	public void deletarProduto() {
		System.out.println("Digite o ID do Produto a ser deletado:");
		int id = sc.nextInt();
		gs.deletarProduto(id);
	}

	public void listarProduto() {
		gs.listarProdutos();
	}

	public void listarEspecificoProduto() {
		System.out.println("Digite o ID do Produto que deseja listar:");
		int id = sc.nextInt();
		gs.listarEspecificoProduto(id);
	}

	private long getNextIdProduto() {
		List<Produto> Produtos = gs.lerProdutos();
		// o maxId se inicia a partir do 0 (que foi determinado pela variavel)
		// o for vai percorrer os Produtos cadastrados, e somar mais 1, para que não aja
		// repetição de id
		long maxId = 0;
		// for => Foreach percorre objeto, um por um
		// unico Produto: lista com todos
		for (Produto Produto : Produtos) {
			long id = Produto.getId();
			if (id > maxId) {
				// logica para descobrir ultimo id
				maxId = id;
			}
		}
		return maxId + 1;
	}
}