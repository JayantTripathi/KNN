/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamining1;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author SuperUser
 */
public class accuracycheck {
    
    public float Accuracy(double[] result){
        double[] classpredicted=new double[5];
         CsvReader products=null;
         float counter=0;
         double predictedclass=0;
                        try
                        {
                            products = new CsvReader("D:\\DataSets\\newirislabel.csv");
                        }
                        catch(FileNotFoundException EB)
                        {
                            System.out.println(EB.getMessage());
                        }
                        int ColumnCount=0;
                        int RowCount =0;
                        int iloop=0;
                        try
                        {
                            while (products.readRecord())
                            {    
                            ColumnCount=products.getColumnCount();
                            RowCount++;
                            
                            }
                        }
                        catch(IOException EN)
                        {
                            System.out.println(EN.getMessage());
                        }
                        try 
                        {
                         products = new CsvReader("D:\\DataSets\\newirislabel.csv");
                        }
                        catch(FileNotFoundException E)
                        {
                                System.out.println(E.getMessage());
                        }
                        double[][] Dataarray= new double[RowCount][ColumnCount];
                        try
                        {
                            while (products.readRecord())
                            {    
                            String v;
                            String[] x;
                            v = products.getRawRecord();
                            x =v.split(",");
                               for(int j=0;j<ColumnCount;j++)
                                {
                                    double value=0;
                                    int z=j;
                                    value=Double.parseDouble(x[z]);
                                    try
                                    {
                                    Dataarray[iloop][j]=value;
                                    }
                                    catch(Exception E)
                                    {
                                        System.out.println(E.getMessage());
                                    }
                                   // System.out.println(Dataarray[iloop][j]);
                                    }
                            iloop=iloop+1;    
                            }
                            }
                        catch(IOException Em)
                        {
                        System.out.println(Em.getMessage());
                        }
                        
	products.close();
        for (int i=0;i<RowCount;i++)
        {
                  String num1 = new Double(Dataarray[i][0]).toString();
                  String num2 = new Double(result[i]).toString();
                if(num1.equals(num2))
                {
               counter=counter+1;
                }
            
        }
return (counter/RowCount)*100;
}
}
