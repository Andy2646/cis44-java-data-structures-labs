public class Calculator {
    private double currentResult;
    private double currentInput;
    private String pendingOperator;
    private boolean newCalculation;

    public Calculator() {
        this.currentResult = 0.0;
        this.currentInput = 0.0;
        this.pendingOperator = "=";
        this.newCalculation = true;
    }

    public void setNumber(double number) {
        this.currentInput = number;
        if (newCalculation) {
            this.currentResult = number;
            this.newCalculation = false;
        }
    }

    public void setOperator(String operator) {
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
                    this.newCalculation = true;
                    break;
                }
                this.currentResult /= this.currentInput;
                break;
        }
        if (operator.equals("=")) {
            this.newCalculation = true;
        }
        this.pendingOperator = operator;

    }

    public double printDisplay() {
        if (this.pendingOperator.equals("=") && this.newCalculation)
            return this.currentResult;
        else
            return this.currentInput;
    }
}
