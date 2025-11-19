# 🎲 Projet SAE -- Reproduction du jeu de plateau *Latice*

## 📥 Installation du projet

### 🔹 Option 1 --- Cloner le dépôt avec Git

Si vous avez Git installé, exécutez simplement :

``` bash
git clone https://github.com/ProgrameurGentil/latice.git
```

Puis accédez au dossier cloné :

``` bash
cd latice
```

Vous pouvez ensuite ouvrir le projet dans votre IDE (IntelliJ, Eclipse,
VS Code...).

------------------------------------------------------------------------

### 🔹 Option 2 --- Télécharger le projet en ZIP

1.  Rendez-vous sur la page GitHub du projet.\
2.  Cliquez sur **Code** → **Download ZIP**.\
3.  Extrayez le fichier téléchargé.\
4.  Ouvrez le dossier dans votre IDE ou votre explorateur.

------------------------------------------------------------------------

## 📌 Présentation

Dans le cadre de la SAE, nous avons recréé le jeu de plateau **Latice**
en **Java** et **JavaFX**.\
L'objectif était de reproduire le fonctionnement du jeu original tout en
proposant une interface jouable sur ordinateur.

------------------------------------------------------------------------

## ▶️ Lancer le jeu

Pour lancer Latice :

1.  Accédez au dossier :\
    `src/main/java/latice/application`
2.  Exécutez le fichier **LaticeMain.java**\
    → C'est le point d'entrée de l'application.

------------------------------------------------------------------------

## 🕹️ Règles du jeu

### 🧩 Déroulement

-   **Premier tour** :\
    Le premier joueur pose une tuile sur la **case Lune**, ce qui
    initialise la partie.\
    Il doit ensuite cliquer sur le bouton du menu pour **passer son
    tour**.

-   **Tours suivants** :\
    Le joueur doit poser une tuile **de la même couleur ou de la même
    forme** sur une case **adjacente** à une autre tuile.\
    Si le placement est impossible, la case s'affichera en **rouge**.

### ⭐ Gagner des points

Les joueurs marquent des points en : - Posant une tuile sur une **case
Soleil** - Réalisant les combinaisons suivantes : - **Double** :
adjacente à 2 tuiles. - **Triple** : adjacente à 3 tuiles. - **Latice**
: adjacente à 4 tuiles (entourée de toutes parts).

### 🎯 Actions possibles avec les points

Les points permettent d'effectuer deux actions : - **Piocher 5 nouvelles
tuiles** dans la pool\
- **Jouer un second coup**

Bon jeu !

------------------------------------------------------------------------

## 💻 Technologies utilisées

-   **Java**
-   **JavaFX**

------------------------------------------------------------------------

## 👥 Contributeurs (***LPS***)
<div>
  <ul>
    <li><a href="https://github.com/Xulungu">Xulungu</a></li>
    <li><a href="https://github.com/ProgrameurGentil">ProgrameurGentil</a></li>
    <li><a href="https://github.com/ahobon">HOBON</a></li>
  </ul>
</div>

---

## 📄 Licence
<p>
  La licence du projet est disponible <a href="https://github.com/ProgrameurGentil/SAE2_dev/edit/main/LICENCE.md">ici</a>.
</p>
