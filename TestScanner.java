import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class TestScanner {

    public static void main(String[] args) throws FileNotFoundException {

    	ArrayList<Datum> trainingData = new ArrayList<Datum>();
        Scanner scanner = new Scanner(new File("train.csv"));
        // scanner.useDelimiter(",");
        String[] labels = scanner.nextLine().split(",");
        while(scanner.hasNextLine()){
            String[] currentImage = scanner.nextLine().split(",");
            trainingData.add(new Datum(currentImage));
        }

        System.out.println(trainingData.get(3));

        scanner.close();
    }

}