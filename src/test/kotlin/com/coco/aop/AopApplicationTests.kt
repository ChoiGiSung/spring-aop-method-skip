package com.coco.aop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AopApplicationTests {

	@Autowired
	private lateinit var sampleService: SampleService

	@Test
	fun contextLoads() {
		assertThat(sampleService.sample1(1)).isNotNull
		assertThat(sampleService.sample1(3)).isNull()
	}

}
