public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();
        writeFiles console = new writeFiles();
        console.clearConsole();

        Image noiseImage;
        int[][] noiseArray ;
        int[][] meanCorrection ;
        int[][] medinaCorrection ;


        int filerSize = 3;

        noiseImage = new Image( sample.messiNoise);
        noiseArray = noiseImage.getPixelArray();
        meanCorrection = noiseImage.restorationByMean(noiseArray,filerSize);
        medinaCorrection = noiseImage.restorationByMedian(noiseArray,filerSize);
        Image.displayAndSaveJPG(meanCorrection,            "1 Mean correction of messiNoise");
        Image.displayAndSaveJPG(medinaCorrection,          "2 Median correction of messiNoise");

        noiseImage = new Image( sample.ronaldoNoise);
        noiseArray = noiseImage.getPixelArray();
        meanCorrection = noiseImage.restorationByMean(noiseArray,filerSize);
        medinaCorrection = noiseImage.restorationByMedian(noiseArray,filerSize);
        Image.displayAndSaveJPG(meanCorrection,            "3 Mean correction of ronaldoNoise");
        Image.displayAndSaveJPG(medinaCorrection,          "4 Median correction of ronaldoNoise");

        noiseImage = new Image( sample.ronaldoDeLimaNoise);
        noiseArray = noiseImage.getPixelArray();
        meanCorrection = noiseImage.restorationByMean(noiseArray,filerSize);
        medinaCorrection = noiseImage.restorationByMedian(noiseArray,filerSize);
        Image.displayAndSaveJPG(meanCorrection,            "5 Mean correction of ronaldoDeLimaNoise");
        Image.displayAndSaveJPG(medinaCorrection,          "6 Median correction of ronaldoDeLimaNoise");

    }
}