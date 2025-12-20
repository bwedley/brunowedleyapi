package br.edu.infnet.brunowedleyapi.utils;

import java.util.Scanner;

public class ValidacoesUtil {
	
	public static String validarStringObrigatoria(Scanner in, String mensagem) {
		while (true) {
			System.out.println(mensagem);
			String texto = in.nextLine();
			
			if(texto != null && !texto.trim().isEmpty()) {
				return texto;
			}
			System.out.println("Erro: campo obrigatório");
		}
	}
	
	public static double validarDoublePositivo(Scanner in, String mensagem) {
		while(true) {
			try {
				System.out.println(mensagem);
				double valor = in.nextDouble();
				in.nextLine();
				
				if(valor < 0) {
					System.out.println("Erro: o valor não pode ser negativo.");
				} else {
					return valor;
				}
			} catch (Exception e) {
				System.out.println("Erro: digite um número válido.");
				in.nextLine();
			}
		}
	}
	
	public static int validarIntPositivo(Scanner in, String mensagem) {
		while(true) {
			try {
				System.out.println(mensagem);
				int valor = in.nextInt();
				in.nextLine();
				
				if(valor < 0) {
					System.out.println("Erro: o valor não pode ser negativo.");
				} else {
					return valor;
				}
			} catch (Exception e) {
				System.out.println("Erro: digite um número válido.");
				in.nextLine();
			}
		}
	}
	
	public static boolean validarBoolean(Scanner in, String mensagem) {
		while(true) {
			System.out.println(mensagem + "(s/n)");
			String input = in.nextLine();
			
			if(input.equalsIgnoreCase("s")) return true;
			if(input.equalsIgnoreCase("n")) return false;
			
			System.out.println("Erro: digite 's' ou 'n' ");
		}
	}
	
	public static int validarOpcao(Scanner in, String mensagem, int min, int max) {
		while(true) {
			try {
				System.out.println(mensagem);
				int opcao = in.nextInt();
				in.nextLine();
				
				if(opcao < min || opcao > max) {
					System.out.println("Erro: escolha um valor entre " + min + " e " + max + ":");
				} else {
					return opcao;
				}
			} catch (Exception e) {
				System.out.println("Erro: digite um número válido");
				in.nextLine();
			}
		}
	}
}
