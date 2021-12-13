
package States;

/**
 *
 * @author Nicolas Arroyave
 */

 

import java.awt.Graphics;
import java.util.ArrayList;

import gameObject.constants;
import graphics.Assets;
import static graphics.Assets.fonttitle;
import graphics.Text;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import math.Vector2D;
import res.ui.Action;
import res.ui.Button;

public class MenuState extends State {
	
  
    
	private ArrayList<Button> buttons;
    
	
	public MenuState() {
           
    
       
            
		buttons = new ArrayList<Button>();
		
		buttons.add(new Button(
				Assets.greyBtn,
				Assets.blueBtn,
				constants.WIDTH / 2 - Assets.greyBtn.getWidth()/2,
				constants.HEIGHT / 2 - Assets.greyBtn.getHeight()*2,
				constants.PLAY,
				new Action() {
					@Override
					public void doAction() {
						State.changeState(new GameState());
					}
				}
				));
		
		buttons.add(new Button(
				Assets.greyBtn,
				Assets.blueBtn,
				constants.WIDTH / 2 - Assets.greyBtn.getWidth()/2,
				constants.HEIGHT / 2 + Assets.greyBtn.getHeight()*2 ,
				constants.EXIT,
				new Action() {
					@Override
					public void doAction() {
						System.exit(0);
					}
				}
				));
                buttons.add(new Button(
				Assets.greyBtn,
				Assets.blueBtn,
				constants.WIDTH / 2 - Assets.greyBtn.getWidth()/2,
				constants.HEIGHT / 2,
				constants.INSTRUCTION,
				new Action() {
					@Override
					public void doAction() {
						State.changeState(new InstruccionState());
					}
				}
				));
		
	}
	
	
	@Override
	public void update() {
		for(Button b: buttons) {
			b.update();
		}
	}

	@Override
	public void draw(Graphics g) {
		for(Button b: buttons) {
			b.draw(g);
		}
               
		Vector2D part1 = new Vector2D(
				constants.WIDTH /2 - 200,//100
				100
				);
		Vector2D part2 = new Vector2D(
				constants.WIDTH / 2 - 48,//33
				100
				);
                Vector2D part3 = new Vector2D(
				constants.WIDTH / 2 - -21,//256
				100
				);
                Vector2D part4 = new Vector2D(
				constants.WIDTH / 2 - -92,
				100
				);
                Vector2D part5 = new Vector2D(
				constants.WIDTH / 2 - -238,
				100
				);
                
                
                
                
                
		
                Text.drawText(g, constants.part1, part1, true, Color.WHITE, Assets.fonttitle);
                Text.drawText(g, constants.part2, part2, true, Color.GREEN, Assets.fonttitle);
                Text.drawText(g, constants.part3, part3, true, Color.BLUE, Assets.fonttitle);
		Text.drawText(g, constants.part4, part4, true, Color.RED, Assets.fonttitle);
		Text.drawText(g, constants.part5, part5, true, Color.WHITE, Assets.fonttitle);
      
                
                
	}

}
    
    

