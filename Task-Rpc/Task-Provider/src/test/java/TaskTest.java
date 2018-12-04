import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wp.hny.base.constants.TaskInfoType;
import com.wp.hny.task.api.dto.req.AddWxTaskReqDto;
import com.wp.hny.task.api.dto.resp.TaskInfoRespDto;
import com.wp.hny.task.api.service.TaskService;

public class TaskTest extends BaseTest {
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void taskInfoListTest() {
		List<TaskInfoRespDto> list = taskService.taskInfoList(TaskInfoType.WX_VOTE);
		
		for(TaskInfoRespDto cur : list) {
			System.out.println(cur);
		}
	}
	
	@Test
	public void addWxPraseTaskTest() {
		AddWxTaskReqDto reqDto = new AddWxTaskReqDto();
		reqDto.setTitle("111");
		reqDto.setCnt(111);
		reqDto.setRemark("111");
		reqDto.setUrl("www.afefa.com");
		reqDto.setType(TaskInfoType.WX_PRASE);
		taskService.addWxTaskInfo(reqDto);
	}
}
