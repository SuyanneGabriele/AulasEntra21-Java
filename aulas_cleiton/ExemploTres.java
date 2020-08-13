import java.util.Scanner;

//  Declarando a classe
public class ExemploTres {

	//	Pedir o gênero da pessoa M ou F
	//	Se for M, diga bem vindo e se for
	//	F mostre bem vinda
    
    //  Declarando o método principal, que se iniciará ao iniciar a classe
	public static void main(String[] args) {
        
        //  Scanner de dados de entrada (le oq o usuario escreve)
        Scanner sc = new Scanner(System.in);
        
        //  Imprime um texto na tela com quebra de linha - ln
        System.out.println("Qual e o seu genero? (F ou M)");
        //  Recebe o valor digitado pelo usuario / valor do teclado
		String genero = sc.next();
        
        //  Bloco de condicao
		if (genero.equalsIgnoreCase("M")) { //testa se o valor é igual a M, ignorando se é maiusculo ou minusculo
			System.out.println("Bem vindo!");
		} else if (genero.equalsIgnoreCase("F")) { //testa se o valor é igual a F, ignorando se é maiusculo ou minusculo
			System.out.println("Bem vinda!");
		} else {    //  Caso não seja nenhuma das alternativas acima, execute:
			System.out.println("Bem vindx!");
        }
        
        //  Fecha o Scanner
		sc.close();
	}
	
}
