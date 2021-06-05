package Saper;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class window_ui extends JFrame implements MouseListener {
    board current;
    player_action last_player_action;

    JFrame frame = new JFrame("Saper");
    ControlActionListener cal = new ControlActionListener();
    public static level_info easy = new level_info(9, 9, 10);
    public static level_info medium = new level_info(16, 16, 40);
    public static level_info hard = new level_info(16, 30, 99);

    final String card1Text = "Easy";
    final String card2Text = "Medium";
    final String card3Text = "Hard";
    final JPanel cards;
    final String FIRST = "FIRST";
    final String NEXT = "NEXT";
    final String LAST = "LAST";

    private final JButton[][] button1;
    private final JButton[][] button2;
    private final JButton[][] button3;

    window_ui() {

        current = new board(easy);


        JPanel lvl_easy = new JPanel();
        lvl_easy.setLayout(new GridLayout(current.width, current.height));


        button1 = new JButton[current.width][current.height];

        for (int i = 0; i < current.width; i++) {
            for (int j = 0; j < current.height; j++) {

                button1[i][j] = new JButton("");
                button1[i][j].setSize(20, 20);
                button1[i][j].setBackground(Color.PINK);
                button1[i][j].setMargin(new Insets(50, 50, 50, 50));
                lvl_easy.add(button1[i][j]);
                button1[i][j].setVisible(true);
                button1[i][j].addMouseListener(new MouseAdapter() {
                    long tStart = System.currentTimeMillis();

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                        if (arg0.getButton() == MouseEvent.BUTTON1) {
                            for (int i = 0; i < current.width; i++) {
                                for (int j = 0; j < current.height; j++) {
                                    if (arg0.getSource() == button1[i][j]) {
                                        switch (current.uncover(new coord(i, j))) { ///time 3 minutes
                                            case in_game:
                                                break;
                                            case won:
                                                long time_to_win = 180;
                                                long tEnd = System.currentTimeMillis();
                                                long tDelta = tEnd - tStart;
                                                double elapsedSeconds = tDelta / 1000.0;
                                                long score = (long) (time_to_win - elapsedSeconds);
                                                JOptionPane.showMessageDialog(null, "You won this game! " + '\n' +
                                                        "Score: " + score);

                                                try (FileWriter fw = new FileWriter("myfile.txt", true);
                                                     BufferedWriter bw = new BufferedWriter(fw);
                                                     PrintWriter out = new PrintWriter(bw)) {
                                                    out.println("Easy");

                                                    out.println("Time: " + elapsedSeconds + '\n'
                                                            + "Score: " + score + '\n');

                                                } catch (IOException e) {
                                                }

                                                System.exit(0);
                                                break;
                                            case lost:
                                                JOptionPane.showMessageDialog(null, "You lost this game!");
                                                System.exit(1);
                                                break;
                                        }
                                        System.out.println("row: " + i + " col: " + j);
                                        view();
                                    }
                                }
                            }
                        } else if (arg0.getButton() == MouseEvent.BUTTON3) {
                            for (int i = 0; i < current.width; i++) {
                                for (int j = 0; j < current.height; j++) {
                                    if (arg0.getSource() == button1[i][j]) {
                                        current.set_flag(new coord(i, j));
                                        System.out.println("Right button clicked" + "row: " + i + " col: " + j);
                                        view();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        lvl_easy.setBackground(new Color(0, 0, 0));

        JPanel lvl_medium = new JPanel();
        lvl_medium.setLayout(new GridLayout(current.width, current.height));

        button2 = new JButton[current.width][current.height];

        for (int i = 0; i < current.width; i++) {
            for (int j = 0; j < current.height; j++) {

                button2[i][j] = new JButton("");
                button2[i][j].setSize(20, 20);
                button2[i][j].setBackground(Color.PINK);
                button2[i][j].setMargin(new Insets(50, 50, 50, 50));
                lvl_medium.add(button2[i][j]);
                button2[i][j].setVisible(true);
                button2[i][j].addMouseListener(new MouseAdapter() {
                    long tStart = System.currentTimeMillis();

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                        if (arg0.getButton() == MouseEvent.BUTTON1) {
                            for (int i = 0; i < current.width; i++) {
                                for (int j = 0; j < current.height; j++) {
                                    if (arg0.getSource() == button1[i][j]) {
                                        switch (current.uncover(new coord(i, j))) { ///time 5 minutes
                                            case in_game:
                                                break;
                                            case won:
                                                long time_to_win = 300;
                                                long tEnd = System.currentTimeMillis();
                                                long tDelta = tEnd - tStart;
                                                double elapsedSeconds = tDelta / 1000.0;
                                                long score = (long) (time_to_win - elapsedSeconds);
                                                JOptionPane.showMessageDialog(null, "You won this game! " + '\n' +
                                                        "Score: " + score);

                                                try (FileWriter fw = new FileWriter("myfile.txt", true);
                                                     BufferedWriter bw = new BufferedWriter(fw);
                                                     PrintWriter out = new PrintWriter(bw)) {
                                                    out.println("Easy");

                                                    out.println("Time: " + elapsedSeconds + '\n'
                                                            + "Score: " + score + '\n');

                                                } catch (IOException e) {
                                                }

                                                System.exit(0);
                                                break;
                                            case lost:
                                                JOptionPane.showMessageDialog(null, "You lost this game!");
                                                System.exit(1);
                                                break;
                                        }
                                        System.out.println("row: " + i + " col: " + j);
                                        view();
                                    }
                                }
                            }
                        } else if (arg0.getButton() == MouseEvent.BUTTON3) {
                            for (int i = 0; i < current.width; i++) {
                                for (int j = 0; j < current.height; j++) {
                                    if (arg0.getSource() == button1[i][j]) {
                                        current.set_flag(new coord(i, j));
                                        System.out.println("Right button clicked" + "row: " + i + " col: " + j);
                                        view();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }


        lvl_medium.setBackground(new Color(0, 0, 0));

        JPanel lvl_hard = new JPanel();
        lvl_hard.setLayout(new GridLayout(16, 30));

        button3 = new JButton[16][30];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 30; j++) {

                button3[i][j] = new JButton("");
                button3[i][j].setSize(20, 20);
                button3[i][j].setBackground(Color.PINK);
                button3[i][j].setMargin(new Insets(50, 50, 50, 50));
                lvl_hard.add(button3[i][j]);
                button3[i][j].setVisible(true);
                button3[i][j].addMouseListener(new MouseAdapter() {
                    long tStart = System.currentTimeMillis();

                    @Override
                    public void mousePressed(MouseEvent arg0) {

                        if (arg0.getButton() == MouseEvent.BUTTON1) {
                            for (int i = 0; i < current.width; i++) {
                                for (int j = 0; j < current.height; j++) {
                                    if (arg0.getSource() == button1[i][j]) {
                                        switch (current.uncover(new coord(i, j))) { ///time 7 minutes
                                            case in_game:
                                                break;
                                            case won:
                                                long time_to_win = 420;
                                                long tEnd = System.currentTimeMillis();
                                                long tDelta = tEnd - tStart;
                                                double elapsedSeconds = tDelta / 1000.0;
                                                long score = (long) (time_to_win - elapsedSeconds);
                                                JOptionPane.showMessageDialog(null, "You won this game! " + '\n' +
                                                        "Score: " + score);

                                                try (FileWriter fw = new FileWriter("myfile.txt", true);
                                                     BufferedWriter bw = new BufferedWriter(fw);
                                                     PrintWriter out = new PrintWriter(bw)) {
                                                    out.println("Easy");

                                                    out.println("Time: " + elapsedSeconds + '\n'
                                                            + "Score: " + score + '\n');

                                                } catch (IOException e) {
                                                }

                                                System.exit(0);
                                                break;
                                            case lost:
                                                JOptionPane.showMessageDialog(null, "You lost this game!");
                                                System.exit(1);
                                                break;
                                        }
                                        System.out.println("row: " + i + " col: " + j);
                                        view();
                                    }
                                }
                            }
                        } else if (arg0.getButton() == MouseEvent.BUTTON3) {
                            for (int i = 0; i < current.width; i++) {
                                for (int j = 0; j < current.height; j++) {
                                    if (arg0.getSource() == button1[i][j]) {
                                        current.set_flag(new coord(i, j));
                                        System.out.println("Right button clicked" + "row: " + i + " col: " + j);
                                        view();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        lvl_hard.setBackground(new Color(0, 0, 0));

        cards = new JPanel(new CardLayout());
        cards.add(lvl_easy, card1Text);
        cards.add(lvl_medium, card2Text);
        cards.add(lvl_hard, card3Text);

        add(cards, BorderLayout.CENTER);

        JButton btn1 = new JButton("Easy");
        btn1.setActionCommand(FIRST);
        btn1.addActionListener(cal);

        JButton btn2 = new JButton("Medium");
        btn2.setActionCommand(NEXT);
        btn2.addActionListener(cal);


        JButton btn4 = new JButton("Hard");
        btn4.setActionCommand(LAST);
        btn4.addActionListener(cal);

        JPanel controlButtons = new JPanel();
        controlButtons.add(btn1);
        controlButtons.add(btn2);
        controlButtons.add(btn4);

        Container pane = frame.getContentPane();
        add(cards, BorderLayout.CENTER);
        add(controlButtons, BorderLayout.PAGE_END);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ControlActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            String cmd = e.getActionCommand();
            if (cmd.equals(FIRST)) {
                cl.first(cards);
            } else if (cmd.equals(NEXT)) {
                cl.next(cards);
            } else if (cmd.equals(LAST)) {
                cl.last(cards);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    ///Here are game functions

    public void view() {
        for (int i = 0; i < current.width; i++) {
            for (int j = 0; j < current.height; j++) {
                Color current_cell_color = Color.pink;
                switch (current.getCell(new coord(i, j)).get_icon()) {
                    case flag:
                        current_cell_color = Color.yellow;
                        break;
                    case covered:
                        current_cell_color = Color.lightGray;
                        break;
                    case uncovered:
                        current_cell_color = Color.pink;
                        break;
                    case bomb:
                        current_cell_color = Color.black;
                        break;
                    case zero:
                        current_cell_color = Color.white;
                        break;
                    case one:
                        current_cell_color = new Color(166, 0, 255);
                        break;
                    case two:
                        current_cell_color = new Color(2, 95, 253);
                        break;
                    case three:
                        current_cell_color = new Color(19, 216, 236);
                        break;
                    case four:
                        current_cell_color = new Color(14, 241, 148);
                        break;
                    case five:
                        current_cell_color = new Color(13, 242, 51);
                        break;
                    case six:
                        current_cell_color = new Color(91, 242, 13);
                        break;
                    case seven:
                        current_cell_color = new Color(238, 247, 8);
                        break;
                    case eight:
                        current_cell_color = new Color(244, 116, 11);
                        break;
                }

                button1[i][j].setBackground(current_cell_color);

            }
        }
    }

    public void get_user_action() {
        //last_player_action = get_user_action();
    }

    public void update_board() {
        //if(last_player_action) -> board.player_action()
    }

}
