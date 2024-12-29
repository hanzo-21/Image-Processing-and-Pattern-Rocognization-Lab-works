import cv2 as cv
import numpy as np

path = "D:\\drive\\OneDrive - Everest Engineering College\\7th sem\\Image Processing and Pattern Recognization\\labs\lab 4\\062.png"

colourImage = cv.imread(path,1)
greyIamge = cv.imread(path,0)

cv.imshow("original",colourImage)
cv.imshow("grey",greyIamge)

kernal = np.ones((5,5),np.float32)/25

result  = cv.filter2D(src= greyIamge,ddepth=-1,kernel=kernal)

cv.imshow("after avering ",result)

cv.imwrite("reult image.png",result)








cv.waitKey()