# Observations

Le projet a été réalisé en 2 heures, le temps maximal que j'alloue à un test technique. 

Quelques points d'améliorations ont été notés, comme par exemple, ne pas faire d'appel récursif afin d'éviter des StackOverFlow Exception. 

Faire du parcours d'arbre en itératif est bien meilleur lors que la taille de l'arbre (et donc la récursivité) est importante mais cela demande bien plus de temps.

J'ai également utilisé des TU pour mesurer les performances, chose qui n'est pas très CI/CD friendly, les pipelines de test se doivent d'etre courtes. 

Il peut arriver qu'on puisse avoir des StackOverFlow Exception dans le test aux limites si la génération de ranges en aléatoire est malchanceuse.

Avec plus de temps, j'aurais bien mieux testé l'ensemble des classes (dont l'Utils) et les méthodes de Range.
