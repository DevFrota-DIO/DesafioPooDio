package view.services_view;

import requestmanager.IRequest;
import requestmanager.RequestDispatcher;
import view.simulator_view.View;

public class ServiceClassifier {
        private int dataSize;
        private IRequest irequest;
        private String dataToString;

        public void runRequest(String objectRequest, String request) {
            View view = new View();
            String[] str = new String[3];
            setIrequest(new RequestDispatcher());
            switch (request){
                case ("create"), ("add"):
                    str = view.scanNameDescription(objectRequest);
                    setDataToString(getIrequest().add(objectRequest, request, str));
                    break;
                case ("getById"):
                    str = view.scanId(objectRequest);
                    setDataToString(getIrequest().getById(objectRequest, request, str));
                    break;
                case ("getAll"):
                    str = view.scanGetAll(objectRequest);
                    setDataToString(getIrequest().getAll(objectRequest, request));
                    break;
                case ("update"):
                    String[] strOne = view.scanId(objectRequest);
                    str = view.scanNameDescription(objectRequest);
                    str[0] = strOne[0];
                    setDataToString(getIrequest().update(objectRequest, request, str));
                    break;
                case ("delete"):
                    str = view.scanId(objectRequest);
                    setDataToString(getIrequest().delete(objectRequest, request, str));
                    break;
                case ("size"):
                    setDataSize(getIrequest().dataSize(objectRequest, request));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + request);
            }
            if (getDataToString() != null && !request.equals("size")) {
                view.printResult(getDataToString());
            }

        }


    public IRequest getIrequest() {
        return irequest;
    }

    public void setIrequest(IRequest irequest) {
        this.irequest = irequest;
    }

    public String getDataToString() {
        return dataToString;
    }

    public void setDataToString(String dataToString) {
        this.dataToString = dataToString;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

}

