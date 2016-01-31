package org.isen.jee.exam.rugby;

import java.util.Optional;

public interface Game {

	/**
	 * Cette méthode doit retourner le score du jeu au format
	 * JoueurA: pointsJoueurA - JoueurB: pointsJoueurB
	 * @return
	 */
	String getScore();


	/**
	 * Cette méthode doit incrémenter le score du jeu en fonction
	 * du point que le joueur A vient de marquer.
	 * @param p
	 */
	void scoreA(Mark p);

	/**
	 * Cette méthode doit incrémenter le score du jeu en fonction
	 * du point que le joueur B vient de marquer.
	 * @param p
	 */
	void scoreB(Mark p);


	/**
	 * Cette méthode renvoie le nom du gagnat si la partie est terminée.
	 * @return
	 */
	Optional<String> getWinner();

	/**
	 * Cette méthode termine la partie. On peut alors désigner un gagnant.
	 */
	void end();

}
