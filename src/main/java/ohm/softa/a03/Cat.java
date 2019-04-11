package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {
	private static final Logger logger = LogManager.getLogger();

	// initially, animals are sleeping
	private State state;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	private int time = 0;
	private int timeDigesting = 0;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		this.state = new SleepingState(this.sleep);
	}

	public void tick(){
		logger.info("tick()");

		state = state.tick(this);

		logger.info(state.getClass().getName());

	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");

		// change state and reset the timer
		state = ((HungryState) state).feed(this);
		timeDigesting = 0;
	}

	public boolean isAsleep() { return state instanceof SleepingState;	}

	public boolean isPlayful() {
		return state instanceof PlayfulState ;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof  DigestingState;
	}

	public boolean isDead() { return state instanceof DeathState;	}

	public int getSleep(){
		return this.sleep;
	}

	public int getDigest(){
		return this.digest;
	}

	public int getAwake(){
		return this.awake;
	}

	public String getName(){
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}

}
