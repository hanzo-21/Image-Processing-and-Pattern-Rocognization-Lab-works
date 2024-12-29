import cv2 as cv 
import numpy as np

path = "D:\\drive\\OneDrive - Everest Engineering College\\7th sem\\Image Processing and Pattern Recognization\\labs\lab 4\\062.png"

colourImage = cv.imread(path,1)
greyIamge = cv.imread(path,0)
 
cv.imshow("original",colourImage)
cv.imshow("grey",greyIamge)

kernalX = np.array([[1,2,1],[0,0,0],[-1,-2,-1]])