package containers;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import stages.*;

@SuppressWarnings("serial")
public class StageContainer extends ArrayList<Stage>
{
	Random gen = new Random();
	
	public StageContainer()
	{
		Stage stg = new MagicCave();
		this.add(stg);
		
		stg = new Hachiko();
		this.add(stg);
		
		stg = new Mansion();
		this.add(stg);
		
		stg = new FinalDestination();
		this.add(stg);
		
		stg = new OceanPalace();
		this.add(stg);
		
		stg = new FalconDeck();
		this.add(stg);
		
		stg = new CelestianForest();
		this.add(stg);
		
		stg = new Onett();
		this.add(stg);
		
		stg = new AvalancheHQ();
		this.add(stg);
		
	}
	
	public JLabel getLabel(int index)
	{
		System.out.println(this.get(index).getName());
		return this.get(index).getLabel();
	}

	public Stage getStage(String text) {
		Stage target = null;
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
	
	public ImageIcon getRandomStage()
	{
		Stage target = this.get(gen.nextInt(this.size()));
		return target.getStage();
	}
	
	
}