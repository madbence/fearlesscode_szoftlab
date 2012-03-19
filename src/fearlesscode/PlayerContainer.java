package fearlesscode;


/**
*	A Player-t és a Player pozicióját tároló segédosztály.
*/

public class PlayerContainer
{
    Player player;
    EntityPosition position;
    
    
    /**
    *	A PlayerContainer konstruktora, beállítja a Player referenciáját,
    *	és pozicióját
    */
    PlayerContainer(Player player, EntityPosition pos)
    {
        this.player=player;
        this.position=pos;
    }
}
