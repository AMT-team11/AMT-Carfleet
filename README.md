# AMT - Carfleet

## Introduction
L'objectif de ce projet est de pratiquer les concepts de bases du TDD.
Pour ce faire, nous devons implémenter un sérialiseur/désérialiseur JSON.
Nous devons donc analyser la structure des fichiers JSON à traiter et définir une architecture
adaptée en java. Nous devons également utiliser une librairie facilitant cette sérialisation/desérialisation.

## Technologies
La libraire que nous avons choisie est Jackson. Nous avons fait ce choix, car il s'agissait d'une des librairies les
plus utilisées et donc les plus documentées. De plus, après quelques tests, nous avons vu qu'elle ne semblait pas compliquée
à utiliser et avons décidé de l'utiliser pour ce travail.

## Travail réalisé
### parserJSON
Deux fichiers de tests nous ont été fournis [dataCar](./src/test/resources/dataCar.json) et 
[dataDriver](./src/test/resources/dataDriver.json). Nous avons décidé de travailler avec la librairie Jackson puisque cette 
dernière semble grandement employée et également correctement documentée. Nous avons donc une classe s'occupant 
d'effectuer le parsing, parserJSON, qui possède deux méthodes publiques : parseCar et parseDriver prenant en argument un
fichier et rendant en sortie une ArrayList d'objets correspondants. Ces deux méthodes instancient une méthode privée
générique à laquelle elles passent le fichier ainsi que la classe correspondant à un tableau d'objets. Cette classe sera
employée afin d'accueillir les flottes de voitures/conducteurs.

Afin de tester le bon fonctionnement de notre classe et ses méthodes de parsing, nous avons ajouté deux classes de test.
Une pour tester le parsing de fichier contenant des voitures, l'autre des conducteurs. Ces tests consistent, 
pour la plupart, en un assertThrows d'exceptions lors du parsing de fichiers JSON mal formés ou incompatibles. 
Nous avons ajouté des Exceptions spécifiques à la classe de notre parser détectant si le fichier passé est vide, possède
un champ obligatoire manquant, un champ intraitable ou est mal structuré (p. Ex une parenthèse fermante manquante). 
Notre parser va attraper les potentielles exceptions lancées par Jackson et lancer une de ses propres exceptions à la 
place. Afin de tester chacune d'entre elles, nous avons créé des fichiers JSON de tests correspondant aux cas que nous 
pourrions rencontrer. Ces derniers se trouvent dans le fichier de [ressources](./src/test/resources) des tests.

Finalement, nous avons une classe de tests d'intégration. Il contient lui-même un objet de chaque classe de test et
appelle leurs tests unitaires séquentiellement. Un des tests permet de vérifier que, même si une exception a dû être levée,
le parser peut toujours être employé pour parser un autre fichier. Nous avons également testé le bon fonctionnement du
parsing de deux fichiers consécutifs. Et le dernier test consiste en la vérification du bon fonctionnement du parsing,
même si une erreur a précédemment été levée.

## Installation
Afin de pouvoir utiliser le projet, il faut d'abord cloner le projet sur votre machine. L'installation de Maven est
nécessaire pour faire fonctionner ce projet puisque nous executons les tests grâce au plugin 
[Surefire](https://maven.apache.org/surefire/maven-surefire-plugin/) de Maven. Une fois le repository cloné, 
il faut installer les dépendances du projet. Pour cela, il faut se placer à la racine du projet et lancer la commande
suivante : ```mvn install```. Cette dernière devrait également lancer tous les tests. 
Notre projet fonctionne avec la version 18 de JDK.

## Utilisation
Pour lancer tous les tests, il faut se placer à la racine du projet et lancer la commande suivante :
```mvn test```, ```mvn clean test``` ou ```mvn -Dtest=<classe de test> test```.

Si vous souhaitez parser des fichiers contenant d'autres objets que des voitures ou des conducteurs, il faut créer une
nouvelle méthode dans la classe parser en utilisant la méthode générique parse avec la classe souhaitée. Cette dernière
est également à créer en fonction du contenu JSON à parser.