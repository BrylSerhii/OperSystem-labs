import java.util.ArrayList;
import java.util.List;

public class ClockAlgorithm {
    private final List<PageFrame> frames;
    private int pointer;
    private int pageFaults;

    public ClockAlgorithm(int frameCount) {
        this.frames = new ArrayList<>(frameCount);
        this.pointer = 0;
        this.pageFaults = 0;
        for (int i = 0; i < frameCount; i++) {
            frames.add(null);
        }
    }

    public void processPage(int pageNumber) {
        // Перевірка, чи сторінка вже у кадрах
        for (PageFrame frame : frames) {
            if (frame != null && frame.getPageNumber() == pageNumber) {
                frame.setReferenced(true);
                return;
            }
        }

        // Якщо сторінка відсутня, збільшуємо кількість помилок
        pageFaults++;
        replacePage(pageNumber);
    }

    private void replacePage(int pageNumber) {
        while (true) {
            PageFrame currentFrame = frames.get(pointer);

            if (currentFrame == null || !currentFrame.isReferenced()) {
                // Замінюємо кадр
                frames.set(pointer, new PageFrame(pageNumber));
                pointer = (pointer + 1) % frames.size();
                return;
            } else {
                // Скидаємо біт використання та переходимо до наступного
                currentFrame.setReferenced(false);
                pointer = (pointer + 1) % frames.size();
            }
        }
    }

    public int getPageFaults() {
        return pageFaults;
    }

    public void displayFrames() {
        for (PageFrame frame : frames) {
            if (frame != null) {
                System.out.print(frame.getPageNumber() + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }
}
