package net.nel.il.service;

import net.nel.il.dao.ExtraDao;
import net.nel.il.entity.Cost;
import net.nel.il.entity.HallList;
import net.nel.il.entity.SessionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExtraService {

    @Autowired
    ExtraDao extraDao;

    @Transactional
    public boolean costExistsById(Integer id){
        return extraDao.costExistsById(id);
    }

    @Transactional
    public boolean hallExistsById(Integer id){
        return extraDao.hallExistsById(id);
    }

    @Transactional
    public Cost getCostById(Integer id){
        return extraDao.getCostById(id);
    }

    @Transactional
    public HallList getHallListById(Integer id){
        return extraDao.getHallListById(id);
    }

    @Transactional
    public void saveSessionList(SessionList sessionList){
        extraDao.saveSessionList(sessionList);
    }

    @Transactional
    public List<Cost> getCosts(){
        return extraDao.getCosts();
    }

    @Transactional
    public List<HallList> getHallList(){
        return extraDao.getHallList();
    }
}
