public class Main {
    public static void main(String[] args) {

        imageSamples sample = new imageSamples();
        writeFiles console = new writeFiles();
        console.clearConsole();


        int filerSize = 3;

        Image messiNoise = new Image( sample.hundredByHundred);
        Image ronaldoNoise = new Image(sample.ronaldoNoise);
        Image ronaldoDeLimaNoise = new Image(sample.ronaldoDeLima);


        int[][] messiNoiseArray = messiNoise.getPixelArray();
        int[][] ronaldoNoiseArray = ronaldoNoise.getPixelArray();
        int[][] ronaldoDeLimaNoiseArray = ronaldoDeLimaNoise.getPixelArray();

        console.writeConsole("image got converted into array\n");
        console.writeConsole("messi noise\n",messiNoiseArray);
        console.writeConsole("ronaldo noise\n",ronaldoNoiseArray);
        console.writeConsole("ronaldoDeLima noise\n",ronaldoDeLimaNoiseArray);


        int[][] messiMeanCorrection = messiNoise.restorationByMean(messiNoiseArray,filerSize);
        console.writeConsole("messi restored by mean\n",messiMeanCorrection);

        int[][] ronaldoMeanCorrection = ronaldoNoise.restorationByMean(ronaldoNoiseArray,filerSize);
        console.writeConsole("ronaldo restored by mean",ronaldoMeanCorrection);

        int[][] ronaldoDeLimaMeanCorrection = ronaldoDeLimaNoise.restorationByMean(ronaldoDeLimaNoiseArray,filerSize);
        console.writeConsole("ronaldoDeLima restored by mean",ronaldoDeLimaMeanCorrection);





        int[][] messiMedinaCorrection = messiNoise.restorationByMedian(messiNoiseArray,filerSize);
        console.writeConsole("messi restored by median\n",messiMedinaCorrection);

        int[][] ronaldoMedianCorrection = ronaldoNoise.restorationByMedian(ronaldoNoiseArray,filerSize);
        console.writeConsole("ronaldoDeLima restored by median",ronaldoMedianCorrection);

        int[][] ronaldoDeLimaMedianCorrection = ronaldoDeLimaNoise.restorationByMedian(ronaldoDeLimaNoiseArray,filerSize);
        console.writeConsole("ronaldoDeLima restored by median",ronaldoDeLimaMedianCorrection);




        Image.displayAndSaveJPG(messiMeanCorrection,            "1 Mean correction of messi");
        Image.displayAndSaveJPG(messiMedinaCorrection,          "2 Median correction of messi");

        Image.displayAndSaveJPG(ronaldoMeanCorrection,          "3 Mean correction of ronaldo");
        Image.displayAndSaveJPG(ronaldoMedianCorrection,        "4 Median correction of ronaldo");
        Image.displayAndSaveJPG(ronaldoDeLimaMeanCorrection,    "5 Mean correction of ronaldoDeLima");
        Image.displayAndSaveJPG(ronaldoDeLimaMedianCorrection,  "6 Median correction of ronaldoDeLima");



    }
}