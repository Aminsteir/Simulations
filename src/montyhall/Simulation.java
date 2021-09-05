package montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
	public boolean won = false;

	private final Door[] doors;
	private final Random random;

	public Simulation() {
		doors = new Door[]{
				new Door(),
				new Door(),
				new Door()
		};

		random = new Random();
	}

	public void Simulate() {
		Reset();

		doors[random.nextInt(doors.length)].setPrizeBehind(true);
		Door chosen = doors[random.nextInt(doors.length)];

		Door alt = getRandomNotOpened(chosen, true);
		alt.setOpen(true);

		Door last = getRandomNotOpened(chosen, false);
		won = last.prizeBehind;
	}

	private Door getRandomNotOpened(Door chosen, boolean withPrizeExcluded)
	{
		List<Door> available = new ArrayList<>();

		for (Door door : doors) {
			boolean prizeVal = !withPrizeExcluded || !door.isPrizeBehind();
			if (!door.isOpen() && prizeVal && door != chosen)
				available.add(door);
		}

		return available.get(random.nextInt(available.size()));
	}

	public void Reset()
	{
		won = false;
		for (Door door : doors)
			door.Reset();
	}

	public static class Door {
		private boolean open = false;
		private boolean prizeBehind = false;

		public boolean isOpen() {
			return open;
		}

		public void setOpen(boolean open) {
			this.open = open;
		}

		public boolean isPrizeBehind() {
			return prizeBehind;
		}

		public void setPrizeBehind(boolean prizeBehind) {
			this.prizeBehind = prizeBehind;
		}

		public void Reset() {
			this.prizeBehind = false;
			this.open = false;
		}
	}
}
