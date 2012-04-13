package fearlesscode;

public interface BlockInfo
{
	/**
	 * Információk lekérésére szolgáló metódus.
	 * @return Az információk.
	 */
	String getInfo(Position pos);
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	String getName();
}