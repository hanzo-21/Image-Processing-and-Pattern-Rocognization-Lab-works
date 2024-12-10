import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

        for(int x =0 ; x<array.length;x++){
            for(int y =0; y<array[0].length;y++){
                text = text.concat(Integer.toString(array[x][y] )+ ",\t");
            }
            text = text.concat("\n");
        }
        try (FileWriter writer = new FileWriter("consoleOutput.txt", true)) {
            // 'true' enables appending

            writer.write(text);
            System.out.println("console output was written");
        } catch (IOException e) {
            System.out.println("error has occurred");
        }

    }

}
