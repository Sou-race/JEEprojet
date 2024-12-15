Auto-évaluation de notre projet :


Fonctionnalités : 
L’application contient cinq entités principales : Product, Stock, Place, EffectAndPreparation, Category pour lesquelles nous avons implémenté des fonctionnalités CRUD
On utilise bel et bien Spring Boot comme framework principal, ainsi que Spring Data JPA et Spring MVC pour gérer les BDD et les contrôleurs. De plus, la gestion des vues se fait via Thymeleaf.
Il y a des relations de tout type : 
-	One-to-One avec Product <-> Stock
-	One-to-Many avec Category <-> EffectAndPreparation et Product <-> EffectAndPreparation
-	Many-to-Many avec Product <-> Place
On peut graphiquement ajouter ou retirer des produits à des lieux et il y a une gestion dynamique de la relation Many-to-Many
Pas de logique métier utile pour l’instant (j’essaie de faire une gestion automatique des stocks)


Technique : 
Nous suivons bel et bien le modèle MVC avec des entités Model, des Views et des Controllers
Nous utilisons des méthodes http telles que GET pour affiché les entités et leurs détails, POST pour en créer de nouvelles et associer des relations ainsi que DELETE pour supprimer des produits ou les dissocier de leur place. La méthode PUT en revanche n’est pas utilisée.
Toutes les pages HTML manipulent les données transmises par leur contrôleur


Qualité : 
Nous utilisons le framework Pico-CSS pour avoir un style épuré, ainsi que des fichiers css personnels. Cela donne un style simple à notre projet mais qui reste agréable à regarder. C'est un style minimal et fonctionnel.

Qualité du Git :
Le code source est bel et bien sur un GitHub. En revanche, il est loin d’être ordonné. Certains commits ont des noms qui ne sont absolument pas significatifs, ou des noms peu sérieux. De plus, même si tout le membres ont travaillé équitablement sur le projet, tout le monde n’a pas travaillé dessus régulièrement. Ceci couplé à des problèmes techniques (problème d’IDE ou d’ordinateur) pour certains rend les commit extrêmement irréguliers.

Qualité du code : 
Le code est organisé comme il se doit avec une séparation claire des dossiers et des méthodes dans les fichiers. Les framework sont correctement utilisés et il n’est pas difficile de s’y retrouver. En revanche, il manque cruellement de commentaires qui rendraient la relecture de certaines méthodes plus facile.
