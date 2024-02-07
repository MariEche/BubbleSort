import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class BubbleSort{
    static int[] randarr;

    //Generate Random Array
    public static int[] createrRandomArray(int size){
        randarr = new int[size];
        Random random = new Random();
        for (int i = 0; i < randarr.length; i++){
            randarr[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(randarr));
        return randarr;
        

    }

    public static void writeArrayToFile(String filename) throws IOException{
        FileWriter writer = new FileWriter(filename);
        for (int i = 0; i < randarr.length; i++){
            writer.write(Integer.toString(randarr[i]));
            if (i < randarr.length - 1) {
                writer.write("\n");
            }


        }
        writer.close();

    }

    //read array from file
    static int[] readarr;
    public static int[] readFileToArray(int size, String filename) throws IOException{
        FileReader read = new FileReader(filename);
        BufferedReader br = new BufferedReader(read);
        readarr = new int[size];
        for (int i = 0; i< size; i++){
            readarr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        return readarr;
        
    }

    //swap values
    public static void swap(int[] arr, int i, int j){
        if (arr == null){
        }
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }

    //sort array
    public static void bubbleSort(int[] array){
        if (array == null || array.length <= 1){
            return;
        }
        for (int i = 0; i< array.length-1; i++){
            for (int j = 0; j < array.length-1-i; j++){
                if (array[j] > array[j+1]){
                    swap(array , j , j+1);

                }
            }
        
        }
    }

    public static void main(String[] args) throws Exception {
        java.util.Scanner sizescanner = new Scanner(System.in);
        System.out.println("Enter the size of your array:");
        int arraysize = sizescanner.nextInt();
        
        java.util.Scanner choicescanner = new Scanner(System.in);
        System.out.println("type 'R' for random array or type 'F' to read the array from your file");
        String choice = choicescanner.nextLine();

        if (choice.equals("R")){
            System.out.println("Here is your array:");
            createrRandomArray(arraysize);
            System.out.println("Here it is sorted:");
            bubbleSort(randarr);
            System.out.println(Arrays.toString(randarr));
            java.util.Scanner writescanner = new Scanner(System.in);
            System.out.println("Enter a file name to write the sorted array in:");
            String file = writescanner.nextLine();
            writeArrayToFile(file);
            System.out.println("Writting array to '" + file +"'...");
            writescanner.close();
        }
        if (choice.equals("F")){
            java.util.Scanner readscanner = new Scanner(System.in);
            System.out.println("Enter the file name");
            String readfile = readscanner.nextLine();
            readFileToArray(arraysize, readfile);
            System.out.println("Here it your array sorted:");
            bubbleSort(readarr);
            System.out.println(Arrays.toString(readarr));

            readscanner.close();

        }
        choicescanner.close();
        sizescanner.close();
    }
        
    }




