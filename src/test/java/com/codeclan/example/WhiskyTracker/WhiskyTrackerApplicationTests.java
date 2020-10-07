package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	private WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(6, found.size());
		found = whiskyRepository.findWhiskyByYear(2014);
		assertEquals(4, found.size());
	}

}
