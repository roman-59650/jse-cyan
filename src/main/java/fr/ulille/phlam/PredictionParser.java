package fr.ulille.phlam;

import fr.ulille.phlam.entities.Datatable;
import fr.ulille.phlam.entities.PredictedTransition;

import java.util.ArrayList;
import java.util.List;

public class PredictionParser {

    private Datatable datatable;

    public PredictionParser(Datatable datatable){
        this.datatable = datatable;
    }

    public Number StrToNum(String num){
        double value = 0;
        for (int i=0;i<num.length();i++){
            int asciiValue = num.charAt(i);
            double pow10 = Math.pow(10, num.length()-i-1);
            if (asciiValue<0x3A) value += pow10*(asciiValue-0x30);
            else value += pow10*(asciiValue-0x37);
        }
        return value;
    }

    private PredictedTransition parseCat(String line){
        PredictedTransition transition = new PredictedTransition(datatable);
        double freq = Double.parseDouble(line.substring(0,13));
        double amp = Double.parseDouble(line.substring(22,30));
        int qncount = Integer.parseInt(line.substring(54,55));
        transition.setFrequency(freq);
        transition.setIntensity(Math.pow(10,amp));

        List<Number> quantumNumbers = new ArrayList<>();
        int qi = 55;
        for (int i=0;i<qncount;i++){
            String ss = line.substring(qi,qi+2).trim();
            quantumNumbers.add(StrToNum(ss));
            qi+=2;
        }
        qi = 67;
        for (int i=0;i<qncount;i++){
            String ss = line.substring(qi,qi+2).trim();
            quantumNumbers.add(StrToNum(ss));
            qi+=2;
        }

        if (qncount==3){
            transition.setQn21(quantumNumbers.get(0).shortValue());
            transition.setQn22(quantumNumbers.get(1).shortValue());
            transition.setQn23(quantumNumbers.get(2).shortValue());
            transition.setQn11(quantumNumbers.get(3).shortValue());
            transition.setQn12(quantumNumbers.get(4).shortValue());
            transition.setQn13(quantumNumbers.get(5).shortValue());
        }

        if (qncount==4){
            transition.setQn21(quantumNumbers.get(0).shortValue());
            transition.setQn22(quantumNumbers.get(1).shortValue());
            transition.setQn23(quantumNumbers.get(2).shortValue());
            transition.setQn24(quantumNumbers.get(3).shortValue());
            transition.setQn11(quantumNumbers.get(4).shortValue());
            transition.setQn12(quantumNumbers.get(5).shortValue());
            transition.setQn13(quantumNumbers.get(6).shortValue());
            transition.setQn14(quantumNumbers.get(7).shortValue());
        }

        if (qncount==5){
            transition.setQn21(quantumNumbers.get(0).shortValue());
            transition.setQn22(quantumNumbers.get(1).shortValue());
            transition.setQn23(quantumNumbers.get(2).shortValue());
            transition.setQn24(quantumNumbers.get(3).shortValue());
            transition.setQn25(quantumNumbers.get(4).shortValue());
            transition.setQn11(quantumNumbers.get(5).shortValue());
            transition.setQn12(quantumNumbers.get(6).shortValue());
            transition.setQn13(quantumNumbers.get(7).shortValue());
            transition.setQn14(quantumNumbers.get(8).shortValue());
            transition.setQn15(quantumNumbers.get(9).shortValue());
        }

        if (qncount==6){
            transition.setQn21(quantumNumbers.get(0).shortValue());
            transition.setQn22(quantumNumbers.get(1).shortValue());
            transition.setQn23(quantumNumbers.get(2).shortValue());
            transition.setQn24(quantumNumbers.get(3).shortValue());
            transition.setQn25(quantumNumbers.get(4).shortValue());
            transition.setQn26(quantumNumbers.get(5).shortValue());
            transition.setQn11(quantumNumbers.get(6).shortValue());
            transition.setQn12(quantumNumbers.get(7).shortValue());
            transition.setQn13(quantumNumbers.get(8).shortValue());
            transition.setQn14(quantumNumbers.get(9).shortValue());
            transition.setQn15(quantumNumbers.get(10).shortValue());
            transition.setQn16(quantumNumbers.get(11).shortValue());
        }

        return transition;
    }

    public PredictedTransition parseTransition(String line){
        return parseCat(line);
    }
}
