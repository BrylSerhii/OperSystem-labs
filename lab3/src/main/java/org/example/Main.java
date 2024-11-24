public class Main {
    public static void main(String[] args) {
        int[] referenceSequence = {1, 3, 0, 3, 5, 6, 3, 1, 2, 0, 1}; // Приклад послідовності
        int frameCount = 3; // Кількість кадрів

        PageReplacementSimulator simulator = new PageReplacementSimulator(frameCount);
        simulator.runSimulation(referenceSequence);
        simulator.displayResults();
    }
}
