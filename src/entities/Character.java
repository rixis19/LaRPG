package entities;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import containers.ImageContainer;

public abstract class Character {
	
	protected ImageContainer imgContainer = new ImageContainer();
	protected ImageIcon characterSprite;
	protected ImageIcon characterPortrait;
	protected String characterName; 
	protected int health;
	protected int magic;
	protected int attack;
	protected int defense;
	protected int exp;
	
	public Character()
	{
		characterName = "dummy";
	}
	
	public Character(String chrName)
	{
		characterName = chrName;
	}
	
	public Character(String chrName, String chrSprite, String chrPortrait) 
	{
		characterName = chrName;
		characterSprite = imgContainer.getIcon(chrSprite);
		characterPortrait = imgContainer.getIcon(chrPortrait);
	}
	
	public Character(String chrName, String chrSprite, String chrPortrait, int health, int attack, int magic, int defense, int exp)
	{
		characterName = chrName;
		characterSprite = imgContainer.getIcon(chrSprite);
		characterPortrait = imgContainer.getIcon(chrPortrait);
		this.health = health;
		this.magic = magic;
		this.attack = attack;
		this.defense = defense;
		this.exp = exp;
	}
	
	public ImageIcon getPortrait()
	{
		return characterPortrait;
	}
	
	public String getName()
	{
		return characterName;
	}
	
	public ImageIcon getSprite()
	{
		return characterSprite;
	}
	
	public int getMagic()
	{
		return magic;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public JLabel getLabel()
	{
		JLabel chr = new JLabel();
		ImageIcon ico = this.getPortrait();
		chr.setIcon(ico);
		chr.setText(this.getName());
		return chr;
	}
	
	public JLabel getSpriteLabel()
	{
		JLabel chr = new JLabel();
		ImageIcon ico = this.getSprite();
		chr.setIcon(ico);
		chr.setText(this.getName());
		return chr;
	}
	

}
