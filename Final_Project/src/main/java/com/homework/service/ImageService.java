package com.homework.service;

import com.homework.dao.DAO;
import com.homework.dao.QuantityFilterDAO;
import com.homework.model.Image;
import com.homework.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ImageService {

    private DAO<Image> imageDAO;

    @Transactional
    public void save(Image image){
        imageDAO.save(image);
    }

    @Transactional
    public void delete(long id){
        imageDAO.delete(id);
    }

    @Transactional
    public Image getById(long id){
        return imageDAO.getById(id);
    }

    @Transactional
    public List<Image> getAll(){
        return imageDAO.getAll();
    }

    @Transactional
    public Image createImage(byte[] file){
        if (file.length == 0){
            return null;
        }
        Image image = new Image();
        image.setFile(file);
        save(image);
        return image;
    }

    public DAO<Image> getImageDAO() {
        return imageDAO;
    }

    public void setImageDAO(DAO<Image> imageDAO) {
        this.imageDAO = imageDAO;
    }
}
