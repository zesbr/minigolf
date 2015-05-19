package com.minigolf.game;


import com.minigolf.gui.GraphicalUserInteface;
import com.minigolf.domain.*;
import java.util.*;
import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {  
        System.out.println("Initializing game ...");
        ArrayList<Player> players = createSingleTestPlayer();
        Minigolf minigolf = new Minigolf(players);
        
        // Luodaan käyttöliittymä
        GraphicalUserInteface gui = new GraphicalUserInteface(minigolf); 
        SwingUtilities.invokeLater(gui);
    }
    
    public static ArrayList<Player> createPlayers() {
        Scanner reader = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        int numOfPlayers = 0;
        while (true) {
            System.out.println("How many players: ");
            numOfPlayers = Integer.parseInt(reader.nextLine());
            if (numOfPlayers > 0 && numOfPlayers < 5) {
                break;
            }
        }
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.println("Enter name for player " + i + ":");
            String name = reader.nextLine();
            players.add(new Player(i, name));
        }
        return players;
    }
    
    public static ArrayList<Player> createSingleTestPlayer() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player(1, "John"));
        return players;
    }
    
    public static void printGameWorld(Minigolf minigolf) {
       for (int i = 0; i < minigolf.getLevel().getHeight(); i++) {
            for (int j = 0; j < minigolf.getLevel().getWidth(); j++) {
                if (i == minigolf.getBall().getY() && j == minigolf.getBall().getX()) {
                    System.out.print("o");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        } 
    }
      
}
