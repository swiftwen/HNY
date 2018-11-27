import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wp.hny.account.api.dto.resp.UserInfoRespDto;
import com.wp.hny.account.api.service.AccountService;

public class UserTest extends BaseTest {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void getByIdTest() {
		UserInfoRespDto userInfo = accountService.getUserInfoDetail(1L);
		System.out.println(userInfo);
	}
}
