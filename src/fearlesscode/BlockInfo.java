package fearlesscode;


/**
 * Blokkokról szóló nformációk szolgáltatás biztosító interface.
 */
public interface BlockInfo
{
	/**
	 * Információk lekérésére szolgáló metódus.
	 * @param post A pozició.
	 * @return Az információk.
	 */
	String getInfo(Position pos);
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	String getName();
}