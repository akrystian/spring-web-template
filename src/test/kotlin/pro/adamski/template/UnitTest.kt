package pro.adamski.template

import org.junit.jupiter.api.Test

class UnitTest {

    @Test
    fun shouldPass() {
        //given
        val a = 1
        val b = 2

        //when
        val result = a + b

        //then
        assert(result == 3)
    }

}
