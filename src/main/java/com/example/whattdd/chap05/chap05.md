### chap05

# JUnit 5 기초

## JUnit 모듈 구성

- JUnit 플랫폼 : 테스팅 프레임워크를 구동하기 위한 런처와 테스트 엔진을 위한 API를 제공한다.
- JUnit 주피터 : JUnit 5 를 위한 테스트 API 와 실행 엔진을 제공한다.
- JUnit 빈티지 : JUnit 3과4로 작성된 테스트를 JUnit5 플랫폼에서 실행하기 위한 모듈을 제공한다.

## Test 애노테이션과 테스트 메서드

- 테스트로 사용할 클래스를 만들고 @Test 애노테이션을 메서드에 붙이기만 하면된다.
@Test 메서드에는 private 를 붙이면 안된다. 
- 클래스는 다른 클래스와 구분하기쉽게 Test 접미사를 붙인다.
- JUnit의 Assertions 클래스는 assertEquls 메서드와 같이 값을 검증하기 위한 목적의 다양한 정적 메서드 제공


## 주요 단언 메서드

- assertEquals(expected, actual) : 실제 값(actual)이 기대하는 값(expected)과 같은지 검사
- assertNotEquals(expected, actual) : 실제 값(actual)이 기대하는 값(expected)과 같지 않은지 검사
- assertSame(Object expected, Object actual) : 두 객체가 동일한 객체인지 검사
- assertNotSame(Object expected, Object actual) : 두 객체가 동일하지 않은 객체인지 검사
- assertTrue(boolean condition) : 같이  true 인지 검사
- assertFalse(boolean condition) : 값이 false 인지 검사
- assertNull(Object actual) : 값이 null인지 검사
- assertNotNull(object actual) : 값이 null이 아닌지 검사
- fail() : 테스트를 실패 처리 


## Assertion가 제공하는 익셉션 발생 유무 검사 메서드

- assertThrows(Class<T> expectedType, Executable executable) : executable을 실행한 결과로 지정한 타입의 익셉션이 발생하는지 검사한다.
- assertDoesNotThrow(Executable executable) executable을 실행한 결과로 익셉션이 발생하지 않는지 검사한다.
-> 경우에 따라 모든 검증을 실행하고 그중에 실패한 것이 있는지 확인하고 싶을 때 assertAll 메서드 사용


## 테스트 라이프사이클 

- @BeforeEach : 테스트를 실행하는데 필요한 준비작업 때 사용
- @AfterEach : 테스트를 실행한 후 정리할 것일 있을때 사용

## 테스트 메서드간 실행순서 의존과 필드 공유하지 않기

- 각 테스트 메서드는 서로 독립적으로 동작해야 한다. 한 테스트 메서드의 결과에 따라 다른 테스트 메서드의 실행 결과가 달라지면 안 된다.
- 테스트 메서드가 서로 필드를 공유한다거나 실행 순서를 가정하고 테스트를 작성하지 말아야 한다.
-> 의존이 생기면 유지보수를 어렵게 만든다. 

## 추가 애노테이션 

- @DisplayName : 자바는 메서드이름에 공백이나 특수문자를 사용할수 없기 때문에 이럴 때는 @DisplayName 애노테이션을 사용해 표시이름을 붙일 수 있다.
- @Disalbed : 특정 테스트를 실행하고 싶지않을때 @Disabled 애노테이션을 사용.
