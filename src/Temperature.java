package yash.Projects.src;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.text.DecimalFormat;

public class Temperature extends JFrame implements ActionListener {

    JComboBox<String> from;
    JComboBox<String> to ;
    JLabel fromLabel,toLabel,indicationLabel1,indicationLabel2,indicationLabel3,indicationLabel4;
    JLabel inputLabel,resultLabel,formulaLabel,errorLabel;
    JTextField inputField,outputField;
    JTextField formula1,formula2;
    JButton convert,reset;
    // you can change the Result format here --> Restricted to two decimal
    final DecimalFormat formatting = new DecimalFormat("0.00");

    Temperature(){
        setSize(450,650);
        setTitle("Temperature Converter");
        String[] temps = {"Select","Celsius","Fahrenheit"};

        Font myfont = new Font(Font.SANS_SERIF,Font.BOLD,17);

        fromLabel = new JLabel("From :");
        fromLabel.setBounds(50,30,70,30);
        fromLabel.setFont(myfont);

        from = new JComboBox<>(temps);
        from.setBounds(50,60,110,50);
        from.addActionListener(this);

        toLabel = new JLabel("To :");
        toLabel.setBounds(250,30,70,30);
        toLabel.setFont(myfont);

        to = new JComboBox<>(temps);
        to.setBounds(250,60,110,50);
        to.addActionListener(this);

        inputLabel = new JLabel("Input :");
        inputLabel.setBounds(30,140,70,30);
        inputLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        inputLabel.setForeground(new Color(61, 138, 204));

        errorLabel = new JLabel("");
        errorLabel.setBounds(130,140,300,30);
        errorLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        errorLabel.setForeground(new Color(255, 10, 10));


        indicationLabel1 = new JLabel("- -");
        indicationLabel1.setBounds(50,180,80,40);
        indicationLabel1.setFont(new Font(Font.SERIF,Font.BOLD,17));

        inputField = new JTextField("0");
        inputField.setBounds(145,180,175,40);
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        inputField.setFont(new Font(Font.SERIF,Font.BOLD,20));
        Border border = BorderFactory.createLineBorder(new Color(38, 47, 37, 255), 1);
        inputField.setBorder(border);

        indicationLabel2 = new JLabel("-");
        indicationLabel2.setBounds(324,180,40,40);
        Border border2 = BorderFactory.createLineBorder(new Color(38, 47, 37, 255), 1);
        indicationLabel2.setBorder(border2);
        indicationLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        convert = new JButton("= Convert");
        convert.setBounds(145,245,92,40);
        convert.setBackground(new Color(133, 231, 102));
        convert.setEnabled(false);
        convert.setFocusable(false);
        convert.addActionListener(this);

        reset = new JButton("X  Reset");
        reset.setBounds(255,245,92,40);
        reset.setForeground(Color.BLACK);
        reset.setBackground(new Color(171, 171, 164));
        reset.addActionListener(this);
        reset.setFocusable(false);

        resultLabel = new JLabel("Result :");
        resultLabel.setBounds(30,320,85,30);
        resultLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        resultLabel.setForeground(new Color(33, 192, 16));

        indicationLabel3 = new JLabel("- -");
        indicationLabel3.setBounds(50,360,80,40);
        indicationLabel3.setFont(new Font(Font.SERIF,Font.BOLD,17));

        outputField = new JTextField("-");
        outputField.setBounds(145,360,175,40);
        outputField.setHorizontalAlignment(SwingConstants.CENTER);
        outputField.setFont(new Font(Font.SERIF,Font.BOLD,20));
        outputField.setEditable(false);
        outputField.setBorder(border);

        indicationLabel4 = new JLabel("-");
        indicationLabel4.setBounds(324,360,40,40);
        indicationLabel4.setBorder(border2);
        indicationLabel4.setHorizontalAlignment(SwingConstants.CENTER);

        formulaLabel = new JLabel("Formula :");
        formulaLabel.setBounds(30,450,105,30);
        formulaLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
        formulaLabel.setForeground(new Color(255, 154, 28));

        formula1 = new JTextField();
        formula1.setText("Celsius  =  ( Fahrenheit - 32 ) * 5 / 9");
        formula1.setBounds(50,490,330,40);
        formula1.setHorizontalAlignment(SwingConstants.CENTER);
        formula1.setFont(new Font(Font.SERIF,Font.BOLD,20));
        formula1.setEditable(false);
        formula1.setBorder(border);

        formula2 = new JTextField();
        formula2.setText("Fahrenheit  =  ( Celsius * 9 / 5 ) + 32");
        formula2.setBounds(50,550,330,40);
        formula2.setHorizontalAlignment(SwingConstants.CENTER);
        formula2.setFont(new Font(Font.SERIF,Font.BOLD,20));
        formula2.setEditable(false);
        formula2.setBorder(border);


        add(fromLabel);
        add(from);
        add(toLabel);
        add(to);
        add(inputLabel);
        add(errorLabel);
        add(indicationLabel1);
        add(inputField);
        add(indicationLabel2);
        add(convert);
        add(reset);
        add(resultLabel);
        add(indicationLabel3);
        add(outputField);
        add(indicationLabel4);
        add(formulaLabel);
        add(formula1);
        add(formula2);

        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == from){
            // Enabling and Disabling the convert Button
            if(!(Objects.equals(from.getSelectedItem(), "Select") ||
                    Objects.equals(to.getSelectedItem(),"Select")))
            {
                convert.setEnabled(true);
            }else{
                convert.setEnabled(false);
            }

            if(Objects.equals(from.getSelectedItem(), "Celsius")){
                indicationLabel2.setText("\u00B0 C");
                indicationLabel1.setText((String) from.getSelectedItem());
            }else if (Objects.equals(from.getSelectedItem(), "Fahrenheit")){
                indicationLabel2.setText("\u00B0 F");
                indicationLabel1.setText((String) from.getSelectedItem());
            }else{
                indicationLabel2.setText("-");
                indicationLabel1.setText("- -");
            }
        }

