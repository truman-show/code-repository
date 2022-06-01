package com.example.getinline.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MyTests : FunSpec({

    test("String length should return the length of the string") {
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }

    xcontext("this outer block is enabled") {
        xtest("this test is disabled") {
            // test here
        }
    }
    xcontext("this block is disabled") {
        test("disabled by inheritance from the parent") {
            // test here
        }
    }
})
