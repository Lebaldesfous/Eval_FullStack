# Eval_FullStack

#Questions : 

1)
2) Concernant le stockage des images il est préférable de stocker l'ID de l'image directement dnas la table du restaurant afin de faciliter l'accès à celui çi et ne pas surcharger la DB en requêtes "inutiles"
3)  C'est une bonne idée lorsque l'on retourne uniquement 1 restaurant puisque cela veut dire que l'utilisateur veut accéder aux détails de celui çi et donc a sûrement besoin d'avoir cette image
4)  C'est une bonne idée lorsque l'on retourne uniquement 1 restaurant puisque cela veut dire que l'utilisateur veut accéder aux détails de celui çi et peut être avoir accès à cette note finale
5)  les tags ont été implémentés de la manière suivante : Entitée a part entière afin de pouvoir les stocker facilement en DB et stocker facilement quels restaurants possède quels tags. Je pense que cette implémentation est la "meilleure" dans ces conditions puisque je n'ai pas perdu beaucoup de temps à réaliser ces tâches et pas beaucoup de temps à trouver comment connecter toutes les pièces puisque ce n'est pas moi qui gère toutes les liaisons. 
