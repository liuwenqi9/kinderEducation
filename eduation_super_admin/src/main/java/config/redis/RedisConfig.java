package config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件的redis信息
 */

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;
    private String password;
//    private int poolMaxTotal;
//    private int poolMaxIdle;
//    private int poolMaxWait;
    private int maxtotal=1000;
    private int maxidle=500;
    private int maxwait=100;


    @Override
    public String toString() {
        return "RedisConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", timeout=" + timeout +
                ", password='" + password + '\'' +
                ", maxtotal=" + maxtotal +
                ", maxidle=" + maxidle +
                ", maxwait=" + maxwait +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxtotal() {
        return maxtotal;
    }

    public void setMaxtotal(int maxtotal) {
        this.maxtotal = maxtotal;
    }

    public int getMaxidle() {
        return maxidle;
    }

    public void setMaxidle(int maxidle) {
        this.maxidle = maxidle;
    }

    public int getMaxwait() {
        return maxwait;
    }

    public void setMaxwait(int maxwait) {
        this.maxwait = maxwait;
    }
}
