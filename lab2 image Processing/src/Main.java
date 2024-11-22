public class Main {
    public static void main(String[] args) {

        Image img = new Image("F:\\OneDrive\\OneDrive - Everest Engineering College\\7th sem\\Image Processing and Pattern Recognization\\labs\\assets\\photos\\1080.png");
        int[][] grayImageArray = img.getPixelsArray();
        Image.display(grayImageArray,"Original");
        Image.saveToFile(grayImageArray,"grayScaled","jpg");

        


    }
}