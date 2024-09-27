import java.io.*;

public class Polynomial{
    double [] coeff;
    int [] expo;

    Polynomial(){
        coeff = new double[1];
        coeff[0] = 0;

    }

    Polynomial(double [] coeff, int [] expo){
        this.coeff = coeff;
        this.expo = expo;
    }
    
    Polynomial(File file){
        
        try{
            Filereader filereader = new Filereader(file);
            BufferedReader reader = new BufferedReader(filereader);

            String line = reader.readline();

          

            String [] terms = line.split("(?=[+-])");
            coeff = new coeff[terms.length];
            expo = new expo[terms.length];

            for (int i = 0; i < terms.length; i++){
                String term = terms[i];
                if(term.contains("x")){
                    String [] substring = term.split("x");
                    coeff[i] = parseDouble(subtring[0]);
                    expo[i] = parseInt(subtring[1]);
                }
                else{
                    coeff[i] = parseDouble(term);
                    expo[i] = 0;
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        coeff = new double[str.length];
        expo = new int[str.length];


    }

    Polynomial multiply(Polynomial p2){
        result_coeff = new double[this.coeff.length * p2.coeff.length];
        result_expo = new int[this.expo.length * p2.expo.length];

        int index = 0;
        for (int i = 0; i < this.coeff.length; i++){
            for(int j = 0; j < p2.coeff.length; j++){
                result_coeff[index] = this.coeff[i] * p2.coeff[j];
                result_expo[index] = this.expo[i] + p2.expo[j];
                index++;
            }
        }

        return new Polynomial(result_coeff, result_expo);
    }

    void saveToFile(String fileName){
        try{
            Filewriter filewriter = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(filewriter);

            for(int i = 0;i < coeff.length; i++){
                double coefficient = coeff[i];
                int exponent = expo[i];
                if(i == 0){
                    writer.write(coefficent);
                    if(exponent != 0){
                        writer.write("x^" + exponent);
                    }
                    
                }
                else{
                    if (coefficient > 0){
                        writer.write("+");
                    }
                    writer.write(coefficient + "x^" + exponent);
                }

            }
        }

        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    Polynomial add(Polynomial poly){
        int maxLength = Math.max(this.coeff.length, poly.coeff.length);
        double [] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++){
            double thisCoeff = i < this.coeff.length ? this.coeff[i] : 0;
            double polyCoeff = i < poly.coeff.length ? poly.coeff[i] : 0;

            result[i] = thisCoeff + polyCoeff;
        }

        return new Polynomial(result);

    }


    double evaluate(double x){
        double result = 0;

        for (int i = 0; i < coeff.length; i++)
            result += coeff[i] * Math.pow(x, expo[i]);
        

        return result;
    }

    boolean hasRoot(double x){
        double result = 0;

        for (int i = 0; i < coeff.length; i++)
            result += coeff[i] * Math.pow(x, expo[i]);

        if (result == 0)
            return true;

        return false;
    }
}