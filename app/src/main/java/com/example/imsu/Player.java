package com.example.imsu;

public class Player {
    private String playerName;
    private String playerScore;
    private static Player playerSingleton;

    public static Player getInstance() {
        if (playerSingleton == null) {
            synchronized (Player.class) {
                playerSingleton = new Player();
                System.out.println(Strings.created_player);
            }
        }

        return playerSingleton;
    }

    private Player() {
        super();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(String playerScore) {
        this.playerScore = playerScore;
    }
}
