//For development only.

package Server;

public class GameStates {
	// Instance variables -- static for global use
	public static GameState current;

	// Constructor
	public GameStates(GameState current) {
		this.current = current;
	}

	public enum GameState {
		PENDING, GAMING, ENDED;
	}

	public void setGameState(GameState state) {
		this.current = state;
	}

}