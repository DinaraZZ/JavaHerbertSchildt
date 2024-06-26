// Java. Полное руководство - Г.Шилдт
// Обработка событий клавиатуры
// стр. 962

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KeyEvent extends Frame implements KeyListener {
    String msg = "";
    String keyState = "";

    public KeyEvent() {
        addKeyListener((KeyListener) this);
        addWindowListener(new MyWindowAdapter() {
        });
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        keyState = "Key Up";
        repaint();
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        keyState = "Key Down";
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        KeyEvent ke = new KeyEvent();
        ke.setSize(new Dimension(200, 150));
        ke.setTitle("SimpleKey");
        ke.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}