
package SimpleDiceGame;

import NetworkStuff.IOHandlers.SocketIOHandler;
import SimpleDiceGame.GameAccessories.Dice;

import java.io.IOException;

public class SimpleDiceGame {

	private Dice dice;
	public static final int ROUNDS_COUNT = 20;

	private SocketIOHandler player1IOHandler, player2IOHandler;

	public int[] startCompetition() throws IOException {

		int[] scores = new int[]{0, 0};

		for ( int i = 0; i < SimpleDiceGame.ROUNDS_COUNT; i++ ) {
			int currentAnswer = dice.throwDice();

			String player1Response = getPlayerResponse( player1IOHandler );
			int player1Answer = Integer.parseInt( player1Response );

			String player2Response = getPlayerResponse( player2IOHandler );
			int player2Answer = Integer.parseInt( player2Response );

			if ( isAnswerCorrect( player1Answer, currentAnswer ) )
				scores[0]++;
			if ( isAnswerCorrect( player2Answer, currentAnswer ) )
				scores[1]++;

		}

		return scores;

	}

	private boolean isAnswerCorrect( int answer, int correctAnswer ) {
		return ( answer == correctAnswer );
	}

	private String getPlayerResponse( SocketIOHandler socketIOHandler ) throws IOException {
		socketIOHandler.dos.writeUTF( "YOUR_TURN" );
		return socketIOHandler.dis.readUTF();
	}

	public SimpleDiceGame( SocketIOHandler player1IOHandler, SocketIOHandler player2IOHandler, int diceRangeStart, int diceRangeEnd) {
		this.player1IOHandler = player1IOHandler;
		this.player2IOHandler = player2IOHandler;
		this.dice = new Dice( diceRangeStart, diceRangeEnd );
	}
}
