/**
 * Created by mattiasst on 2014-06-03.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Calculator extends JFrame implements ActionListener {

    Matheq math = new Matheq();

    public static void main(String[] arguments) {
        Calculator c = new Calculator();
    }

    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];
    String[] buttonString = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", ".", "/", "C", "√", "+/-", "=", "0"};
    int[] dimW = {300, 45, 100, 90};
    int[] dimH = {35, 40};
    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    JTextArea display = new JTextArea(1, 20);

    Font font = new Font("Times new Roman", Font.BOLD, 14);
    boolean[] function = new boolean[4];
    ArrayList<String> temporary = new ArrayList<String>();

    Calculator() {
        super("Ongame Calculator");

        setDesign();
        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5, 5);
        setLayout(grid);
        for (int i = 0; i < 4; i++)
            function[i] = false;

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        for (int i = 0; i < 5; i++)
            row[i] = new JPanel();

        for (int i = 0; i < 19; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        display.setPreferredSize(displayDimension);

        for (int i = 0; i < 14; i++)
            button[i].setPreferredSize(regularDimension);
        for (int i = 14; i < 18; i++)
            button[i].setPreferredSize(rColumnDimension);

        button[18].setPreferredSize(zeroButDimension);

        row[0].add(display);
        add(row[0]);

        for (int i = 0; i < 4; i++)
            row[1].add(button[i]);
        row[1].add(button[14]);
        add(row[1]);

        for (int i = 4; i < 8; i++)
            row[2].add(button[i]);
        row[2].add(button[15]);
        add(row[2]);

        for (int i = 8; i < 12; i++)
            row[3].add(button[i]);
        row[3].add(button[16]);
        add(row[3]);

        row[4].add(button[18]);
        for (int i = 12; i < 14; i++)
            row[4].add(button[i]);
        row[4].add(button[17]);
        add(row[4]);

        setVisible(true);

    }

    public final void setDesign() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button[0])
        {
            addToArray("7");
            display.append("7");
        }
        if (ae.getSource() == button[1])
        {
            addToArray("8");
            display.append("8");
        }
        if (ae.getSource() == button[2])
        {
            addToArray("9");
            display.append("9");
        }
        if (ae.getSource() == button[3])
        {
            addToArray("+");
            display.setText("");
        }
        if (ae.getSource() == button[4])
        {
            addToArray("4");
            display.append("4");
        }
        if (ae.getSource() == button[5])
        {
            addToArray("5");
            display.append("5");
        }
        if (ae.getSource() == button[6])
        {
            addToArray("6");
            display.append("6");
        }
        if (ae.getSource() == button[7]) {
            addToArray("-");
            display.setText("");
        }
        if (ae.getSource() == button[8])
        {
            addToArray("1");
            display.append("1");
        }
        if (ae.getSource() == button[9])
        {
            addToArray("2");
            display.append("2");
        }
        if (ae.getSource() == button[10])
        {
            addToArray("3");
            display.append("3");
        }
        if (ae.getSource() == button[11]) {
            {
                addToArray("*");
                display.setText("");
            }
        }
        if (ae.getSource() == button[12])
        {
            addToArray(".");
            display.append(".");
        }
        if (ae.getSource() == button[13]) {
            {
                addToArray("/");
                display.setText("");
            }
        }
       if (ae.getSource() == button[14])
            clear();
        if (ae.getSource() == button[15])
        {
            display.setText("");
        }
        if (ae.getSource() == button[16])
        {
            addToArray("+");
            display.setText("");
        }
        if (ae.getSource() == button[17])
        {
            getResult();
        }

        if (ae.getSource() == button[18])
        {
            addToArray("0");
            display.append("0");
        }
    }

    public void clear() {
        try {
            display.setText(""); // Sets the display blank
                temporary = new ArrayList<String>(); // Sets our temporary variables back to 0
        } catch (NullPointerException e) {
        }
    }

    public void getResult() {
        if(temporary.size()>1)
            display.setText(math.getResult(getCalculatorString()));
        else
            display.setText(temporary.get(0));
    }

    public static class TestFacade {

        public static void addToTempArray(Calculator calculator, String item) {
            calculator.addToArray(item);
        }

        public static void clear(Calculator calculator) {
            calculator.clear();
        }

        public static JTextArea accessDisplay(Calculator calculator) {
            return calculator.display;
        }

        public static void accessResult(Calculator calculator){
            calculator.getResult();
        }

    }

    private void addToArray(String item)
    {
        String last="";
        if(temporary.size()>0) {
            last = temporary.get(temporary.size() - 1);
        }

        if(last.equals("."))
        {
            //fix to have decimals in a number
            String second_last = temporary.get(temporary.size() - 2);
            last = second_last + last + item;
            temporary.remove(temporary.size()-1);
            temporary.remove(temporary.size()-1);
            temporary.add(last);
        }
        else
        {
            temporary.add(item);
        }

        System.out.print(temporary.size());
    }

    private String getCalculatorString()
    {
        String calculator_str = "";
        Iterator<String> itr = temporary.iterator();
        while (itr.hasNext()) {
            calculator_str = calculator_str + " " + itr.next();
        }

        return calculator_str;
    }


}
