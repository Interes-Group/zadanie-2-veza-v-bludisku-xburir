package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsScreen extends JPanel implements ActionListener {

    public ButtonsScreen(){
        setLayout(new GridLayout(2,3));
        add(new JLabel("Counter"));
        JButton up = new JButton("Up");
        JButton right = new JButton("Right");
        JButton left = new JButton("Left");
        JButton down = new JButton("Down");
        JButton reset = new JButton("RESET");

        reset.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);


        add(up);
        add(reset);
        add(left);
        add(down);
        add(right);

    }

    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand()+" called");
        if(e.getActionCommand().equals("RESET")){
            //new maze

        }
    }




}
