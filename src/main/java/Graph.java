import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

    public boolean isMatrix(int[][] arr){
        int n=arr.length;
        for(int k = 0; k<n;k++){
            if (arr[k].length!=n) return false;
        }
        return true;
    }

    public int algorithm(int[][] arr){
        boolean runTheMethod = new Graph().isMatrix(arr);
        if(runTheMethod==false){
            System.out.println("The array doesnt meet the conditions");
            return 0;
        }
        int n = arr.length;
        List<Integer> path = new ArrayList<Integer>();
        List<Integer> subPath = new ArrayList<Integer>();
        int maxFirst = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            System.out.println("initialVertex->["+i+"][0] = "+arr[i][0]);
            path.add(arr[i][0]);
            subPath.add(arr[i][0]);
        }
        for(int j=1;j<n;j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    max = Math.max(subPath.get(i) + arr[i][j], subPath.get(i+1) + arr[i][j]);
                    path.add(max);
                    System.out.println("initialVertex->[" + i + "][" + j + "] = " + path.get(path.size() - 1));
                } else if (i == (n - 1)) {
                    max = Math.max(subPath.get(i) + arr[i][j], subPath.get(i-1) + arr[i][j]);
                    path.add(max);
                    System.out.println("initialVertex->[" + i + "][" + j + "] = " + path.get(path.size() - 1));
                } else {
                    maxFirst = Math.max(subPath.get(i) + arr[i][j], subPath.get(i+1) + arr[i][j]);
                    max = Math.max(maxFirst, subPath.get(i-1) + arr[i][j]);
                    path.add(max);
                    System.out.println("initialVertex->[" + i + "][" + j + "] = " + path.get(path.size() - 1));
                }
            }
            for(int i = 0; i<n;i++) {
                subPath.set(i, path.get(path.size() - n + i));
            }
        }
        return Collections.max(path);
    }

    public static void main(String[] args) {
        //int[][] arr = {{1,3,3},{2,1,4},{0,6,4}};
        int[][] arr = {{1,3,3,7},{2,1,4,8},{0,6,4,3},{2,4,5,1}};
        int result = new Graph().algorithm(arr);
        System.out.println("The longest path is "+result);
    }
}


