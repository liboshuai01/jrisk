package cn.liboshuai.jrisk.framework.signature.config;

import cn.liboshuai.jrisk.framework.redis.config.JriskRedisAutoConfiguration;
import cn.liboshuai.jrisk.framework.signature.core.aop.ApiSignatureAspect;
import cn.liboshuai.jrisk.framework.signature.core.redis.ApiSignatureRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * HTTP API 签名的自动配置类
 *
 * @author Zhougang
 */
@AutoConfiguration(after = JriskRedisAutoConfiguration.class)
public class JriskApiSignatureAutoConfiguration {

    @Bean
    public ApiSignatureAspect signatureAspect(ApiSignatureRedisDAO signatureRedisDAO) {
        return new ApiSignatureAspect(signatureRedisDAO);
    }

    @Bean
    public ApiSignatureRedisDAO signatureRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new ApiSignatureRedisDAO(stringRedisTemplate);
    }

}
