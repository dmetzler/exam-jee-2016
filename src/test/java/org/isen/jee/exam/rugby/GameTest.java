package org.isen.jee.exam.rugby;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void doBefore() {
		game = new GameImpl("France", "New-Zealand");
	}

	@Test
	/**
	 * Dans cette méthode on instanciera le type Marque de type Try. On
	 * vérifiera le nombre de point que cela fournit suivant que l'essaie est
	 * transformé ou pas.
	 *
	 * @throws Exception
	 */
	public void un_essai_vaut_3_ou_5_suivant_si_il_est_transforme_ou_pas() throws Exception {

	}

	@Test
	/**
	 * Dans cette méthode on instanciera les types de Marque de type Drop et
	 * Penalty. On vérifiera le nombre de point que ces deux marques
	 * fournissent.
	 *
	 * @throws Exception
	 */

	public void un_drop_ou_une_penalite_valent_3_points() throws Exception {

	}

	@Test
	/**
	 * Dans ce test, on vérifiera que le score initial d'un jeu est de 0 à 0.
	 * Attenntion
	 *
	 * @throws Exception
	 */
	public void le_score_initial_est_de_0_a_0() throws Exception {
		/**
		 * Attention à bien respecter le formalisme donnée dans l'interface
		 * Game. C'est important pour la suite.
		 */

	}

	@Test
	/**
	 * Dans ce test, on vérifiera que lorsqu'une équipe marque, alors le score
	 * est augmenté en fonction de la marque qui a été faite (essai, drop,
	 * penalité).
	 *
	 * @throws Exception
	 */
	public void quand_une_equipe_marque_le_score_est_augmente() throws Exception {

	}

	@Test
	/**
	 * Dans ce test, on vérifiera, que le gagnant ne peut être connu que si la
	 * partie est arrêté.
	 *
	 * @throws Exception
	 */
	public void quand_la_partie_s_arrete_on_peu_connaitre_le_gagnant() throws Exception {

	}

}
