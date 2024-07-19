package br.com.dio.controller.dao.dao;

import br.com.dio.controller.dao.IDao;
import br.com.dio.controller.model.Bootcamp;
import java.util.List;
import static br.com.dio.controller.dao.data.DataBootcamp.*;

public class DaoBootcamp implements IDao<Bootcamp> {
    private IDao<Bootcamp> dataBootcampIDao;

    @Override
    public void add(Bootcamp bootcamp) {
        addBootcamp(bootcamp);

    }

    @Override
    public Bootcamp getById(int id) {
        return getBootcampById(id);
    }

    @Override
    public List<Bootcamp> getAll() {
        return getAllBootcamps();
    }

    @Override
    public boolean update(int id, Bootcamp bootcamp) {

        return updateBootcamp(id, bootcamp);
    }

    @Override
    public boolean delete(int id) {

        return deleteBootcamp(id);
    }

    @Override
    public void startAutoData() {
        startAutoDataBootcamp();
    }

    @Override
    public int sizeMap() {
        return returnSizeMap();
    }
}
