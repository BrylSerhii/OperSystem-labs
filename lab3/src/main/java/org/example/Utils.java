import java.util.Random;

public class Utils {
    public static int[] generateReferenceSequence(int length, int maxPageNumber) {
        Random random = new Random();
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = random.nextInt(maxPageNumber + 1);
        }
        return sequence;
    }
}
