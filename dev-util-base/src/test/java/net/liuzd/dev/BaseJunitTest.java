package net.liuzd.dev;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @copyright 2011-2017 jd.com
 * @author <a href="mailto:liuzidong@jd.com">liuzidong</a>
 * @version V1.0 上午11:30:32
 */
public class BaseJunitTest {

    protected Logger log = LoggerFactory.getLogger(getClass().getName());

    @After
    public void after() {
        log.info("---after---");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("---afterClass---");
    }

    @Before
    public void before() {
        log.info("---before---");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("---beforeClass---");
    }
}
