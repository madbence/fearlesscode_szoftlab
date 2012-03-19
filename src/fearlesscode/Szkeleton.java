package fearlesscode;

class Szkeleton
{
	public static void main(String[] args)
	{
		Game game=new Game();
		//inicializalas
		game.start();

		//blokk mozgatas
		game.getPlayField().move(null, 1);

		//jatekos mozgatas
		game.getPlayField().getPlayer().move(null);

		//tick
		game.getPlayField().tick();

		//toggleMode
		game.getPlayField().toggleMode();
	}
}