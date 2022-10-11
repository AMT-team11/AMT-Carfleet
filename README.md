# AMT - Carfleet

## Introduction
L'objectif de ce projet est de pratiquer les concepts de bases du TDD.
Pour ce faire, nous devons implémenter un sérialiseur/désérialiseur JSON.
Nous devons donc analyser la structure des fichiers JSON à traiter et définir une architecture
adaptée en java. Nous devons également utiliser une librairie facilitant cette sérialisation/desérialisation.

## Technologies
La libraire que nous avons choisie est Jackson. Nous avons fait ce choix car il s'agissait d'une des librairies les
plus utilisées et donc les plus documentées. De plus, après quelques tests, nous avons vu qu'elle ne semblait pas compliquée
à utiliser.

## Installation
Afin de pouvoir utiliser le projet, il faut d'abord cloner le projet sur votre machine. Une fois cela fait, il faut installer les
dépendances du projet. Pour cela, il faut se placer à la racine du projet et lancer la commande suivante :
```mvn install```.

## Utilisation
Pour lancer tous les tests, il faut se placer à la racine du projet et lancer la commande suivante :
```mvn test```.