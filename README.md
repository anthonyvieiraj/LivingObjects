# Observations

Le projet a été réalisé en à peu près 2 heures, le temps maximal que j'alloue à un test technique en général. 

Quelques points d'améliorations ont été notés, comme par exemple, ne pas faire d'appel récursif afin d'éviter des StackOverFlow Exception. 

Faire du parcours d'arbre en itératif est bien meilleur lorsque la taille de l'arbre (et donc la récursivité) est importante mais cela demande bien plus de temps à etre codé (sans la pratique au quotidien de parcours d'arbres immenses en itératif, c'est loin d'etre trivial).

J'ai également utilisé des TU pour mesurer les performances, chose qui n'est pas très CI/CD friendly, les pipelines de test se doivent d'etre courtes. 

Il peut arriver qu'on puisse avoir des StackOverFlow Exception dans le test aux limites si la génération de ranges en aléatoire est malchanceuse.

Avec plus de temps, j'aurais bien mieux testé l'ensemble des classes (dont l'Utils) et les méthodes de Range.

Sur l'algo de Tree, en cas aux limites, on voit un petit gain de performances comparés à l'algo Naive (10/20%). 
Cela est surement plus intéressant sur des Ranges avec du sens métier, permettant d'écarter plus facilement beaucoup plus de ranges (n'étant pas uniformément réparti comme avec des Ranges aléatoire). 

Sur l'algo basé sur les arbres, je me suis très clairement inspiré de celui de Wikipédia.
Dans ma pratique au quotidien, j'utilise les algos de recherche déjà implémenté que de réinventer la roue. 
Je savais que ce type d'algo existait mais l'implémenter était nouveau.
