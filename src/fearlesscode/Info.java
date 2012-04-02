package fearlesscode;

interface Info{

	/**
	 * Információk lekérésére szolgáló metódus.
	 * @return Az információk.
	 */
	String getInfo();
	
	
	/**
	 * A név és az ID lekérésére szolgáló metódus.
	 * @return Szögletes zárójelek között visszaadja az ID-t és a nevet. ([ID:név])
	 */
	String getName();
}