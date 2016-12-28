package com.homework.controller;

import com.homework.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/imageController/{imageId}")
    @ResponseBody
    public byte[] getImage(@PathVariable long imageId)  {
        return imageService.getById(imageId).getFile();
    }

}
