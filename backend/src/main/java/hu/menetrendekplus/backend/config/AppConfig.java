package hu.menetrendekplus.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.menetrendekplus.backend.converter.RouteConverter;
import hu.menetrendekplus.backend.converter.SimpleStationConverter;
import hu.menetrendekplus.backend.converter.StationConverter;
import hu.menetrendekplus.backend.model.RedisConfig;
import hu.menetrendekplus.backend.util.MenetrendekHttpRequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class AppConfig {

    @Bean
    JedisPool jedisPool() {
        RedisConfig redisConfig;
        try {
            redisConfig = new ObjectMapper().readValue(AppConfig.class.getResourceAsStream("redis.json"), RedisConfig.class);
        } catch (Exception e) {
            throw new RedisConfig.ConfigNotFoundException(e);
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxPool());
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdlePool());
        jedisPoolConfig.setMinIdle(redisConfig.getMinIdlePool());
        return new JedisPool(jedisPoolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout(), redisConfig.getPassword());
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    MenetrendekHttpRequestHandler httpRequestHandler() {
        return new MenetrendekHttpRequestHandler();
    }

    @Bean
    StationConverter stationsConverter() {
        return new StationConverter();
    }

    @Bean
    SimpleStationConverter simpleStationsConverter() {
        return new SimpleStationConverter();
    }

    @Bean
    RouteConverter routeConverter() {
        return new RouteConverter();
    }
}
