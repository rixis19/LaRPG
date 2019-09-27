package engines;

import javax.swing.JLabel;

import containers.CharacterContainer;
import entities.Character;
import entities.*;

public class CharacterSelectEngine
{
	public Character playerOne = new Dummy();
	public Character playerTwo = new Dummy();
	public Character playerThree = new Crono();
	public Character playerFour = new Crono();
	public Character currentPlayer;
	public CharacterContainer chrContainer = new CharacterContainer();
	
	public CharacterSelectEngine(Character one)
	{
		playerOne = one;
	}
	
	public void setPlayerOne(String label)
	{
		if(label!=null)
		{
			playerOne = chrContainer.getCharacter(label);
		}
	}
	
	public void setPlayerTwo(String label)
	{
		if(label!=null)
		{
			playerTwo = chrContainer.getCharacter(label);
		}
	}
	
	public void setPlayerThree(JLabel label)
	{
		playerThree = chrContainer.getCharacter(label.getText());
	}
	
	public void setPlayerFour(JLabel label)
	{
		playerFour = chrContainer.getCharacter(label.getText());
	}
	
	public Character getPlayerOne()
	{
		return playerOne;
	}
	
	public Character getPlayerTwo()
	{
		return playerTwo;
	}
	
	public Character getPlayerThree()
	{
		return playerThree;
	}
	
	public Character getPlayerFour()
	{
		return playerFour;
	}

	public String toString()
	{
		return "Player 1: "+playerOne.getName();
	}
}
