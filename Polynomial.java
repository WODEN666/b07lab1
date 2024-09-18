public class Polynomial{
    double [] coeff;

    Polynomial(){
        coeff = new double[1];
        coeff[0] = 0;

    }

    Polynomial(double [] coeff){
        this.coeff = coeff;

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
            result += coeff[i] * Math.pow(x, i);
        

        return result;
    }

    boolean hasRoot(double x){
        double result = 0;

        for (int i = 0; i < coeff.length; i++)
            result += coeff[i] * Math.pow(x, i);

        if (result == 0)
            return true;

        return false;
    }
}