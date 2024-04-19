package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class GerenciadorProduto {

	// Private => Variavel privada
	// Static => Pode ser acessada por outras variaveis
	// Final => Não pode ser alterada
	private static final String NOME_ARQUIVO = "Produtos.txt";

	// Verificar a Existencia do nosso banco e criar caso nao exista
	public void verificaECria(String nomeArquivo) {
//		 file => arquivo
		File arquivo = new File(nomeArquivo);
//		 verificar se o arquivo existe
		if (arquivo.exists()) {
		} else {
//			 tente criar, caso de erro, exibe o erro
			try {
//				 Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao criar o arquivo" + e.getMessage());
			}
		}
	}

	public void adicionarProduto(Produto Produto) {
//		 Writer => Escrever
//		 BufferWriter, FileWriter
//		 BufferedWriter, proporciona uma eficiente escrita
//		 FileWriter, escreve dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(Produto.toString()); // 1;giovanna;12345
			bw.newLine();// nova linha no arquivo txt
			System.out.println("Produto adicionado com sucesso!");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public List<Produto> lerProdutos() {
		List<Produto> Produtos = new ArrayList<Produto>();
//		 Buffed, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => 1;nome;senha
//			 percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // dividir em tres partes
				Produtos.add(new Produto(Long.parseLong(partes[0]),(partes[1]) ,Double.parseDouble(partes[2]),Integer.parseInt (partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return Produtos;
	}

	public void deletarProduto(int id) {
		List<Produto> Produtos = lerProdutos();
		if (Produtos.removeIf(Produto -> Produto.getId() == id)) {
//			 reescrevendo arquivo com novos Produtos e alteracoes
			reescreverArquivo(Produtos);
			System.out.println("Produto deletado com sucesso");
		} else {
			System.out.println("Produto nao encontrado");
		}
	}

	public void reescreverArquivo(List<Produto> Produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Produto Produto : Produtos) {
				bw.write(Produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarProdutos() {
		List<Produto> Produtos = lerProdutos();
//		 nenhum Produto para listar
//		 isEmpty => esta vazio
//		 caso não esteja ira fazer o percurso para listar todos os Produtos
		if (Produtos.isEmpty()) {
			System.out.println("Nenhum Produto cadastrado");
		} else {
			System.out.println("Lista de Produtos");
			for (Produto Produto : Produtos) {
				System.out.println("ID: " + Produto.getId() + ", Nome: " + "" + Produto.getNome() + ", Preço: "
						+ Produto.getPreco() + ", Quantidade: " + "" + Produto.getQuantidade());
			}
		}
	}

	public void editarProduto(int id, String novoNome, double novaPreco, int novoQuantidade) {
		List<Produto> Produtos = lerProdutos();
		boolean encontrado = false;
		for (Produto Produto : Produtos) {
			if (Produto.getId() == id) {
				Produto.setNome(novoNome);
				Produto.setPreco(novaPreco);
				Produto.setQuantidade(novoQuantidade);

				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(Produtos);
			System.out.println("Produto editado com sucesso!");
		} else {
			System.out.println("Produto nao encontrado");
		}
	}

	public void listarEspecificoProduto(int id) {
		List<Produto> Produtos = lerProdutos();

		for (Produto Produto : Produtos) {

			if (Produto.getId() == id) {
				System.out.println("ID: " + Produto.getId() + ", Nome: " + "" + Produto.getNome() + ", Preço: "
						+ Produto.getPreco() + ", Quantidade: " + "" + Produto.getQuantidade());
			}
		}
	}

}