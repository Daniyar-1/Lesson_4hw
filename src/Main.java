import java.util.Random;

public class Main {
    static int[] health = {700, 250, 250, 250, 150};
    static int[] hits = {50, 20, 20, 20, 0};
    static String[] hitTypes = {"Physical", "Physical", "Magical", "Pycho", "Medical"};


    public static void main(String[] args) {
        fighting();
    }

    public static void fighting() {
        while (!isFinish()) {
            changeBossDefence();
            round();
            printStatics();

        }
    }

    public static boolean isFinish() {
        if (health[0] <= 0) {
            System.out.println("Heroes Won!");
            return true;
        }
        if (health[1] <= 0 && health[2] <= 0 && health[3] <= 0 && health[4] <= 0) {
            System.out.println("Boss Won");
            return true;
        }
        return false;

    }

    public static void round() {
        for (int i = 1; i <5 ; i++) {
            health[0] = playerHit(i);

        }
        if (health[0] <= 0) {
            return;
        }
        for (int i = 1; i < 5; i++) {
            int newHealth = bossHit(i);
            if(newHealth < 0) {
                health[i] = 0;
            } else {
                health[i] = newHealth;
            }
        }
        for (int i = 1; i < 4; i++) {
            health[i] = treatMedical(i);
        }
    }

    public static int treatMedical(int playerNumber) {
        int treat = 0;
        if (health[4] > 0) {
            treat = 30;
        }
        return health[playerNumber] + treat;
    }

    public static int bossHit(int playerNumber) {
        return health[playerNumber] - hits[0];
    }

    public static int playerHit(int playerNumber) {
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;
        if (hitTypes[0].equals(hitTypes[playerNumber])) {
            System.out.println(hitTypes[playerNumber] + " hits " + hits[playerNumber] * randomInt);
            return health[0] - hits[playerNumber] * randomInt;
        } else {
            return health[0] - hits[playerNumber];
        }
    }

    public static void changeBossDefence() {
        Random random = new Random();
        int randomInt = random.nextInt(3) + 1;
        hitTypes[0] = hitTypes[randomInt];
    }

    public static void printStatics() {
        System.out.println("_____________________");
            System.out.println("Boss health: " + health[0]);
            System.out.println("Warrior health: " + health[1]);
            System.out.println("Magical health: " + health[2]);
            System.out.println("Kinetic health: " + health[3]);
            System.out.println("Medical health: " + health[4]);
            System.out.println("____________________");
        }
    }






