package com.example.shop.generator.strategy;

import com.example.shop.utils.AbstractStrategy;
import com.example.shop.generator.model.FileType;


public abstract class FileStrategy extends AbstractStrategy<FileType> {


    public FileStrategy(FileType fileType) {
        super(fileType);
    }

    public abstract byte[] generateFile();

}
