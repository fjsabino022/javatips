package javatips.fsabino.app_codility;

/**
 * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

 * @author fsabino
 *
 */
public class SmallerNumberOutsideArray {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{-1,1,  4, 3}));
	}

    public static int solution(int[] A) {
        // the smallest number must be mayor than 0
    	int menor = 0;
    	for (int i : A) {
			if (i >= 0) {
				menor = i;
				break;
			}
		}
    	
    	for (int i : A) {
			if (i > 0 && i <= menor) {
				menor = i;
			}
		}
    	
    	// if all elements are negatives
    	if (menor <= 0) {
    		return 1;
    	}
    	
    	for (int i = 1; i <= menor; i++) {
			if (!isNumberInArray(A, i)) {
				return i;
			}
		}
    	
    	int mayor = findMayor(A);
    	
    	for (int x = menor; x <= mayor; x++) {
    		if (!isNumberInArray(A, x)) {
				return x;
			}
		}
    	
    	return mayor +1;
    }
	
    private static boolean isNumberInArray(int[] array, int number) {
    	for (int i : array) {
			if (number == i) {
				return true;
			}
		}
    	return false;
    }
    
    private static int findMayor(int[] array) {
    	int mayor = 0;
    	for (int i : array) {
			if (i >= mayor) {
				mayor = i;
			}
		}
    	return mayor;
    }
}
