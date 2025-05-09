package latice.model;

public interface IGameBoard {
	
	boolean isTuileAt(Position position);
	public boolean isEmpty();
	public boolean put(Position position, Tuile tuile);
	public void clear();
	public int howManyTuilesOnBoard();
	public Tuile tuileAt(Position position);
	public Tuile removeTuileAt(Position position);
	public String toAscii();	
	
	public Object tuiles();


}
