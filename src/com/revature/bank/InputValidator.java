package com.revature.bank;

public class InputValidator {
    private String input;
    private char inputChar;
    private int inputInt;
    private double inputDouble;
    private boolean isValid;

    public boolean validate(String input, String type){
        this.input = input;

        isValid = false;
        try {
            switch(type)
            {
                case "choice":
                    inputChar = input.charAt(0);
                    break;
                case "name":
                    break;
                case "pass":
                    break;
                case "int":
                    inputInt = Integer.parseInt(input);
                    break;
                case "double":
                    inputDouble = Double.parseDouble(input);
                    break;
                default:
                    isValid = false;
            }
        } catch (NumberFormatException nfe) {
        }

        return isValid;
    }

    private void checkChoice(){}
    private void checkName(){}
    private void checkPass(){}
    private void checkInt(){}
    private void checkDouble(){}
}
