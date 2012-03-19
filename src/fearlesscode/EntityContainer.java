package fearlesscode;


/**
*	Egy Entity-t és annak EntityPosition-jét tároló segédosztály.
*/

public class EntityContainer
{
    Entity entity;
    EntityPosition position;
    
    
    /**
    *	EntityContainer konstruktora.
    */
    EntityContainer(Entity en, EntityPosition pos)
    {
        entity = en;
        position=pos;
    }
}
