package view.services_view;

import view.error_view.EmptyInputException;
import view.error_view.InvalidDataTypeException;
import view.error_view.InvalidIDException;
import view.error_view.InvalidInputException;

public class ServiceError {
    private String mensageError;

    public String getMensageError() {
        return mensageError;
    }

    public void setMensageError(String mensageError) {
        this.mensageError = mensageError;
    }

    public boolean sanitize(String input, String objectRequest, String request){
        try {
            emptyInput(input);
            if(request.equals("size")) invalidID(input, objectRequest, request);
            return false;
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            return true;
        }
    }

    private void invalidID(String input, String objectSize, String request) throws InvalidIDException, InvalidDataTypeException {
        try {
            int id = Integer.parseInt(input);
            validateID(id, dataSize(objectSize, request));
        } catch (NumberFormatException e) {
            throw new InvalidDataTypeException("Numero Inteiro", "Letras ou Valor inválido");
        }
    }

    private static void emptyInput(String input) throws EmptyInputException {
        if (input.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    private static void validateID(int id, int size) throws InvalidIDException {
        if (id < 0 || id >= size) {
            throw new InvalidIDException(id);
        }
    }

    public int dataSize(String objectSize, String request) {
            ServiceRequest serviceRequest = new ServiceRequest();
            serviceRequest.submitRequest(objectSize, request);
        return serviceRequest.requestDataSize();
    }
}
