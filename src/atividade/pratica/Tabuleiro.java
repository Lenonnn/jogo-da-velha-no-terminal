package atividade.pratica;

public class Tabuleiro {// cria o tabuleiro
	private int[][] tabuleiro = new int[3][3];

	public Tabuleiro() {
		zerarTabuleiro();
	}

	public void zerarTabuleiro() { // faz todas as posi��es do tabuleiro iniciar com valor 0
		for (int linha = 0; linha < 3; linha++)
			for (int coluna = 0; coluna < 3; coluna++)
				tabuleiro[linha][coluna] = 0;
	}

	public void exibeTabuleiro() {// mostra em tela o tabuleiro
		System.out.println();
		for (int linha = 0; linha < 3; linha++) {

			for (int coluna = 0; coluna < 3; coluna++) {

				if (tabuleiro[linha][coluna] == -1) {// caso encontre o valor -1 imprime um X na posi��o
					System.out.print(" X ");
				}
				if (tabuleiro[linha][coluna] == 1) {// caso encontre o valor 1 imprime um O na posi��o
					System.out.print(" O ");
				}
				if (tabuleiro[linha][coluna] == 0) {// caso encontre o valor deixa o campo vazio
					System.out.print("   ");
				}

				if (coluna == 0 || coluna == 1)// imprime as divisorias do tabuleiro
					System.out.print("|");
			}
			System.out.println();
		}

	}

	public int getPosicao(int[] tentativa) {// retorna o valor encontrado em determinada posi��o
		return tabuleiro[tentativa[0]][tentativa[1]];
	}

	public void setPosicao(int[] tentativa, int jogador) {// altera o valor encontrado conforme o jogador
		if (jogador == 1)
			tabuleiro[tentativa[0]][tentativa[1]] = -1;
		else
			tabuleiro[tentativa[0]][tentativa[1]] = 1;

		exibeTabuleiro();
	}

	public int checaLinhas() {// verifica se a linhas est�o cheias
		for (int linha = 0; linha < 3; linha++) {

			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
				return -1;
			if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
				return 1;
		}

		return 0;

	}

	public int checaColunas() {// verifica se as colunas est�o cheias
		for (int coluna = 0; coluna < 3; coluna++) {

			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
				return -1;
			if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
				return 1;
		}

		return 0;

	}

	public int checaDiagonais() {// verifica se as diagonais est�o cheias
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
			return -1;
		if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
			return 1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
			return -1;
		if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
			return 1;

		return 0;
	}

	public boolean tabuleiroCompleto() {// verifica se h� alguma posi��o dispon�vel
		for (int linha = 0; linha < 3; linha++)
			for (int coluna = 0; coluna < 3; coluna++)
				if (tabuleiro[linha][coluna] == 0)
					return false;
		return true;
	}
}
