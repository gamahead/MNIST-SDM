import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class TestScanner {

	public static LabelNeuron[] labels = new LabelNeuron[10];

    public static void main(String[] args) throws FileNotFoundException {

    	ArrayList<Datum> trainingData = new ArrayList<Datum>();
        Scanner scanner = new Scanner(new File("train.csv"));
        // scanner.useDelimiter(",");
        String[] labs = scanner.nextLine().split(",");
        while(scanner.hasNextLine()){
            String[] currentImage = scanner.nextLine().split(",");
            trainingData.add(new Datum(currentImage));
        }

        scanner.close();

        // Setup the label Neurons
        for (int i = 0; i < 10; i++) {
        	labels[i] = new LabelNeuron(i);
        }

        Random r = new Random();
        ArrayList<Neuron> regionOne = new ArrayList<Neuron>();
        int[] randoms = new int[Neuron.n];
        for (int i = 0; i < 1000; i++) {
        	for (int j = 0; j < Neuron.n; j++)
        		randoms[j] = r.nextInt(785);

        	regionOne.add(new Neuron(randoms));
        }

        int count = 0;

        for (Datum d : trainingData) {
        	System.out.println(Arrays.toString(d.oneDArray));
        	// for (Neuron n : regionOne) {
        	// 	n.setActivated(d.oneDArray);
        	// 	System.out.println("" + d + " \n"+n.activated);
        	// }
        	
        }

    }

    public static int findClosestNum(ArrayList<Neuron> region, int lab) {
    	for (int i = 0; i < region.size(); i++)
    		labels[lab].hebIt(i,region.get(i).activated);

    	int[] distances = new int[10];
    	int i = 0;
    	for (LabelNeuron ln : labels) {
    		distances[i] = ln.checkDistance(region);
    		i++;
    	}

    	int max = 0;
    	int index = 0;
    	for (i = 0; i < distances.length; i++)
    		if (distances[i] > max) {
    			max = distances[i];
    			index = i;
    		}

    	System.out.println("Label: " + lab + " - Prediction: " + index + " - Max: " + max);
    	return 0;

    }

    public static int hammingDistance(int[] a, int[] b) {
    	int distance = 0;
    	for (int i = 0; i < a.length; i++)
    		distance += (a[i] == b[i] ? 1 : 0);

    	return distance;

    }

}