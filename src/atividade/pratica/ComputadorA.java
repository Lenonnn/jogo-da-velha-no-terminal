package atividade.pratica;

import java.util.Scanner;

public class ComputadorA extends Computador {
	public static Scanner entrada;

	public ComputadorA(int computador) {
		super(computador);
		System.out.println("Jogador 'Computador A' criado!");
	}

	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, computador);
	}

	public void Tentativa(Tabuleiro tabuleiro) {// computador joga sempre de forma aleatória
		do {
			do {
				tentativa[0] = (int) (Math.random() * 4);

				if (tentativa[0] > 3 || tentativa[0] < 1)
					System.out.print("");
			} while (tentativa[0] > 3 || tentativa[0] < 1);

			do {
				tentativa[1] = (int) (Math.random() * 4);
				if (tentativa[1] > 3 || tentativa[1] < 1)
					System.out.print("");
			} while (tentativa[1] > 3 || tentativa[1] < 1);
			tentativa[0]--;
			tentativa[1]--;

			if (!checaTentativa(tentativa, tabuleiro))
				System.out.print("");
		} while (!checaTentativa(tentativa, tabuleiro));
	}
}