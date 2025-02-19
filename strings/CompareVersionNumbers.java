class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1=version1.split("\\.");
        String[] arr2=version2.split("\\.");
        int n1=arr1.length;
        int n2=arr2.length;
        int i=0,j=0;
        while(i<n1 && j<n2){
            if(Integer.parseInt(arr1[i])>Integer.parseInt(arr2[j])){
                return 1;
            }
            else if(Integer.parseInt(arr2[j])>Integer.parseInt(arr1[i])){
                return -1;
            }
            i++;
            j++;
        }
        while(i<n1){
            if(Integer.parseInt(arr1[i])!=0){
                return 1;
            }
            i++;
        }
        while(j<n2){
            if(Integer.parseInt(arr2[j])!=0){
                return -1;
            }
            j++;
        }
        return 0;
    }
}
