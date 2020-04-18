package life;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameOfLife extends JFrame {
    int n = 20;
    int g = 50;
    Universe universe = new Universe(n);
    UniverseUtil util = new UniverseUtil(universe);
    JPanel mainPanel;
    JPanel upPanel;
    JLabel generationLabel;
    JLabel aliveLabel;
    JToggleButton  playToggleButton;
    JButton resetButton;
    Thread gameThread;
    Boolean pause = true;

    //int n = Main.n;
    public GameOfLife() {
        super("Game Of Life");

        Image playImg = null;
        try {
            playImg = ImageIO.read(new File("C:\\Users\\maslov\\IdeaProjects\\stepik\\src\\main\\resources\\Play.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        playImg = playImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        Image reloadImg = null;
        try {
            reloadImg = ImageIO.read(new File("C:\\Users\\maslov\\IdeaProjects\\stepik\\src\\main\\resources\\reload.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        reloadImg = reloadImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        Image pauseImg = null;
        try {
            pauseImg = ImageIO.read(new File("C:\\Users\\maslov\\IdeaProjects\\stepik\\src\\main\\resources\\pause.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pauseImg = pauseImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setBackground(Color.GRAY);
        setName("Game Of Life");

        util.newGeneration();

        upPanel = new JPanel();
        // upPanel.setBounds(0,0,40,300);
        upPanel.setBackground(Color.GRAY);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);

        playToggleButton = new JToggleButton();
        playToggleButton.setName("PlayToggleButton");
        playToggleButton.setIcon(new ImageIcon(playImg));
        playToggleButton.setMargin(new Insets(0, 0, 0, 0));
        playToggleButton.setSize(5,5);
        buttonPanel.add(playToggleButton);

        resetButton = new JButton();
        resetButton.setName("ResetButton");
        resetButton.setIcon(new ImageIcon(reloadImg));
        resetButton.setMargin(new Insets(0, 0, 0, 0));
        buttonPanel.add(resetButton);
        upPanel.add(buttonPanel);

        JPanel labelPanel = new JPanel();
        //upPanel.setBounds(0,0,300,20);
        labelPanel.setBackground(Color.GRAY);
        // labelPanel.setBounds(5, 5, 60, 20);

        generationLabel = new JLabel("Generation #" + util.getGen());
        generationLabel.setName("GenerationLabel");
        labelPanel.add(generationLabel);
        aliveLabel = new JLabel("Alive: " + util.getAlive());
        aliveLabel.setName("AliveLabel");
        labelPanel.add(aliveLabel);
        //upPanel.setLayout(new GridLayout(2, 1, 1, 1));
        labelPanel.setLayout( new GridLayout(2, 1, 5, 5));
        upPanel.add(labelPanel);
        upPanel.setLayout( new GridLayout(2, 2, 0, 0) /*new BoxLayout(upPanel, BoxLayout.Y_AXIS)*/);
        add(upPanel);

        mainPanel = new JPanel();
        //mainPanel.setBounds(0,40,260,260);
        mainPanel.setBackground(Color.GRAY);


        /*for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                if (universe.getCells()[i][j].isAlive()){
                    panel.setBackground(Color.BLACK);
                }else {
                    panel.setBackground(Color.GRAY);
                }
                mainPanel.add(panel);
            }
        }*/
        JPanel newPanel = new JPanel();
        newPanel.setBounds(0,40,260,260);
        newPanel.setBackground(Color.GRAY);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                if (universe.getCells()[i][j].isAlive()){
                    panel.setBackground(Color.BLACK);
                }else {
                    panel.setBackground(Color.GRAY);
                }

                newPanel.add(panel);
            }
        }
        newPanel.setLayout(new GridLayout(n, n, 0, 0));
        mainPanel.add(newPanel);

        add(mainPanel);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setVisible(true);


        Image finalPauseImg = pauseImg;
        Image finalPlayImg = playImg;
        playToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (pause){
                    pause = false;
                    gameThread = new Thread( new Runnable(){

                        @Override
                        public void run() {
                            while (!pause){
                                updateMain();
                                updateUp();

                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    gameThread.start();

                    playToggleButton.setIcon(new ImageIcon(finalPauseImg));
                    playToggleButton.setMargin(new Insets(0, 0, 0, 0));


                } else {
                    pause = true;
                    //gameThread.interrupt();
                    playToggleButton.setIcon(new ImageIcon(finalPlayImg));
                    playToggleButton.setMargin(new Insets(0, 0, 0, 0));

                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pause = true;
                playToggleButton.setIcon(new ImageIcon(finalPlayImg));
                playToggleButton.setMargin(new Insets(0, 0, 0, 0));
                universe = new Universe(n);
                util = new UniverseUtil(universe);
                updateMain();
                updateUp();
            }
        });


    }

    public void updateUp(){
        generationLabel.setText("Generation #" + util.getGen());
        aliveLabel.setText("Alive: " + util.getAlive());
    }

    public void updateMain(){

        mainPanel.removeAll();
        util.newGeneration();
        JPanel newPanel = new JPanel();
        newPanel.setBounds(0,40,260,260);
        newPanel.setBackground(Color.GRAY);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                if (universe.getCells()[i][j].isAlive()){
                    panel.setBackground(Color.BLACK);
                }else {
                    panel.setBackground(Color.GRAY);
                }

                newPanel.add(panel);
            }
        }
        newPanel.setLayout(new GridLayout(n, n, 0, 0));
        mainPanel.add(newPanel);

        mainPanel.revalidate();
    }
}
