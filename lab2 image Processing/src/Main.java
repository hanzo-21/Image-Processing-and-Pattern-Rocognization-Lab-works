public class Main {
    public static void main(String[] args) {

        Image img = new Image("F:\\OneDrive\\OneDrive - Everest Engineering College\\7th sem\\" +
                "Image Processing and Pattern Recognization\\labs\\lab2 image Processing\\2024.png");
        int[][] grayImageArray = img.getPixelsArray();
        Image.display(grayImageArray,"Original");
        Image.saveToFile(grayImageArray,"grayScaled","jpg");

        int[][] arrayLogTransform = img.logTransformArray(grayImageArray,1);
        Image.display(arrayLogTransform,"log transform image");
        Image.saveToFile(arrayLogTransform,"log transform image","jpg");

        int[][] arrayHistogram= img.histogramArray(grayImageArray);
        Image.display(arrayHistogram,"Histogram equalization image");
        Image.saveToFile(arrayHistogram,"Histogram equalization image","jpg");

        



    }
}