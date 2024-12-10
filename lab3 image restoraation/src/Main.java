public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();
        writeFiles console = new writeFiles();

        Image img = new Image( sample.ronaldoDeLima);

        int[][] f = img.getPixelArray();
        Image.display(f, "gray scale");
        Image.saveToFile(f,"gray scale","jpg");
    }
}