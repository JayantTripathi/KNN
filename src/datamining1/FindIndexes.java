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
public class FindIndexes {
    
    public double FindIndexesandcheck(double[][] distSDarray,int which,int Fold, int RowCount)
    { 
        double[] top5results=new double[5];
        int[] Indexes= new int[5];
        double predictedclass=0;
     /* for(int i=0;i<5;i++)
      {
          top5results[i]=distSDarraytemp[i];
      }*/
      for(int j=0;j<5;j++)
      {/*
          for(int k=0;k<distSDarraytemp.length;k++)
              {
                  String num1 = new Double(distSDarray[which][k]).toString();
                  String num2 = new Double(distSDarraytemp[j]).toString();
                 // string compvalue=distSDarray[k].;
                 // top5results[j]
                if(num1.equals(num2))
                {
                    try 
                    {
                    int z=k+1;
                    Indexes[j]=z;
                     break;
                   // System.out.println(Indexes[j]);
                    }
                    catch(Exception E)
                    {
                        System.out.println(E.getMessage());
                    }
                }
              }*/
          Indexes[j]=(int)distSDarray[j][1]+1;
      }
      ClassPrediction objpre=new ClassPrediction();
           predictedclass= objpre.classpredictionfunc(Indexes,Fold,RowCount);
            return  predictedclass;
    }
    
}
