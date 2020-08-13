import java.util.Scanner;

//  Declarando a classe
public class ExemploQuatro {

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
        
        //  Bloco de condicao CASO

        //  Caso o switch nao encontre o resultado esperado no primeiro case, ele pula pro próximo, e quando encontra, o break faz o switch parar
        switch (genero.toUpperCase()) { //  Pega a variavel genero e coloca em UPPERCASE
            case "M":   //  Caso for M, printa bem vindo
                System.out.println("Bem vindo");
                break;  //  Não executa nada abaixo
            
            case "F":   //  Caso for F, printa bem vinda
                System.out.println("Bem vinda");
                break;  //  Não executa nada abaixo
            
            default:    //  Caso não seja nenhum caso acima, printa bem vindx
            System.out.println("Bem vindx!");
                break;  //  Não executa nada abaixo
        }
        
        //  Fecha o Scanner
		sc.close();
	}
	
}
