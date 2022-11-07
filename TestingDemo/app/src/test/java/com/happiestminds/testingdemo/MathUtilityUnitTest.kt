package com.happiestminds.testingdemo

import org.junit.*
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MathUtilityUnitTest {

    lateinit var mUtility: MathUtility

    @Before
    fun setup(){
        mUtility = MathUtility()
    }

    @Test
    fun testAdd(){

        val result = mUtility.add(10, 20)

        assertEquals(30, result)
    }

    @Test
    fun testSubtract(){

        val result = mUtility.subtract(10, 20)

        assertEquals(-10, result)
    }

    @Test
    fun testMultiply(){

        val result = mUtility.multiply(10, 20)

        assertEquals(200, result)
    }

    @Test
    fun testDivide(){

        val result = mUtility.divide(10, 2)

        assertEquals(5, result)
    }

    @Test
    fun testDivideByZero(){

        val result = mUtility.divide(10, 0)

        assertNull(result)

    }

    @Test
    fun testIsEven(){

        val result = mUtility.isEven(10)

        assertTrue(result)
    }

    @Test
    fun testIsEvenOdd(){

        val result = mUtility.isEven(13)

        assertFalse(result)
    }
}