package com.care.root;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) //실행시 underscore을 없애준다. 
class StudyTest {

	@Test
	//@Tag("local")
	@DisplayName("스터디 만들기") //테스트하는 메소드이름 설정 가능
	@EnabledOnJre(JRE.JAVA_11) // 해당 jre 에서만 실행
	@EnabledOnOs(OS.WINDOWS) // 해당 os 에서만 실행
	void create_new_study() {
		Study study = new Study(1);
		
		/*
		 * 	assumeTrue()
		 *  처음 조건을 건뒤 조건이 true 이면 테스트를 진행한다.
		 */
		
		//테스트를 한번에 진행시키게 해준다
		assertAll(
			()-> assertNotNull(study),	
			 
			()-> assertEquals(StudyStatus.DRAFT, study.getStatus(), ()-> "스터디가 실행되면 처음은 draft여야 한다."),
						//          기대값                            상태값
			
			()-> assertTrue(study.getLimit()> 0,"스터디는 0")
				);
		
		//예외발생여부 확인
		assertThrows(IllegalArgumentException.class, ()-> new Study(2));
		
		//메세지 여부 확인
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new Study(1));
		assertEquals("limit은 0보다 커야함",exception.getMessage());
	
		
	}
	

	// @Disabled // 실행하고 싶지 않은 테스트코드에 사용한다.
	// @EnabledIfEnvironmentVariable(named = "", matches="") 매칭되는 값이 있으면 테스트 실행
	@Test
	//@Tag("local") // 테스트 실행환경 설정
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
