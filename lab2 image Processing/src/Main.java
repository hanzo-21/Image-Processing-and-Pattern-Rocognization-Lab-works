public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();

        writeFiles console = new writeFiles();
        console.clearConsole();

        Image img = new Image(sample.hundredByHundred);
        int[][] grayImageArray = img.getPixelsArray();
        Image.display(grayImageArray,"Original");
        Image.saveToFile(grayImageArray,"1 grayScaled","jpg");

        console.writeConsole("gray scale",grayImageArray);

        int[][] arrayLogTransform = img.logTransformArray(grayImageArray,1);
        Image.display(arrayLogTransform,"log transform image");
        Image.saveToFile(arrayLogTransform,"2 log transform image","jpg");


        int[][] arrayHistogram= img.histogramArray(grayImageArray);
        Image.display(arrayHistogram,"Histogram equalization image");
        Image.saveToFile(arrayHistogram,"3 Histogram equalization image","jpg");


        int[][] kernel = img.getLaplacianKernel();
        int[][] correlationArray = img.correlationConvolutionTransform(grayImageArray,kernel);
        Image.display(correlationArray,"correlation image");
        Image.saveToFile(correlationArray,"4 correlation image","jpg");


        int[][]enhancedImage =img.imageLaplacianEnhancement(grayImageArray,correlationArray,kernel);

        Image.display(enhancedImage,"enhanced image");
        Image.saveToFile(enhancedImage,"5 enhanced image","jpg");

        double[][] blurKernel = img.getAverageKernel();
        int[][] blurArray = img.averageTransform(grayImageArray,blurKernel);
        Image.display(blurArray,"blurring image ");
        Image.saveToFile(blurArray,"6 blurring image","jpg");


        int[][] horizontalKernel = img.getHorizontalKernel();
        int[][] verticalKernel = img.getVerticalKernel();
        int[][] magnitudeOfSobelOperator = img.getMagnitudeOfSobelOperator(grayImageArray,horizontalKernel,
                verticalKernel);
        int percentile93th = Image.get93thPercentile(magnitudeOfSobelOperator);
        int[][] binaryImageMedian = img.binaryImagePixelsArray(magnitudeOfSobelOperator, percentile93th);
        Image.display(binaryImageMedian," image gradient using Sobel masks");
        Image.saveToFile(binaryImageMedian,"7 image gradient using Sobel masks","jpg");
    }
}

