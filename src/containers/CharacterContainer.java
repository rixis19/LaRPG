package containers;

import java.util.ArrayList;

import javax.swing.JLabel;

import entities.*;
import entities.Character;

@SuppressWarnings("serial")
public class CharacterContainer extends ArrayList<Character>
{
	public CharacterContainer() //Load all characters into the roster
	{
		Character chr = new Crono();
		this.add(chr);
		
		chr = new Noctis();
		this.add(chr);
		
		chr = new Sora();
		this.add(chr);
		
		chr = new Neku();
		this.add(chr);
		
		chr = new Link();
		this.add(chr);
		
		chr = new Pikachu();
		this.add(chr);
		
		chr = new Mario();
		this.add(chr);
		
		chr = new Fox();
		this.add(chr);
		
		chr = new Jotaro();
		this.add(chr);
		
		chr = new Ness();
		this.add(chr);
		
		chr = new CaptFalcon();
		this.add(chr);
		
		chr = new Samus();
		this.add(chr);
		
		
	}
	
	public JLabel getLabel(int index) //Gets the label of the character at the specified index
	{
		return this.get(index).getLabel();
	}

	public Character getCharacter(String text) { //Gets the character associated with the line of text
		Character target = null;
		for(int i = 0; i<this.size(); i++)
		{
			
			if(this.get(i).getName().equals(text))
			{
				target = this.get(i);
				break;
			}
		}
		
		return target;
	}
	
	public JLabel getSprite(int index) //Gets the sprite label of the character at the specified index
	{
		return this.get(index).getSpriteLabel();
	}
	
	
}
