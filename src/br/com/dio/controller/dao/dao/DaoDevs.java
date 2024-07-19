package br.com.dio.controller.dao.dao;

import br.com.dio.controller.dao.IDao;
import br.com.dio.controller.model.Dev;
import java.util.List;
import static br.com.dio.controller.dao.data.DataDevs.*;

public class DaoDevs implements IDao<Dev> {
    @Override
    public void add(Dev dev) {
        addDev(dev);

    }

    @Override
    public Dev getById(int id) {
        return getDevById(id);
    }

    @Override
    public List<Dev> getAll() {
        return getAllDevs();
    }

    @Override
    public boolean update(int id, Dev dev) {
        return updateDev(id, dev);
    }

    @Override
    public boolean delete(int id) {
        return deleteDev(id);
    }

    @Override
    public void startAutoData() {
    }

    @Override
    public int sizeMap() {
        return returnSizeMap();
    }
}
