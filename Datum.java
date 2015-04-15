import java.util.*;

public class Datum {

	public int[][] pixelArray = new int[28][28];
	public int[] oneDArray;
	public int label;

	public Datum(String[] data) {
		oneDArray = toIntArray(data);
		// oneToTwo(data);
		this.label = Integer.parseInt(data[0]);
	}

	public void oneToTwo(String[] rdata) {
		int[] currentImage = new int[785];
		for (int i = 0; i < 785; i++)
			currentImage[i] = Integer.parseInt(rdata[i]);

		int[] pixels = Arrays.copyOfRange(currentImage, 1, 785);
		int colCounter = 0;
		int rowCounter = 0;
		for (int pixel : pixels) {
			pixelArray[rowCounter][colCounter] = (pixel != 0 ? 1 : 0);
			if ((colCounter+1) % 28 == 0) {
				rowCounter++;
				colCounter = -1; // Set to -1 because it immediately gets incremented to 0
			}
			colCounter++;
		}
	}

	@Override
	public String toString() {
		String output = "";
		for (int[] i : pixelArray) {
			output += Arrays.toString(i) + "\n";
		}

		return output;
	}

	public int[] toIntArray(String[] sArray) {
		int[] intArray = new int[sArray.length];
		for (int i = 0; i < 785; i++)
			intArray[i] = Integer.parseInt(sArray[i]) > 0 ? 1 : 0;

		return intArray;
	}

}