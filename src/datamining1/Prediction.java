/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining1;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 *
 * @author SuperUser
 */
public class Prediction {
   
    public double[] calcclass( double[][] distarray, int Fold, int RowCount )
    {   int greater;
        double predictedclass=0;
        double minvalue=0.0;
        double[] predictedvalues=new double[distarray.length];
        double[][] distSDarray=new double[distarray[0].length][2];
         double[] distSDarraytemp=null;
        for(int i=0;i<distarray.length;i++)
        {
            
           // minvalue=distarray[i][0];
            for(int k=0;k<distarray[0].length;k++)
            {
            distSDarray[k][0]= distarray[i][k];
            distSDarray[k][1]= k;
            if(distarray[i][k]<minvalue)
            {
                minvalue=distarray[i][k];
            }
            //System.out.println(distSDarray[k]);
            
            }
            
        //   distSDarraytemp=distSDarray;
        //   Arrays.sort(distSDarraytemp);
            
             for(int indexL=0;indexL<distSDarray.length;indexL++)
        {
           // greater=0;
            for(int indexR=0;indexR<distSDarray.length;indexR++)
            {
                if(distSDarray[indexL][0]<distSDarray[indexR][0])
                {
                  double temp1=0;
                  double temp2=0;
                  temp1=distSDarray[indexL][0];
                  temp2=distSDarray[indexL][1];
                  distSDarray[indexL][0]=distSDarray[indexR][0];
                  distSDarray[indexL][1]=distSDarray[indexR][1];
                  distSDarray[indexR][0]=temp1;
                  distSDarray[indexR][1]=temp2;
                }
            }
          //  orderedNums[greater]=tenNums[indexL];
        }
            
            
            
           FindIndexes objfind= new FindIndexes();
          predictedclass=  objfind.FindIndexesandcheck(distSDarray,  i, Fold,RowCount);
          predictedvalues[i]=predictedclass;
            
        }
         return predictedvalues;
    }
}
