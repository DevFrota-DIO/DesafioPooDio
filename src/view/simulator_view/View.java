package view.simulator_view;

import view.services_view.ServiceView;
import java.util.Scanner;

public class View {
    private final ServiceView serviceView;
    private final Scanner scanner;

    public View() {
        this.serviceView = new ServiceView();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        serviceView.setAllMenu();
        serviceView.startAppData();
        serviceView.loopOne(0, "Inicial");
    }

    public String[] createRequest(String objectRequest) {
        return scanNameDescription(objectRequest);
    }

    public String[] scanNameDescription(String objectRequest) {
        String[] str = new String[4];
        str[0] = "";
        str[1] = "Digite o Nome do "+objectRequest + " -> ";
        str[2] = "Digite o e-mail-> ";
        str[3] = "Digite a descrição-> ";
        return serviceView.sanitizeRequest(str, objectRequest, "create");
    }

    public String[] scanId(String objectRequest) {
        String[] str = new String[4];
        str[0] = "Digite o ID do " + objectRequest + " -> ";
        str[1] = " ";
        str[2] = " ";
        str[3] = " ";
        return serviceView.sanitizeRequest(str, objectRequest, "size");
    }

    public String[] scanGetAll(String objectRequest) {
        String[] str = new String[3];
        System.out.print("Imprimindo lista de " + objectRequest + "s");
        return str;
    }

    public void printResult(String dataToString) {
        System.out.println("___________________________________________________");
        System.out.println("|____________Resultado da requisição:_____________|");
        System.out.println(dataToString);
        System.out.println("Digite ENTER para continuar");
        String c = scanner.nextLine();

    }



}
