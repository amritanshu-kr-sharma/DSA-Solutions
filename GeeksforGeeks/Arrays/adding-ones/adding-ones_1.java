class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        // code here
        // In this case we will 1stly create a aaraylist 
        // then we will increase by 1 from the required index using the updates array
        // and then increase it by on adding 1 to the index element
        // But it is giving TLE
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i=0; i<n; i++) {
        //     arr.add(0);
        // }
        // // Arrays.sort(updates);
        // for(int i=0; i<updates.length; i++) {
        //     int idx = updates[i]-1;
        //     for(int j=idx; j<n; j++) {
        //         arr.set(j, arr.get(j)+1);
        //     }
        // }
        // return arr;
        
        // 2nd Method
        // In this method we Instead of updating all subsequent elements immediately, 
        // I can record the starting positions of the updates in a separate array.
        // After processing all updates, I can traverse this array and calculate a running sum. 
        // This running sum tells me how many updates affect each position.
        
        // create a diff arr
        int[] diff = new int[n+1];
        // Record the updates
        for(int i=0; i<updates.length; i++) {
            diff[updates[i]-1]++;
        }
        // Calculate the running sum
        ArrayList<Integer> arr = new ArrayList<>(n);
        int count = 0;
        for(int i=0; i<n; i++) {
            count += diff[i];
            arr.add(count);
        }
        return arr;
    }
}
