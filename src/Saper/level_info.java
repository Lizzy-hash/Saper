package Saper;

public class level_info {
    int width;
    int height;

    int number_of_bombs;

    level_info(int w, int h, int bomb) {
        this.height = h;
        this.width = w;
        this.number_of_bombs = bomb;
    }
}
