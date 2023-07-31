import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortierAlgorithmen {
	
	public static void main (String[]args) {
		
		Random random = new Random();
		
		int[] arr = new int[10];
		ArrayList<Integer> arrList= new ArrayList<>();
		
		for(int i=0; i<arr.length; i++){
			arr[i] = random.nextInt(1000);//inclusive 0, exclusive set argument
			arrList.add(random.nextInt(1000));
		}
		
		
		long startTime = System.nanoTime();
		//----------------------------------------------------------------------------------------------
		arr = mergeSort(arr);
		//arrList = insertionSort(arrList);
		//----------------------------------------------------------------------------------------------
		
		System.out.println((System.nanoTime()-startTime)	/Math.pow(10, 9));
		//System.out.println(Arrays.toString(arr));//bis 6500
	}
	
	
	
	
	
	
	
	//O(n²)
	private static int[] selectionSort(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int z=i; z<arr.length; z++) {
				
				
				if(arr[i]>arr[z]) {
					
					int g = arr[i];
					int k = arr[z];
					
					arr[i] = k;
					arr[z] = g;
				}
				
				
			}
		}
		return arr;
	}

	
	
	
	
	
	
	//O(n²)
	private static int[] bubbleSort(int[] arr) {
		
		int end= arr.length-1;
		while(end>0) {
			
			for(int i=0; i<end; i++) {
				if(arr[i] > arr[i+1]) {
					int g= arr[i];
					int k= arr[i+1];
					
					arr[i] = k;
					arr[i+1] = g;
				}
			}
			
			end--;
		}
		return arr;
	}
	
	
	
	
	
	
	//O(n*log(n))
	private static int[] mergeSort(int[] arr) {

		if(arr.length==1)
			return arr;
		
		int middleIndex = arr.length/2;
		
		int[] arrL = Arrays.copyOfRange(arr, 0, middleIndex);
		int[] arrR = Arrays.copyOfRange(arr, middleIndex, arr.length);
		
		arrL = mergeSort(arrL);
		arrR = mergeSort(arrR);
		
		//-----------------------------------------------------sort and write arrL and arrR in arr
		int controllR =0;
		int controllL = 0;
		int counter=0;
		
		while(controllR < arrR.length || controllL < arrL.length) {
			
			if(controllR<arrR.length && controllL < arrL.length) {
				if(arrR[controllR] < arrL[controllL]) {
					arr[counter] = arrR[controllR];
					controllR++;
				}else {
					arr[counter] = arrL[controllL];
					controllL++;
				}
				counter++;
				continue;
			}
			
			if(controllR < arrR.length && !(controllL < arrL.length) ) {
				arr[counter] = arrR[controllR];
				controllR++;
			}else
				if(!(controllR < arrR.length) && controllL < arrL.length) {
					arr[counter] = arrL[controllL];
					controllL++;
				}
			counter++;
		}
		//----------------------------------------------------
		
		return arr;
	}
	
	
	
	
	
	
	
	private static ArrayList<Integer> insertionSort(ArrayList<Integer> list){
		
		ArrayList<Integer> resList = new ArrayList<Integer>();
		
		int compareValue;
		int index;
		
		while(list.size() > 0) {
			
			index =0;
			compareValue = list.get(0);
			
			for(int i=0; i<list.size(); i++) {
				if(compareValue > list.get(i)) {
					compareValue=list.get(i);
					index = i;
				}
			}
			
			resList.add(compareValue);
			list.remove(index);
		}
		
		return resList;
	}

}
