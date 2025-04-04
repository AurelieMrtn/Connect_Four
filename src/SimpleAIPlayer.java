import java.util.Scanner;
import java.util.Random;

public class SimpleAIPlayer extends Player {
    private Random random;

    protected SimpleAIPlayer(char symbol) {
        super("SimpleAI", symbol);
        this.random = new Random();
    }

    @Override
    protected int chooseColumn(Scanner scanner) {
        return random.nextInt(7);
    }
}
