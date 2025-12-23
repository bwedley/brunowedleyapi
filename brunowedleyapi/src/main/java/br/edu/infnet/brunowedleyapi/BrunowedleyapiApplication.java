package br.edu.infnet.brunowedleyapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.brunowedleyapi.interfaces.Impressao;
import br.edu.infnet.brunowedleyapi.model.domain.Bebida;
import br.edu.infnet.brunowedleyapi.model.domain.Cardapio;
import br.edu.infnet.brunowedleyapi.model.domain.Prato;
import br.edu.infnet.brunowedleyapi.model.domain.ProdutoCardapio;
import br.edu.infnet.brunowedleyapi.model.domain.Sobremesa;
import br.edu.infnet.brunowedleyapi.services.ImprimirArquivo;
import br.edu.infnet.brunowedleyapi.utils.ValidacoesUtil;

@SpringBootApplication
public class BrunowedleyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrunowedleyapiApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		Impressao impressao = new ImprimirArquivo();
		Cardapio cardapio = new Cardapio(impressao);
		
		
		int opcao;
		
		System.out.println("Iniciando cadastro...");
		
		do {
			System.out.println("==== MENU PRINCIPAL ====");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Mostrar produtos");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Buscar por categoria");
			System.out.println("5 - Remover produto");
			System.out.println("6 - Adicionar cadastro atual ao cardápio");
			System.out.println("7 - Sobrescrever cadastro atual no cardápio");
			System.out.println("8 - Ler relatório");
			System.out.println("0 - Sair");
			System.out.println("Escolha a opção: ");
			opcao = in.nextInt();
			in.nextLine();
			
			switch(opcao) {
			case 1: 
				int tipo;
				
				do {
					System.out.println("==== Escolha o tipo de produto: ====");
					System.out.println("1 - Cadastrar Prato");
					System.out.println("2 - Cadastrar Bebida");
					System.out.println("3 - Cadastrar Sobremesa");
					System.out.println("0 - Voltar");
					System.out.println("Escolha a opção: ");
					
					tipo = in.nextInt();
					in.nextLine();
					
					switch(tipo) {
					case 1:
						cardapio.adicionarProduto(Prato.cadastrar(in));
						System.out.println("Prato adicionado");
						break;
						
					case 2:
						cardapio.adicionarProduto(Bebida.cadastrar(in));
						System.out.println("Bebida adicionada");
						break;
						
					case 3:
						cardapio.adicionarProduto(Sobremesa.cadastrar(in));
						System.out.println("Sobremesa Adicionada");
						break;
						
					case 0:
						System.out.println("Voltando ao menu principal...");
						break;
					default:
						System.out.println("Opção inválida! Tente novamente.");
						break;
					}
				} while (tipo != 0);
				break;
				
			case 2:
				cardapio.listarCategorias();
				break;
			case 3:
				int id = ValidacoesUtil.validarIntPositivo(in, "Digite o id desejado: ");
				cardapio.listarProdutoPorId(id);
				break;
			case 4:
				cardapio.listarProdutosPorCategoria(in);
				break;
			case 5:
				cardapio.listarProdutos();
				int idR = ValidacoesUtil.validarIntPositivo(in, "Digite o id do produto que você deseja remover: ");
				ProdutoCardapio removido = cardapio.removerProdutoId(idR);
				if(removido != null) {
					System.out.println("Produto: **" +removido.getNome() +"** removido com sucesso!");
				} else {
					System.out.println("Produto de id " + idR + "não encontrado");
				}
				break;
			case 6:
				cardapio.imprimirCardapio();
				break;
			case 7:
				cardapio.sobrescreverImpressao();
				break;
			case 8:
				cardapio.lerCardapio();
				break;
			case 0:
				System.out.println("Finalizando aplicação...");
				break;
			}	
		} while (opcao != 0);
		in.close();
	}
}