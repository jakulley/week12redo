

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				Arguments.of(2,4,6,false),
				Arguments.of(-3,5,2,true),
				Arguments.of(0,2,2,true),
				Arguments.of(5,0,5,true));
	}
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(45, 45)).isEqualTo(90);
	}
	
	static Stream<Arguments> argumentsForCheckPrimeness() {
		return Stream.of(
				Arguments.of(1, false),
				Arguments.of(2, true),
				Arguments.of(3, true),
				Arguments.of(4, false),
				Arguments.of(7, true));
				
	}
	//Tests that primeTester returns true for primes and false for composite numbers. The test cases of course must be numbers whose primeness is known.
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForCheckPrimeness")
	void assertThatPrimeTesterReturnsCorrectBooleans(int a, boolean isPrime) {
		assertThat(testDemo.checkPrimeness(a)).isEqualTo(isPrime);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		assertThat(mockDemo.randomNumberSquared()).isEqualTo(25);
	}
	
}
