package spacepong;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class GameObject {
	
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visibility;
	Random random = new Random();
	GameObject(String name,int check){
		this.height= 50;
		this.width = 50;
		this.x=  random.nextInt(1024-50) ;
		this.y=  random.nextInt(50)+75*check;
		this.name = name;
		this.visibility = false;
	}
	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	public Image imageReader() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/spacepong/"+name));
			
		} 
		catch (IOException e) {
			System.err.println(e);
		}
		return image;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}	
}
