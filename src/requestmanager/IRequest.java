package requestmanager;

public interface IRequest {

    String add(String objectRequest, String request, String[] dataStr);

    String getById(String objectRequest, String request, String[] dataStr);

    String getAll(String objectRequest, String request);

    String update(String objectRequest, String request, String[] dataStr);

    String delete(String objectRequest, String request, String[] dataStr);

    void startAutoData();

    int dataSize(String objectRequest, String request);
}
