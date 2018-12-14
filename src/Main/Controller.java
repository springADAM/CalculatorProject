package Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    @FXML
    Button One= new Button(),Two= new Button(),Three= new Button(),Four= new Button(),Five= new Button(),Six= new Button(),Seven= new Button(),Eight= new Button(),Nine= new Button(),Zero= new Button(),Clear= new Button(),Comma = new Button(),Delete = new Button();
    @FXML
    Label Screen = new Label();
    @FXML
    Label Result = new Label();
    private int Counter=0;

    private static String chaine="";
    private static ArrayList<Character> operators= new ArrayList<>();

    public void One(){
        chaine = chaine+1;
        Screen.setText(chaine);

    }
    public void Two(){
        chaine = chaine+2;
        Screen.setText(chaine);
    }
    public void Three(){
        chaine = chaine+ 3;
        Screen.setText(chaine);
    }
    public void Four(){
        chaine = chaine+4;
        Screen.setText(chaine);
    }
    public void Five(){
        chaine = chaine+ 5;
        Screen.setText(chaine);
    }
    public void Six(){
        chaine = chaine+ 6;
        Screen.setText(chaine);
    }
    public void Seven(){
        chaine = chaine+ 7;
        Screen.setText(chaine);
    }
    public void Eight(){
        chaine = chaine+ 8;
        Screen.setText(chaine);
    }
    public void Nine(){
        chaine = chaine+ 9;
        Screen.setText(chaine);
    }
    public void Zero(){
        chaine = chaine+ 0;
        Screen.setText(chaine);

    }


    private void CalculeOp() {
        Counter++;
        if(Counter>=2){
            char tmp = operators.get(operators.size()-1);
            operators.remove(operators.size()-1);
            String[] op = new String[operators.size()+1];
            Calculate(op);
            operators.add(tmp);
        }
    }
    public void Devide(){
        chaine = chaine+ '/';
        Screen.setText(Screen.getText()+'/');
        operators.add('/');
        CalculeOp();

    }

    public void Multiply(){
        chaine = chaine+ '*';
        Screen.setText(Screen.getText()+'*');
        operators.add('*');
        CalculeOp();
    }
    public void Minus(){
        chaine = chaine+ '-';
        Screen.setText(Screen.getText()+'-');
        operators.add('-');
        CalculeOp();
    }
    public void Plus(){
        chaine = chaine+ '+';
        Screen.setText(Screen.getText()+'+');
        operators.add('+');
        CalculeOp();

    }
    public void Calculate(String[] op){
        System.out.println("op size is "+op.length);
        int index=0;
        for(int i=0;i<op.length;i++){
            op[i]="";//1+1
            while(index<chaine.length()&&chaine.charAt(index)!='/' && chaine.charAt(index)!='*' && chaine.charAt(index)!='-' && chaine.charAt(index)!='+'){
                op[i]=op[i]+chaine.charAt(index);
                System.out.println(op[i]);
                index++;
            }
            index++;
        }
        double tmp;
        int i=0;
        try {
            for (Character operator : operators) {
                switch (operator) {
                    case '/':
                        if(Double.parseDouble(op[i + 1])==0){
                            throw new ArithmeticException();
                        }else{
                        tmp = Double.parseDouble(op[i]) / Double.parseDouble(op[i + 1]);
                        op[i + 1] = String.valueOf(tmp);
                        i++;}
                        break;
                    case '*':
                        tmp = Double.parseDouble(op[i]) * Double.parseDouble(op[i + 1]);
                        op[i + 1] = String.valueOf(tmp);
                        i++;
                        break;
                    case '-':
                        tmp = Double.parseDouble(op[i]) - Double.parseDouble(op[i + 1]);
                        op[i + 1] = String.valueOf(tmp);
                        i++;
                        break;
                    case '+':
                        tmp = Double.parseDouble(op[i]) + Double.parseDouble(op[i + 1]);
                        op[i + 1] = String.valueOf(tmp);
                        i++;
                        break;
                }
            }
            Result.setText(op[op.length - 1]);
            Comma.setDisable(false);
        }catch(ArithmeticException e){
            Result.setText("ERROR");
        }catch (NumberFormatException a){
            JOptionPane.showMessageDialog(null,"write the operation correctly","Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void Equal(){
        String[] op = new String[operators.size()+1];
        Calculate(op);
    }
    public void Clear(){
        Result.setText(null);
        Screen.setText("0");
        chaine = "";
        operators = new ArrayList<>();
        Comma.setDisable(false);
    }


    public void Delete() {
        try {
            if(chaine.charAt(chaine.length()-1) == '*' | chaine.charAt(chaine.length()-1) == '/' | chaine.charAt(chaine.length()-1) == '-' | chaine.charAt(chaine.length()-1) == '+')
                operators.remove(operators.size()-1);
            StringBuilder sb = new StringBuilder(chaine);
            sb.deleteCharAt(chaine.length()-1);
           if(chaine.charAt(chaine.length()-1)=='.'){
                Comma.setDisable(false);
            }
            chaine = sb.toString();
            Screen.setText(chaine);

        }catch (StringIndexOutOfBoundsException e){
            Screen.setText("nothing to delete");
        }
    }
    public void Comma(){
        chaine+=".";
        Comma.setDisable(true);
        Screen.setText(chaine);
    }
    public void About(){
        JOptionPane.showMessageDialog(null,"Made with love n java by Benyamina Mohammed","About",JOptionPane.INFORMATION_MESSAGE);
    }

}