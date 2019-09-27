package main;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main 
{
	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
		Game game = new Game();
		game.setVisible(true);
	}
}


