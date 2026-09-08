import java.util.Arrays;
import java.util.Random;

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        // Randomly place bears and fishes
        for (int i = 0; i < Math.round(riverSize/random.nextDouble(2,5)); i++) {
            int type = i % 2;
            boolean spawned = false;

            do {
                int randomCell = random.nextInt(riverSize);

                if (river[randomCell] == null) {
                    switch(type) {
                        case 0 -> {
                            river[randomCell] = new Bear();

                        }
                        case 1 -> river[randomCell] = new Fish();
                    }
                    spawned = true;
                }
            } while(!spawned);
        }
    }

    public void runStep() {
        Animal[] newRiver = river.clone();

        // Get the animals' original indexes
        for (int i = 0; i < river.length; i++) {
            if (newRiver[i] instanceof Bear && !((Bear) newRiver[i]).isMoved()) {
                int move = random.nextInt(3);

                switch (move) {
                    // Move Left
                    case 1 -> {
                        // Check if bear tries to move out of bounds
                        if ((i - 1) >= 0) {
                            // Check if bear collides with fish
                            if (newRiver[i-1] instanceof Fish) {
                                newRiver[i] = null;
                                newRiver[i-1] = null;
                                newRiver[i-1] = new Bear(true);
                            }
                            // Check if bear collides with bear
                            else if (newRiver[i-1] instanceof Bear) {
                                // Randomly spawn a bear
                                boolean spawned = false;

                                do {
                                    int randomCell = random.nextInt(river.length);

                                    if (newRiver[randomCell] == null) {
                                        newRiver[randomCell] = new Bear(true);
                                        spawned = true;
                                    }
                                } while(!spawned);
                            }
                            else {
                                newRiver[i] = null;
                                newRiver[i-1] = new Bear(true);
                            }
                        }
                    }
                    // Move Right
                    case 2 -> {
                        if ((i + 1) < river.length) {
                            // Check if bear collides with fish
                            if (newRiver[i+1] instanceof Fish) {
                                newRiver[i] = null;
                                newRiver[i+1] = null;
                                newRiver[i+1] = new Bear(true);
                            }
                            // Check if bear collides with bear
                            else if (newRiver[i+1] instanceof Bear) {
                                // Randomly spawn a bear
                                boolean spawned = false;

                                do {
                                    int randomCell = random.nextInt(river.length);

                                    if (newRiver[randomCell] == null) {
                                        newRiver[randomCell] = new Bear(true);
                                        spawned = true;
                                    }
                                } while(!spawned);
                            }
                            else {
                                newRiver[i] = null;
                                newRiver[i+1] = new Bear(true);
                            }
                        }
                    }
                }
            }
            else if (newRiver[i] instanceof Fish && !((Fish) newRiver[i]).isMoved()) {
                int move = random.nextInt(3);

                switch (move) {
                    // Move Left
                    case 1 -> {
                        // Check if fish tries to move out of bounds
                        if ((i - 1) >= 0) {
                            // Check if fish collides with bear
                            if (newRiver[i-1] instanceof Bear) {
                                newRiver[i] = null;
                            }
                            // Check if fish collides with fish
                            else if (newRiver[i-1] instanceof Fish) {
                                // Randomly spawn a fish
                                boolean spawned = false;

                                do {
                                    int randomCell = random.nextInt(river.length);

                                    if (newRiver[randomCell] == null) {
                                        newRiver[randomCell] = new Fish(true);
                                        spawned = true;
                                    }
                                } while(!spawned);
                            }
                            else {
                                newRiver[i] = null;
                                newRiver[i-1] = new Fish(true);
                            }
                        }
                    }
                    // Move Right
                    case 2 -> {
                        if ((i + 1) < river.length) {
                            // Check if bear collides with fish
                            if (newRiver[i+1] instanceof Bear) {
                                newRiver[i] = null;
                            }
                            // Check if bear collides with bear
                            else if (newRiver[i+1] instanceof Fish) {
                                // Randomly spawn a bear
                                boolean spawned = false;

                                do {
                                    int randomCell = random.nextInt(river.length);

                                    if (newRiver[randomCell] == null) {
                                        newRiver[randomCell] = new Fish(true);
                                        spawned = true;
                                    }
                                } while(!spawned);
                            }
                            else {
                                newRiver[i] = null;
                                newRiver[i+1] = new Fish(true);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < river.length; i++) {
            river[i] = null;

            if (newRiver[i] instanceof Bear) {
                river[i] = new Bear();
            }
            else if (newRiver[i] instanceof Fish) {
                river[i] = new Fish();
            }
        }
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(25); // Create a river of size 20
        eco.visualize();

        for (int i = 1; i <= 10; i++) {
            eco.runStep();
            eco.visualize();
        }
    }
}
