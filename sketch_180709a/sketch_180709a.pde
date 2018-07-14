/* Paste the code into a new Processing sketch and complete the steps. */

//1. create an array of ints. don't initialize it yet.
import java.util.Random;
int[] intArray;
void setup() {
  //2. set the size of your window
  //  if you are using Processing 3, you cannot use variables
  //  because the developers don't know how programming is supposed to work.
  size(500, 500);
  //3. initialize your array with the built in width variable
  intArray=new int[width]; 

  //4. initialize the ints in the array with random numbers
  //   from 0 to the built in height variable

  //5. call the noStroke() method
  noStroke();
  
    randomizer();
    println(intArray);

}

void draw() {
  //6. set the background color with background(r, g, b);
  background(100, 100, 200);
  //7. set the color for your graph
  fill(255, 255, 255);
  //8. draw a rectangle for each int in your array.
  //   the x value will be the element of the int
  //   the y value will the height variable
  //   the width is 1
  //   the height is negative the value of the int at that element in the array
  for (int i=0; i<intArray.length; i++) {
    rect(i, height - intArray[i], 1, intArray[i]);
  }

  //9. call the stepSort method
  
  //10. extract the code that randomizes the array into a method.
  //11. call the method you made in step 10 when the mouse is pressed
  if (mousePressed) {
    stepSort(intArray);
  }
}

void randomizer() {
  Random ran=new Random();
  for (int i=0; i<intArray.length; i++) {
    intArray[i]=ran.nextInt(500);
  }
}
void stepSort(int[] arr) {
  for (int i = 1; i < arr.length; i++) {
    if (arr[i - 1] > arr[i]) {
      int t = arr[i];
      arr[i] = arr[i - 1];
      arr[i - 1] = t;
    }
  }
}