import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class AmericanFlag {

        private int height;
        private int width;
        private double scale;
        private Rectangle[] stripes;
        private Rectangle redRec;
        private Rectangle union;
        private Stars star;
        private Stars[] states;
        public AmericanFlag(int width, int height, double scale) {
                
                int starOffsetY = 50;
                int variable = 0;
                
                int starOffsetX = 0;
                this.states = new Stars[6];
                this.stripes = new Rectangle[6];
                int yOffset = (int)(height/13.0);
                this.height = height * (int)scale;
                this.width = width * (int)scale;
                double diameter = (.0616*this.height);
                int uWidth = (int)(((double)this.height) * 0.76);
                int uHeight = (int)yOffset * 7;
                this.redRec = new Rectangle(this.width, this.height, Color.RED, new Point(0,0));
                this.union = new Rectangle(uWidth, uHeight, Color.BLUE, new Point(0,0));
                for (int i = 0; i < stripes.length; i++) {
                        stripes[i] = new Rectangle(this.width, this.height/13, Color.WHITE, new Point(0,yOffset));
                        yOffset = yOffset + (((int)this.height/13) * 2);
                }
                int maxStars = 6;
                int starCount = 0;
                int startingX = ((uWidth/12)/2);
                int startingY = (uHeight/10);
                //this.star = new Stars(diameter, new Point((int)(height*0.0315), (int)(height*0.054)), Color.WHITE);
                for (int i = 0; i < states.length; i++) {
                        //this.star = new Stars(diameter, new Point(starOffsetX, starOffsetY), Color.WHITE);
                        //if (starCount < maxStars) {
                                states[i] = new Stars(diameter, new Point(startingX+starOffsetX, startingY), Color.WHITE);
                                starCount++;
                                variable += 3;
                                starOffsetX = (startingX*variable);
                        //}
                        
                        
                        starOffsetY = (starOffsetY);
                        
                }

        }

        public void draw(Graphics g){
               
                redRec.paint(g);
                for (int i = 0; i < stripes.length; i++) {
                        stripes[i].paint(g);
                }
                union.paint(g);
                for (int i = 0; i<states.length; i++) {
                        states[i].paint(g);
                }
        }
}