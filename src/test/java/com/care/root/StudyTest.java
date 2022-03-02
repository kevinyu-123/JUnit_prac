package com.care.root;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) //실행시 underscore을 없애준다. 
class StudyTest {

	@Test
	@DisplayName("스터디 만들기") //테스트하는 메소드이름 설정 가능
	void create_new_study() {
		Study study = new Study();
		assertNotNull(study);
		assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디가 실행되면 처음은 draft여야 한다.");
	}
	
	@Test
	// @Disabled // 실행하고 싶지 않은 테스트코드에 사용한다.
	void create_other_class() {
		System.out.println("Create1");
	}
	
	@BeforeAll // static을 꼭 사용, 리턴값이 없다.
	static void beforeAll() {
		System.out.println("before All");
	}
	
	@AfterAll // static을 꼭 사용, 리턴값이 없다.
	static void afterAll() {
		System.out.println("after all");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("before each");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("after each");
	}
	
}
