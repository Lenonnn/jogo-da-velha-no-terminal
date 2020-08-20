package atividade.pratica;

public abstract class Jogador {

	protected int[] tentativa = new int[2];
	protected int jogador;

	public Jogador(int jogador) {
		this.jogador = jogador;
	}

	public abstract void jogar(Tabuleiro tabuleiro);// recebe o tabuleiro atual

	public abstract void Tentativa(Tabuleiro tabuleiro);// recebe as posições que podem ser marcadas

	public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro) {// verifica se a posiçao escolha está diponível
		if (tabuleiro.getPosicao(tentativa) == 0)
			return true;
		else
			return false;

	}

}
