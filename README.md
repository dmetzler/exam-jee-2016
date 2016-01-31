# Examen JEE 01/02/2016

## Modalités de rendu : 1 point

Pour rendre votre travail, vous devrez :

 * Implémenter les différentes méthodes demandées
 * Modifier dans le fichier `pom.xml` le nom de l'artifactId sous la forme suivante :

 		<artifactId>exam-JEE-2016-NOM-PRENOM</artifactid>

 	Remplacer les espaces et tout caractère non alphanumérique dans le nom et prénom par un `-`. Par exemple : `Gérard D'Orimont de Haute Cloque` donnera :

	 	<artifactId>exam-JEE-2016-D-ORIMONT-DE-HAUTE-CLOQUE-GERARD</artifactid>

 * Zipper le répertoire de travail sans le répertoire `target` et renommer le fichier :

 		exam-JEE-2016-NOM-PRENOM.zip

 * Envoyer le fichier zip à `dmetzler@gmail.com` avec comme sujet `Exam JEE 2016 : Nom Prénom`


## Première partie : TDD sur 10 points

![Let's play Rugby](http://cdn.londonandpartners.com/asset/1f8caef09915bd47b9a2d911c74caf48.jpg)

Dans cette première partie, on développera une librairie permettant de compter les points d'une partie de rugby. Vous devrez implémenter les tests proposés pour ensuite implémenter la librairie elle même.


### Règles du compte de points du rugby

Il y a deux moyens de marquer des points au rugby :

 * L'essai : un joueur arrive à déposer le ballon derrière l'embut de l'équipe adverse. Cela lui rapporte alors 5 points. Il a de plus la possiblité de transformer cette essai en tentant de botter le ballon entre les poteaux et au-dessus de la barre horizontale du but adverse, depuis la perpendiculaire du point où a été aplati le ballon. La transformation vaut 2 points.
 * La pénalité et le drop : en bottant le ballon entre les poteaux et au dessus de la barre horizontale du but adverse. Un pénalité ou un drop valent 3 points.

 ### Tests

Vous disposez dans le projet Maven de trois classes:

 * `Game` : le contrat que doit suivre la partie, cette interface ne doit pas être modifiée. C'est dans cette interface que vous trouverez la documentation des méthodes que vous devrez implémenter.
 * `GameImpl` : l'implémentation de l'interface précédente que vous allez coder.
 * `GameTest` : la classe contenant des méthodes de test vides.

En prenant un test à la fois, implémenter le corps de celui-ci en fonction de la description contenue dans la javadoc des différentes fonctions de test.

Compléter ensuite GameImpl pour que le test passe, puis passer au test suivant.

### Remarque

Chaque type de marque doit faire l'objet d'une classe.


## Deuxième partie : Servlet sur 10 points

A l'aide d'une servlet, on exposera la librairie précédente pour pouvoir afficher le score d'un jeu ainsi qu'enregistrer les points des équipes.

Pour cet exercice, vous disposez de la classe `RugbyServletTest` : une classe de test déjà remplie qui doit vous aider à valider votre servlet.

Suivre les instructions présentes dans la Javadoc de chaque test. Le harnais de test test (`JettyHarness`) lance toutes les servlets correctement référencées dans un micro container pendant le test.

### Indices

On utilisera le mécanisme de la session web (HttpRequest#getSession()) dans lequel on pourra stocker l'état courant du jeu (setAttribute()et getAttribute()). Par exemple :

	Game game = (Game) req.getSession().getAttribute("game");




