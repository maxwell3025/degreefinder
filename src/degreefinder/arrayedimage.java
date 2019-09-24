package degreefinder;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class arrayedimage extends JFrame {
	private Color[][] display = new Color[1000][1000];

	public arrayedimage() {
		for (int q = 0; q < 1000; q++) {
			for (int w = 0; w < 1000; w++) {
				display[q][w] = Color.GRAY.darker();
			}
		}
	}

	public void paint(Graphics g) {
		draw();

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				g.setColor(display[i][j]);
				g.drawRect(i, j, 0, 0);
				display[i][j]=Color.GRAY.darker();
			}
		}
	}

	public abstract void draw();

	public void drawLine(int x1, int y1, int x2, int y2) {
		for (int s = 0; s < 1000; s++) {
			display[x1 + (int) ( ((double)(x2 - x1) / 1000) * s)][y1
					+ (int) ( ((double)(y2 - y1) / 1000) * s)] = Color.GRAY.brighter();
		}
	}
}
