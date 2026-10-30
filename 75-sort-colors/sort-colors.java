class Solution {
    public void sortColors(int[] nums) {

        // 1st method by simple sorting 
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]>nums[j]){  //Here we will check if the 1st no is greater than the 2nd it will swap the no.
        //             int t = nums[i];    //1stly we assign the 1st num value
        //             nums[i] = nums[j];  //Then we will allot the 2nd value in 1st
        //             nums[j] = t;    //Then we will allot the 1st value in 2nd that we have assigned earlier  
        //         }
        //     }
        // }

        // 2nd method by bubble sort
        // for(int i=0;i<nums.length;i++){
        //     int value = 0;
        //     for(int j=0;j<nums.length-1-i;j++){
        //         if(nums[j] > nums[j+1]){
        //             int temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //             value = 1;
        //         }
        //     }
        //     if(value == 0){     // This will check kab tk bubble karega
        //         break;
        //     }
        // }

        // 3rd method
        // Arrays.sort(nums);

        // 4th method 
        // By using Dutch National Flag in this we will use 3 partition
        // first will be low for the next position of 0 
        // 2nd will be mid for the current value if mid = 0 swap with low & mid++ low++, if mid = 2 swap with high & only high-- and mid = 1, mid++
        // 3rd will be high for the next position of 2
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else if(nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
            else {
                mid++; 
            }
        }
    }
}