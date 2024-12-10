public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();

        writeFiles console = new writeFiles();
        console.clearConsole();

        Image img = new Image(sample.polywag);
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


        int[][]enhancedImage =img.imageLaplacianEnhancement(grayImageArray,correlationArray,kernel);

        //console.writeConsole("laplacina image",correlationArray);
        //console.writeConsole("ehance image",enhancedImage);

        Image.display(enhancedImage,"enhanced image");
        Image.saveToFile(enhancedImage,"5 enhanced image","jpg");

        System.out.println("Laplacian enhancement complete ");

        double[][] blurKernel = img.getAverageKernel();
        int[][] blurArray = img.averageTransform(grayImageArray,blurKernel);
        Image.display(blurArray,"blurring image ");
        Image.saveToFile(blurArray,"6 blurring image","jpg");

        System.out.println("Image blurring complete ");

        int[][] horizontalKernel = img.getHorizontalKernel();
        int[][] verticalKernel = img.getVerticalKernel();
        int[][] magnitudeOfSobelOperator = img.getMagnitudeOfSobelOperator(grayImageArray,horizontalKernel,
                verticalKernel);
        System.out.println("solbe's complete ");

        int median  = Image.getMedian(magnitudeOfSobelOperator);
        int[][] binaryImageMedian = img.binaryImagePixelsArray(magnitudeOfSobelOperator,median);
        System.out.println("binary image ");
        Image.display(binaryImageMedian," image gradient using Sobel masks");
        Image.saveToFile(binaryImageMedian,"7 image gradient using Sobel masks","jpg");




    }
}

