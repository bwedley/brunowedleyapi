package br.edu.infnet.brunowedleyapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.brunowedleyapi.model.domain.Bebida;
import br.edu.infnet.brunowedleyapi.model.domain.Pedido;
import br.edu.infnet.brunowedleyapi.model.domain.Prato;
import br.edu.infnet.brunowedleyapi.model.domain.Sobremesa;

@SpringBootApplication
public class BrunowedleyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrunowedleyapiApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		Pedido pedido = new Pedido();
		
		int opcao;
		
		System.out.println("Iniciando cadastro...");
		
		do {
			System.out.println("==== MENU PRINCIPAL ====");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Mostrar produtos");
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
						pedido.adicionarProduto(Prato.cadastrar(in));
						System.out.println("Prato adicionado");
						break;
						
					case 2:
						pedido.adicionarProduto(Bebida.cadastrar(in));
						System.out.println("Bebida adicionada");
						break;
						
					case 3:
						pedido.adicionarProduto(Sobremesa.cadastrar(in));
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
				
			case 2:
				pedido.mostrarPedido();
				break;
			case 0:
				System.out.println("Finalizando aplicação...");
				break;
			}	
		} while (opcao != 0);
		in.close();
	}
}