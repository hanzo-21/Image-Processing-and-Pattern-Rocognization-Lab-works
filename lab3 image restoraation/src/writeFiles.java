import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class writeFiles {
    File file = new File("consoleOutput.txt");

    writeFiles(){
        try {
            // Check if file exists
            if (!file.exists()) {
                // Create the file
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    void clearConsole(){
        try (FileWriter writer = new FileWriter("consoleOutput.txt", false)) { // 'false' overwrites the file
            // Writing nothing clears the file
        } catch (IOException e) {
            System.out.println("error has occurred");
        }
    }


    void writeConsole(String title ,int[][] array){
        String text = title.concat("\n\n") ;
        text = text.concat( Arrays.deepToString(array));
        text = text.concat("\n\n");

        System.out.println(text);
        try (FileWriter writer = new FileWriter("consoleOutput.txt", true)) {
            // 'true' enables appending

            writer.write(text);
            System.out.println("console output was written");
        } catch (IOException e) {
            System.out.println("error has occurred");
        }

    }
    void writeConsole(String title ,int[] array){
        String text = title.concat("\n\n") ;

        for (int i : array) {

            text = text.concat(Integer.toString(i) + ",\t");

        }
        text = text.concat("\n");
        try (FileWriter writer = new FileWriter("consoleOutput.txt", true)) {
            // 'true' enables appending

            writer.write(text);
            System.out.println("console output was written");
        } catch (IOException e) {
            System.out.println("error has occurred");
        }

    }

    void writeConsole(String title ){

        title = title.concat("\n");

        try (FileWriter writer = new FileWriter("consoleOutput.txt", true)) {
            // 'true' enables appending

            writer.write(title);
            System.out.println("console output was written");
        } catch (IOException e) {
            System.out.println("error has occurred");
        }

    }


}
