package com.in28minutes.microservices.testes;

import com.in28minutes.microservices.testes.models.Player;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        return player1.getScore() == player2.getScore()
                ? player1.getName().compareTo(player2.getName())
                : Integer.valueOf(player2.getScore()).compareTo(player1.getScore());
    }
}