package com.task.transport.service;

import com.task.transport.model.Transport;
import java.util.List;

public interface TransportService {
    //Вывод всех ТС
    List<Transport> findByAll();
    //Вывод ТС по фильтру (Государственный номер, Марка, Модель, Категория, Год выпуска)
    List<Transport> findByFilter(String filterStateNumber, String filterBrand,
                                 String filterModel, String filterCategory,
                                 String filterYearRelease);
    // Добавление ТС в БД
    Boolean insertNewTransport(Transport newTransport);
    // Удаление ТС из БД
    Boolean deleteTransport(Transport transport);
    // Изъятие информации о ТС из БД по гос. номеру
    Transport informTransport(Transport transport);
    // Редактирование ТС в БД
    Boolean editingTransport(Transport transport);
}

