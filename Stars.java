import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Stars {
        private Point leftPoint;
        private double diameter;
        private Color color;


        public Stars(double diameter, Point leftPoint, Color color) {
                this.color = color;
                this.leftPoint = leftPoint;
                this.diameter = diameter;
                
                

        }
        public void paint(Graphics g) {
                
                double radius = (this.diameter/2);
                double bottomLeftX = (leftPoint.getX()+(radius/2));
                double bottomLeftY = (leftPoint.getY()+radius);
                Point lefftPoint = new Point(leftPoint.getX(), leftPoint.getY());
                Point topPoint = new Point((int)(leftPoint.getX()+radius), (int)(leftPoint.getY()-radius));
                Point rightPoint = new Point((int)(leftPoint.getX()+this.diameter), leftPoint.getY());
                Point bRightPoint = new Point((int)(bottomLeftX+radius), (int)bottomLeftY);
                Point bLeftPoint = new Point((int)bottomLeftX, (int)bottomLeftY);
                double bigDistance = Math.sqrt((Math.pow(((leftPoint.getX()+radius) - leftPoint.getX()), 2) + Math.pow(((leftPoint.getY()-radius) - leftPoint.getY()), 2)));
                double littleDistance = Math.sqrt((Math.pow((leftPoint.getX()+this.diameter) - (leftPoint.getX()+(int)bigDistance), 2) + Math.pow((leftPoint.getY() - leftPoint.getY()), 2)));
                double heightOfTriangle = Math.sqrt((Math.pow((bigDistance-littleDistance), 2)) - (Math.pow((bigDistance/2), 2)));
                int lPentBotY = (leftPoint.getY()+(int)(radius/2));
                g.setColor(this.color);
                Polygon oGon = new Polygon();
                
                oGon.addPoint(leftPoint.getX(), leftPoint.getY());                                                                                //left point
                oGon.addPoint((int)(leftPoint.getX()+radius), (int)(leftPoint.getY()-radius));                        //top point
                oGon.addPoint((int)(leftPoint.getX()+this.diameter), leftPoint.getY());                                        //right point
                oGon.addPoint((int)(bottomLeftX+radius), (int)bottomLeftY);                                                                //bottom right point
                oGon.addPoint((int)bottomLeftX, (int)bottomLeftY);                                                                                //bottom left point
                //g.fillPolygon(oGon);
                //g.setColor(Color.GREEN);
                Polygon cGon = new Polygon();
                cGon.addPoint((int)(leftPoint.getX()+(int)bigDistance), leftPoint.getY());                                                                                        //inside left point
                cGon.addPoint((int)(((leftPoint.getX()+(int)bigDistance))-littleDistance), leftPoint.getY());                                                //inside right point
                cGon.addPoint((int)(leftPoint.getX()+radius), (int)(bottomLeftY-heightOfTriangle));                                                                                //bottom point
                cGon.addPoint((int)((leftPoint.getX()+(bigDistance-littleDistance))-0.05), (int)(leftPoint.getY()+(radius/2)));                //bottom inside left point
                cGon.addPoint((int)((leftPoint.getX()+bigDistance)+0.05), (int)lPentBotY);                                                                                        //bottom inside right point
                Polygon star = new Polygon();
                star.addPoint(leftPoint.getX(), leftPoint.getY());                                                                                                                                        //left point
                star.addPoint((int)((leftPoint.getX()+(int)bigDistance)-0.3), leftPoint.getY());                                                                                        //inside left
                star.addPoint((int)(leftPoint.getX()+radius), (int)((leftPoint.getY()-radius)+0.4));                                                                                //top
                star.addPoint((int)((((leftPoint.getX()+(int)bigDistance))-littleDistance)-0.3), leftPoint.getY());                                                //inside right
                star.addPoint((int)(leftPoint.getX()+this.diameter), leftPoint.getY());                                                                                                //right point
                star.addPoint((int)(((leftPoint.getX()+bigDistance)+0.05)-0.3), lPentBotY);                                                                                        //bottom inside right point
                star.addPoint((int)(bottomLeftX+radius), (int)bottomLeftY);                                                                                                                        //bottom right point
                star.addPoint((int)(leftPoint.getX()+radius), (int)(bottomLeftY-heightOfTriangle));                                                                                //bottom inside point
                star.addPoint((int)(bottomLeftX-0.3), (int)bottomLeftY);                                                                                                                                        //bottom left point
                star.addPoint((int)((leftPoint.getX()+(bigDistance-littleDistance))-0.05), lPentBotY);                //bottom inside left point
                g.fillPolygon(star);
                //cGon.addPoint((int)(leftPoint.getX()+radius), (int)(leftPoint.getY()+radius));
                
                //g.fillPolygon(cGon);
        }
}