package com.coindesk;

import com.coindesk.repositories.CoindeskRepository;
import com.coindesk.services.GetCoindeskApiService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UseCoindeskApiApplication.class)
class UseCoindeskApiApplicationTests {
	@Autowired
	private CoindeskRepository repository;

	@Test
	void contextLoads() {
		GetCoindeskApiService service = new GetCoindeskApiService();
		service.getCoindesk(repository);
	}

}
