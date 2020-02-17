package lecture_200217.subject;

public abstract class Game {
	
	public void run() {
		gameLogic();
	}
	
	abstract void gameLogic();
}
