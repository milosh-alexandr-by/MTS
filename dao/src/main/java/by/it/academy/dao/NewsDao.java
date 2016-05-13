package by.it.academy.dao;

import by.it.academy.pojos.News;

import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public interface NewsDao extends Dao<News> {

    // возвращает количество записей, количество страниц и номер текущей страницы
    public List<Integer> infoNewsesPagination(int currentPage);
    public List<News> getAllPagination(int firstElement);
    public List<News> getAllPaginationInverse(int firstElement);

}
