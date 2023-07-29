package calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculadora extends JFrame {
    JButton FirstDisplay = new JButton("0");
    JButton SecondDisplay = new JButton("0");

    String result="0";
    public Calculadora(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension myScreen= Toolkit.getDefaultToolkit().getScreenSize();
        int widht= myScreen.width;
        int height= myScreen.height;
        setBounds(widht/4,height/4,widht/2,height/2);
        setVisible(true);
        add(new MyPanel());
        pack();
    }
    private class MyPanel extends JPanel{
        MyPanel(){
            FirstDisplay.setEnabled(false);
            SecondDisplay.setEnabled(false);

            JPanel Display= new JPanel();
            Display.add(SecondDisplay);
            Display.add(FirstDisplay);

            setLayout(new BorderLayout());
            add(Display,BorderLayout.NORTH);

            JButton reset= new JButton("C");
            reset.addActionListener(new ResetAction());
            add(reset,BorderLayout.SOUTH);

            JPanel panelOption= new JPanel();
            panelOption.setLayout(new GridLayout(4,4) );
            String[] calculator= {"7","8","9","/","4","5","6","*","1","2","3","-","0",",","=","+"};
            for (String letter : calculator) {
                JButton button = new JButton(letter);
                if (letter == "/" || letter == "-" || letter == "+" || letter == "=" || letter == "*") {
                    button.addActionListener(new ActionCommand());
                    panelOption.add(button);
                } else {
                    button.addActionListener(new ActionEvent());
                    panelOption.add(button);
                }
            }
            add(panelOption,BorderLayout.CENTER);
        }
    }

    class ActionEvent implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String newDisplay= FirstDisplay.getText();
            String comand= e.getActionCommand();
            String regex = ",";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(FirstDisplay.getText());
            if (comand=="," && matcher.find()) {
                System.out.println("Se encontró una coma en la posición: " + matcher.start()+" .No se puede utilizar mas de una ',' en esta calculadora ='( ");
            } else {
                if(newDisplay=="0" && comand !=","){
                    FirstDisplay.setText(comand);
                }else{
                    FirstDisplay.setText(newDisplay + comand);
                }
            }

        }
    }
    class ResetAction implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            FirstDisplay.setText("0");
            SecondDisplay.setText("0");
        }
    }
    class ActionCommand implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          if(e.getActionCommand()=="="){
              Result(result);
          }else{
           result= e.getActionCommand();
           Result(e.getActionCommand());
          }
        }
    }
    private void Result (String command){
        String firstNumber= FirstDisplay.getText();
        String secondNumber= SecondDisplay.getText();
        switch (command) {
            case "+" -> {
                float result = Float.parseFloat(secondNumber) + Float.parseFloat(firstNumber);
                SecondDisplay.setText(String.valueOf(result));
                FirstDisplay.setText("0");
            }
            case "-" -> {
                float result = Float.parseFloat(secondNumber) - Float.parseFloat(firstNumber);
                SecondDisplay.setText(String.valueOf(result));
                FirstDisplay.setText("0");
            }
            case "*" -> {
                float result = Float.parseFloat(secondNumber) * Float.parseFloat(firstNumber);
                SecondDisplay.setText(String.valueOf(result));
                FirstDisplay.setText("0");
            }
            case "/" -> {
                float result = Float.parseFloat(secondNumber) / Float.parseFloat(firstNumber);
                SecondDisplay.setText(String.valueOf(result));
                FirstDisplay.setText("0");
            }
        }
    }
}


