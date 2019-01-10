package com.muji.zh.config;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2019/1/5/005.
 */
@Service
public class FastefsClient {
    @Autowired
    protected  FastFileStorageClient storageClient;

    public String uploFile(MultipartFile file){
        String fileType = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        StorePath path = null;
        try {
            path = storageClient.uploadFile(file.getInputStream(), file.getSize(), fileType, null);
        }catch (IOException e){
            e.printStackTrace();
        }
        if(path != null)
            return path.getFullPath();
        else
            return null;
    }

    public String uploFile(InputStream inputStream, Long size, String type){
        StorePath path = null;
        try {
            path = storageClient.uploadFile(inputStream, size, type, null);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(path != null)
            return path.getFullPath();
        else
            return null;
    }

//    public void deleteFile(String fullPath){
//        storageClient.deleteFile(fullPath);
//    }

    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            e.printStackTrace();
        }
    }

}
