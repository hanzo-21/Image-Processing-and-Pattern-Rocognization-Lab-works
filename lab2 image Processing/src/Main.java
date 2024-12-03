public class Main {
    public static void main(String[] args) {

        Image img = new Image("D:\\drive\\OneDrive - Everest Engineering College\\7th sem\\Image Processing and Pattern Recognization\\labs\\lab1\\20241.png" );
        int[][] grayImageArray = img.getPixelsArray();
        Image.display(grayImageArray,"Original");
        Image.saveToFile(grayImageArray,"grayScaled","jpg");

        int[][] arrayLogTransform = img.logTransformArray(grayImageArray,1);
        Image.display(arrayLogTransform,"log transform image");
        Image.saveToFile(arrayLogTransform,"log transform image","jpg");

        int[][] arrayHistogram= img.histogramArray(grayImageArray);
        Image.display(arrayHistogram,"Histogram equalization image");
        Image.saveToFile(arrayHistogram,"Histogram equalization image","jpg");

        int[][] kernel = img.getLaplacianKernel();
        int[][] correlationArray = img.correlationConvolutionTransform(grayImageArray,kernel);
        Image.display(correlationArray,"correlation image");
        Image.saveToFile(correlationArray,"correlation image","jpg");

        int[][]enhancedImage =img.imageLaplacianEnhancement(grayImageArray,correlationArray);
        Image.display(enhancedImage,"enhanced image");
        Image.saveToFile(enhancedImage,"enhanced image","jpg");

        double[][] blurKernel = img.getAverageKernel();
        int[][] blurArray = img.averageTransform(grayImageArray,blurKernel);
        Image.display(blurArray,"blur face");
        Image.saveToFile(blurArray,"blur face","jpg");
    }
}

