class BuildingSegmentTree{
    int[] tree;
    int n;

     BuildingSegmentTree(int[] nums){
        n = nums.length;

        tree = new int[4*n];

        //call build tree function
        buildTree(0, 0, n-1, nums);
    }
    
    private void buildTree(int idx, int start, int end, int[] nums){
        if(start == end){
            tree[idx] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;

        //build left subtree
         buildTree(2*idx+1, start, mid, nums);
        //build right subtree
         buildTree(2*idx+2, mid+1, end, nums);

         //store sum 
         tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public void printTree(){
       for(int i=0; i<tree.length; i++){
         System.out.println(tree[i]+" ");
       }
    }

     public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7};

        SegmentTree st = new SegmentTree(nums);

        st.printTree();
    }
}