package net.liuzd.dev.ip;

import org.junit.Assert;
import org.junit.Test;

import net.liuzd.dev.BaseJunitTest;
import net.liuzd.util.ip.IP;

/**
 * @copyright 2011-2017 jd.com
 * @author <a href="mailto:liuzidong@jd.com">liuzidong</a>
 * @version V1.0 上午11:30:04
 */
public class TestIP extends BaseJunitTest {

    @Test
    public void get() throws Exception {
        String ip = IP.get();
        log.info("IP : {}", ip);
        Assert.assertNotNull(ip, "IP获取出错了！");
    }

}
