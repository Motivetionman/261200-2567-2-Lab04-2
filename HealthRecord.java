public class HealthRecord {
public int height;
private static final int MIN_PERMITTED_HEIGHT = 50;
private static final int MAX_PERMITTED_HEIGHT = 175;
private static final int DEFAULT_HEIGHT = 100;
private static int tallestHeight = MIN_PERMITTED_HEIGHT ;
private static int shortestHeight = MAX_PERMITTED_HEIGHT ;
private static int counter=0;
private static double averageHeight=0.0;


public HealthRecord(int height) { 
  counter++;
  setHeight(height);

  
}
public void setHeight(int height) {

  
  if ( height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT )
    this.height = height;
  else
    this.height = DEFAULT_HEIGHT ;

  
  if ( this.height >  tallestHeight )
    tallestHeight = this.height ;
  if ( this.height < shortestHeight )
     shortestHeight = this.height;

     averageHeight=(averageHeight*(counter-1)+this.height)/counter;
  
}

public static double getAverageHeight(){
  return averageHeight;
}

public int getHeight() {
  return this.height;
}

public static int getTallestHeight() {
   return tallestHeight;
}

public static int getShortestHeight() {
   return shortestHeight;
 }


public void displayDetails() { 
    System.out.println("Height (cm): " + getHeight());
  }
  public static void displayClassDetails() {
    System.out.println("The tallest height (cm): " + getTallestHeight());
    System.out.println("The shortest height (cm): " + getShortestHeight());
    System.out.println("The averageheight (cm)"+ getAverageHeight());
  }


  public static void main(String[] args) {
    HealthRecord student1 = new HealthRecord(120);
    HealthRecord student2 = new HealthRecord(55);
    HealthRecord student3 = new HealthRecord(180);
    student1.displayDetails(); // 120
    student2.displayDetails(); // 55
    student3.displayDetails(); // 180 is not permitted, so it is replaced by default value
    HealthRecord.displayClassDetails(); // tallest = 120, shortest = 55
  }

  }
  