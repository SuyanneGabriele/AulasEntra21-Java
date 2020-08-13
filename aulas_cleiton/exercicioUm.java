package e21.api.exercicios;
import java.util.Scanner;

public class exercicioUm {

	//	Pedir nome e idade e dizer se a pessoa e maior de idade
	
	public static void main(String[] args) {
		
		//	Scanner de dados de entrada
		Scanner sc = new Scanner(System.in);
		
		//	Printa o texto
		System.out.println("Digite o seu nome: ");
		//	Recebe o texto digitado pelo usuário
		String nome = sc.next();
		
		System.out.println("Digite sua idade: ");
		//	Recebe o valor numerico digitado pelo usuário
		int idade = sc.nextInt();
		
		//	Teste de condição
		// 	Se for verdadeira faça isso
		if (idade > 18) {
			System.out.println(nome + " é maior de idade.");
		//	Se for falso faça isso	
		} else {
			System.out.println(nome + " é menor de idade.");
		}
		//	Fechando o Scanner
		sc.close();
	}
}
