package sk.stuba.fei.uim.oop.frontend;

import sk.stuba.fei.uim.oop.MazeGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AskFrame extends JFrame {
    public AskFrame(){
        JTextField askSize = new JTextField(30);
        JTextField askCellSize = new JTextField(30);
        JButton button = new JButton("Confirm");
        JLabel info = new JLabel("");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String size = askSize.getText();
                String cellSize = askCellSize.getText();
                int prve = 0;
                int druhe  = 0;


                try {
                    prve = Integer.parseInt(size);
                    druhe = Integer.parseInt(cellSize);
                    if(prve<5 || druhe <5){
                        prve = Integer.parseInt("b");
                    }
                    else{
                        MazeGame game = new MazeGame(prve,druhe);
                        dispose();
                    }
                } catch (NumberFormatException nfe) {
                    askSize.setText("");
                    askCellSize.setText("");
                    info.setText("Size must be 5+");
                }

            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(new JLabel("Maze size: "));
        panel.add(askSize);
        panel.add(new JLabel("Cell size: "));
        panel.add(askCellSize);
        panel.add(info);
        panel.add(button);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setTitle("Richard's maze settings");
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    }

}
