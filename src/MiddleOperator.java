/**
 *
 * @author Vincenzo Scarso
 */
public class MiddleOperator {
    public String middle_operator;
    public int middle_operator_position;

    public MiddleOperator(String str) {
        setOperator(str);
    }

    private void setOperator(String str) {
        int i;
        String operators[] = new String[5];
        operators[0] = "+";
        operators[1] = "-";
        operators[2] = "*";
        operators[3] = "÷";
        operators[4] = "%";

        i = 0;
        do {
            this.middle_operator = operators[i];
            this.middle_operator_position = str.indexOf(operators[i], 1); // a partire dall'indice 1 perche l'indice
                                                                          // zero potrebbe essere un segno relativo ad
                                                                          // un valore
            i++;
        } while (!isOperator() || this.middle_operator_position == -1);
    }

    private Boolean isOperator() {
        switch (this.middle_operator) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "÷":
                return true;
            case "%":
                return true;
            default:
                return false;
        }
    }
}
