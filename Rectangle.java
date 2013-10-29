import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {
	
	private double height;
	private double width;
	private Point point;
	private Color color;
	public Rectangle(double width, double height, Color color, Point point) {
		this.width = width;
		this.height = height;
		this.color = color;
		this.point = point;

	}
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.point.getX(), this.point.getY(), (int)width, (int)height);
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight(){
		return this.height;
	}
}