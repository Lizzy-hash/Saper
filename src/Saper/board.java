package Saper;

import java.util.Random;

public class board {

    public cell[][] board;
    protected int width;
    protected int height;
    protected int number_of_bombs;


    public board() {
        Random rand = new Random();
        width = 9;
        height = 9;
        number_of_bombs = 8;

        board = new cell[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (rand.nextInt(100) < 5)
                    board[i][j] = new bomb();
                else board[i][j] = new digit();
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].type() == myType.bomb) continue;

                int sum = 0;

                if (getCell(new coord(i - 1, j - 1)) != null)
                    if (getCell(new coord(i - 1, j - 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i - 1, j)) != null)
                    if (getCell(new coord(i - 1, j)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i - 1, j + 1)) != null)
                    if (getCell(new coord(i - 1, j + 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i, j - 1)) != null)
                    if (getCell(new coord(i, j - 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i, j + 1)) != null)
                    if (getCell(new coord(i, j + 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i + 1, j - 1)) != null)
                    if (getCell(new coord(i + 1, j - 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i + 1, j)) != null)
                    if (getCell(new coord(i + 1, j)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i + 1, j + 1)) != null)
                    if (getCell(new coord(i + 1, j + 1)).type() == myType.bomb)
                        sum++;

                board[i][j].setNeighbors(sum);

            }
        }
    }

    public board(level_info level) {
        Random rand = new Random();
        width = level.width;
        height = level.height;
        number_of_bombs = level.number_of_bombs;

        board = new cell[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (rand.nextInt(100) < 5)
                    board[i][j] = new bomb();
                else board[i][j] = new digit();
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].type() == myType.bomb) continue;

                int sum = 0;

                if (getCell(new coord(i - 1, j - 1)) != null)
                    if (getCell(new coord(i - 1, j - 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i - 1, j)) != null)
                    if (getCell(new coord(i - 1, j)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i - 1, j + 1)) != null)
                    if (getCell(new coord(i - 1, j + 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i, j - 1)) != null)
                    if (getCell(new coord(i, j - 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i, j + 1)) != null)
                    if (getCell(new coord(i, j + 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i + 1, j - 1)) != null)
                    if (getCell(new coord(i + 1, j - 1)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i + 1, j)) != null)
                    if (getCell(new coord(i + 1, j)).type() == myType.bomb)
                        sum++;

                if (getCell(new coord(i + 1, j + 1)) != null)
                    if (getCell(new coord(i + 1, j + 1)).type() == myType.bomb)
                        sum++;

                board[i][j].setNeighbors(sum);

            }
        }
    }

    board(int height, int width, int number_of_bombs) {
        this.height = height;
        this.width = width;
        this.number_of_bombs = number_of_bombs;

        board = new cell[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) board[i][j] = new bomb();
        }
    }

    public int getWidth() {
        return width;
    }

    public void uncoverAll() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].covered = false;
            }
        }

    }

    public int getHeight() {
        return height;
    }

    public cell getCell(coord position) {
        if (position.h < 0 || position.h >= height || position.w < 0 || position.w >= width) {
            return null;
        }

        return board[position.h][position.w];
    }

    public void set_flag(coord position) {
        getCell(position).toggle_flag();
    }

    public final void player_action(player_action type_of_click, coord position) {

    }

    public void propagate(coord position) {
        getCell(position).uncover();
        if (getCell(position).getNeighbors() != 0) return;

        if (getCell(new coord(position.h - 1, position.w - 1)) != null)
            if(getCell(new coord(position.h - 1, position.w - 1)).covered)
                uncover(new coord(position.h - 1, position.w - 1));

        if (getCell(new coord(position.h - 1, position.w)) != null)
            if(getCell(new coord(position.h - 1, position.w )).covered)
                uncover(new coord(position.h - 1, position.w));

        if (getCell(new coord(position.h - 1, position.w + 1)) != null)
            if(getCell(new coord(position.h - 1, position.w + 1)).covered)
                uncover(new coord(position.h - 1, position.w + 1));

        if (getCell(new coord(position.h, position.w - 1)) != null)
            if(getCell(new coord(position.h , position.w - 1)).covered)
                uncover(new coord(position.h, position.w - 1));

        if (getCell(new coord(position.h, position.w + 1)) != null)
            if(getCell(new coord(position.h , position.w + 1)).covered)
                uncover(new coord(position.h, position.w + 1));

        if (getCell(new coord(position.h + 1, position.w - 1)) != null)
            if(getCell(new coord(position.h + 1, position.w - 1)).covered)
                uncover(new coord(position.h + 1, position.w - 1));


        if (getCell(new coord(position.h + 1, position.w)) != null)
            if(getCell(new coord(position.h + 1, position.w )).covered)
                uncover(new coord(position.h + 1, position.w));

        if (getCell(new coord(position.h + 1, position.w + 1)) != null)
            if(getCell(new coord(position.h + 1, position.w + 1)).covered)
                uncover(new coord(position.h + 1, position.w + 1));

    }

    public game_state uncover(coord position) {


        if (getCell(position).is_flag) return game_state.in_game;
        if (getCell(position).type() == myType.bomb)  return game_state.lost;
        if (getCell(position).uncover()) propagate(position);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
               if( board[i][j].covered && board[i][j].type() != myType.bomb) return game_state.in_game;

            }
        }
        return game_state.won;
    }


}
