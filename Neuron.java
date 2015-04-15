import java.util.*;

public class Neuron {
	public static int n = 10;
	public int numConnections = 10;
	public int[] indices = new int[numConnections];
	public int activated = 0;

	public Neuron(int[] indices) {
		this.indices = indices;
	}

	public void setActivated(int[] lowerLayer) {
		int sum = 0;
		for (int i : indices)
			sum += lowerLayer[i];

		activated = (sum > 0 ? 1 : 0);

	}

	public void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}
}