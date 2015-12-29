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
public class classMajority {
    public double classmjcalc(double[] classpredicted)
    {
        int i=0;
        double[][] count=new double[5][2];
      //  for(int j=0;j<5;j++)
       // {
            
            
                
                
                for(int m=0;m<5;m++)
                {
                    count[m][0]=classpredicted[m];
                    double increment=0.00;
                    for(int n=0;n<5;n++)
                    {
                        String num1 = new Double(classpredicted[m]).toString();
                        String num2 = new Double(classpredicted[n]).toString();
                       if(num1.equals(num2))
                       {
                           increment=increment+1;
                       }
                    }
                    count[m][1]=increment;
                } 
       // }
        double bb=0;
        double index=0;
        for(int b=0;b<5;b++)
        {
            
                
                if(bb<count[b][1])
                {
                    bb=count[b][1];
                    index=count[b][0];
                }
                    
            
        }
       
    return index;
    }
    
}
