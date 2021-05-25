package com.mph.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class TestSuite.
 */
@RunWith(Suite.class)
@SuiteClasses(value = { CustomerTest.class, LoanTest.class })
public class TestSuite {

}
