#  ApoTakeCare

## Présentation 
ApoTakeCare est une application Web se présentant comme une bibliothèque d'apothicaire permettant de stocker des données représentant divers plantes médicinales munies chacune d'une description, de son numéro d'étagère, sa quantité ainsi que son prix. Il est également possible de consulter les stocks de chaque produit, connaître les catégories et effets associés à ces produits ainsi que de gérer des lieux et les produits associés à ces derniers.  
Grâce à une interface simple, l'utilisateur peut ajouter, modifier ou supprimer des produits de même que les informations relatif aux stocks et aux lieux . L'application utilise un backend **Spring Boot** et un frontend léger avec **Thymeleaf** pour le rendu dynamique.

## Pré-requis et lancement de l'application
Le lancement de l'application se fait via Springboot. Il est nécessaire d'utiliser la version 20 de java JDK : https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html  
A partir d'un IDE tel qu'Eclipse, lancer le fichier "ProjectJeeApplication.java" qui se situe dans src/main/java/com/projectJEE/

## Auto-évaluation de notre projet à l'aide de la grille d'évaluation
Fonctionnalités : 
L’application contient cinq entités principales : Product, Stock, Place, EffectAndPreparation, Category pour lesquelles nous avons implémenté des fonctionnalités CRUD
On utilise bel et bien Spring Boot comme framework principal, ainsi que Spring Data JPA et Spring MVC pour gérer les BDD et les contrôleurs. De plus, la gestion des vues se fait via Thymeleaf.
Il y a des relations de tout type : 
-	One-to-One avec Product <-> Stock
-	One-to-Many avec Category <-> EffectAndPreparation et Product <-> EffectAndPreparation
-	Many-to-Many avec Product <-> Place
On peut graphiquement ajouter ou retirer des produits à des lieux et il y a une gestion dynamique de la relation Many-to-Many
Il y a une logique de métier "utile" permettant de gérer dynamiquement le stock des objets et d'afficher un message d'attention lorsqu'il manque de stock d'un objet (moins de 5)

5/5 Toutes les fonctionnalités sont présentes et fonctionnelles 

Technique : 
Nous suivons bel et bien le modèle MVC avec des entités Model, des Views et des Controllers
Nous utilisons des méthodes http telles que GET pour affiché les entités et leurs détails, POST pour en créer de nouvelles et associer des relations ainsi que DELETE pour supprimer des produits ou les dissocier de leur place. La méthode PUT en revanche n’est pas utilisée.
Toutes les pages HTML manipulent les données transmises par leur contrôleur

4/5 Il manque une méthode PUT, mais le modèle est gloabelement correctement utilisé

Qualité : 
Nous utilisons le framework Pico-CSS pour avoir un style épuré, ainsi que des fichiers css personnels. Cela donne un style simple à notre projet mais qui reste agréable à regarder. C'est un style minimal et fonctionnel.

Qualité du Git :
Le code source est bel et bien sur un GitHub. En revanche, il est loin d’être ordonné. Certains commits ont des noms qui ne sont absolument pas significatifs, ou des noms peu sérieux. De plus, même si tout le membres ont travaillé équitablement sur le projet, tout le monde n’a pas travaillé dessus régulièrement. Ceci couplé à des problèmes techniques (problème d’IDE ou d’ordinateur) pour certains rend les commit extrêmement irréguliers.

Qualité du code : 
Le code est organisé comme il se doit avec une séparation claire des dossiers et des méthodes dans les fichiers. Les framework sont correctement utilisés et il n’est pas difficile de s’y retrouver. En revanche, il manque cruellement de commentaires qui rendraient la relecture de certaines méthodes plus facile.

2.5/5 Le site est de bonne qualité mais le programme et le git sont brouillons.

Le projet s'est bien déroulé, les points noirs étant principalement au niveau de la partie "Qualité".

### Fonctionnalités : 
L’application contient cinq entités principales : Product, Stock, Place, EffectAndPreparation, Category pour lesquelles nous avons implémenté des fonctionnalités CRUD
On utilise bel et bien Spring Boot comme framework principal, ainsi que Spring Data JPA et Spring MVC pour gérer les BDD et les contrôleurs. De plus, la gestion des vues se fait via Thymeleaf.
Il y a des relations de tout type : 
-	One-to-One avec Product <-> Stock
-	One-to-Many avec Category <-> EffectAndPreparation et Product <-> EffectAndPreparation
-	Many-to-Many avec Product <-> Place
On peut graphiquement ajouter ou retirer des produits à des lieux et il y a une gestion dynamique de la relation Many-to-Many
Pas de logique métier utile pour l’instant (j’essaie de faire une gestion automatique des stocks)


### Technique : 
Nous suivons bel et bien le modèle MVC avec des entités Model, des Views et des Controllers
Nous utilisons des méthodes http telles que GET pour affiché les entités et leurs détails, POST pour en créer de nouvelles et associer des relations ainsi que DELETE pour supprimer des produits ou les dissocier de leur place. La méthode PUT en revanche n’est pas utilisée.
Toutes les pages HTML manipulent les données transmises par leur contrôleur


### Qualité : 
Nous utilisons le framework Pico-CSS pour avoir un style épuré, ainsi que des fichiers css personnels. Cela donne un style simple à notre projet mais qui reste agréable à regarder. C'est un style minimal et fonctionnel.

### Qualité du Git :
Le code source est bel et bien sur un GitHub. En revanche, il est loin d’être ordonné. Certains commits ont des noms qui ne sont absolument pas significatifs, ou des noms peu sérieux. De plus, même si tout le membres ont travaillé équitablement sur le projet, tout le monde n’a pas travaillé dessus régulièrement. Ceci couplé à des problèmes techniques (problème d’IDE ou d’ordinateur) pour certains rend les commit extrêmement irréguliers.

### Qualité du code : 
Le code est organisé comme il se doit avec une séparation claire des dossiers et des méthodes dans les fichiers. Les framework sont correctement utilisés et il n’est pas difficile de s’y retrouver. En revanche, il manque cruellement de commentaires qui rendraient la relecture de certaines méthodes plus facile.

## Version 
**Version stable : 1.0 Lien GitHub du projet :** https://github.com/Sou-race/JEEprojet

## Auteurs
* CASSARD Pierre-Antoine : https://github.com/Sou-race 
* FINANA Tom : https://github.com/Erra570 
* LAKOMICKI Laura : https://github.com/Voidhi 
* TUEUX Rubens : https://github.com/RubensGHub
