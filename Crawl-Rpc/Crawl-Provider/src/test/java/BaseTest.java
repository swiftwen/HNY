
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wp.hny.crawl.provider.CommonProviderHook;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = CommonProviderHook.class
)
@Transactional
@Rollback
public abstract class BaseTest {

  
}
