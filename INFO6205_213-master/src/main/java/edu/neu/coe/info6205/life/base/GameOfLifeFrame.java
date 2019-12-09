package edu.neu.coe.info6205.life.base;

;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;


public class GameOfLifeFrame extends JFrame {

    private JButton openFileBtn = new JButton("Choose pattern");
    private JButton startGameBtn = new JButton("Start");
    private boolean isStart = false;
    private boolean stop = false;

    private UseCaseMatrix cellMatrix;
    private JPanel jPanel = new JPanel(new GridLayout(2, 2));
    private JPanel gridPanel = new JPanel();

    private JTextField[][] textMatrix;

    private static final int DEFAULT_DURATION = 200;
    private int duration = DEFAULT_DURATION;

    public GameOfLifeFrame() {
        setTitle("GameOfLife");
        openFileBtn.addActionListener(new OpenFileActioner());
        startGameBtn.addActionListener(new StartGameActioner());

        jPanel.add(openFileBtn);
        jPanel.add(startGameBtn);

        jPanel.setBackground(Color.WHITE);

        getContentPane().add("North", jPanel);

        this.setSize(800, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private class OpenFileActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser jFileChooser = new JFileChooser(".");
            jFileChooser.setDialogTitle("choose your pattern");
            int returnVal = jFileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                isStart = false;
                stop = true;
                startGameBtn.setText("Start");

                String filepath = jFileChooser.getSelectedFile().getPath();
                cellMatrix = Utils.initMatrixFromFile(filepath);
                initGridLayout();
                showMatrix();
                gridPanel.updateUI();
            }
        }


    }

    private void showMatrix() {

        int[][] matrix = cellMatrix.getMatrix();
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    textMatrix[y][x].setBackground(Color.BLACK);
                } else {
                    textMatrix[y][x].setBackground(Color.WHITE);
                }
            }  
        }
    }
    private void initGridLayout() {
        int rows = cellMatrix.getHeight();
        int cols = cellMatrix.getWidth();
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        textMatrix = new JTextField[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                JTextField text = new JTextField();
                textMatrix[y][x] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
    }


    private class StartGameActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isStart) {
                new Thread(new GameControlTask()).start();
                isStart = true;
                stop = false;
                startGameBtn.setText("suspend");
            } else {
                stop = true;
                isStart = false;
                startGameBtn.setText("start");
            }
        }
    }

    private class GameControlTask implements Runnable {

        @Override
        public void run() {
            while (!stop) {
                cellMatrix.transform();
                showMatrix();
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

}
