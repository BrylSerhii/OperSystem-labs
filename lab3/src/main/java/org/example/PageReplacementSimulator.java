import java.util.List;

public class PageReplacementSimulator {
    private final ClockAlgorithm clockAlgorithm;

    public PageReplacementSimulator(int frameCount) {
        clockAlgorithm = new ClockAlgorithm(frameCount);
    }

    public void runSimulation(int[] referenceSequence) {
        for (int page : referenceSequence) {
            clockAlgorithm.processPage(page);
        }
    }

    public void displayResults() {
        System.out.println("Final Page Frames:");
        clockAlgorithm.displayFrames();
        System.out.println("Page Faults: " + clockAlgorithm.getPageFaults());
    }
}
