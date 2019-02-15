

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weiye.WebLauncher;
import com.weiye.workflow.service.WorkFlowService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebLauncher.class)
public class Springboot02ApplicationTests {
	@Autowired
    WorkFlowService workFlowService;
	@Test
	public void contextLoads() {
        // workFlowService.claimTask("14", "weiye11");// 认领任务
	}

    @Test
    public void test() {
        // workFlowService.unclaimTask("14");// 退回任务
    }

    @Test
    public void test1() {
        workFlowService.completeTask("10013", null, "审批内容测试哈哈哈哈");
    }
}