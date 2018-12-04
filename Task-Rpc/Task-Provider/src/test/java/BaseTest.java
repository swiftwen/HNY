
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wp.hny.task.provider.TaskProviderLauncher;

/**
 * 
 * @author swiftwen
 * @date 2018年11月26日 下午5:49:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskProviderLauncher.class)
@Transactional
@Rollback(value=false)
public abstract class BaseTest {

  
}
