import java.util.Scanner;
import java.util.Random;

public class SimpleMachinePlayer extends Player {
    private Random random;

    protected SimpleMachinePlayer(char symbol) {
        super("SimpleAI", symbol);
        this.random = new Random();
    }

    @Override
    protected int chooseColumn(Scanner scanner) {
        return random.nextInt(7);
    }
}
