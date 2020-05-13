package com.example.shop.generator.strategy;

import com.example.shop.generator.model.FileType;
import org.springframework.stereotype.Component;

@Component
public class PdfGenerator extends FileStrategy {

    public PdfGenerator() {
        super(FileType.PDF);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }
}
