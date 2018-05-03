package com.xiaomo.travelhelper.controller;

import com.xiaomo.travelhelper.commons.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * 文件控制器
 */
@RestController
@RequestMapping("/api/file")
public class FileController {

    public static final String ROOT = "C:\\Users\\mojiale\\Desktop\\OA\\TravelHelperServer\\src\\main\\resources\\upload\\";

    @PostMapping("/upload")
    public ResultMessage handleFileUpload(@RequestParam("file") List<MultipartFile> files) {
        ResultMessage resultMessage = ResultMessage.buildByFail("文件为空");
        List<String> filenameList = new ArrayList<>();
        if(files != null && !files.isEmpty()){
            BufferedOutputStream stream = null;
            try {
                for(MultipartFile file : files){
                    String filename = UUID.randomUUID().toString();
                    File f = new File(ROOT + filename + ".png");
                    if(f.exists()){
                        f.mkdirs();
                    }
                    byte[] bytes = file.getBytes();
                    stream= new BufferedOutputStream(new FileOutputStream(f));
                    stream.write(bytes);
                    stream.close();
                    filenameList.add(filename);
                }
                resultMessage = ResultMessage.buildBySuccess("上传成功",filenameList);
            }catch (Exception e){
                stream = null;
                resultMessage = ResultMessage.buildByFail(e.getMessage());
            }
        }
        return resultMessage;
    }

}
