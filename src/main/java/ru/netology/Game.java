package ru.netology;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> registeredPlayers = new ArrayList<>();

    public void registration(Player player) throws NotRegisteredException {

        if (findByName(player.getName()) == null) {
            registeredPlayers.add(player);
        } else {
            throw new NotRegisteredException("A player with the same name already exists");
        }
    }
    public Player findByName(String name) {

        for (int i = 0; i < registeredPlayers.size(); i++) {
            if (registeredPlayers.get(i).getName() == name) {
                return registeredPlayers.get(i);
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = null;
        Player player2 = null;

        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
