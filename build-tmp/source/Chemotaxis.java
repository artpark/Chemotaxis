import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

//Art Parkeenvincha, Block 3, Chemotaxis
Bacteria [] colony;
Bacteria [] jump;
public void setup()
{
  colorMode(HSB);
  size(500, 500);
  colony = new Bacteria[100];
  jump = new Bacteria[3];
  for(int i=0; i < colony.length; i++)
  {
    colony[i] = new Bacteria((int)(Math.random()*500), (int)(Math.random()*500), (int)(Math.random()*255), (int)(Math.random()*15)+35);
  }
  for(int i=0; i < jump.length; i++)
  {
    jump[i] = new Bacteria((int)(Math.random()*500), (int)(Math.random()*500), (int)(Math.random()*255), (int)(Math.random()*20)+30);
  }
}

public void draw()
{
  background(40);
  for(int i=0; i < colony.length; i++)
{
    colony[i].walk();
    colony[i].show();
  }
  for(int i=0; i < jump.length; i++)
	{
	    jump[i].jump();
	    jump[i].show();
	}

}

class Bacteria
{
  int myX, myY, myC, myS;
  Bacteria(int x, int y, int c, int s){
    myX = x;
    myY = y;
    myC = c;
    myS = s;
  }
  public void walk()
  {
    myX += (Math.random()*5)-2;
    myY += (Math.random()*5)-2;
  }
  public void jump()
  {
    myX = (int)(Math.random()*500);
    myY = (int)(Math.random()*500);
  }
  public void show()
  {
    stroke(myC, 100, 255, 100);
    fill(myC, 100, 255, 50);
    ellipse(myX, myY, myS, myS);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
