package requestmanager;

import br.com.dio.controller.IController;
import br.com.dio.controller.model.Bootcamp;
import br.com.dio.controller.model.Course;
import br.com.dio.controller.model.Dev;

import java.util.ArrayList;
import java.util.List;

public class RequestClassifier {
    private int dataSise;
    private int success;
    private static List<String> menssage;
    private String dataToString;

    public RequestClassifier() {
        setMenssage();
    }

    public void devRequest(IController<Dev> dev, String objectRequest, String request, String[] str) {
        Dev responseDev;
        int up = 0;
        switch (request){
            case ("add"),("create"):
                responseDev = dev.create(str[1], str[2], up);
                dev.add(responseDev);
                setDataToString(responseDev.toString());
                break;
            case ("getById"):
                responseDev =
                        dev.getById(Integer.parseInt(str[0]));
                setDataToString(responseDev.toString());
                break;
            case ("getAll"):
                setDataToString(formatList(dev.getAll(), objectRequest));
                break;
            case ("update"):
                up = 1;
                responseDev = dev.create(str[1], str[2], up);
                setSuccess(dev.update(Integer.parseInt(str[0]), responseDev));
                setDataToString("Desenvolvedor Id-" + responseDev.getId() +" "+ request + getMenssage().get(getSuccess()));
                break;
            case ("delete"):
                setSuccess(dev.delete(Integer.parseInt(str[0])));
                setDataToString("Desenvolvedor Id-" + str[0] +" "+ request + getMenssage().get(getSuccess()));
                break;
            case ("size"):
                setDataSise(dev.sizeMap());
                break;
        }
    }

    public void courseRequest(IController<Course> course,String objectRequest, String request, String[] str) {
        Course responseCourse;
        int up = 0;
        switch (request){
            case ("add"),("create"):
                responseCourse = course.create(str[1], str[2], up);
                course.add(responseCourse);
                setDataToString(responseCourse.toString());
                System.out.println("Este é o resultado - "+getDataToString());
                break;
            case ("getById"):
                responseCourse =
                        course.getById(Integer.parseInt(str[0]));
                setDataToString(responseCourse.toString());
                break;
            case ("getAll"):
                setDataToString(formatList(course.getAll(), objectRequest));
                break;
            case ("update"):
                up = 1;
                responseCourse = course.create(str[1], str[2], up);
                setSuccess(course.update(Integer.parseInt(str[0]), responseCourse));
                setDataToString("Curso Id-" + responseCourse.getId() +" "+ request + getMenssage().get(getSuccess()));
                break;
            case ("delete"):
                setSuccess(course.delete(Integer.parseInt(str[0])));
                setDataToString("Curso Id-" + str[0] +" "+ request + getMenssage().get(getSuccess()));
                break;
            case ("size"):
                setDataSise(course.sizeMap());
                break;
        }
    }

    public void bootcampRequest(IController<Bootcamp> bootcamp, String objectRequest, String request, String[] str) {
        Bootcamp responseBootcamp;
        int up = 0;
        switch (request){
            case ("add"),("create"):
                responseBootcamp = bootcamp.create(str[1], str[2], up);
                bootcamp.add(responseBootcamp);
                setDataToString(responseBootcamp.toString());
                break;
            case ("getById"):
                responseBootcamp =
                bootcamp.getById(Integer.parseInt(str[0]));
                setDataToString(responseBootcamp.toString());
                break;
            case ("getAll"):
                setDataToString(formatList(bootcamp.getAll(), objectRequest));
                break;
            case ("update"):
                up = 1;
                responseBootcamp = bootcamp.create(str[1], str[2], up);
                setSuccess(bootcamp.update(Integer.parseInt(str[0]), responseBootcamp));
                setDataToString("Bootcamp Id-" + responseBootcamp.getId() +" "+ request + getMenssage().get(getSuccess()));
                break;
            case ("delete"):
                setSuccess(bootcamp.delete(Integer.parseInt(str[0])));
                setDataToString("Bootcamp Id-" + str[0] +" "+ request + getMenssage().get(getSuccess()));
                break;
            case ("size"):
                setDataSise(bootcamp.sizeMap());
                break;
        }
    }



    private String formatList(List<?> all, String objectRequest) {
        StringBuilder str = new StringBuilder("Lista de "+ objectRequest +"s cadastrados:\n");
        for (Object object : all) {
            str.append(object.toString()).append("\n");
        }
        return str.toString();
    }

    private void objCast(String obj) {
    }

    public String getDataToString() {
        return dataToString;
    }

    public void setDataToString(String dataToString) {
        this.dataToString = dataToString;
    }

    public int getDataSise() {
        return dataSise;
    }

    public void setDataSise(int dataSise) {
        this.dataSise = dataSise;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<String> getMenssage() {
        return menssage;
    }

    public void setMenssage() {
        menssage = new ArrayList<>();
        menssage.add(0," Não executado - o objeto não existe!");
        menssage.add(1," executado com sucesso!");
    }
}

