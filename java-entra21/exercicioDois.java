package e21.api.exercicios;

import java.util.Scanner;

public class exercicioDois {

	//	Pedir o gênero da pessoa M ou F
	//	Se for M, diga bem vindo e se for
	//	F mostre bem vinda
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual é o seu gênero? (F ou M)");
		String genero = sc.next();
		
		if (genero.equals("M")) {
			System.out.println("Bem vindo!");
		} else if (genero.equals("F")) {
			System.out.println("Bem vinda");
		} else {
			System.out.println("Bem vindx!");
		}
		sc.close();
	}
	
}
