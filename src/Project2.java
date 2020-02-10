import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
Sterling Despanza
Project 2
9 February 2020
Program creates a GUI that takes users' input then calculates sales tax on hybrid, electric and normal vehicles and stores into an array.
 */

public class Project2 extends JFrame{

    public static void main(String[] args){

        ArrayList<Automobile> cars = new ArrayList<Automobile>();

        JFrame auto = new JFrame("Calculate Sales tax");
        auto.setSize(550,500);
        auto.setResizable(true);
        auto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.lightGray);

        auto.add(panel);
        auto.setVisible(true);

        JLabel make = new JLabel("Make and Model");
        make.setBounds(100,20,200,25);
        panel.add(make);
        JTextField makeTextField = new JTextField(20);
        makeTextField.setBounds(250,20,150,25);
        panel.add(makeTextField);

        JLabel salesPriceLabel = new JLabel("Sales Price");
        salesPriceLabel.setBounds(100,50,200,25);
        panel.add(salesPriceLabel);
        JTextField saleTextField = new JTextField(20);
        saleTextField.setBounds(250,50,150,25);
        panel.add(saleTextField);


        JLabel autoType = new JLabel("Automobile Type");
        autoType.setBounds(30,90,200,25);
        panel.add(autoType);

        JRadioButton hybridButton = new JRadioButton("Hybrid");
        hybridButton.setBounds(10,120,150,25);
        panel.add(hybridButton);
        JLabel mpgLabel = new JLabel("Miles Per Gallon");
        mpgLabel.setBounds(200,120,150,25);
        panel.add(mpgLabel);
        JTextField mpgText = new JTextField(20);
        mpgText.setBounds(350,120,150,25);
        panel.add(mpgText);

        JRadioButton electricButton = new JRadioButton("Electric");
        electricButton.setBounds(10,150,150,25);
        panel.add(electricButton);
        JLabel weightLabel = new JLabel("Weight in Pounds");
        weightLabel.setBounds(200,150,100,25);
        panel.add(weightLabel);
        JTextField weightPounds = new JTextField(20);
        weightPounds.setBounds(350,150,150,25);
        panel.add(weightPounds);

        JRadioButton otherButton = new JRadioButton("Other");
        otherButton.setBounds(10,180,150,25);
        panel.add(otherButton);

        JButton compute = new JButton("Compute Sales Tax");
        compute.setBounds(80,240,150,25);
        panel.add(compute);

        JTextField result = new JTextField(20);
        result.setBounds(250,240,150,25);
        result.setEditable(false);
        panel.add(result);

        JButton clearFields = new JButton("Clear Fields");
        clearFields.setBounds(80,270,150,25);
        panel.add(clearFields);
        JButton displayReport = new JButton("Display Report");
        displayReport.setBounds(250,270,150,25);
        panel.add(displayReport);

        ButtonGroup group = new ButtonGroup();
        group.add(hybridButton);
        group.add(electricButton);
        group.add(otherButton);


        compute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {//using try to check if values are an integer for sales price mpg etc.

                    int clicked = 0; //used to index to store automobile objects
                    String makeAndModel = makeTextField.getText(); //take inputted value from make and model textfield
                    int salePrice = Integer.parseInt(saleTextField.getText());//takes the int value of sale price

                    if (otherButton.isSelected()) {//if clicked on
                        Automobile aCar = new Automobile(makeAndModel, salePrice);//create automobile object
                        result.setText(String.valueOf(aCar.salesTax(salePrice)));//takes int value from sale price
                        if (clicked < 5) {//trying to use to verify and display the last 5 entries, isnt working
                            cars.add(clicked, aCar);//adds automobile to arraylist
                            clicked = clicked + 1;
                        }
                    }
                    if (hybridButton.isSelected()) {
                        int mpg = Integer.parseInt(mpgText.getText());
                        Hybrid hybridCar = new Hybrid(makeAndModel, salePrice, mpg);
                        result.setText(String.valueOf(hybridCar.salesTax(salePrice)));
                        if (clicked < 5) {
                            cars.add(clicked, hybridCar);
                            clicked++;
                        }
                    }
                    if (electricButton.isSelected()) {
                        int weight = Integer.parseInt(weightPounds.getText());
                        Electric electricCar = new Electric(makeAndModel, salePrice, weight);
                        result.setText(String.valueOf(electricCar.salesTax(salePrice)));
                        if (clicked < 5) {
                            cars.add(clicked, electricCar);
                            clicked++;
                        }
                    }

                    System.out.println(clicked);
                } catch (NumberFormatException ex){//catches exception if integer isnt entered as expected
                    JOptionPane.showMessageDialog(null,"ERROR: Please enter an integer ");//alert box
                }
            }
        });


        displayReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cars);// used to print arraylist in console
            }
        });
        clearFields.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.clearSelection();
                makeTextField.setText("");//quotes reset the field
                saleTextField.setText("");
                mpgText.setText("");
                weightPounds.setText("");
                result.setText("");
            }
        });
    }
}
