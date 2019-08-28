package com.demo.answer;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

public class QuestionTest {

    @Test
    public void answer1Test() {
        System.out.println(StringUtils.join(Question.answer1(new int[]{2,3}), ", "));
    }

    @Test
    public void answer2Test() {
        System.out.println(StringUtils.join(Question.answer1(new int[]{23,34}), ", "));
    }
}