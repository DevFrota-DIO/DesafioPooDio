package view.services_view;

import view.config_view.Config;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServiceView extends Config{
    private final ServiceError serviceError;
    private ServiceRequest serviceRequest;
    private final Scanner scanner = new Scanner(System.in);

    public ServiceView() {
        this.serviceError = new ServiceError();
        setServiceRequest(new ServiceRequest());
    }

    public void startAppData(){
        serviceRequest.startApp();
    }

    public void printMenu(Map<Integer, String> menu, String str) {
        menu.forEach((key, value) ->{
            if(key == 0){
                System.out.println(value + str);
            }else{
                System.out.println(value);
            }
        });

    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    private String sanitizeChoice(Map<Integer, String> menu, int choice) {
        String[] str = menu.get(choice).split(" ");
        return str[1];
    }

    public void loopOne(int choice, String key){

        boolean exit = true;
        String objectRequest = "";
        super.setAllMenu();
        setMenuIndice();
        while (exit) {
            printMenu(super.getAllMenu().get(sanitizeKey(key)), key);
            choice = scanner.nextInt();

            String nivelMenu = sanitizeChoice(getAllMenu().get(sanitizeKey(key)), 0);
            String request = sanitizeKey(key);
            key = sanitizeChoice(getAllMenu().get(sanitizeKey(key)), choice);
            request = ifRequest(key, request);

            objectRequest = ifNivelTwo(key, nivelMenu, objectRequest);
            exit = isExit(key, exit);
            key = ifNivelThree(key,nivelMenu, request, objectRequest);

        }
    }

    private String ifNivelThree(String key, String nivelMenu, String request, String objectRequest) {
        if (nivelMenu.equalsIgnoreCase("3")) {
           serviceRequest.submitRequest(objectRequest, request);
           key = "Inicial";
       }
        return key;
    }

    private boolean isExit(String key, boolean exit) {
        if(key.equalsIgnoreCase("Sair")){
            exit = false;
        }
        return exit;
    }

    private static String ifNivelTwo(String key, String nivelMenu, String objectRequest) {
        if(nivelMenu.equalsIgnoreCase("2")){
            objectRequest = key;

        }
        return objectRequest;
    }

    private String ifRequest(String key, String request) {
        if(request.equalsIgnoreCase("Request")){
            request = getMenuIndice().get(key);

        }
        return request;
    }

    private String sanitizeKey(String objectRequest) {
        AtomicBoolean ok = new AtomicBoolean(false);
        String str = "Request";
        super.getAllMenu().forEach((key,value)->{
            if(objectRequest.equalsIgnoreCase(key)){
                ok.set(true);
            }
        });
        if(ok.get()){
            ok.set(false);
            return objectRequest;
        }

        return str;
    }

    public String[] sanitizeRequest(String[] strMenu, String objectRequest, String request){
        String id = strMenu[0];
        String name = strMenu[1];
        String email = strMenu[2];
        String description = strMenu[3];
        String[] str = new String[3];

            for (int i = 0; i < strMenu.length; i++) {
                if(request.equals("size")){
                    str[i] = isError(objectRequest, request, id, str, i);
                    break;
                } else if(i == 1) {
                    str[i] = isError(objectRequest, request, name, str, i);

                } else if (objectRequest.equals("Dev")&& i==2) {
                    str[i] = isError(objectRequest, request, email, str, i);
                }else if(!objectRequest.equals("Dev")&& i==2){
                    str[i] = isError(objectRequest, request, description, str, i);
                }

            }

        return str;
    }

    private String isError(String objectRequest, String request, String menu, String[] str, int i) {
        boolean error = true;
        while(error) {
            System.out.print(menu);
            System.out.flush();
            str[i] = scanner.nextLine();
            error = serviceError.sanitize(str[i], objectRequest, request);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return str[i];
    }

}

