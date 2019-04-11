package ohm.softa.a03;

public class HungryState extends State {
    public HungryState(int duration) {
        super(duration);
    }

    @Override
    State successor(Cat cat) {
        return new DeathState();
    }

    State feed(Cat cat){
        return new DigestingState(cat.getDigest(), getTime());
    }
}
