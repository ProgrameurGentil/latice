package latice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import latice.model.Constantes;
import latice.model.Couleur;
import latice.model.Forme;
import latice.model.PlateauTuiles;
import latice.model.Position;
import latice.model.Tuile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlateauTuiles {

    private PlateauTuiles plateau;
    private Tuile tuileRougeFleur;
    private Tuile tuileBleuTortue;

    @BeforeEach
    public void setup() {
        plateau = new PlateauTuiles();
        tuileRougeFleur = new Tuile(Couleur.ROUGE, Forme.FLEUR);
        tuileBleuTortue = new Tuile(Couleur.BLEU, Forme.TORTUE);
    }

    @Test
    public void testInitialisationPlateauVide() {
        assertTrue(plateau.siListTuileVide());
        assertEquals(0, plateau.combienDeTuiles());
    }

    @Test
    public void testPoserTuileFonctionne() {
        Position pos = new Position(3, 3);
        assertTrue(plateau.poser(pos, tuileRougeFleur));
        assertTrue(plateau.siTuileIci(pos));
        assertEquals(tuileRougeFleur, plateau.donnerTuilesAPosition(pos));
    }

    @Test
    public void testPoserTuileEchoueSiDejaPresente() {
        Position pos = new Position(4, 4);
        assertTrue(plateau.poser(pos, tuileRougeFleur));
        assertFalse(plateau.poser(pos, tuileBleuTortue));
    }

    @Test
    public void testViderPlateau() {
        plateau.poser(new Position(0, 0), tuileRougeFleur);
        plateau.vider();
        assertTrue(plateau.siListTuileVide());
    }

    @Test
    public void testCombienDeTuilesAutour() {
        Position centre = new Position(4, 4);
        plateau.poser(new Position(4, 3), tuileRougeFleur);
        plateau.poser(new Position(3, 4), tuileRougeFleur);

        assertEquals(2, plateau.combienDeTuileAutour(centre));
    }

    @Test
    public void testSiTuilePosableCentrePremierTour() {
        assertTrue(plateau.siTuilePosableIci(tuileRougeFleur, Constantes.CENTRE));
    }

    @Test
    public void testTuileNonPosablePremierTourHorsCentre() {
        Position pos = new Position(0, 0);
        assertFalse(plateau.siTuilePosableIci(tuileRougeFleur, pos));
    }

    @Test
    public void testTuileNonPosableSansVoisin() {
        Position centre = Constantes.CENTRE;
        plateau.poser(centre, tuileRougeFleur);

        Position coin = new Position(0, 0);
        assertFalse(plateau.siTuilePosableIci(tuileRougeFleur, coin));
    }

    @Test
    public void testTuilePosableAvecVoisinCompatible() {
        Position voisin = new Position(4, 3);
        Position aPlacer = new Position(4, 4);

        Tuile compatible = new Tuile(Couleur.BLEU, Forme.FLEUR); 
        plateau.poser(voisin, tuileRougeFleur);

        assertTrue(plateau.siTuilePosableIci(compatible, aPlacer));
    }

    @Test
    public void testTuileNonPosableAvecVoisinNonCompatible() {
        Position voisin = new Position(4, 3);
        Position aPlacer = new Position(4, 4);

        plateau.poser(voisin, tuileRougeFleur);
        assertFalse(plateau.siTuilePosableIci(tuileBleuTortue, aPlacer));
    }

    @Test
    public void testTuileNonPosableSiDejaTuile() {
        Position pos = new Position(2, 2);
        plateau.poser(pos, tuileRougeFleur);

        assertFalse(plateau.siTuilePosableIci(tuileRougeFleur, pos));
    }
}
