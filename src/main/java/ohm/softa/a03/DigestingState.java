package ohm.softa.a03;

public class DigestingState extends State {
    private int hungry;

    public DigestingState(int duration, int hungry) {
        super(duration);
        this.hungry = hungry;
    }

    @Override
    State successor(Cat cat) {
        return new PlayfulState(cat.getAwake() - hungry - getTime());
    }
}
