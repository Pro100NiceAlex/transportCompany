package com.task.transport.service;

import com.task.transport.model.Transport;
import com.task.transport.repos.TransportRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImp1 implements TransportService {
    private final TransportRepo transportRepo;
    public TransportServiceImp1(TransportRepo transportRepo) {
        this.transportRepo = transportRepo;
    }
    @Override
    public List<Transport> findByAll() {
        return (List<Transport>) transportRepo.findAll();
    };
    @Override
    public List<Transport> findByFilter(String filterStateNumber, String filterBrand,
                                        String filterModel, String filterCategory,
                                        String filterYearRelease){
        if (filterStateNumber != null && filterStateNumber.isEmpty())
            filterStateNumber = null;
        if (filterBrand != null && filterBrand.isEmpty())
            filterBrand = null;
        if (filterModel != null && filterModel.isEmpty())
            filterModel = null;
        if (filterCategory != null && filterCategory.isEmpty())
            filterCategory = null;
        if (filterYearRelease != null && filterYearRelease.isEmpty())
            filterYearRelease = null;
        return transportRepo.findByFilter(filterStateNumber, filterBrand, filterModel, filterCategory,filterYearRelease);
    };
    @Override
    public Boolean insertNewTransport(Transport newTransport) {
        if (checkStateNumber(newTransport.getStateNumber()) && !transportRepo.existsById(newTransport.getStateNumber()) && newTransport.getBrand() != null && newTransport.getBrand().length() <= 255
                && newTransport.getModel() != null && newTransport.getModel().length() <= 255 && checkCategory(newTransport.getCategory()) && newTransport.getTrailer() != null
                && checkYearRelease(newTransport.getYearRelease()) && newTransport.getVehicleType() != null && newTransport.getVehicleType().length() <= 255) {
            transportRepo.save(newTransport);
            return true;
        }
        return false;
    }
    @Override
    public Boolean deleteTransport(Transport transport){
        if (transport.getStateNumber() != null && transport.getStateNumber().length() == 6 && transportRepo.existsById(transport.getStateNumber())){
            transportRepo.deleteById(transport.getStateNumber());
            return true;
        }
        return false;
    };
    @Override
    public Transport informTransport(Transport transport){
        if (transport.getStateNumber() != null && transport.getStateNumber().length() == 6 && transportRepo.existsById(transport.getStateNumber())){
            return transportRepo.findById(transport.getStateNumber()).get();
        }
        transport.setStateNumber("");
        return transport;
    }
    @Override
    public Boolean editingTransport(Transport transport)
    {
        if (checkStateNumber(transport.getStateNumber()) && transportRepo.existsById(transport.getStateNumber()) && transport.getBrand() != null && transport.getBrand().length() <= 255
                && transport.getModel() != null && transport.getModel().length() <= 255 && checkCategory(transport.getCategory()) && transport.getTrailer() != null
                && checkYearRelease(transport.getYearRelease()) && transport.getVehicleType() != null && transport.getVehicleType().length() <= 255) {
            transportRepo.save(transport);
            return true;
        }
        return false;
    }
    // Проверка корректности государственного номера ТС
    private Boolean checkStateNumber(String chStateNumber) {
        if (chStateNumber != null && chStateNumber.length() == 6) {
            char[] checkSymbols = chStateNumber.toCharArray();
            for(int i = 1; i <= 3; i++) {
                if (!((checkSymbols[i] >= '0') && (checkSymbols[i] <= '9')))
                    return false;
            }
            if (!(checkSymbols[0] == 'А' || checkSymbols[0] == 'В' || checkSymbols[0] == 'Е' || checkSymbols[0] == 'К' ||
                    checkSymbols[0] == 'М' || checkSymbols[0] == 'Н' || checkSymbols[0] == 'О' || checkSymbols[0] == 'Р' ||
                    checkSymbols[0] == 'С' || checkSymbols[0] == 'Т' || checkSymbols[0] == 'У' || checkSymbols[0] == 'Х'))
                return false;
            for(int i = 4; i <= 5; i++) {
                if (!(checkSymbols[i] == 'А' || checkSymbols[i] == 'В' || checkSymbols[i] == 'Е' || checkSymbols[i] == 'К' ||
                        checkSymbols[i] == 'М' || checkSymbols[i] == 'Н' || checkSymbols[i] == 'О' || checkSymbols[i] == 'Р' ||
                        checkSymbols[i] == 'С' || checkSymbols[i] == 'Т' || checkSymbols[i] == 'У' || checkSymbols[i] == 'Х'))
                    return false;
            }
            return true;
        }
        else return false;
    }
    // Проверка корректности категории ТС
    private Boolean checkCategory(String chCategory) {
        if (chCategory != null && chCategory.length() == 2) {
            char[] checkSymbols = chCategory.toCharArray();
            return (checkSymbols[0] == 'L' && checkSymbols[1] >= '1' && checkSymbols[1] <= '7') ||
                    ((checkSymbols[0] == 'M' || checkSymbols[0] == 'N') && checkSymbols[1] >= '1' && checkSymbols[1] <= '3') ||
                    (checkSymbols[0] == 'O' && checkSymbols[1] >= '1' && checkSymbols[1] <= '4');
        }
        else return false;
    }
    // Проверка корректности года выпуска ТС
    private Boolean checkYearRelease(String chYearRelease) {
        if(chYearRelease != null && !chYearRelease.isEmpty()){
            char[] checkSymbols = chYearRelease.toCharArray();
            for (char symbol: checkSymbols){
                if (!((symbol >= '0') && (symbol <= '9')))
                    return false;
            }
            return chYearRelease.length() == 1 || checkSymbols[0] != '0';
        }
        else return false;
    }
}

