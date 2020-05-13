package com.example.shop.config;


import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Config config () {
        return new Config().setInstanceName("hazelcast-instance-1").addMapConfig(new MapConfig().setName("product"));
    }

}
