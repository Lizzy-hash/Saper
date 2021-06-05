package Saper;

public class bomb extends cell{

    bomb(){
        super();
    }

    @Override
    public void setNeighbors(int bombs) {
        return;
    }

    @Override
    public boolean user_press(){
        assert(false);
        return false;
    }


    @Override
    public myType type() {
        return myType.bomb;
    }

    @Override
    public int getNeighbors(){
        assert(false);
        return 0;
    }


    @Override
    public icon get_icon(){
        if(is_flag) return icon.flag;
        if(covered) return icon.covered;

        return icon.bomb;

    }

    @Override
    public boolean uncover() {

        return false;
    }

}
