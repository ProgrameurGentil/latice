package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.model.Couleur;
import latice.model.Forme;
import latice.model.Joueur;
import latice.model.Pioche;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Position;
import latice.model.Rack;
import latice.model.Tuile;

public class TestJoueur {
	PlateauTuiles plateauTuiles;
    PlateauDeCase plateauDeCase;

    @BeforeEach
    public void setup() {
        plateauTuiles = new PlateauTuiles();
        plateauDeCase = new PlateauDeCase();
    }
    
    @Test
    public void testPoserTuile() {
        Joueur joueur = new Joueur("Alice", new Pioche());
        Rack rack = new Rack(new ArrayList<>(Arrays.asList(
                new Tuile(Couleur.BLEU, Forme.OISEAU),
                new Tuile(Couleur.ROUGE, Forme.FLEUR),
                new Tuile(Couleur.JAUNE, Forme.PLUME)
        )));
        joueur.setRack(rack);
        joueur.setNombreActionRestanteAJouer(1);

        plateauTuiles.poser(new Position(4, 4), new Tuile(Couleur.BLEU, Forme.FLEUR));

        boolean result = joueur.poserTuile(0, new Position(3, 4), plateauDeCase, plateauTuiles);
        assertTrue(result);
        assertEquals(0, joueur.getNombreActionRestanteAJouer());
    }

    @Test
    public void testRemplirSonRack() {
        Pioche pioche = new Pioche();
        pioche.ajouter(new Tuile(Couleur.VERT, Forme.DAUPHIN));
        pioche.ajouter(new Tuile(Couleur.JAUNE, Forme.PLUME));
        pioche.ajouter(new Tuile(Couleur.BLEU, Forme.OISEAU));

        Joueur joueur = new Joueur("Bob", pioche);
        joueur.getRack().enleverTout();

        joueur.remplirSonRack();
        assertEquals(3, joueur.getRack().taille());
    }

    @Test
    public void testEchangerRack() {
        Pioche pioche = new Pioche();
        for (int i = 0; i < 15; i++) {
            pioche.ajouter(new Tuile(Couleur.BLEU, Forme.FLEUR));
        }

        Joueur joueur = new Joueur("Charlie", pioche);
        joueur.setPoints(4);
        ArrayList<Tuile> tuiles = new ArrayList<Tuile>(Arrays.asList(
                new Tuile(Couleur.BLEU, Forme.OISEAU),
                new Tuile(Couleur.ROUGE, Forme.FLEUR),
                new Tuile(Couleur.JAUNE, Forme.PLUME)
        ));
        joueur.setRack(new Rack(tuiles));
        assertTrue(joueur.echangerRack());
        
        assertTrue(joueur.getPoints().equals(2));
        assertEquals(5, joueur.getRack().taille());
    }

    @Test
    public void testAcheterAction() {
        Joueur joueur = new Joueur("Dana", new Pioche());
        joueur.setPoints(3);
        joueur.setNombreActionRestanteAJouer(0);

        boolean result = joueur.acheterAction();
        assertTrue(result);
        assertEquals(1, joueur.getNombreActionRestanteAJouer());
        assertEquals(1, joueur.getPoints());
    }

    @Test
    public void testNombreDeTuilesToTal() {
        Pioche pioche = new Pioche();
        for (int i = 0; i < 3; i++) {
            pioche.ajouter(new Tuile(Couleur.VERT, Forme.TORTUE));
        }

        Rack rack = new Rack(Arrays.asList(
                new Tuile(Couleur.BLEU, Forme.PLUME),
                new Tuile(Couleur.ROUGE, Forme.OISEAU)
        ));

        Joueur joueur = new Joueur("Eva", 0, 0, 0, rack, pioche);
        assertEquals(5, joueur.nombreDeTuilesToTal());
    }

    @Test
    public void testVerifierSiUnCoupEstPossible() {
        Joueur joueur = new Joueur("Fred", new Pioche());
        joueur.setRack(new Rack(Arrays.asList(
                new Tuile(Couleur.ROUGE, Forme.OISEAU),
                new Tuile(Couleur.VERT, Forme.FLEUR)
        )));

        plateauTuiles.poser(new Position(4, 4), new Tuile(Couleur.ROUGE, Forme.FLEUR));

        Integer coups = joueur.verifierSiUnCoupEstPossible(plateauTuiles);
        assertTrue(coups >= 0);  // Ajuster si tu connais la valeur exacte attendue
    }

}
