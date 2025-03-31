class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l>=r){
            return;
        }
       int mid = l + (r - l) / 2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,r,mid);
    }
    public static void merge(int[] arr, int start,int end, int mid){
        int[] temp=new int[end-start+1];
        int i=start,j=mid+1,index=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[index++]=arr[i];
                i++;
            }
            else{
                temp[index++]=arr[j];
                j++;
            }
        }
        while(i<=mid){
            temp[index++]=arr[i];
            i++;
        }
        while(j<=end){
            temp[index++]=arr[j];
            j++;
        }
        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }
}
