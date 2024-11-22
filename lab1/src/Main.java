public class Main {
    public static void main(String[] args) {

        Image img = new Image("F:\\OneDrive\\OneDrive - Everest Engineering College\\7th sem\\" +
                "Image Processing and Pattern Recognization\\labs\\lab1\\2024.png");

        int[][] f = img.getPixelsArray();
        Image.display(f,"Original");
        Image.saveToFile(f,"grayScaled","jpg");

        System.out.println("gray scaled complete");

        // binary image with threshold of 128 from a greyscale
        int[][] binaryImage128 = img.binaryImagePixelsArray(f,128);
        Image.display(binaryImage128,"Binary image of threshold 128");
        Image.saveToFile(binaryImage128,"Binary image threshold 128","jpg");

        System.out.println("binary image with 128 intensity threshold complete");

        //binary image with threshold of mean of the intensity of pixels
        int mean = Image.getMean(f);
        int[][] binaryImageMean = img.binaryImagePixelsArray(f,mean);
        Image.display(binaryImageMean,"Binary image of threshold  mean ");
        Image.saveToFile(binaryImageMean,"Binary image threshold mean","jpg");

        System.out.println("binary image with mean intensity threshold complete");

        //binary image with threshold of median of the intensity of pixels
        int median  = Image.getMedian(f);
        int[][] binaryImageMedian = img.binaryImagePixelsArray(f,median);
        Image.display(binaryImageMedian,"Binary image if threshold median ");
        Image.saveToFile(binaryImageMedian,"Binary image threshold median","jpg");

        System.out.println("binary image with median intensity threshold complete");

    }
}