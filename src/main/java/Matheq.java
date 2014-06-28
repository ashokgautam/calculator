/**
 * Created by mattiasst on 2014-06-10.
 */
import java.util.*;

public class Matheq {

    String fnum = null;
    String lnum = null;
    String total = null;
    String output = "";
    String output2 = "";
    String negcheck = "";
    String[] splitstr;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Matheq matheq = new Matheq();
    }

    public boolean isOperator(String[] splitstr, char op){
        switch(op){
            case '+':
                for(int i=0; i<splitstr.length; i++) {
                    output += splitstr[i] + " ";
                }
                StringBuffer buffer = new StringBuffer(output);
                output2 = buffer.reverse().toString();
                System.out.println("Add sign" + buffer.reverse().indexOf("+"));
                if(output2.indexOf("+") > output2.indexOf("-") &&
                        output.indexOf("*") == -1 &&
                        output.indexOf("/") == -1 ||
                        output.indexOf("-") == -1 &&
                                output.indexOf("*") == -1 &&
                                output.indexOf("/") == -1){
                    buffer = null;
                    output = "";
                    return true;
                } else {
                    buffer = null;
                    output = "";
                    return false;
                }
            case '-':
                for(int i=0; i<splitstr.length; i++) {
                    output += splitstr[i] + " ";
                }
                System.out.println("out: "+output);
                StringBuffer buffer2 = new StringBuffer(output);
                output2 = buffer2.reverse().toString();
                System.out.println("Sub sign" + buffer2.reverse().indexOf("-"));
                if(output2.indexOf("-") > output2.indexOf("+") &&
                        output.indexOf("*") == -1 &&
                        output.indexOf("/") == -1 ||
                        output.indexOf("+") == -1 &&
                                output.indexOf("*") == -1 &&
                                output.indexOf("/") == -1){
                    buffer2 = null;
                    output = "";
                    return true;
                } else {
                    buffer2 = null;
                    output = "";
                    return false;
                }
            case '/':
                for(int i=0; i<splitstr.length; i++) {
                    output += splitstr[i] + " ";
                }
                StringBuffer buffer3 = new StringBuffer(output);
                output2 = buffer3.reverse().toString();
                System.out.println("Divid sign" + buffer3.reverse().indexOf("/"));
                if(buffer3.reverse().indexOf("/") > output2.indexOf("*") || output.indexOf("*") == -1){
                    buffer3 = null;
                    output = "";
                    output2 = "";
                    return true;
                } else {
                    buffer3 = null;
                    output2 = "";
                    output = "";
                    return false;
                }
            case '*':
                for(int i=0; i<splitstr.length; i++) {
                    output += splitstr[i] + " ";
                }
                StringBuffer buffer4 = new StringBuffer(output);
                output2 = buffer4.reverse().toString();
                if(output2.indexOf("*") > output2.indexOf("/") || output.indexOf("/") == -1){
                    buffer4 = null;
                    output = "";
                    output2 = "";
                    return true;
                } else {
                    buffer4 = null;
                    output2 = "";
                    output = "";
                    return false;
                }
            default:
                output = "";
                output2 = "";
                return false;
        }
    }


    public String getResult(String mathoperation) {
        //math(mathoperation);

        mathoperation = mathoperation.replaceAll(",", "");
        mathoperation = mathoperation.replaceAll("plus", "+");
        mathoperation = mathoperation.replaceAll("minus", "-");
        mathoperation = mathoperation.replaceAll("times", "*");
        mathoperation = mathoperation.replaceAll("divided by", "/");
        mathoperation = mathoperation.replaceAll("percent of", "percentof");

        splitstr = mathoperation.split(" ");

        while(splitstr.length > 1){
            for(int i=0; i<splitstr.length; i++) {
                splitstr[i] = negativecheck(splitstr[i]);
                System.out.println("Get value: " + splitstr[i]);
                if(splitstr[i].indexOf("percentof") >= 0) {
                    String buildit = splitstr[i-1] + " percent of " + splitstr[i+1];
                    String done = math(buildit);
                    System.out.println("Percentage operation: " + splitstr[i-1] + " percent of " + splitstr[i+1] + "=" + done);
                    splitstr[i] = done;
                    splitstr[i-1] = "";
                    splitstr[i+1] = "";
                    ArrayList<String> list = new ArrayList<String>();
                    for(String s : splitstr){
                        if(!s.equals("")){
                            list.add(s);
                        }
                    }
                    splitstr = list.toArray(new String[list.size()]);
                }
            }

            for(int o=0; o<splitstr.length; o++) {

                char[] chars = splitstr[o].toCharArray(); //convers input to character array
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    System.out.println(chars[j]);
                    //If next char is an operator pop the top 2 numbers and use that operand on them.
                    if ((chars[j] == '*') || (chars[j] == '/') || (chars[j] == '+') || (chars[j] == '-' )) {
                        switch(ch) {
                            case '/':
                                if(isOperator(splitstr, chars[j]) == true){
                                    if(splitstr[o].indexOf("/") >= 0) {
                                        String buildit = splitstr[o-1] + " divided by " + splitstr[o+1];
                                        String done = math(buildit);
                                        System.out.println("Division operation: " + splitstr[o-1] + " divided by " + splitstr[o+1] + "=" + done);
                                        splitstr[o] = done;
                                        splitstr[o-1] = "";
                                        splitstr[o+1] = "";
                                        ArrayList<String> list = new ArrayList<String>();
                                        for(String s : splitstr){
                                            if(!s.equals("")){
                                                list.add(s);
                                            }
                                        }
                                        splitstr = list.toArray(new String[list.size()]);
                                    }
                                }
                                break;
                            case '*':
                                if(isOperator(splitstr, chars[j]) == true){
                                    if(splitstr[o].indexOf("*") >= 0) {
                                        String buildit = splitstr[o-1] + " * " + splitstr[o+1];
                                        String done = math(buildit);
                                        System.out.println("Multiplication operation: "+ splitstr[o-1] + " * " + splitstr[o+1] + "=" + done);
                                        splitstr[o] = done;
                                        splitstr[o-1] = "";
                                        splitstr[o+1] = "";
                                        ArrayList<String> list = new ArrayList<String>();
                                        for(String s : splitstr){
                                            if(!s.equals("")){
                                                list.add(s);
                                            }
                                        }
                                        splitstr = list.toArray(new String[list.size()]);
                                    }
                                }
                                break;
                            case '+':
                                if(isOperator(splitstr, chars[j]) == true){
                                    if(splitstr[o].indexOf("+") >= 0) {
                                        String buildit = splitstr[o-1] + " + " + splitstr[o+1];
                                        String done = math(buildit);
                                        System.out.println("Add operation: " + splitstr[o-1] + " + " + splitstr[o+1] + "=" + done);
                                        splitstr[o] = done;
                                        splitstr[o-1] = "";
                                        splitstr[o+1] = "";
                                        ArrayList<String> list = new ArrayList<String>();
                                        for(String s : splitstr){
                                            if(!s.equals("")){
                                                list.add(s);
                                            }
                                        }
                                        splitstr = list.toArray(new String[list.size()]);
                                    }
                                }
                                break;
                            case '-':
                                if(isOperator(splitstr, chars[j]) == true){
                                    if(splitstr[o].indexOf("-") >= 0) {
                                        String buildit = splitstr[o-1] + " - " + splitstr[o+1];
                                        String done = math(buildit);
                                        System.out.println("Sub operation: "+ splitstr[o-1] + " - " + splitstr[o+1] + "=" + done);
                                        splitstr[o] = done;
                                        splitstr[o-1] = "";
                                        splitstr[o+1] = "";
                                        ArrayList<String> list = new ArrayList<String>();
                                        for(String s : splitstr){
                                            if(!s.equals("")){
                                                list.add(s);
                                            }
                                        }
                                        splitstr = list.toArray(new String[list.size()]);
                                    }
                                }
                                break;
                            default:
                                break;
                        }    //end switch
                    } // end if

                }
            }
            for(int i=0; i<splitstr.length; i++) {
                System.out.println("Final operation: " + total + " " + splitstr[i]);
            }
        }
        return total;

    }
    private String negativecheck(String splitstr2) {
        // TODO Auto-generated method stub
        if(splitstr2.contains("-") && splitstr2.length() > 1) {
            splitstr2 = splitstr2.replaceAll("-", "neg");
        }
        System.out.println("Negcheck" + splitstr2);

        //rebuild string array


        return splitstr2;
    }

    private String removeneg(String splitstr2) {
        // TODO Auto-generated method stub
        if(splitstr2.contains("neg")) {
            splitstr2 = splitstr2.replaceAll("neg", "-");
        }
        System.out.println("Negcheck" + splitstr2);
        return splitstr2;
    }
    private String math(String mathoperation) {
        // TODO Auto-generated method stub
        if(mathoperation.contains("percent of")){
            mathoperation = removeneg(mathoperation);
            mathoperation = mathoperation.replaceAll("percent of", "%");
            int str = mathoperation.indexOf("%");
            //System.out.println(str);
            fnum = mathoperation.substring(0, str-1);
            fnum = fnum.replaceAll(" ", "");
            fnum = "." + fnum;
            //System.out.println(fnum);
            double intfnum = Double.parseDouble(fnum);
            //System.out.println(intfnum);
            int lastind = mathoperation.length();
            //System.out.println(lastind);
            lnum = mathoperation.substring(str+1, lastind);
            lnum = lnum.replaceAll(" ", "");
            //System.out.println(lnum);
            double intlnum = Double.parseDouble(lnum);
            //System.out.println(intlnum);
            double tot = intlnum * intfnum;
            //System.out.println(tot);
            total = Double.toString(tot);
            if(total.length() == 3){
                total = total + "0";
            }
            if(total.length() > 5){
                total = total.substring(0, 4);
            }
            total = total.replace("0.", "");

        } else
        if(mathoperation.contains("-")){
            mathoperation = removeneg(mathoperation);
            int str = mathoperation.indexOf("-");
            fnum = mathoperation.substring(0, str-1);
            fnum = fnum.replaceAll(" ", "");
            //System.out.println(fnum);
            double intfnum = Double.parseDouble(fnum);
            //System.out.println(intfnum);
            int lastind = mathoperation.length();
            //System.out.println(lastind);
            lnum = mathoperation.substring(str+1, lastind);
            lnum = lnum.replaceAll(" ", "");
            //System.out.println(lnum);
            double intlnum = Double.parseDouble(lnum);
            //System.out.println(intlnum);
            double tot = intfnum - intlnum;
            System.out.println(tot);
            total = Double.toString(tot);
            //System.out.println(total);
        } else
        if(mathoperation.contains("+")){
            mathoperation = removeneg(mathoperation);
            int str = mathoperation.indexOf("+");
            //System.out.println(str);
            fnum = mathoperation.substring(0, str-1);
            fnum = fnum.replaceAll(" ", "");
            //System.out.println(fnum);
            double intfnum = Double.parseDouble(fnum);
            //System.out.println(intfnum);
            int lastind = mathoperation.length();
            //System.out.println(lastind);
            lnum = mathoperation.substring(str+1, lastind);
            lnum = lnum.replaceAll(" ", "");
            //System.out.println(lnum);
            double intlnum = Double.parseDouble(lnum);
            //System.out.println(intlnum);
            double tot = intfnum + intlnum;
            //System.out.println(tot);
            total = Double.toString(tot);
            //System.out.println(total);
        } else
        if(mathoperation.contains("*")){
            mathoperation = removeneg(mathoperation);
            int str = mathoperation.indexOf("*");
            //System.out.println(str);
            fnum = mathoperation.substring(0, str-1);
            fnum = fnum.replaceAll(" ", "");
            //System.out.println(fnum);
            double intfnum = Double.parseDouble(fnum);
            //System.out.println(intfnum);
            int lastind = mathoperation.length();
            //System.out.println(lastind);
            lnum = mathoperation.substring(str+1, lastind);
            lnum = lnum.replaceAll(" ", "");
            //System.out.println(lnum);
            double intlnum = Double.parseDouble(lnum);
            //System.out.println(intlnum);
            double tot = intfnum * intlnum;
            //System.out.println(tot);
            total = Double.toString(tot);
            //System.out.println(total);
        } else
        if(mathoperation.contains("divided by")){
            mathoperation = removeneg(mathoperation);
            mathoperation = mathoperation.replaceAll("divided by", "/");
            int str = mathoperation.indexOf("/");
            //System.out.println(str);
            fnum = mathoperation.substring(0, str-1);
            fnum = fnum.replaceAll(" ", "");
            //System.out.println(fnum);
            double intfnum = Double.parseDouble(fnum);
            //System.out.println(intfnum);
            int lastind = mathoperation.length();
            //System.out.println(lastind);
            lnum = mathoperation.substring(str+1, lastind);
            lnum = lnum.replaceAll(" ", "");
            //System.out.println(lnum);
            double intlnum = Double.parseDouble(lnum);
            //System.out.println(intlnum);
            double tot = intfnum / intlnum;
            //System.out.println(tot);
            total = Double.toString(tot);
            //System.out.println(total);
        } else {
            total = null;
        }
        return total;
    }
}

