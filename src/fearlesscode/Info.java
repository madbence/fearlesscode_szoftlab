package fearlesscode;

public interface Info
{
	/**
	 * Információk lekérésére szolgáló metódus.
	 * @param pos A pozició.
	 * @return Az információk.
	 */
	String getInfo(EntityPosition pos);
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	String getName();
}