package wildwestshootout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import pelituotanto.Interface;

/**
 * asdf
 * @author s1200478
 */

public class MainMenu extends JFrame {
    
    private MainMenu ikkuna;
    private JPanel Pohja = new JPanel(new GridLayout(4,6,5,5));
    
    private JButton btAloita = new JButton("Aloita peli");
    private JButton btAsetukset = new JButton("Asetukset");
    private JButton btTekijat = new JButton("Tekijät");
    private JButton btLopeta = new JButton("Lopeta");
    
    public MainMenu(){
        this.setTitle("Wild West Shootout!");
        this.setSize(260, 300);
        this.setLocation(550, 250);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asettelu();
        this.setVisible(true);
    }
    
    private void asettelu(){
        Pohja.add(btAloita);
        Pohja.add(btAsetukset);
        Pohja.add(btTekijat);
        Pohja.add(btLopeta);
        
        //Napin tekstin väri
        btAloita.setForeground(Color.BLACK);
        btAsetukset.setForeground(Color.BLACK);
        btTekijat.setForeground(Color.BLACK);
        btLopeta.setForeground(Color.BLACK);
        
        //Napin taustan väri
        btAloita.setBackground(Color.GRAY);
        btAsetukset.setBackground(Color.GRAY);
        btTekijat.setBackground(Color.GRAY);
        btLopeta.setBackground(Color.GRAY);
        
        Pohja.setBackground(Color.BLACK);
        this.add(Pohja);
        
        btAloita.addActionListener(new lAloita());
        btAsetukset.addActionListener(new lAsetukset());
        btTekijat.addActionListener(new lTekijat());
        btLopeta.addActionListener(new lLopeta());
    }
    //toinen muutos
    //muutos2
    class lAloita implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            Game game = new Game();
            game.frame.setResizable(false);
            game.frame.setTitle(Game.title);
            game.frame.add(game);
            game.frame.pack();
            game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.frame.setLocationRelativeTo(null);
            game.frame.setVisible(true);

            game.start();
        }
    }
    
    class lAsetukset implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(rootPane, "Ei vielä käytössä", "Ilmoitus", WIDTH);
        }
    }
    
    class  lTekijat implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(rootPane, "Sami Nurmivaara\nJesse Vuori\nToni Liivola\nVille Vihervaara\nVille Henriksson", "Tekijät", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    class lLopeta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        MainMenu ikkuna = new MainMenu();
    }
}
