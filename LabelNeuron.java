import java.util.*;

public class LabelNeuron {
	public int[] synapseStrengths = new int[1000];
	public int label;

	public LabelNeuron(int label) {
		this.label = label;
	}

	public void hebIt(int index, int active) {
		synapseStrengths[index] += (1 == active ? 1 : 0);
	}

	public int checkDistance(ArrayList<Neuron> b) {
		int[] a = new int[b.size()];
		for (int i = 0; i < b.size(); i++)
			a[i] = b.get(i).activated;

		int distance = 0;
    	for (int i = 0; i < a.length; i++) 
    		if (synapseStrengths[i] > 0)
    			if (a[i] == 1)
    				distance += 1;
    			else
    				distance += -1;
    		else
    			distance += -1;
    	
    	return distance;
	}
}