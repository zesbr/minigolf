package minigolf.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import minigolf.domain.Level;
import minigolf.domain.Player;
import minigolf.game.Game;

public class Scorecard extends JPanel {
    
    private Game game;
    private ActionListener handler;
     
    private JPanel menuPanel;
    private JLabel title;
    private JButton quitButton;
    private JTable scores;
    private JButton continueButton;

    public Scorecard(Game game, ActionListener handler) {
        super();
        this.game = game;
        this.handler = handler;
         
        this.menuPanel = new JPanel();
        
        ArrayList<Level> levels = game.getAllLevels();
        ArrayDeque<Player> players = game.getAllPlayers();
        String[] columns = getColumns(levels);
        Object[][] rows = getRows(levels, players);
        this.scores = new JTable(rows, columns);
        this.continueButton = new JButton("CONTINUE");
        this.handler = handler;
        
        init();
        addComponents();
    }
    
    private void init() {
        
        // Pohja
        setLayout(new BorderLayout());
        //setLayout(new GridBagLayout());  
        setBackground(new Color(138, 224, 0));
        
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        //menuPanel.setAlignmentX(CENTER_ALIGNMENT);
        //menuPanel.setAlignmentY(TOP_ALIGNMENT);
        // menuPanel.setBounds(0, 0, 400, 400);
        menuPanel.setOpaque(false);
        
        // Alustaa taulukon ylärivin
        initTableHeader();
        
        scores.setFont(new Font("Liberations Sans", Font.BOLD, 14));
        scores.setRowHeight(32);
        scores.setOpaque(false);
        // scores.setGridColor(new Color(138, 224, 0));
        scores.setAlignmentX(CENTER_ALIGNMENT);
        scores.setAlignmentY(CENTER_ALIGNMENT);
        scores.setShowGrid(false);
        
        // Keskittää solun tekstit
        centralAlignCells();
        
        // Continue painike
        continueButton.setFont((new Font("Liberation Sans", Font.BOLD, 20)));
        continueButton.setAlignmentX(CENTER_ALIGNMENT);
        continueButton.setBackground(Color.WHITE);
        continueButton.setForeground(Color.WHITE);
        continueButton.setOpaque(false);
        continueButton.setBorderPainted(false);
        continueButton.setMargin(new Insets(10, 20, 10, 20));
        continueButton.setFocusPainted(false);
        
        // Tapahtumakuuntelija (ViewManager)
        continueButton.addActionListener(handler);
        
    }
    
    // Palauttaa taulukon sarakkeet
    private  String[] getColumns(ArrayList<Level> levels) {
        String[] columns = new String[levels.size()+2];
        int col = 0;
        columns[col] = "HOLE";
        col++;
        for (Level level : levels) {
            columns[col] = level.getName();
            col++;
        }
        columns[col] = "TOTAL";
        return columns;
    }
    
    // Palauttaa taulukon rivit
    private Object[][] getRows(ArrayList<Level> levels, ArrayDeque<Player> players) {
        Object[][] rows = new Object[players.size()][levels.size()+2];
        int row = 0;
        for (Player player : players) {
            int col = 0;
            int total = 0;
            rows[row][col] = player.getName();
            col++;
            for (Level level : levels) {
                int score = player.getScore(level);
                if (score == -1) {
                    rows[row][col] = "-";
                } else {
                    rows[row][col] = score;
                    total += score;
                }
                col++;
            }
            rows[row][col] = total;
            row++;
        }
        return rows;
    }
    
    // Alustaa taulukon ylärivin
    private void initTableHeader() {
        JTableHeader header = scores.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setOpaque(false);
        header.setFont(new Font("Liberation Sans", Font.BOLD, 16));
        scores.setTableHeader(header);
    }
    
    // Keskittää taulukonsolujen tekstikentät
    private void centralAlignCells() {
        for (int i = 0; i < scores.getColumnCount(); i++) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            scores.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);  
        }
    }
    
    
    private void addComponents() {
        
        menuPanel.add(scores.getTableHeader());
        menuPanel.add(scores);
        menuPanel.add(continueButton);
        
        add(menuPanel);

        
    }
    
}