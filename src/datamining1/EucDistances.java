/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining1;

/**
 *
 * @author SuperUser
 */
public class EucDistances {

    public double[] calcdistance(double[][] DataSettest, double[][] DataSettraining, int Fold, int RowCount)
    {
        double predictedclass=0;
        double[] predictedvalues=new double[DataSettest.length];
        double[][] distarray = new double[DataSettest.length][DataSettraining.length];
        
        for (int i = 0; i < DataSettest.length; i++) 
        {

           // double summation=0;
                for (int k = 0; k < DataSettraining.length;k++) 
                {
                       double summation=0;
                    for (int l = 0;l<DataSettraining[k].length; l++) 
                    {
                       double num1=DataSettest[i][l];
                       double num2=DataSettraining[k][l];
                       double subresult=num1-num2;
                        summation +=(Math.pow(subresult, 2));
                        summation=Math.round(summation*100.0)/100.0;
                      //  System.out.println(summation);
                    }    
                    
                
                distarray[i][k] = Math.sqrt(summation);
                
               
                }
                
        }
        
       Prediction objprediction1=new Prediction();
              predictedvalues=  objprediction1.calcclass(distarray, Fold, RowCount);
              //  predictedvalues[i]=predictedclass;
            return predictedvalues;
    }

}
