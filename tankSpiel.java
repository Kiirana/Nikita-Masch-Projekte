main.java

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class main implements KeyListener {
	//Do not changes these constants
	static int i = 0;
	static int j = 0;
	static int cooldown = 0;
	static int lastPosX;
	static int lastPosY;
	static ArrayList<Bullet> bullet = new ArrayList<>(); //List for Bullets
	static int[] hit = new int[Enemy.count];
	static int points = 0;

	//start function
	
	public static void main(String[] args)  {
		
		graphics g = new graphics();
		GM gm = new GM();
	
		bullet.add(new Bullet(20,10,Color.blue,-10,-10,false,0));//nötig damit die Graphics methode die Bullets sieht
		
		
		//create Frame
		
		JFrame f = new JFrame("Tank Game");
		f.setBackground(Color.cyan);
        f.setSize(820, 820);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        // create a JPanel and add it to the JFrame

        f.add(g);
        f.setVisible(true);
        
		//main method with timer every 30 miliseconds i guess... or 3 seconds
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//check so that the tank isnt outside the frame
            	if(Tank.x<0||Tank.x>=800) {
            		Tank.x = lastPosX;
            	}
            	if(Tank.y<0||Tank.y>=780) {
            		Tank.y = lastPosY;
            	}
            	lastPosX = Tank.x;
            	lastPosY = Tank.y;
            	
            	//colldown for the shooting
            	cooldown++;
                //repaint the screen
                g.repaint();
                //let the bullet fly
                bullet_fly();
                System.out.println(bullet.get(j).y);
                System.out.println(Enemy.e[0].y);
                check_hit();
            }
	
        });
        
        //start the timer
        timer.start();
		
		//add the KeyListener for the controls
        f.addKeyListener(new KeyListener() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		//
        		//Shooting part every 3 seconds
        		//
        		if (e.getKeyChar() == KeyEvent.VK_SPACE && cooldown >40){
        		      
        				cooldown = 0;
        				if(Tank.direc==1 && bullet.get(i).fly == false) {
        					bullet.get(i).direc = 1;
        				}else if(Tank.direc==2 && bullet.get(i).fly == false) {
        					bullet.get(i).direc = 2;
        				}else if(Tank.direc==3 && bullet.get(i).fly == false) {
        					bullet.get(i).direc = 3;
        				}else if(Tank.direc==4 && bullet.get(i).fly == false) {
        					bullet.get(i).direc = 4;
        				}
        				
        				
        				bullet.get(i).fly = true;
        				bullet.get(i).x = Tank.x+4;
        				bullet.get(i).y = Tank.y+4;
        				
        				bullet.add(new Bullet(20,10,Color.blue,Tank.x,Tank.y,false,Tank.direc));
        				i++;			
        		    }
        		
        		        		

        	}
        	//movement WASD
        	@Override
        	public void keyPressed(KeyEvent e) {
        		// TODO Auto-generated method stub
        		// Check which key was pressed
        		if (e.getKeyChar() == 'w' && e.getKeyChar() =='a') {
                	
                	Tank.y-=20;
                	Tank.x-=20;
                    // Handle "W" key press (move up)
                } 
                if (e.getKeyChar() =='a' && e.getKeyChar() == 's') {
                	
                	
                	Tank.x-=20;
                	Tank.y+=20;
                    // Handle "A" key press (move left)
                } 
                if (e.getKeyChar() == 's' && e.getKeyChar() == 'd') {
                	
                	Tank.y+=20;
                	Tank.x+=20;
                    // Handle "S" key press (move down)
                } 
                if (e.getKeyChar() == 'd' && e.getKeyChar() == 'w' ) {
                	
                	
                	Tank.y-=20;
                	Tank.x+=20;
                    // Handle "D" key press (move right)
                }
                if (e.getKeyChar() == 'w') {
                	Tank.direc = 3;
                	Tank.y-=20;
                	
                    // Handle "W" key press (move up)
                } 
                if (e.getKeyChar() =='a') {
                	Tank.direc = 2;
                	
                	Tank.x-=20;
                    // Handle "A" key press (move left)
                } 
                if (e.getKeyChar() == 's') {
                	Tank.direc = 1;
                	Tank.y+=20;
                
                    // Handle "S" key press (move down)
                } 
                if (e.getKeyChar() == 'd') {
                	
                	Tank.direc = 4;
                	
                	Tank.x+=20;
                    // Handle "D" key press (move right)
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN ){
    		      	Tank.direc = 1;	
    		      
        		}
        		if (e.getKeyCode() == KeyEvent.VK_LEFT ){
    		      	Tank.direc = 2;	
    		      
        		}if (e.getKeyCode() == KeyEvent.VK_UP){
    		      	Tank.direc = 3;	
    		      
        		}
        		if (e.getKeyCode() == KeyEvent.VK_RIGHT ){
    		      	Tank.direc = 4;	
    		      
        		}
                
                
        	}

        	@Override
        	public void keyReleased(KeyEvent e) {
        		// TODO Auto-generated method stub
        		
        	}
        
	});
        }
	public static void bullet_fly() {
		 if(i-2==j) {
			 
         	j++;
         }
         if(bullet.get(j).fly == true) {
         	
         	if(bullet.get(j).direc==1) {
         		bullet.get(j).y+=bullet.get(j).speed;
				}else if(bullet.get(j).direc==2) {
					bullet.get(j).x-=bullet.get(j).speed;
				}else if(bullet.get(j).direc==3) {
					bullet.get(j).y-=bullet.get(j).speed;
				}else if(bullet.get(j).direc==4) {
					bullet.get(j).x+=bullet.get(j).speed;
				}

         }
	}
	public static void check_hit(){
		for(int i = 0;i<3;i++) {
			if(bullet.get(j).x-4 == Enemy.e[i].x && bullet.get(j).y-4 == Enemy.e[i].y) {
				hit[i] = 1;
				Enemy.count++;
				points++;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

graphics.java

import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class graphics extends JPanel {
	
	 	static final int WINDOW_WIDTH = 820, WINDOW_HEIGHT = 820;

	 	static Tank tank = new Tank(400, 400, 5, Color.cyan,4, 20, 0, 0);
	 	
	    public void paintComponent(Graphics g){
	    	
	        //draw the background,
	        g.setColor(Color.GRAY);
	        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	        //draw bullets if there
	        draw_bullets(g);
	        //draw countdown
		    GM.paint(g);
		    //draw the player
	        tank.paint(g);  
	        
	        Enemy.paint(g);
	        
	       
	       
	    }
	    
	    public static void draw_bullets(Graphics g) {
	    	main.bullet.get(main.j).paint(g);
	        try {
	        main.bullet.get(main.j-1).paint(g);
	        }catch(Exception e) {
	        	
	        }
	        try {
		        main.bullet.get(main.j-2).paint(g);
		        }catch(Exception e) {
		        	
		        }
	        try {
		        main.bullet.get(main.j-3).paint(g);
		        }catch(Exception e) {
		        	
		        }
	        
	    }   
	    
}

GM.java

import java.awt.*;
import java.awt.Graphics;


public class GM {
	public static void paint(Graphics g){
		
	    //draw the countdown component
		
	    if(main.cooldown<=40) {
		g.setColor(Color.DARK_GRAY);
	    g.fillOval(10,10,20,20);
	    }
	    if(main.cooldown>40) {
	    	g.setColor(Color.green);
		    g.fillOval(10,10,20,20);
	    	}
	    
	    String numberString = Integer.toString(main.points);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString(numberString, 770, 30); 
		}
	}


Tank.java

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Tank {
	//constants needed for the constructor
	static int x;
	static int y;
	static int cx;
	static int cy;
	static int bullets;
	Color color;
	int size;
	static int direc;
	public Tank(int x,int y, int bullets, Color color,int direc, int size,int cx,int cy) {
		Tank.x = x;
		Tank.y = y;
		Tank.bullets = bullets;
		this.color = color;
		this.size = size;
		Tank.cy = cy;
		Tank.cx = cx;
		Tank.direc = direc;
	}
	//paint method for the player
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		 AffineTransform originalTransform = g2d.getTransform();
		//main Body
	    //g.setColor(Color.BLACK);
	    //g.fillRect(x-4,y-3,size+10,size+20);
	    
	    g.setColor(color);
	    g.fillOval(x, y, size, size);
	    
	    //KANONENROHR!!!! with the direction the tank is looking to 
	    if(direc==1) {
	    	double angleInRadians = Math.toRadians(0);
		    g2d.translate(x+8, y+8);
		    g2d.rotate(angleInRadians);
		    g.setColor(Color.DARK_GRAY);
		    g2d.fillRect(0,0,4,24);
		   
	    }
	    else if(direc==2) {
	    	double angleInRadians = Math.toRadians(90.0);
		    g2d.translate(x+8, y+8);
		    g2d.rotate(angleInRadians);
		    g.setColor(Color.DARK_GRAY);
		    g2d.fillRect(0,-4,4,24);
		   
	    }
	    else if(direc==3) {
	    	double angleInRadians = Math.toRadians(180.0);
		    g2d.translate(x+8, y+8);
		    g2d.rotate(angleInRadians);
		    g.setColor(Color.DARK_GRAY);
		    g2d.fillRect(-4,-4,4,24);
		   
	    }
	    else if(direc==4) {
	    	double angleInRadians = Math.toRadians(270.0);
		    g2d.translate(x+8, y+8);
		    g2d.rotate(angleInRadians);
		    g.setColor(Color.DARK_GRAY);
		    g2d.fillRect(-4,0,4,24);
		   
	    }
	    g2d.setTransform(originalTransform);

	}
	
}

Bullet.java

import java.awt.*;

public class Bullet {
	int speed;
	int size;
	Color color;
	int x;
	int y;
	boolean fly;
	int direc;
	public Bullet(int speed, int size, Color color, int x, int y,boolean fly,int direc) {
		this.speed = speed;
		this.size = size;
		this.color = color;
		this.x = x;
		this.y = y;
		this.fly = fly;
		this.direc = direc;
	}
	//paint function
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;

	    g.setColor(color);
	    g.fillOval(x, y, size, size);

	}
}

Enemy.java

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy {
	static int count = 3;
	int x;
	int y;
	Color color;
	int size;
	static int direc;
	public Enemy(int x,int y, Color color, int size) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		
		
	}
	static Enemy[] e = new Enemy[count];
	
	
	
public static void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		Random r = new Random();
	    //draw the countdown component
		if(count==3) {
			for(int i = 0;i<count;i++) {
				e[i]= new Enemy(0,0,Color.red,20);
				int c = 0;
				c = r.nextInt(2);
				e[i].x = (r.nextInt(39)+1)*20;
				
				e[i].y = (r.nextInt(38)+1)*20;
					if(c==1) {
					e[i].x+=300;
					e[i].y+=300;
					}
					if(c==0) {
						e[i].x-=300;
						e[i].y-=300;
						}

				if(e[i].x<0||e[i].x>=780) {
					i--;
					continue;
				}else if(e[i].y<0||e[i].y>=760) {
					i--;
					continue;
				}
				
				g.setColor(Color.RED);
			    g.fillOval(e[i].x, e[i].y, 20, 20);
				
				
			}
		}
		if(count < 3) {
			for(int i = 0;i<3;i++) {

			    if(main.hit[i]!=1) {
			    	g.setColor(Color.RED);
				    g.fillOval(e[i].x, e[i].y, 20, 20);
			    }
			}
			
			
		}
		if(count==3) {
			count = 0;
			main.hit[0] = 0;
			main.hit[1] = 0;
			main.hit[2] = 0;
		}
	    
	    
		}
}


