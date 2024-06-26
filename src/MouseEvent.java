// Java. Полное руководство - Г.Шилдт
// Обработка событий мыши
// стр. 959

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseEvent extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0;

    public MouseEvent() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter1());
    }

    // Обработать щелчок кнопкой мыши
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        msg = msg + " -- click received";
        repaint();
    }

    //Обработать нажатие кнопки мыши
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // сохранить координаты
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down";
        repaint();
    }

    //Обработать отпускание кнопки мыши
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button released";
        repaint();
    }

    //Обработать наведение на окно указателя мыши
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered";
        repaint();
    }

    //Обработать покидание окна указателем мыши
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited";
        repaint();
    }

    //Обработать перетаскивание указателя мыши
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*" + " mouse at " + mouseX + ", " + mouseY;
        repaint();
    }

    //Обработать перемещение указателя мыши
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        msg = "Moving mouse at " + e.getX() + ", " + e.getY();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args) {
        MouseEvent me = new MouseEvent();
        me.setSize(new Dimension(300, 300));
        me.setTitle("Mouse Event");
        me.setVisible(true);
    }
}

class MyWindowAdapter1 extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}