package Saper;

public class digit extends cell{
    protected int neighbors;

    digit(){
        super();
        neighbors = 0;
    }

    @Override
    public void setNeighbors(int bombs){
        assert(bombs<9);

        neighbors = bombs;
    }

    @Override
    public myType type() {
        return myType.digit;
    }

    @Override
    public int getNeighbors(){
        return neighbors;
    }

    @Override
    public boolean user_press(){
       if(!is_flag) {
           uncover();
           return true;
       }
        else return false;
    }

    @Override
    public icon get_icon(){
        if(is_flag) return icon.flag;
        if(covered) return icon.covered;
         switch(neighbors) {
             case 0:
                 return icon.zero;
             case 1:
                 return icon.one;
             case 2:
                 return icon.two;
             case 3:
                 return icon.three;
             case 4:
                 return icon.four;
             case 5:
                 return icon.five;
             case 6:
                 return icon.six;
             case 7:
                 return icon.seven;
             case 8:
                 return icon.eight;
         }

         assert(false);
         return icon.bomb;
    }

    @Override
    public boolean uncover(){

        is_flag = false;
        covered = false;

        if(neighbors == 0) return true;
        else return false;
    }

}
