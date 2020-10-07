package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
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
	@Autowired
	private DistilleryRepository distilleryRepository;

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

	@Test
	public void canGetDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegionIgnoreCase("highland");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskyByDistilleryOfCertainAge() {
		List<Whisky> found = whiskyRepository.findWhiskyByDistilleryIdAndAge(1L, 12);
		assertEquals(1, found.size());
		assertEquals("The Glendronach Original", found.get(0).getName());
	}

	@Test
	public void canFindAllWhiskiesFromAParticularRegion() {
		List<Whisky> found = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(7, found.size());
	}

}
