package code.better.com.interviews;

public class RotatedArray {

	public int findPivot(int[] array, int lower, int higher) {
		if (array == null || array.length <= 1)
			return -1;
		int mid = lower + (higher - lower) / 2;
		if (mid >= higher || mid < 0)
			return -1;
		if (mid == 0 && array[mid] < array[mid + 1])
			return -1;
		else if (mid == array.length - 1 && array[mid] > array[mid - 1]) {
			return -1;
		} else if (mid != lower && mid != higher - 1) {
			if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1]) {
				int pivot = findPivot(array, lower, mid - 1);
				return pivot != -1 ? pivot : findPivot(array, mid + 1, higher);
			} else if (array[mid] < array[mid - 1]) {
				return mid - 1;
			} else if (array[mid] > array[mid + 1]) {
				return mid;
			}
		}

		return mid;
	}

	

	public int findIndex(int[] array, int lower, int higher, int number) {
		int mid = lower + (higher - lower) / 2;
		if (mid > higher || mid < 0)
			return -1;
		if (array[mid] == number)
			return mid;
		else if (array[mid] > number)
			return findIndex(array, lower, mid - 1, number);
		else
			return findIndex(array, mid + 1, higher, number);
	}
	
	public int findNumber(int[] array, int number){
		if (array == null || array.length == 0)
			return -1;
		int pivot=findPivot(array,0,array.length);
		if(pivot==-1)return findIndex(array,0,array.length,number);
		else{
		 int index=findIndex(array,0,pivot,number);
		 return index!=-1?index:findIndex(array,pivot+1,array.length,number);
		}
	}
	
	

}
