public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();
        writeFiles console = new writeFiles();
        console.clearConsole();

        Image noiseImage;
        Image originalImage;
        int[][] noiseArray ;
        int[][] meanCorrection ;
        int[][] medinaCorrection ;
        int[][] originalArray;
        double[][] SNR_0_mean_1_median = new double[3][2];


        int filerSize = 3;

        noiseImage = new Image( sample.messiNoise);
        noiseArray = noiseImage.getPixelArray();
        meanCorrection = noiseImage.restorationByMean(noiseArray,filerSize);
        medinaCorrection = noiseImage.restorationByMedian(noiseArray,filerSize);
        Image.displayAndSaveJPG(meanCorrection,            "1 Mean correction of messiNoise");
        Image.displayAndSaveJPG(medinaCorrection,          "2 Median correction of messiNoise");

        originalImage = new Image(sample.messi);
        originalArray = originalImage.getPixelArray();
        SNR_0_mean_1_median[0][0] = noiseImage.signalToNoiseRatio(meanCorrection,originalArray);
        SNR_0_mean_1_median[0][1] = noiseImage.signalToNoiseRatio(medinaCorrection,originalArray);

        noiseImage = new Image( sample.ronaldoNoise);
        noiseArray = noiseImage.getPixelArray();
        meanCorrection = noiseImage.restorationByMean(noiseArray,filerSize);
        medinaCorrection = noiseImage.restorationByMedian(noiseArray,filerSize);
        Image.displayAndSaveJPG(meanCorrection,            "3 Mean correction of ronaldoNoise");
        Image.displayAndSaveJPG(medinaCorrection,          "4 Median correction of ronaldoNoise");

        originalImage = new Image(sample.ronaldo);
        originalArray = originalImage.getPixelArray();
        SNR_0_mean_1_median[1][0] = noiseImage.signalToNoiseRatio(meanCorrection,originalArray);
        SNR_0_mean_1_median[1][1] = noiseImage.signalToNoiseRatio(medinaCorrection,originalArray);

        noiseImage = new Image( sample.ronaldoDeLimaNoise);
        noiseArray = noiseImage.getPixelArray();
        meanCorrection = noiseImage.restorationByMean(noiseArray,filerSize);
        medinaCorrection = noiseImage.restorationByMedian(noiseArray,filerSize);
        Image.displayAndSaveJPG(meanCorrection,            "5 Mean correction of ronaldoDeLimaNoise");
        Image.displayAndSaveJPG(medinaCorrection,          "6 Median correction of ronaldoDeLimaNoise");

        originalImage = new Image(sample.ronaldoDeLima);
        originalArray = originalImage.getPixelArray();
        SNR_0_mean_1_median[2][0] = noiseImage.signalToNoiseRatio(meanCorrection,originalArray);
        SNR_0_mean_1_median[2][1] = noiseImage.signalToNoiseRatio(medinaCorrection,originalArray);

        String[][] SNRTable = Image.convertIntoString(SNR_0_mean_1_median);
        String[][] imageNames = {{"messi"}, {"ronaldo"},{"ronaldoDeLima"}};
        Image.displaySNRTable(SNRTable,imageNames);

    }
}