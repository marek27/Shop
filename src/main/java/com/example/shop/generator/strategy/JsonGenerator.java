package com.example.shop.generator.strategy;

import com.example.shop.generator.model.FileType;
import org.springframework.stereotype.Component;

@Component
public class JsonGenerator extends FileStrategy {
    public JsonGenerator() {
        super(FileType.JSON);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }
}
