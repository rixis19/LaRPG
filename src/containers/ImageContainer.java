package containers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.Game;

public class ImageContainer {
	
	private Map<String, Image> map;
	
	public ImageContainer() //Creates the Hashmap
	{
		map = new HashMap<String, Image>();
		imageLibrary();
	}
	
	public void imageLibrary() //Loads all the sprites in resources/ to the Hashmap
	{
	    try {
	    	
			this.addIcon("greyBox", "greyTextBox.png");
			this.addIcon("blackBox", "blackTextBox.png");
			this.addIcon("enemy", "Enemy.png");
			this.addIcon("textBox", "textBox.png");
			this.addCard("charRed", "charSelectCardRed.png");
			this.addCard("charYellow", "charSelectCardYellow.png");
			this.addCard("charGreen", "charSelectCardGreen.png");
			this.addCard("charBlue", "charSelectCardBlue.png");
			this.addCard("charCPU", "charSelectCardCPU.png");
			this.addCard("charNA", "charSelectCardNA.png");
			this.addCard("Lara Icon", "laraIcon.png");
			
			this.addStageBackground("magicCave", "magicCave.png");
			this.addStageBackground("hachiko", "hachiko.png");
			this.addStageBackground("mansion", "mansion.png");
			this.addStageBackground("finalDestination", "finalDestination.png");
			this.addStageBackground("oceanPalace", "oceanPalace.png");
			this.addStageBackground("celestianForest", "celestianForest.png");
			this.addStageBackground("falconDeck", "falconDeck.png");
			this.addStageBackground("avalancheHQ", "avalancheHQ.png");
			this.addStageBackground("onett", "onett.png");
			
			this.addStagePortrait("onettPortrait", "onettSelectPortrait.png");
			this.addStagePortrait("avalancheHQPortrait", "avalancheHQSelectPortrait.png");
			this.addStagePortrait("falconDeckPortrait", "falconDeckSelectPortrait.png");
			this.addStagePortrait("celestianForestPortrait", "celestianForestSelectPortrait.png");
			this.addStagePortrait("oceanPalacePortrait", "oceanPalaceSelectPortrait.png");
			this.addStagePortrait("finalDestinationPortrait", "finalDestinationSelectPortrait.png");
			this.addStagePortrait("mansionPortrait", "mansionSelectPortrait.png");
			this.addStagePortrait("magicCavePortrait", "magicCaveSelectPortrait.png");
			this.addStagePortrait("hachikoPortrait", "hachikoSelectPortrait.png");
			
			this.addCharacterSprite("crono", "Crono.png");
			this.addCharacterSprite("noctis", "Noctis.png");
			this.addCharacterSprite("neku", "Neku.png");
			this.addCharacterSprite("pikachu", "pikachu.png");
			this.addCharacterSprite("sora", "Sora.png");
			this.addCharacterSprite("link", "link.png");
			this.addCharacterSprite("mario", "mario.png");
			this.addCharacterSprite("fox", "fox.png");
			this.addCharacterSprite("jotaro", "jotaro.png");
			this.addCharacterSprite("samus", "samus.png");
			this.addCharacterSprite("captFalcon", "captFalcon.png");
			this.addCharacterSprite("ness", "ness.png");
			
			this.addCharacterPortrait("cronoPortrait", "cronoSelectPortrait.png");					
			this.addCharacterPortrait("noctisPortrait", "noctisSelectPortrait.png");							
			this.addCharacterPortrait("nekuPortrait", "nekuSelectPortrait.png");			
			this.addCharacterPortrait("pikachuPortrait", "pikachuSelectPortrait.png");			
			this.addCharacterPortrait("linkPortrait", "linkSelectPortrait.png");			
			this.addCharacterPortrait("soraPortrait", "soraSelectPortrait.png");
			this.addCharacterPortrait("marioPortrait", "marioSelectPortrait.png");
			this.addCharacterPortrait("randomPortrait", "randomSelectPortrait.png");
			this.addCharacterPortrait("foxPortrait", "foxSelectPortrait.png");
			this.addCharacterPortrait("nessPortrait", "nessSelectPortrait.png");
			this.addCharacterPortrait("captFalconPortrait", "captFalconSelectPortrait.png");
			this.addCharacterPortrait("samusPortrait", "samusSelectPortrait.png");
			this.addCharacterPortrait("jotaroPortrait", "jotaroSelectPortrait.png");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addIcon(String name, String fileName) throws IOException //adds a standard icon to the map
	{
		String path = "./src/resources/"+fileName;
		File file = new File(path);
	    BufferedImage image = ImageIO.read(file);
	    Image newimg = image;
	    map.put(name, newimg);
	}
	
	public void addStageBackground(String name, String fileName) throws IOException //adds a stage background to the map, scaling it to the window size
	{
		String path = "./src/resources/stage/"+fileName;
		File file = new File(path);
	    BufferedImage image = ImageIO.read(file);
	    Image newimg = null;
	    newimg = image.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH);
	    map.put(name, newimg);
	}
	
	public void addCard(String name, String fileName) throws IOException //adds a character card portrait to the map, scaling it to the required size
	{
		String path = "./src/resources/"+fileName;
		File file = new File(path);
	    BufferedImage image = ImageIO.read(file);
	    Image newimg = null;
	    newimg = image.getScaledInstance(98, 136, Image.SCALE_SMOOTH);
	    map.put(name, newimg);
	}
	
	public void addCharacterPortrait(String name, String fileName) throws IOException //adds a character portrait to the map
	{
		String path = "./src/resources/portraits/"+fileName;
		File file = new File(path);
	    BufferedImage image = ImageIO.read(file);
	    Image newimg = null;   
	    newimg = image;
	    map.put(name, newimg);
	}
	
	public void addStagePortrait(String name, String fileName) throws IOException //adds a stage portrait to the map
	{
		String path = "./src/resources/stagePortraits/"+fileName;
		File file = new File(path);
	    BufferedImage image = ImageIO.read(file);
	    Image newimg = null;   
	    newimg = image;
	    map.put(name, newimg);
	}
	
	public void addCharacterSprite(String name, String fileName) throws IOException //adds a character sprite to the map
	{
		String path = "./src/resources/sprites/"+fileName;
		File file = new File(path);
	    BufferedImage image = ImageIO.read(file);
	    Image newimg = null;   
	    newimg = image;
	    map.put(name, newimg);
	}
	
	public ImageIcon resizeIcon(String name, int width, int height) //resizes the icon to the appropriate size
	{
		Image image = map.get(name);
		Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return new ImageIcon(newimg);
	}
	
	public Image resizeImage(String name, int width, int height) //resizes the image to the appropriate size
	{
		Image image = map.get(name);
		return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public Image getImage(String name) //gets the image
	{
		return map.get(name);
	}
	
	public ImageIcon getIcon(String name) //gets the icon
	{
		ImageIcon ico = new ImageIcon(map.get(name));
		return ico;
	}
	
	public static BufferedImage horizontalFlip(BufferedImage img) //horizontally flips a image, used for characters on stages
	{
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }
}
