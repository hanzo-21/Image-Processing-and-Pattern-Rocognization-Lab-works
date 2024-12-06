public class Main {
    public static void main(String[] args) {

        Image img = new Image("D:\\drive\\OneDrive - Everest Engineering College\\7th sem\\Image Processing and Pattern Recognization\\labs\\lab2 image Processing\\062.png" );
        int[][] grayImageArray = img.getPixelsArray();
        Image.display(grayImageArray,"Original");
        Image.saveToFile(grayImageArray,"1 grayScaled","jpg");

        System.out.println("Grey scaling complete ");

        int[][] arrayLogTransform = img.logTransformArray(grayImageArray,1);
        Image.display(arrayLogTransform,"log transform image");
        Image.saveToFile(arrayLogTransform,"2 log transform image","jpg");

        System.out.println("Log transform complete ");

        int[][] arrayHistogram= img.histogramArray(grayImageArray);
        Image.display(arrayHistogram,"Histogram equalization image");
        Image.saveToFile(arrayHistogram,"3 Histogram equalization image","jpg");

        System.out.println("Histogram equalization complete ");


        int[][] kernel = img.getLaplacianKernel();
        int[][] correlationArray = img.correlationConvolutionTransform(grayImageArray,kernel);
        Image.display(correlationArray,"correlation image");
        Image.saveToFile(correlationArray,"4 correlation image","jpg");

        System.out.println("Laplacian complete ");

        int[][]enhancedImage =img.imageLaplacianEnhancement(grayImageArray,correlationArray);
        Image.display(enhancedImage,"enhanced image");
        Image.saveToFile(enhancedImage,"5 enhanced image","jpg");

        System.out.println("Laplacian enhancement complete ");

        double[][] blurKernel = img.getAverageKernel();
        int[][] blurArray = img.averageTransform(grayImageArray,blurKernel);
        Image.display(blurArray,"blurring image ");
        Image.saveToFile(blurArray,"6 blurring image","jpg");

        System.out.println("Image blurring complete ");


    }
}

