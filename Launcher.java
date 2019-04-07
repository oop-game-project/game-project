package Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Launcher extends JFrame
{

    private class Records extends JFrame
    {
        public Records()
        {
            super("Рекорды");
            setLayout(new GridLayout(10, 1));
            for (int i = 1; i<=10; i++)
                this.add(new JLabel(Integer.toString(i) + ". --"));
            setSize(500, 500);
            setLocationRelativeTo(null);
            setResizable(false);

            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent e)
                {
                    Launcher.this.setVisible(true);
                    Records.this.dispose();
                }
            });
        }
    }

    public Launcher()
    {
        super("Старт");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2;
        int y = screenSize.height / 2;
        setSize(x, y);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setButtons();

    }

    private void setButtons()
    {   Launcher.this.setLayout(new GridLayout());
        JButton startGame = new JButton(
                new AbstractAction("Начать новую игру")
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        //TODO
                        //Launcher.this.setVisible(false);
                        System.out.print("Запускаемся");
                    }
                }
        );
        JButton continueGame = new JButton(new AbstractAction("Продолжить игру")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //TODO
                //Launcher.this.setVisible(false);
                System.out.print("Продолжаемся");
            }
        });
        JButton records = new JButton(new AbstractAction("Рекорды")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Launcher.this.setVisible(false);
                Records records = new Records();
                records.setVisible(true);
            }
        });
        JButton exitGame = new JButton(new AbstractAction("Выйти")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Launcher.this.setVisible(false);
                Launcher.this.dispose();
            }
        });

        Launcher.this.add(continueGame);
        Launcher.this.add(startGame);
        Launcher.this.add(records);
        Launcher.this.add(exitGame);

    }

    public static void main(String[] args)
    {
        Launcher launcher = new Launcher();
        launcher.setVisible(true);
    }
}