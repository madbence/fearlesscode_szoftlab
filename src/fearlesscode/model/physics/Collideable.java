package fearlesscode.model.physics;

/**
 * Az ütköztethető objektumok rendelkeznek befoglaló dobozzal.
 */
public interface Collideable
{
	/**
	 * Visszaadja a befoglaló dobozt.
	 */
	Rectangle getBoundingBox();
}