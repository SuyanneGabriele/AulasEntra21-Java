import java.util.Scanner;

//  Declarando a classe
public class ExemploCinco {

    //	Escrever um meno de selecao
    //  Apos selecionar imprima o barulho
    //  que ele faz, auau, miau, piupiu
    
    //  Declarando o método principal, que se iniciará ao iniciar a classe
	public static void main(String[] args) {
        
        //  Scanner de dados de entrada (le oq o usuario escreve)
        Scanner sc = new Scanner(System.in);
        
        //  Imprime um texto na tela com quebra de linha - ln
        System.out.println("Selecione um animal:");
        System.out.println("1- Cachorro");
        System.out.println("2- Gato");
        System.out.println("3- Pássaro");
        System.out.println("4- Vaca");
        System.out.println("");
        //  Recebe o valor digitado pelo usuario / valor do teclado
		int bixinho = sc.nextInt();
        
        //  Bloco de condicao CASO

        //  Caso o switch nao encontre o resultado esperado no primeiro case, ele pula pro próximo, e quando encontra, o break faz o switch parar
        switch (bixinho) { //  
            case 1:   //  Caso o valor da variavel seja igual a opção 1, printa:
                System.out.println("auau");
                break;  //  Não executa nada abaixo
            
            case 2:   //  Caso for igual a 2, printa 
                System.out.println("meoww");
                break;  
            
            case 3:
                System.out.println("piupiu");   //  Caso for igual a 3, printa
                break;

            case 4:
                System.out.println("muuu"); //  Caso for igual a 4, printa
                break;
            
            default:    //  Caso não seja nenhum caso acima, printa
            System.out.println("Ainda não temos essa opção!");
                break;  
        }
        
        //  Fecha o Scanner
		sc.close();
	}
	
}
