package view.error_view;

public class InvalidDataTypeException  extends InvalidInputException{
    public InvalidDataTypeException(String expectedType, String receivedType) {
        super("Tipo esperado: " + expectedType + ", mas você digitou tipo: " + receivedType);
    }
}