        if(e.getSource() == to){
            // Enabling and Disabling the convert Button
            if(!(Objects.equals(from.getSelectedItem(), "Select") ||
                    Objects.equals(to.getSelectedItem(),"Select")))
            {
                convert.setEnabled(true);
            }else{
                convert.setEnabled(false);
            }

            if(Objects.equals(to.getSelectedItem(), "Celsius")){
                indicationLabel4.setText("\u00B0 C");
                indicationLabel3.setText((String) to.getSelectedItem());
            }else if (Objects.equals(to.getSelectedItem(), "Fahrenheit")){
                indicationLabel4.setText("\u00B0 F");
                indicationLabel3.setText((String) to.getSelectedItem());
            }else{
                indicationLabel4.setText("-");
                indicationLabel3.setText("- -");
            }
        }

        if(e.getSource() == reset){
            convert.setEnabled(false);
            from.setSelectedIndex(0);
            to.setSelectedIndex(0);
            inputField.setText("0");
            outputField.setText("-");
            errorLabel.setText("");
        }

        if (e.getSource() == convert){
            try{
                double inputValue = Double.parseDouble(inputField.getText());
                errorLabel.setText("");
                if(Objects.equals(from.getSelectedItem(), "Celsius")){
                    if(Objects.equals(to.getSelectedItem(), "Celsius")){
                        outputField.setText(String.valueOf(inputValue));
                    }else{
                        Double result = (inputValue * 9 / 5 ) + 32;
                        outputField.setText(String.valueOf(formatting.format(result)));
                    }
                }else{
                    if(Objects.equals(to.getSelectedItem(), "Fahrenheit")){
                        outputField.setText(String.valueOf(inputValue));
                    }else {
                        Double result  = (inputValue - 32 ) * 5 / 9;
                        outputField.setText(String.valueOf(formatting.format(result)));
                    }
                }

            }catch (Exception exception){
                errorLabel.setText("Only numeric values allowed.");
                outputField.setText("-");
            }
        }
    }

    public static void main(String[] args) {
        new Temperature();
    }
}
