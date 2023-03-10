import java.util.*;
public class Array2D {

    // search key 
    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.println(key + " is at : (" + i + "," + j + ")");
                return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    // 1 spiral matrix 
    public static void spiralMatrix(int mat[][]){
        int startRow = 0;
        int endRow = mat.length-1;
        int startCol = 0;
        int endCol = mat[0].length-1;
        
        while(startRow <= endRow && startCol <= endCol){
            // top
            for(int j=startCol; j<=endCol; j++){
                System.out.print(mat[startRow][j] + "  ");
            }
            // right 
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(mat[i][endCol] + "  ");
            }
            // bottom
            for(int j=endCol-1; j>=startCol; j--){
                System.out.print(mat[endRow][j] + "  ");
            }
            // left
            for(int i=endRow-1; i>=startRow+1; i--){
                System.out.print(mat[i][startCol]+ "  ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    // 2 diagonal sum
    public static int diagSum(int mat[][]){
        int sum = 0;
        
        /*for(int i=0; i<mat.length; i++){        // TC = O(n^2)
            for(int j=0; j<mat[0].length; j++){
                if(i == j){
                    sum += mat[i][j]; 
                }
                else if(i+j == mat.length-1){
                    sum += mat[i][j];
                }
            }
        }*/

        // optimize code    TC = O(n)
        for(int i=0; i<mat.length; i++){
            sum += mat[i][i];               // PD
            sum += mat[i][mat.length-i-1];  // SD
        }
        return sum;
    }

    // search in sorted 2D array(staircase search)
    public static boolean staircaseSearch(int sorArr[][], int key){
        int row=0, col=sorArr[0].length-1;
        while(row<sorArr.length && col>=0){
            if(sorArr[row][col] == key){
                System.out.println("key found at (" + row + "," + col + ")");
                return true;
            }
            else if(key < sorArr[row][col]){
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found!!");
        return false;
    }

    
    public static void main(String...arg){
        Scanner sc = new Scanner(System.in);
        
       /* // 1 simple example ( input-output-search key)
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;   // n=row m=colums
        // input
        System.out.print("enter elements of 2D array : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        // output
        System.out.println("matrix : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // search key
        System.out.print("enter a number to find in array : ");
        int key = sc.nextInt();
        search(matrix,key);   */

        // 1 spiral matrix
        int mat[][] = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12},
                      {13,14,15,16}};
        // spiralMatrix(mat);  
        
        // 2 diagonal sum
        // System.out.print("Diagonal sum : " + diagSum(mat));
        
        // 3 search in sorted array
        //System.out.print("enter a number to find : ");
        //int key = sc.nextInt();
        int sorArr[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};
        //staircaseSearch(sorArr, key);                  
    }
}
