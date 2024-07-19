package view.services_view;

import requestmanager.IRequest;
import requestmanager.RequestDispatcher;
import view.config_view.Config;

public class ServiceRequest extends Config{
    private IRequest irequest;
    private ServiceClassifier serviceClassifier;


    public ServiceRequest() {
        setIrequest(new RequestDispatcher());
        setServiceClassifier(new ServiceClassifier());
    }

    public IRequest getIrequest() {
        return irequest;
    }

    public void setIrequest(IRequest irequest) {
        this.irequest = irequest;
    }

    public ServiceClassifier getServiceClassifier() {
        return serviceClassifier;
    }

    public void setServiceClassifier(ServiceClassifier serviceClassifier) {
        this.serviceClassifier = serviceClassifier;
    }

    public void submitRequest(String objectRequest, String request) {
        if (objectRequest.equalsIgnoreCase("Mentoria")
                || objectRequest.equalsIgnoreCase("Conteudo")) {
            System.out.println("Executando " + request + " de " + objectRequest);
        }else {
            serviceClassifier.runRequest(objectRequest, request);
        }

    }

    public int requestDataSize(){
        return getServiceClassifier().getDataSize();
    }

    public void startApp() {
        irequest.startAutoData();
    }
}
