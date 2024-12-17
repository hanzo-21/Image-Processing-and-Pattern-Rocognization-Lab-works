
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Image {
	BufferedImage image;
	
	//*********************************************************************
	//************** Constructors *****************************************
	public Image(String filename) {
		 try{
			 this.image = ImageIO.read(new File(filename));
		    }catch(IOException e){
		      System.out.println("Error: "+e);
		  }
	}
	
	public Image(BufferedImage img) {
		this.image = img;
	}
	
	public Image(int[][] A) {//gray-scale image from array
		image = new BufferedImage(A.length,A[0].length,
								BufferedImage.TYPE_BYTE_GRAY);
		for(int x=0;x<image.getWidth(); x++)
			for(int y=0;y<image.getHeight();y++) {
				Color newColor = new Color(A[x][y],A[x][y],A[x][y]);
	    		image.setRGB(x, y,newColor.getRGB());
			}
	}		
	
	
	
	//*******************************************************************
	//************** Basic IO and other functions ***********************
	
	BufferedImage getImage() {
		return this.image;
	}
		
	void saveToFile(String filename,String extension) {
		 try{
		      ImageIO.write(image, "jpg", new File(filename+"."+extension));
		    }catch(IOException e){
		      System.out.println("Error: "+e);
		    }
	}
	
	public static void saveToFile(int[][] f, String filename, String extension) {
		Image im = new Image(f);
		im.saveToFile(filename, extension);
	}
	
	void display(String title) {
		ImageIcon icon=new ImageIcon(this.image);
		JFrame frame=new JFrame(title);
        frame.setLayout(new FlowLayout());
        frame.setSize(this.image.getWidth(),this.image.getHeight());
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	
	public static void display(int[][] f,String title) {
		//clip intensities to the range [0,255]
		for(int x=0;x<f.length;x++)
			for(int y=0;y<f[0].length;y++) {
				if(f[x][y]>255)
					f[x][y]=255;
				if(f[x][y]<0)
					f[x][y]=0;
				}

		Image img = new Image(f);
		img.display(title);
	}

	public static void displayAndSaveJPG ( int[][] array , String title){
		Image.saveToFile(array,title,"jpg");
		Image.display(array,title);
	}
	
	public static void display(double[][] f,String title){
		//clip intensities to the range [0,255]
		int[][] F = new int[f.length][f[0].length];
		for(int x=0;x<f.length;x++)
			for(int y=0;y<f[0].length;y++) {
				F[x][y] = (int) Math.round(f[x][y]);
				if(F[x][y]>255)
							F[x][y]=255;
				if(F[x][y]<0)
							F[x][y]=0;
				}
		Image img = new Image(F);
		img.display(title);

	}

	
	int[][] getPixelArray(){
		int[][] A = new int[image.getWidth()][image.getHeight()];
		for(int x=0;x<image.getWidth();x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				Color c = new Color(image.getRGB(x, y));
				A[x][y] = (int) (c.getRed() + c.getGreen() + c.getBlue()) / 3;
			}
		}
		return A;
	}

	//*******************************************************************
	//************** additional function for lab***********************



	int[] getUnPaddedSection(int[][]imageArray, int xCord, int yCord , int sizeOfKernel){
		Stack <Integer> stack = new Stack<>();

		int x = xCord - (sizeOfKernel /2);
		for(int i = 0; i< sizeOfKernel; i++){
			int y = yCord - (sizeOfKernel /2);
			for(int j = 0; j< sizeOfKernel; j++){
				//console.writeConsole("checking for " + x+ ","+y);
				if(x<0 || y< 0 || x>=imageArray.length || y>= imageArray[0].length){
					y++;
					continue;
				}else {
					stack.push(imageArray[x][y]) ;
				}
				y++;
			}
			x++;
		}


		int[] finalArray = new int[stack.size()];

		for(int k = 0; k<finalArray.length;k++){
			finalArray[k]= stack.get(k);
		}
		return finalArray;
	}

	int getMean(int[] array){

		int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
		return sum /array.length;
	}

	int[][]restorationByMean(int[][]NoiseArray,int filterSize){

		int[][]finalArray = new  int [NoiseArray.length][NoiseArray[0].length];

		for(int x  =0 ; x<NoiseArray.length;x++){
			for(int y =0 ; y< NoiseArray[0].length;y++){
				int [] unPaddedSection = getUnPaddedSection(NoiseArray,x,y,filterSize);
				finalArray[x][y] = getMean(unPaddedSection);
			}
		}
		return  finalArray;
	}

	int getMedian (int[] array){
		Arrays.sort(array);
		return array[array.length/2];
	}


	int[][]restorationByMedian(int[][]NoiseArray,int filterSize){

		int[][]finalArray = new  int [NoiseArray.length][NoiseArray[0].length];

		for(int x  =0 ; x<NoiseArray.length;x++){
			for(int y =0 ; y< NoiseArray[0].length;y++){
				int [] unPaddedSection = getUnPaddedSection(NoiseArray,x,y,filterSize);
				finalArray[x][y] = getMedian(unPaddedSection);
			}
		}
		return  finalArray;
	}

}
