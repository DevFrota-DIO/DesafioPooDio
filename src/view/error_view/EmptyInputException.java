package view.error_view;

public class EmptyInputException  extends InvalidInputException{
    public EmptyInputException() {
        super("Entrada vazia, você deve digitar um dado válido.");
    }
}
