package requestmanager;

import br.com.dio.controller.BootcampController;
import br.com.dio.controller.CourseController;
import br.com.dio.controller.DevController;
import br.com.dio.controller.IController;
import br.com.dio.controller.model.Bootcamp;
import br.com.dio.controller.model.Course;
import br.com.dio.controller.model.Dev;
import java.util.HashMap;
import java.util.Map;


public class ControllerResolver {
    private Map<String, Object> controllerMap;
    private IController<Bootcamp> cBootcamp;
    private IController<Course> cCurso;
    private IController<Dev> cDev;

    public ControllerResolver() {
        this.cBootcamp = new BootcampController();
        this.cCurso = new CourseController();
        this.cDev = new DevController();
        this.controllerMap = new HashMap<>();
        setControllerMap();
    }

    public Object resolveController(String route) {
        return controllerMap.get(route);
    }

    public Map<String, Object> getControllerMap() {
        return controllerMap;
    }

    public void setControllerMap() {
        this.controllerMap.put("bootcamp", cBootcamp);
        this.controllerMap.put("curso", cCurso);
        this.controllerMap.put("Dev", cDev);
    }

    public IController<Bootcamp> getcBootcamp() {
        return cBootcamp;
    }

    public IController<Course> getcCurso() {
        return this.cCurso;
    }

    public IController<Dev> getcDev() {
        return cDev;
    }


    public void resolver(String key) {

    }
}

