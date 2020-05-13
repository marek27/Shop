package com.example.shop.generator.strategy;

import com.example.shop.generator.model.FileType;
import org.springframework.stereotype.Component;

@Component
public class XlsGenetarot extends FileStrategy {
    public XlsGenetarot() {
        super(FileType.XLS);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }
}
