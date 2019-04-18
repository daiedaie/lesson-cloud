package cn.edu.gzmu.config;

import cn.edu.gzmu.validate.ValidateCode;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;

/**
 * 缓存配置类(读取model模块的yaml配置文件)
 *
 * @author echo
 * @version 1.0
 * @date 19-4-12 09:50
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient redisson) {
        return new RedissonConnectionFactory(redisson);
    }

    /**
     * redisson 配置
     *
     * @param configFile 配置文件
     * @return 结果
     * @throws IOException 异常
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson(@Value("classpath:/redisson.yaml") Resource configFile) throws IOException {
        Config config = Config.fromYAML(configFile.getInputStream());
        return Redisson.create(config);
    }

    /**
     * 操作 redis
     *
     * @param redisConnectionFactory redis 链接工厂
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, ValidateCode> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, ValidateCode> redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory);
        redis.afterPropertiesSet();
        return redis;
    }

}
