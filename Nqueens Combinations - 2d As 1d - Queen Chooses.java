import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
       for(int i=row,j=col;i>=0;i--)
       {
           if(chess[i][j])
           {
               
               return false;
           }
       }
       for(int i=row,j=col;j>=0;j--)
       {
           if(chess[i][j])
           {
               
               return false;
           }
       }
       for(int i=row,j=col;i>=0&& j>=0;i--,j--)
       {
           if(chess[i][j])
           {
               
               return false;
           }
           
       }
       
    
       for(int i=row,j=col;i >= 0 && j < chess.length;i--,j++)
       {
           if(chess[i][j])
           {
               
               return false;
           }
           
        }
    
        return true;
    }

     public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        
        
        
        if(qpsf==tq)
        {
            for(int row=0;row<chess.length;row++)
            {
                for(int col=0;col<chess.length;col++)
                {
                    if(chess[row][col]==true)
                    {
                        System.out.print("q\t");
                    }
                    else
                    {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int cell=lcno+1;cell<chess.length*chess.length;cell++)
        {
            int row = cell/chess.length;
            int col = cell % chess.length;
            
            
            if(chess[row][col]==false && IsQueenSafe(chess,row,col))
            {
               chess[row][col]=true;
               queensCombinations(qpsf+1,tq,chess,cell);
               chess[row][col]=false; 
            }
            
            
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}