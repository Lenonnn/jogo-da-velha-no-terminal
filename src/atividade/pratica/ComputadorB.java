package atividade.pratica;

import java.util.Scanner;

public class ComputadorB extends Computador {
	public static Scanner entrada;

	public ComputadorB(int computador) {
		super(computador);
		System.out.println("Jogador 'Computador B' criado!");
	}

	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, computador);
	}

	// computador sempre inicia tentando marcar na linha 1, coluna 1 e depois joga aleatório
	// não sendo possível, joga aleatório desde o começo
	public void Tentativa(Tabuleiro tabuleiro) {

		int a = 1;
		int b = 1;

		do {

			do {
				tentativa[0] = a;
				if (tentativa[0] > 3 || tentativa[0] < 1)
					System.out.print("");
			} while (tentativa[0] > 3 || tentativa[0] < 1);

			do {

				tentativa[1] = b;
				if (tentativa[1] > 3 || tentativa[1] < 1)
					System.out.print("");
			} while (tentativa[1] > 3 || tentativa[1] < 1);
			tentativa[0]--;
			tentativa[1]--;

			if (!checaTentativa(tentativa, tabuleiro)) {
				System.out.print("");
				tentativa[0] = (int) (Math.random() * 3);
				tentativa[1] = (int) (Math.random() * 3);

			}

		} while (!checaTentativa(tentativa, tabuleiro));
	}
}