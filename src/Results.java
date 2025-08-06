/**
 *
 * @author Vincenzo Scarso
 */
public class Results {
    public String first_value;
    public String second_value;
    public MiddleOperator OP;
    public String result;
    
    public Results(Double textField1_value, Double textField2_value,  MiddleOperator OP, Double result) {
        this.first_value = String.valueOf(textField1_value);
        this.second_value = String.valueOf(textField2_value);
        this.OP = OP;
        this.result = String.valueOf(result);
    }
}
