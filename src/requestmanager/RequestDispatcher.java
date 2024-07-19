package requestmanager;

public class RequestDispatcher implements IRequest{
    private final RequestClassifier requestClassifier;
    private final ControllerResolver controllerResolver;

    public RequestDispatcher() {
        this.requestClassifier = new RequestClassifier();
        this.controllerResolver = new ControllerResolver();
        //startAutoData();
    }

    private void actionType(String objectRequest, String request, String[] dataStr) {
        switch (objectRequest) {
            case ("Bootcamp"):
                requestClassifier.bootcampRequest(
                        controllerResolver.getcBootcamp(),objectRequest, request, dataStr);
                break;
            case ("Curso"):
                requestClassifier.courseRequest(
                        controllerResolver.getcCurso(),objectRequest, request, dataStr);
                break;
            case ("Dev"):
                requestClassifier.devRequest(
                        controllerResolver.getcDev(),objectRequest, request, dataStr);
                break;
            case ("Conteudo"):
                requestClassifier.devRequest(
                        controllerResolver.getcDev(),objectRequest, request, dataStr);
                break;
            case ("Mentoria"):
                requestClassifier.devRequest(
                        controllerResolver.getcDev(),objectRequest, request, dataStr);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + objectRequest);
        }
    }

    @Override
    public String add(String objectRequest, String request, String[] dataStr) {
        actionType(objectRequest, request, dataStr);
        return requestClassifier.getDataToString();
    }

    @Override
    public String getById(String objectRequest, String request, String[] dataStr) {
        actionType(objectRequest, request, dataStr);
        return requestClassifier.getDataToString();
    }

    @Override
    public String getAll(String objectRequest, String request) {
        String[] dataStr = new String[1];
        actionType(objectRequest, request, dataStr);
        return requestClassifier.getDataToString();
    }

    @Override
    public String update(String objectRequest, String request, String[] dataStr) {
        actionType(objectRequest, request, dataStr);
        return requestClassifier.getDataToString();
    }

    @Override
    public String delete(String objectRequest, String request, String[] dataStr) {
        actionType(objectRequest, request, dataStr);
        return requestClassifier.getDataToString();
    }

    @Override
    public void startAutoData() {
        controllerResolver.getcBootcamp().startAutoData();
    }

    @Override
    public int dataSize(String objectRequest, String request) {
        String[] dataStr = new String[]{"","",""};
        actionType(objectRequest, request, dataStr);
        return requestClassifier.getDataSise();
    }
}


