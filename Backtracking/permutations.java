// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void permut(int[] arr,List<List<Integer>>ans,ArrayList<Integer> temp,int[] visited){
        if(temp.size()==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                temp.add(arr[i]);
                permut(arr,ans,temp,visited);
                visited[i]=0;
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int[] visited=new int[n];
        ArrayList<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        permut(arr,ans,temp,visited);
        System.out.println(ans);
        
    }
}
