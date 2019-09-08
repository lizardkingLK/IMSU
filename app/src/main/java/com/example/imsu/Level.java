package com.example.imsu;

public class Level {
    private int levelID;
    private String levelName;
    private String levelScore;

    private Level() {
        super();
    }

    public Level(int levelID, String levelName, String levelScore) {
        this.levelID = levelID;
        this.levelName = levelName;
        this.levelScore = levelScore;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelScore() {
        return levelScore;
    }

    public void setLevelScore(String levelScore) {
        this.levelScore = levelScore;
    }
}
