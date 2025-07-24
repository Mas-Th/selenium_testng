package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {
    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void doSomething() {
        logger.info("Bắt đầu xử lý...");
        logger.debug("Chi tiết xử lý cho môi trường dev/test");
        logger.error("Có lỗi xảy ra");
    }
}
