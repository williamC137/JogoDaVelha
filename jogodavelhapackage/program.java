package jogodavelhapackage; //pacote onde estão os arquivos

import java.util.Scanner; //1.java.util.Scanner inserido no inicio do codigo 
                        //1.para fazer a leitura da jogada de acordo com o teclado
public class program
{
	public static void main(String[] args){ 
		Campos[][] velha = new Campos[3][3]; //9. Estabelecendo uma matriz de 3 linhas e 3 colunas
		char simboloAtual = 'X'; //10.Indicar simbolo no qual vai ser jogado
		Boolean game = true; //11.Indicar que o jogo está rodando
		Scanner scan = new Scanner(System.in); //12.Criação do leitor, mostrando a posiçao do simbolo 
		                                    //12. que vai ser marcado
		iniciarJogo(velha); //15. Iniciar jogo enquanto game = true
		while(game) { //16. Enquanto game for true executar os seguintes comandos
			desenhaJogo(velha); //17. Chamar função desenhaJogo()
			try{ //18. Tentar fazer a seguinte verificação
				if(verificarJogada(velha,jogar(scan, simboloAtual), simboloAtual)) { // 19. Chamada da função verificarJogada() e passagens de parâmetros
					if(simboloAtual == 'X') { //20. Caso X tenha jogado, o próximo será O
						simboloAtual = 'O'; // 21. Símbolo atual recebe O
					}else {
						simboloAtual = 'X'; // 22. Caso O tenha jogado, o próximo será X
					}
				}
			}catch(Exception e){ // 23. Caso o "try" dê erro, imprime a palavra "erro" no terminal e reinicia o while.
				System.out.printf("Erro");
			}
		}
	}
	
	public static void desenhaJogo(Campos[][] velha) { //13.criada a função para desenhar o jogo
		                                            //13. e a cada jogada ele vai redesenhar o jogo
		 //14.Iniciação das impressoes do jogo
		 //14. e estabelencendo todas as opções de jogada
		 System.out.println("     0    1    2");
		 System.out.printf ("0   %c  |  %c  | %c %n", velha[0][0].getSimbolo(),velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
		 System.out.println("    --------------");
		 System.out.printf ("1   %c  |  %c  | %c %n", velha[1][0].getSimbolo(),velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
		 System.out.println("    --------------");
		 System.out.printf ("2   %c  |  %c  | %c %n", velha[2][0].getSimbolo(),velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
	} 

	public static int[] jogar(Scanner scan, char sa){ //25. Criada a função jogar, que receberá dois parâmetros, a entrada do Scanner e um char que atribuirá simbuloAtual
		int p[] = new int[2]; // 25. Criando o vetor p que terá duas posições. Referente a linha e coluna.
		System.out.printf("%s %c %n","Quem joga:", sa); // 25. Informando qual símbolo será usado na próxima jogada
		System.out.print("Informe a linha:");
		p[0]=scan.nextInt(); //25. Recebendo a linha da posição em que ocorrerá a jogada
		System.out.print("Informe a coluna:");
		p[1]=scan.nextInt(); //25. Recebendo a coluna da posição em que ocorrerá a jogada
		return p; //25. A função retorna o valor de p
	}
	
	public static Boolean verificarJogada(Campos[][] velha, int p[], char simboloAtual) { //26. Criada a função verificarJogada, definindo como parâmetros a matriz velha,
		//o vetor p, e o char simboloAtual
		if(velha[p[0]][p[1]].getSimbolo() == ' ') { //26. se a posição informada estiver vazia, setar o valor do campo como sendo o de simboloAtual
			velha[p[0]][p[1]].setSimbolo(simboloAtual);
			return true; //26. retorna true
		}else {
			return false; //Caso a posição já esteja ocupada, a função não executa nenhuma ação e retorna false
		}
	}
	
	public static void iniciarJogo(Campos[][] velha) { // 24. Criando a função iniciarJogo, definindo como parâmetro a matriz velha
		for(int l = 0; l<3; l++){ // 24. percorrendo as linhas
			for(int c =0; c<3; c++){ // 24. percorrendo as colunas
				velha[l][c] = new Campos(); //24. Definindo cada espaço como um objeto da classe Campos()
			}
				
		}
	}
}