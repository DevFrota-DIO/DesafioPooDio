package view.error_view;

public class InvalidIDException extends InvalidInputException{
    public InvalidIDException(int id) {
        super("O ID " + id + " não existe!");

    }
}
