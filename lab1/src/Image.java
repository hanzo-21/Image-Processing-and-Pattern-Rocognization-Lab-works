import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Image {
    BufferedImage image;

    //-------------------------constructor---------

    public  Image(String filename){
        try{
            this.image = ImageIO.read(new File(filename));
        }catch (IOException e){
            System.out.println("error" + e);
        }
    }

    public Image ( BufferedImage img){
        this.image = img;
    }

    public Image(int[][]A ){ // grey scale image form array
        image = new BufferedImage(A.length, A[0].length,BufferedImage.TYPE_BYTE_GRAY);
        for (int x =0 ; x< image.getWidth(); x++){
            for(int y =0 ; y < image.getHeight(); y++){
                Color newColour = new Color(A[x][y],A[x][y],A[x][y]);
                image.setRGB(x,y,newColour.getRGB());
            }
        }

    }

    //-----------------------basic io function---------------


    public BufferedImage getImage() {
        return this.image;
    }

    void saveToFile(String filename , String extension){
        try{
            ImageIO.write(image,"jpg",new File(filename+"."+extension));
        }catch (IOException e){
            System.out.println("error : "+ e);
        }
    }

    public  static  void saveToFile(int [][]f, String filename , String extension){
        Image im = new Image(f);
        im.saveToFile(filename,extension);
    }

    public static void  displayPixelsIntensity(int[][] f){

        for(int x = 0 ; x <f.length ; x++){
            for(int y = 0; y < f[0].length ; y++){
                System.out.print(f[x][y]+",");
            }
            System.out.println();
        }
    }

    void display (String title){
        ImageIcon icon = new ImageIcon(this.image);
        JFrame frame = new JFrame(title);

        frame.setLayout(new FlowLayout());
        frame.setSize(this.image.getWidth(),this.image.getHeight());
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public  static  void display (int [][]f , String title){

        //clip intensities to the range [0,255]

        for(int x = 0 ; x <f.length ; x++){
            for(int y = 0; y < f[0].length ; y++){
                if (f[x][y] > 255){
                    f[x][y] =255;
                }
                if (f[x][y] < 0 ){
                    f[x][y] = 0;
                }
            }
        }
        Image img = new Image(f);
        img.display(title);
    }

    public  static  void display (double [][]f , String title){

        //clip intensities to the range [0,255]

        int [][] F = new int[f.length][f[0].length];

        for(int x = 0 ; x <f.length ; x++){
            for(int y = 0; y < f[0].length ; y++){
                F[x][y] = (int) Math.round(f[x][y]);

                if (F[x][y] > 255){
                    F[x][y] =255;
                }
                if (F[x][y] < 0 ){
                    F[x][y] = 0;
                }
            }
        }

        Image img = new Image(F);
        img.display(title);
    }

    int [][] getPixelsArray(){
        int [][] A = new int[image.getWidth()][image.getHeight()];
        for (int x =0 ; x< image.getWidth(); x++){
            for(int y =0 ; y < image.getHeight(); y++){
               Color c = new Color(image.getRGB(x,y));
               A[x][y] = (int) ( c.getRed() + c.getBlue() + c.getGreen())/3;
            }
        }
        return A;
    }

    int [][] binaryImagePixelsArray (int[][]inputArray , int threshold){

        //if the intensity is greater than  threshold up it to 255 else downgrade it to 0

        int [][] finalArray = new int[inputArray.length][inputArray[0].length];

        for(int x = 0 ; x <inputArray.length ; x++){
            for(int y = 0; y < inputArray[0].length ; y++){
                if (inputArray[x][y] > threshold){
                    finalArray[x][y] =255;
                }else{
                    finalArray[x][y] = 0;
                }
            }
        }
        return finalArray;
    }

    public static int getMedian(int [][]array ){
        // how we do is we flatten 1d array into 2d and sort the array
        //then if odd number of elements are odd then value in length/2 is median
        //if even we take out average of 2

        int [] oneDArray = new int[array.length * array[0].length];
        int index = 0;
        for(int x =0 ; x< array.length ; x++){
            for(int y = 0;y< array[0].length;y++){
                oneDArray[index] = array[x][y];
                index ++;
            }
        }

        Arrays.sort(oneDArray);

        System.out.println("total number of pixels " + oneDArray.length);
        System.out.println("min max intensity"+oneDArray[0]+","+oneDArray[oneDArray.length-1]);

        if(oneDArray.length % 2 == 0){//is even
            int num1 = oneDArray[(oneDArray.length-1)/2];
            int num2 = oneDArray[((oneDArray.length-1)/2)+1];
            System.out.println("even median intensity"+num1+","+num2);
            return (num1+num2)/2;
        }
        else {//is odd
            System.out.println("odd median intensity"+oneDArray[oneDArray.length/2]);
            return oneDArray[oneDArray.length/2];
        }
    }

    public static int getMean(int [][]array){
        //figure out the mean of the intensity  and use that as threshold of that intensity
        int sumOfIntensity = 0;
        for(int x = 0 ; x <array.length ; x++){
            for(int y = 0; y < array[0].length ; y++){
                sumOfIntensity = sumOfIntensity + array[x][y];
            }
        }
       return  sumOfIntensity/(array.length *array[0].length);
    }

}


//if f[][] then f.length is nuber of rows and f[0].length is number of columns