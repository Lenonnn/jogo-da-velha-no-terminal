package atividade.pratica;

import java.util.Scanner;

public class ComputadorC extends Computador {
	public static Scanner entrada;

	public ComputadorC(int computador) {
		super(computador);
		System.out.println("Jogador 'Computador C' criado!");
	}

	public void jogar(Tabuleiro tabuleiro) {
		Tentativa(tabuleiro);
		tabuleiro.setPosicao(tentativa, computador);
	}

	// computador sempre inicia tentando marcar na linha 3, coluna 3 e depois joga aleatório
	// não sendo possível, joga aleatório desde o começo
	public void Tentativa(Tabuleiro tabuleiro) {

		int a = 3;
		int b = 3;
		
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
				tentativa[0] = (int) (Math.random() * a);
				tentativa[1] = (int) (Math.random() * b);
			}

		} while (!checaTentativa(tentativa, tabuleiro));

	}
}