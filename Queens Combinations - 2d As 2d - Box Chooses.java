import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        
        
        if(row==tq)
        {
            if(qpsf==tq)
            {
                System.out.println(asf);
            }
            
            return;
        }
        int nrow = 0;
        int ncol=0;
        String yansf="";
        String nansf="";
        if(col==tq-1)
        {
            nrow= row+1;
            ncol=0;
           yansf=asf+"q\n";
            nansf= asf+"-\n";
        }
        else
        {
            nrow = row;
            ncol=col+1;
            yansf=asf+"q";
            nansf= asf+"-";
            
        }
        queensCombinations(qpsf+1, tq, nrow, ncol,yansf);
        queensCombinations(qpsf+0, tq, nrow, ncol,nansf);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
