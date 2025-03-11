package gfg.a13_Deque.course;

/*
 * Problem Statement -
 * I/P =
 * assume these array are circular array
 * petrol[] = [4, 8, 7,4] // capacity of petrol pump in liters
 * distance[] = [6, 5, 3, 5] // distance to next petrol from current pump
 *
 * O/P = 2
 * -----------------------------------------------------------
 * Assume we have truck(object) with infinite petrol capacity,
 * object consumes 1 unit of petrol to travel 1 unit of distance.
 *
 * Circular arrangements of petrol pump and infinite capacity object.
 * Task - Find out the first petrol pump such we should be able to visit
 * all petrol pump with given petrol capacity and should come back to same petrol pump.
 *
 * */
public class a3_FirstCircularTour {
  public static void main(String[] args) {
    int[] petrol = {4, 8, 7, 4};
    int[] distance = {6, 5, 3, 5};
    System.out.println("Naive Solution - " + firstPetrolPumpNaiveSol(petrol, distance));
    System.out.println("Efficient Solution - " + firstPetrolPumpEffSol(petrol, distance));
  }

  private static int firstPetrolPumpEffSol(int[] petrol, int[] distance) {
    int n = petrol.length;
    int start = 0, currPetrol = 0, prevPetrol = 0;
    for (int i = 0; i < n; i++) {
      currPetrol += petrol[i] - distance[i];
      if (currPetrol < 0) {
        start = i + 1;
        prevPetrol += currPetrol;
        currPetrol = 0;
      }
    }
    return (currPetrol + prevPetrol) >= 0 ? start + 1 : -1;
  }

  private static int firstPetrolPumpNaiveSol(int[] petrol, int[] distance) {
    int n = petrol.length;
    for (int start = 0; start < n; start++) {
      int cp = 0; // petrol capacity
      int end = start;
      while (true) {
        cp += petrol[end] - distance[end];
        if (cp < 0) {
          break;
        }
        end = (end + 1) % n;
        if (end == start) return start + 1;
      }
    }
    return -1;
  }
}
