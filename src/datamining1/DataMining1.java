/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package datamining1;

import java.lang.Object;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author SuperUser
 */
public class DataMining1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
                        CsvReader products=null;
                        
                        try
                        {
                            products = new CsvReader("D:\\DataSets\\newiris.csv");
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
                         products = new CsvReader("D:\\DataSets\\newiris.csv");
                        }
                        catch(FileNotFoundException E)
                        {
                                System.out.println(E.getMessage());
                        }
                        double[] predictedvalues=new double[RowCount];
                        double[] predictedvaluesloose=new double[RowCount/5];
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
        // Start of the program where the entire dataset is divided into training and test dataset.
        
        int k=5;
         for(int l=1;l<=k;l++)
         {
             if(l==1)
             {
              // int k=5;
                     int Fold=1;
                     int testrowcount=RowCount/k;
                     int trainingrowcount=RowCount-testrowcount;
                     double[][] Dataarraytest= new double[testrowcount][ColumnCount];
                     double[][] Dataarraytraining= new double[trainingrowcount][ColumnCount];
                     for(int i=0;i<testrowcount;i++)
                        {
                                for(int j=0;j<ColumnCount;j++)
                                {
                                
                                    Dataarraytest[i][j]=Dataarray[i][j];
                                  
                                   
                                }
                        }
                     for(int i=testrowcount;i<RowCount;i++)
                        {
                                for(int j=0;j<ColumnCount;j++)
                                {
                                    try
                                   {
                                    int z=i-(testrowcount);
                                      
                                    Dataarraytraining[z][j]=Dataarray[i][j];
                                   
                                     }
                                   catch(Exception E)
                                   {
                                       System.out.println(E.getMessage());
                                   }
                                }
                        }
    EucDistances objEuc=new EucDistances();
    predictedvaluesloose=objEuc.calcdistance(Dataarraytest,Dataarraytraining, Fold, RowCount);
            for(int jk=0;jk<(RowCount/5);jk++)
            {                    predictedvalues[jk]= predictedvaluesloose[jk];   
                
                
            }
    
             }
             if(l==2)
             {
                 int Fold=2;
                          int testrowcount=RowCount/k;
                                                int trainingrowcount=RowCount-testrowcount;
                                                double[][] Dataarraytest= new double[testrowcount][ColumnCount];
                                                double[][] Dataarraytraining= new double[trainingrowcount][ColumnCount];
                                                for(int i=testrowcount;i<(2*testrowcount);i++)
                                                    
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                                 int z=i-(testrowcount);
                                                               Dataarraytest[z][j]=Dataarray[i][j];


                                                           }
                                                   }
                                                for(int i=0;i<testrowcount;i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               //int z=i-30;

                                                               Dataarraytraining[i][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                                                for(int i=(2*testrowcount);i<RowCount;i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               int z=i-(testrowcount);

                                                               Dataarraytraining[z][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                               EucDistances objEuc=new EucDistances();
                              // double[] predictedvalues=new double[Dataarraytest.length];
                                predictedvaluesloose=objEuc.calcdistance(Dataarraytest,Dataarraytraining, Fold, RowCount);
            
               for(int fg=0;fg<(RowCount/5);fg++)
                {
                    predictedvalues[fg+(testrowcount*(Fold-1))]= predictedvaluesloose[fg];   
                }
                
                
            
             }
             if(l==3)
             {
                 int Fold=3;
                          int testrowcount=RowCount/k;
                                                int trainingrowcount=RowCount-testrowcount;
                                                double[][] Dataarraytest= new double[testrowcount][ColumnCount];
                                                double[][] Dataarraytraining= new double[trainingrowcount][ColumnCount];
                                                for(int i=(2*testrowcount);i<(3*testrowcount);i++)
                                                    
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                                int z=i-(2*testrowcount);
                                                               Dataarraytest[z][j]=Dataarray[i][j];


                                                           }
                                                   }
                                                for(int i=0;i<(2*testrowcount);i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               //int z=i-30;

                                                               Dataarraytraining[i][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                                                for(int i=(3*testrowcount);i<RowCount;i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               int z=i-(testrowcount);

                                                               Dataarraytraining[z][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                               EucDistances objEuc=new EucDistances();
                              // double[] predictedvalues=new double[Dataarraytest.length];
                               predictedvaluesloose=objEuc.calcdistance(Dataarraytest,Dataarraytraining, Fold, RowCount);
            
              for(int fg=0;fg<(RowCount/5);fg++)
                {
                    predictedvalues[fg+(testrowcount*(Fold-1))]= predictedvaluesloose[fg];   
                }
                
                
           
             }
             if(l==4)
             {
                 int Fold=4;
                          int testrowcount=RowCount/k;
                                                int trainingrowcount=RowCount-testrowcount;
                                                double[][] Dataarraytest= new double[testrowcount][ColumnCount];
                                                double[][] Dataarraytraining= new double[trainingrowcount][ColumnCount];
                                                for(int i=(3*testrowcount);i<(4*testrowcount);i++)
                                                    
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                                int z=i-(3*testrowcount);
                                                               Dataarraytest[z][j]=Dataarray[i][j];


                                                           }
                                                   }
                                                for(int i=0;i<(3*testrowcount);i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               //int z=i-30;

                                                               Dataarraytraining[i][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                                                for(int i=(4*testrowcount);i<RowCount;i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               int z=i-(testrowcount);

                                                               Dataarraytraining[z][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                               EucDistances objEuc=new EucDistances();
                              // double[] predictedvalues=new double[Dataarraytest.length];
                             predictedvaluesloose=objEuc.calcdistance(Dataarraytest,Dataarraytraining, Fold, RowCount);
            
               for(int fg=0;fg<(RowCount/5);fg++)
                {
                    predictedvalues[fg+(testrowcount*(Fold-1))]= predictedvaluesloose[fg];   
                }
                
           
             }
             if(l==5)
             {
                 int Fold=5;
                          int testrowcount=RowCount/k;
                                                int trainingrowcount=RowCount-testrowcount;
                                                double[][] Dataarraytest= new double[testrowcount][ColumnCount];
                                                double[][] Dataarraytraining= new double[trainingrowcount][ColumnCount];
                                                for(int i=(4*testrowcount);i<RowCount;i++)
                                                    
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                                 int z=i-(4*testrowcount);
                                                               Dataarraytest[z][j]=Dataarray[i][j];


                                                           }
                                                   }
                                                for(int i=0;i<(4*testrowcount);i++)
                                                   {
                                                           for(int j=0;j<ColumnCount;j++)
                                                           {
                                                               try
                                                              {
                                                               //int z=i-30;

                                                               Dataarraytraining[i][j]=Dataarray[i][j];

                                                                }
                                                              catch(Exception E)
                                                              {
                                                                  System.out.println(E.getMessage());
                                                              }
                                                           }
                                                   }
                                               
                               EucDistances objEuc=new EucDistances();
                             //  double[] predictedvalues=new double[Dataarraytest.length];
                               predictedvaluesloose=objEuc.calcdistance(Dataarraytest,Dataarraytraining, Fold, RowCount);
            
               
                for(int fg=0;fg<(RowCount/5);fg++)
                {
                    
                    predictedvalues[fg+(testrowcount*(Fold-1))]= predictedvaluesloose[fg];   
                }
                
               
                
           
             }
             }
        
        
    accuracycheck obj=new accuracycheck();
    float Accuracy = obj.Accuracy(predictedvalues);
    System.out.println(Accuracy);
    }
}
    
    

