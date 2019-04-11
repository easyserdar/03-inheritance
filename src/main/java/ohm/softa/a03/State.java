package ohm.softa.a03;

import java.util.logging.Logger;

public abstract class State {
    protected Logger logger;
    private int t;
    private final int duration;

    public State(int duration){
        this.duration = duration;
    }

    final State tick(Cat cat){
        if (duration < 0){
            return this;
        }

        t = t + 1;

        if(t < duration){
            return this;
        }
        else{
            return successor(cat);
        }
    }

    abstract State successor(Cat cat);

    public int getTime(){
        return t;
    }

    public int getDuration(){
        return duration;
    }

}
