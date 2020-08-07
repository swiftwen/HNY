import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wp.hny.account.api.dto.resp.PermissionRespDto;
import com.wp.hny.account.api.dto.resp.RoleRespDto;
import com.wp.hny.account.api.dto.resp.UserInfoRespDto;
import com.wp.hny.account.api.service.AccountService;
import com.wp.hny.account.api.service.PermissionService;
import com.wp.hny.account.api.service.RoleService;

public class UserTest extends BaseTest {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	@Test
	public void getByIdTest() {
		UserInfoRespDto userInfo = accountService.getUserInfoDetail(1L);
		System.out.println(userInfo);
	}
	@Test
	public void getByAccountTest() {
		String pwd = accountService.getPwdByAccount("root");
		System.out.println(pwd);
	}
	
	@Test
	public void getRoleByUserIdTest() {
		List<RoleRespDto> list = roleService.getRoleByUserId(1L);
		for(RoleRespDto dto : list) {
			System.out.println(dto);
		}
	}
	@Test
	public void getPermissionByRoleIdTest() {
		List<Long> roleIdList = new ArrayList<>();
		roleIdList.add(2L);
		//roleIdList.add(2L);
		List<PermissionRespDto> list = permissionService.getPermissionByRoleId(roleIdList);
		for(PermissionRespDto dto : list) {
			System.out.println(dto);
		}
		//ThreadPoolExecutor executor = Executors.newFixedThreadPool(5);
		
	}
}
