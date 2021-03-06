package testBusinessLayer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.UserService;
import com.qa.business.UserServiceImpl;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class testUserBusinesses {

	private static final String MOCK_OBJECT1 = "{\"username\":\"JDCR\",\"password\":\"Bob\"}";
	private static final String MOCK_OBJECT2 = "{\"username\":\"KNEE\",\"password\":\"Bryan\"}";
	private static final String MOCK_VALUE = "test_value_2";
	private static final String MOCK_ID = "JDCR";
	@InjectMocks
	private UserServiceImpl serv;
	@Mock
	private UserRepository repo;
	@Mock
	private JSONUtil util;
	@Before
	public void setUp(){
		serv.setRepo(repo);
	}
	@Test
	public void testCreateUser() {
		Mockito.when(repo.createUser(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.createUser(MOCK_ID));
	}
	@Test
	public void testGetAllUsers() {
		Mockito.when(repo.getAllUsers()).thenReturn(MOCK_OBJECT1);
		assertEquals(MOCK_OBJECT1, serv.getAllUsers());
	}
	@Test
	public void testGetAUser() {
		Mockito.when(repo.getAUser(MOCK_ID)).thenReturn(MOCK_OBJECT1);
		assertEquals(MOCK_OBJECT1, serv.getAUser(MOCK_ID));
	}
	@Test
	public void testUpdateUser() {
		Mockito.when(repo.updateUser(MOCK_ID, MOCK_OBJECT1)).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_OBJECT2, serv.updateUser(MOCK_ID, MOCK_OBJECT1));
	}
	@Test
	public void testDeleteUser() {
		Mockito.when(repo.deleteUser(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.deleteUser(MOCK_ID));
	}
}
