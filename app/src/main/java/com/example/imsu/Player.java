package com.example.imsu;

public class Player {
    private int playerID;
    private String playerName;
    private int playerScore;
    private int levelScore;
    private int currentLevel;
    private int totalScore;
    private static Player playerSingleton;

    private Player() {
        super();
    }

    public static Player getInstance() {
        if (playerSingleton == null) {
            synchronized (Player.class) {
                playerSingleton = new Player();
                System.out.println(Strings.created_player);
            }
        }

        return playerSingleton;
    }

    public Player(int playerID, String playerName, int playerScore, int levelScore, int currentLevel, int totalScore) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.levelScore = levelScore;
        this.currentLevel = currentLevel;
        this.totalScore = totalScore;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getLevelScore() {
        return levelScore;
    }

    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

}
