package config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig  redisConfig;

    /**
     * 将redis连接池注入spring容器
     * @return
     */
    @Bean
    public JedisPool JedisPoolFactory(){
        System.out.println(redisConfig.toString());
        System.out.println(redisConfig.getPort());
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(redisConfig.getMaxidle());
        config.setMaxTotal(redisConfig.getMaxtotal());
        config.setMaxWaitMillis(redisConfig.getMaxwait() * 1000);
        JedisPool jp = new JedisPool(config, redisConfig.getHost(), redisConfig.getPort(),
                redisConfig.getTimeout()*1000, null, 0);
        return jp;
    }

}
