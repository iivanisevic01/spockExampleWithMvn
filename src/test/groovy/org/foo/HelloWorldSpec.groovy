package org.foo

import spock.lang.Specification

class HelloWorldSpec extends Specification {
	
	def setup() {
		// runs before each test
	}	
	
	def cleanup() {
		// runs after each test
	}

	// example of a typical Spock unit test
	def 'testMe1' () {
		// setup blocks are optional and setup label can be omitted (in which case it is implied)
		setup: // initialize any test conditions
		HelloWorld hw = new HelloWorld()
		
		// when blocks can contain arbitrary code
		when: // stimulus
		int respVal1 = hw.testMe1(1)
		int respVal2 = hw.testMe1(2)
			
		// then blocks are restricted to conditions, exception conditions, interactions, 
		// and variable definitions
		then: // response check
		respVal1 == 9
		respVal2 == 7
	}
	
	// example of a data driven test (replacement to junit parametrizations) 
	def 'test' () {
		// alternative to then blocks, limited to just conditions and variable declarations
		expect:
		name.size() == length
			
		// A where block always comes last in a method, and may not be repeated. 
		// It is used to write data-driven feature methods.
		where:
		name << ['test', 'test1', 'test28569']
		length << [4, 5, 9]
	}

	def 'testMe2' () {
		HelloWorld hw = new HelloWorld()
				
		when:
		int respVal1 = hw.testMe2('me')
		int respVal2 = hw.testMe2('not me')
		int respVal3 = hw.testMe2("me")
				
		then:
		respVal1 == 7
		respVal2 == 9
		respVal3 == 7
	}

	// can test private java methods
	def 'testMe3' () {
		HelloWorld hw = new HelloWorld()
				
		when:
		int respVal1 = hw.testMe3(true)
		int respVal2 = hw.testMe3(false)
				
		then:
		respVal1 == 7
		respVal2 == 9
	}	
}
