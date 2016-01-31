package org.isen.jee.exam.rugby;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.isen.jee.exam.rugby.harness.JettyHarness;
import org.junit.Test;

public class RugbyServletTest extends JettyHarness {

	/**
     * En implémentant la méthode `doGet()` faire en sorte que la servlet
     * affiche le score de jeu courant pour la requête suivante :
     *
     * GET http://localhost:9090/rugby
     *
     * @throws Exception
     */
    @Test
    public void une_partie_doit_etre_intialisee() throws Exception {
        assertEquals("Partie non initialisee", get(getServletUri()));
    }

    /**
     * En implémentant la méthode `doPost()` faire en sorte que la servlet
     * crée un jeu en spécifiant le nom des joueurs :
     *
     * POST http://localhost:9090/rugby?A=France&B=New-Zealand
     *
     * @throws Exception
     */
    @Test
    public void can_setup_a_game() throws Exception {

    	Map<String, String> params = new HashMap<>();
        params.put("A", "France");
        params.put("B", "New-Zealand");
        post(getServletUri(), params);

        assertEquals("France: 0 - New-Zealand: 0", get(getServletUri()));
    }

    /**
     * En implémentant la méthode `doPut()` faire en sorte que la servlet
     * incrémente le score du joueur paramétré pour la requête suivante :
     *
     * PUT http://localhost:9090/rugby?player=A&point=try&transformed=true
     *
     * @throws Exception
     */
    @Test
    public void canMarkTries() throws Exception {
        setupGame("France","New-Zealand");
        score("A","try", true);
        assertEquals("France: 7 - New-Zealand: 0", get(getServletUri()));
        score("B","try",false);
        assertEquals("France: 7 - New-Zealand: 5", get(getServletUri()));
        score("B","drop",false);
        assertEquals("France: 7 - New-Zealand: 8", get(getServletUri()));
        score("A","penalty",false);
        assertEquals("France: 10 - New-Zealand: 8", get(getServletUri()));
    }




    /**
     * En modifiant la méthode `doPut()` faire en sorte que la servlet
     * incrémente termine la partie pour la requête suivante :
     *
     * PUT http://localhost:9090/rugby?end=true
     *
     * @throws Exception
     */
    @Test
    public void gameCanEnd() throws Exception {
        setupGame("France","New-Zealand");
        score("A","try", true);
        assertEquals("France: 7 - New-Zealand: 0", get(getServletUri()));
        end();
        assertEquals("Winner is France", get(getServletUri()));
    }




	/**
     * En implémentant la méthode doDelete() faire en sorte que la servlet
     * réintialise le jeu pour la requête suivante :
     *
     * DELETE http://localhost:9090/rugby
     *
     * @throws Exception
     */
    @Test
    public void gameCanBeResetted() throws Exception {
    	setupGame("France","New-Zealand");
        score("A","try", true);
        assertEquals("France: 7 - New-Zealand: 0", get(getServletUri()));
        resetScore();
        assertEquals("Partie non initialisee", get(getServletUri()));
    }




    /**
     * Envoie la méthode DELETE sur le endpoint de la servlet.
     *
     * @return
     * @throws IOException
     */
    private String resetScore() throws IOException {
        return delete(getServletUri());

    }

	private String end() {
		Map<String, String> params = new HashMap<>();
        params.put("end", "true");
        return put(getServletUri(), params);

	}

    private String getServletUri() {
        return getBaseUri() + "/rugby";
    }

    private String score(String player, String point, boolean transformed) {
    	Map<String, String> params = new HashMap<>();
        params.put("player", player);
        params.put("point", point);
        params.put("transformed", transformed ? "true" : "false");
        return put(getServletUri(), params);

	}

	private String setupGame(String A, String B) {
    	Map<String, String> params = new HashMap<>();
        params.put("A", A);
        params.put("B", B);
        return post(getServletUri(), params);

	}

}
