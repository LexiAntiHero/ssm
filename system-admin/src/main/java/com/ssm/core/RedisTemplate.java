package com.ssm.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import javax.annotation.Resource;
import java.util.Optional;

@Component
@Slf4j
public class RedisTemplate {

    @Resource
    private JedisPool jedisPool;

    @Resource
    private CustomObjectMapper objectMapper;

    /**
     * Store a plain string
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String set(String key, String value, Long expire) {
        Jedis jedis = jedisPool.getResource();
        String returnValue = null;
        try {
            // If the operation is successful, it returns the "ok" string
            returnValue = jedis.setex(key, expire, value);
        } catch (JedisException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return returnValue;
    }

    /**
     * Get a string value by key
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String returnValue = null;
        try {
            returnValue = jedis.get(key);
        } catch (JedisException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return returnValue;
    }

    /**
     * Store an object type data
     * @param key
     * @param object
     * @param expire
     * @return
     */
    public String setObject(String key, Object object, Long expire) {
        Jedis jedis = jedisPool.getResource();
        String returnValue = null;
        try {
            // Serialize the object
            String objValue = objectMapper.writeValueAsString(object);
            // If the operation is successful, it returns the "ok" string
            returnValue = jedis.setex(key, expire, objValue);
        } catch (JedisException | JsonProcessingException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return returnValue;
    }

    /**
     * Get object type data by key
     * @param key
     * @param valueType
     * @param <T>
     * @return
     */
    public <T> Optional<T> getObject(String key, Class<T> valueType) {
        Jedis jedis = jedisPool.getResource();
        String returnValue = null;
        try {
            // If the operation is successful, it returns the value
            String objectValue = jedis.get(key);
            return objectValue == null ? Optional.empty() : Optional.of(objectMapper.readValue(objectValue, valueType));
        } catch (JedisException | JsonProcessingException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return Optional.empty();
    }

    public <T> Optional<T> getObject(String key, TypeReference<T> typeReference) {
        Jedis jedis = jedisPool.getResource();
        String returnValue = null;
        try {
            // If the operation is successful, it returns the value
            String objectValue = jedis.get(key);
            return objectValue == null ? Optional.empty() : Optional.of(objectMapper.readValue(objectValue, typeReference));
        } catch (JedisException | JsonProcessingException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return Optional.empty();
    }

    /**
     * Remove multiple keys
     * @param key
     * @return
     */
    public Long remove(String... key) {
        Jedis jedis = jedisPool.getResource();
        String returnValue = null;
        try {
            // If the operation is successful, it returns the number of keys removed
            return jedis.del(key);
        } catch (JedisException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return -1L;
    }

    public Long lpush(String key, String... value) {
        Jedis jedis = jedisPool.getResource();
        long pos = -1;
        try {
            // If the operation is successful, it returns the length of the list after the push
            pos = jedis.lpush(key, value);
        } catch (JedisException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return pos;
    }

    public Optional<String> rpop(String key) {
        Jedis jedis = jedisPool.getResource();
        Optional<String> returnValue = Optional.empty();
        try {
            // If the operation is successful, it returns the value removed from the end of the list
            String value = jedis.rpop(key);
            returnValue = value == null ? Optional.empty() : Optional.of(value);
        } catch (JedisException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return returnValue;
    }

    public long llen(String key) {
        Jedis jedis = jedisPool.getResource();
        long llen = -1;
        try {
            // If the operation is successful, it returns the length of the list
            llen = jedis.llen(key);
        } catch (JedisException e) {
            jedisPool.returnBrokenResource(jedis);
            log.error("Redis execution error!", e);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return llen;
    }
}

