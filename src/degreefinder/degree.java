package degreefinder;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class degree extends arrayedimage implements MouseMotionListener,
		Runnable {
	private double degreesofclick;
	private double paneposx;
	private double paneposy;
	private int oldx;
	private int newx;
	private int oldy;
	private int newy;

	public degree() {
		addMouseMotionListener(this);
		setSize(1000, 1000);
		setVisible(true);

	}

	public void draw() {
		for (int mult = 1; mult < 500; mult++) {
			drawLine(oldx, oldy, newx, newy );
			oldx = newx;
			oldy = newy;

			newx = (int) (Math.sin(degreesofclick * mult) * 1 * mult) + 500;
			newy = (int) (Math.cos(degreesofclick * mult) * 1 * mult) + 500;

		}
		oldx = 500;
		oldy = 500;
		newx = 500;
		newy = 500;

	}

	public static void main(String[] args) {
		degree d = new degree();
		new Thread(d).start();

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void run() {
		for (;;) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			degreesofclick=degreesofclick+0.001;
			repaint();
		}

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		paneposx = e.getX() - 500;
		paneposy = e.getY() - 500;
		degreesofclick = Math.atan(paneposx / paneposy);
		if (paneposy < 0) {
			degreesofclick = degreesofclick + Math.PI;
		}
		repaint();
	}

}
