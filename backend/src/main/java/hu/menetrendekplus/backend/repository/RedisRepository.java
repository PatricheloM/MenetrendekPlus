package hu.menetrendekplus.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.net.ConnectException;
import java.util.*;


@Repository
public class RedisRepository {

    @Autowired
    private JedisPool jedisPool;

    public void set(String key, String value)
    {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedis.close();
    }

    public int del(String... key)
    {
        Jedis jedis = jedisPool.getResource();
        int response = jedis.del(key).intValue();
        jedis.close();
        return response;
    }

    public void setex(String key, String value, int expiration) {
        Jedis jedis = jedisPool.getResource();
        jedis.setex(key, expiration, value);
        jedis.close();
    }

    public boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        boolean response = jedis.exists(key);
        jedis.close();
        return response;
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String response = jedis.get(key);
        jedis.close();
        return response;
    }

    public List<String> keys(String regex) {
        Jedis jedis = jedisPool.getResource();
        List<String> response = new ArrayList<>(jedis.keys(regex));
        jedis.close();
        return response;
    }

    public void expire(String key, int expiration) {
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key, expiration);
        jedis.close();
    }

    public boolean ping() {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.ping();
            jedis.close();
            return true;
        } catch (JedisConnectionException e) {
            return false;
        }
    }
}
