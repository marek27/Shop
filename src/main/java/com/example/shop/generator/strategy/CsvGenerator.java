package com.example.shop.generator.strategy;

import com.example.shop.generator.model.FileType;
import org.springframework.stereotype.Component;

@Component
public class CsvGenerator extends FileStrategy {
    public CsvGenerator() {
        super(FileType.CSV);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }
}
