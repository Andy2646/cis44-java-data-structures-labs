public class Calculator {
    private double currentResult;
    private double currentInput;
    private String pendingOperator;
    private boolean isStartOfNewCalculation;

    public Calculator() {
        this.currentResult = 0.0;
        this.currentInput = 0.0;
        this.pendingOperator = "=";
        this.isStartOfNewCalculation = true;
    }

    public void enterNumber(double number) {
        this.currentInput = number;
        if (isStartOfNewCalculation) {
            this.currentResult = number;
            this.isStartOfNewCalculation = false;
        }
    }

    public void enterOperator(String operator) {
        switch (pendingOperator) {
            case "+":
                this.currentResult += this.currentInput;
                break;
            case "-":
                this.currentResult -= this.currentInput;
                break;
            case "*":
                this.currentResult *= this.currentInput;
                break;
            case "/":
                if (currentInput == 0) {
                    System.out.println("Error: Division by zero.");
                    this.currentResult = 0.0;
                    this.currentInput = 0.0;
                    this.pendingOperator = "=";
                    this.isStartOfNewCalculation = true;
                    break;
                }
                this.currentResult /= this.currentInput;
                break;
        }
        if (operator.equals("=")) {
            this.isStartOfNewCalculation = true;
        }
        this.pendingOperator = operator;

    }

    public double getDisplayValue() {
        if (this.pendingOperator.equals("=") && this.isStartOfNewCalculation)
            return this.currentResult;
        else
            return this.currentInput;
    }
}
