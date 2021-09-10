package montyhall;

import java.util.Scanner;

public class MontyHall {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Number of simulations: ");
		int sims = input.nextInt();

		if (sims <= 0)
			return;

		Simulation sim = new Simulation();

		// ANOTHER IMPLEMENTATION OF AVERAGE OF MANY SIMS GOING UP FROM 1 TO N_SIMS
		/*

		float avg = 0f;

		for (int i = 1; i <= sims; i++)
		{
			int won = 0;

			for (int j = 0; j < sims; j++) {
				sim.Simulate();
				won += sim.won ? 1 : 0;
			}

			float chance = ((float) won) / (sims);
			System.out.printf("\r%.2f%% done", ((float) i) / sims * 100);
			avg += chance;
		}

		avg /= sims;
		System.out.printf("\rAWR When Switching: %.2f\n", avg * 100);
		System.out.printf("\rAWR When Staying: %.2f\n", 100 - (avg * 100));

		*/

		int won = 0;

		for (int j = 0; j < sims; j++) {
			sim.Simulate();
			won += sim.won ? 1 : 0;
		}

		float chance = ((float) won) / (sims);
		System.out.printf("AWR Switching: %.4f%% \n", chance * 100f);
	}
}
