package Saper;

abstract class cell  {
    public boolean is_flag;

    protected boolean covered;

    public cell() {
        is_flag = false;
        covered = true;
    }

    public abstract void setNeighbors(int bombs);
    public abstract int getNeighbors();
    public abstract myType type();

    public abstract boolean user_press();

    public abstract icon get_icon();

    public void toggle_flag() {
        if(covered) is_flag = !is_flag;
    }

    ///safe cell click
    public abstract boolean uncover();
}
