package top.oyoung.erp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private WebApplicationContext webContext;
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc(){
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webContext)
				.apply(springSecurity())
				.build();
	}

	@Test
	public void homePage() throws Exception {
//		mockMvc.perform(get("/test"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("index"))
//				.andExpect(model().attributeExists("param"))
//				.andExpect(model().attribute("params", is(empty())));
	}


	@Test
	@WithUserDetails("hello")
//	@WithMockUser(username="hello", password="password", roles="READER")
	public void homePage_authenticatedUser() throws Exception {
//		User expectedReader = new User();
//		expectedReader.setUsername("hello");
//		expectedReader.setPassword("password");
//
//		mockMvc.perform(get("/"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("index"))
//				.andExpect(model().attribute("reader",
//						samePropertyValuesAs(expectedReader)))
//				.andExpect(model().attribute("books", hasSize(0)))
//				.andExpect(model().attribute("amazonID", "habuma-20"));
	}
}
