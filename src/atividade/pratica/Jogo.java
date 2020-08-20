package atividade.pratica;

import java.util.Scanner;

public class Jogo {
	private Tabuleiro tabuleiro;
	private int rodada = 1, vez = 1;
	private Jogador jogador1;
	private Computador jogador2;
	public Scanner entrada = new Scanner(System.in);

	public Jogo() {
		tabuleiro = new Tabuleiro();
		iniciarJogadores();

		while (Jogar())
			;
	}

	public void iniciarJogadores() {// inicializa os jogadores, sendo o 1 sempre humano

		this.jogador1 = new Humano(1);

		System.out.println("----------------------");
		System.out.println("Quem vai ser o Jogador 2 ?");

		switch (escolherJogador()) {// inicializa o jogador2, sempre uma opção de jogador computador
		case 1:
			jogador2 = new ComputadorA(2);
			break;
		case 2:
			jogador2 = new ComputadorB(2);
			break;
		case 3:
			jogador2 = new ComputadorC(2);
			break;
		default:
		}
	}

	public int escolherJogador() {
		int opcao = 0;

		do {
			System.out.println("1. ComputadorA\n");
			System.out.println("2. ComputadorB\n");
			System.out.println("3. ComputadorC\n");
			System.out.print("Opção: ");
			opcao = entrada.nextInt();

			if (opcao != 1 && opcao != 2 && opcao != 3)
				System.out.println("Opção inválida! Tente novamente");
		} while (opcao != 1 && opcao != 2 && opcao != 3);

		return opcao;
	}

	public boolean Jogar() {// faz o controle do jogo, rodando o laço sempre que encontra true
		if (ganhou() == 0) {
			System.out.println("----------------------");
			System.out.println("\nRodada " + rodada);
			System.out.println("É a vez do jogador " + vez());

			if (vez() == 1)
				jogador1.jogar(tabuleiro);
			else
				jogador2.jogar(tabuleiro);

			if (tabuleiro.tabuleiroCompleto()) {
				System.out.println("Tabuleiro Completo. Encerrado");
				return true;
			}
			vez++;
			rodada++;

			return true;
		} else {
			if (ganhou() == -1)
				System.out.println("Jogador 1 ganhou!");
			else
				System.out.println("Jogador 2 ganhou!");

			return false;
		}

	}

	public int vez() {// verifica a rodada
		if (vez % 2 == 1)
			return 1;
		else
			return 2;
	}

	public int ganhou() {// verifica quem venceu
		if (tabuleiro.checaLinhas() == 1)
			return 1;
		if (tabuleiro.checaColunas() == 1)
			return 1;
		if (tabuleiro.checaDiagonais() == 1)
			return 1;

		if (tabuleiro.checaLinhas() == -1)
			return -1;
		if (tabuleiro.checaColunas() == -1)
			return -1;
		if (tabuleiro.checaDiagonais() == -1)
			return -1;

		return 0;
	}

}
