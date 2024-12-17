public class Player {
    private String name;
    private String job;
    private int health = 100;
    private int score = 0;
    private double difficulty; // determined by job
    private int food = 0;
    private int money = 0;
    private int clothes = 1;

    // Constructor
    public Player(String name, String job) {
        this.name = name;
        this.job = job;
        if (job == "Banker")
            this.difficulty = 1;
        if (job == "Carpenter")
            this.difficulty = 1.5;
        if (job == "Farmer")
            this.difficulty = 2;
    }

    @Override
    public String toString() {
        String s = "Hello, " + name + ". You have selected to be a " + job + " with difficulty " + difficulty + ".";
        return s;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getClothes() {
        return clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }
}
