
package States;

import graphics.Assets;
import java.awt.Graphics;
import res.ui.Button;
import gameObject.constants;
import static graphics.Assets.fontsmall;
import graphics.Text;
import java.awt.Color;
import math.Vector2D;
import res.ui.Action;
/**
 *
 * @author Nicolas Arroyave
 */
public  class InstruccionState  extends State{
    
    private Button regresar;
    
    public InstruccionState (){
    
        regresar = new Button(
				Assets.greyBtn,
				Assets.blueBtn,
				Assets.greyBtn.getHeight(),
				constants.HEIGHT - Assets.greyBtn.getHeight() * 2,
				constants.RETURN,
				new Action() {
					@Override
					public void doAction() {
						State.changeState(new MenuState());
					}
				}
			);
    
        
    }

    @Override
    public void update() {
       regresar.update();
    }

    @Override
    public void draw(Graphics g) {
      regresar.draw(g);
      
      
		Vector2D Inst1 = new Vector2D(
				constants.WIDTH / 2 - 0,//100
				150
				);
		Vector2D Inst2 = new Vector2D(
				constants.WIDTH / 2 - 0,//33
				250
				);
                Vector2D Inst3 = new Vector2D(
				constants.WIDTH / 2 - 0,//256
				350
				);
                Vector2D Inst4 = new Vector2D(
				constants.WIDTH / 2 - 0,
				460
				);
                
                
                
                
                
                
		
		Text.drawText(g, constants.LINEA1, Inst1, true, Color.WHITE, Assets.fontsmall);
                Text.drawText(g, constants.LINEA2, Inst2, true, Color.WHITE, Assets.fontsmall);
                Text.drawText(g, constants.LINEA3, Inst3, true, Color.WHITE, Assets.fontsmall);
                Text.drawText(g, constants.LINEA4, Inst4, true, Color.WHITE, Assets.fontsmall);
		
      
      
      
      
      
      
      
    }




}
