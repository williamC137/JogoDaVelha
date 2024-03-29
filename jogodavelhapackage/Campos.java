package jogodavelhapackage; //pacote onde estão os arquivos

public class Campos { //2. Jogo da velha é dividido por 9 quadrados
	                  //2. os quadrados são chamados de campo
	private char simbolo; //3. Representaçao do simbolo que vai estar no campo
	                      //3. pode ser um X, O ou Vazio
	public Campos(){ 
		this.simbolo = ' '; //4. Inicialização do simbolo
	}
	public char getSimbolo() { //5. Obtenção do simbolo de determinado campo
		return this.simbolo;
	}
	public void setSimbolo(char simbolo) { //6. setSimbolo para podermos setar o simbolo
		if(this.simbolo == ' '){ //7.checar se o espaço está vazio
			this.simbolo = simbolo; //7.caso esteja vazio vai receber um valor
		}else{
			System.out.print("Campo ja usado"); //8. caso campo já esteja setado
			                                    //8. mostrar a mensagem campo ja usado
		}
	}
}
