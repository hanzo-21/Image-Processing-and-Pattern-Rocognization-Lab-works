public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();
        writeFiles console = new writeFiles();

        int filerSize = 3;

        Image messiNoise = new Image( sample.messiNoise);
        Image ronaldoNoise = new Image(sample.ronaldoNoise);
        Image ronaldoDeLimaNoise = new Image(sample.ronaldoDeLima);

        int[][] messiNoiseArray = messiNoise.getPixelArray();
        int[][] ronaldoNoiseArray = ronaldoNoise.getPixelArray();
        int[][] ronaldoDeLimaNoiseArray = ronaldoDeLimaNoise.getPixelArray();

        int[][] messiMeanCorrection = messiNoise.restorationByMean(messiNoiseArray,filerSize);
        int[][] ronaldoMeanCorrection = ronaldoNoise.restorationByMean(ronaldoNoiseArray,filerSize);
        int[][] ronaldoDeLimaMeanCorrection = ronaldoDeLimaNoise.restorationByMean(ronaldoDeLimaNoiseArray,filerSize);


        int[][] messiMedinaCorrection = messiNoise.restorationByMedian(messiNoiseArray,filerSize);
        int[][] ronaldoMedianCorrection = ronaldoNoise.restorationByMedian(ronaldoNoiseArray,filerSize);
        int[][] ronaldoDeLimaMedianCorrection = ronaldoDeLimaNoise.restorationByMedian(ronaldoDeLimaNoiseArray,filerSize);

        Image.displayAndSaveJPG(messiMeanCorrection,            "1 Mean correction of messi");
        Image.displayAndSaveJPG(messiMedinaCorrection,          "1 Median correction of messi");
        Image.displayAndSaveJPG(ronaldoMeanCorrection,          "1 Mean correction of ronaldo");
        Image.displayAndSaveJPG(ronaldoMedianCorrection,        "1 Median correction of ronaldo");
        Image.displayAndSaveJPG(ronaldoDeLimaMeanCorrection,    "1 Mean correction of ronaldoDeLima");
        Image.displayAndSaveJPG(ronaldoDeLimaMedianCorrection,  "1 Median correction of ronaldoDeLima");

    }
}