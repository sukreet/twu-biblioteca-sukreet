package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void testForComparingNullObjectsWithA() {
        User user = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertThat(user, not(equalTo(null)));
    }

    @Test
    public void testForDifferentObjects() {
        User user = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        Object one = new Integer(1);

        assertThat(user, not(equalTo(one)));
    }

    @Test
    public void testForEquality() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        User userTwo = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);


        assertEquals(userOne, userTwo);
    }

    @Test
    public void testForReflexivity() {
        User user = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertEquals(user, user);
    }

    @Test
    public void testForSymmetry() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        User userTwo = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertEquals(userOne, userTwo);
        assertEquals(userTwo, userOne);
    }

    @Test
    public void testForTransitivity() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        User userTwo = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        User userThree = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertEquals(userOne, userTwo);
        assertEquals(userTwo, userThree);
        assertEquals(userThree, userOne);
    }

    @Test
    public void equalityTestForHashCode() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);
        User userTwo = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertEquals(userOne.hashCode(), userTwo.hashCode());
    }

    @Test
    public void shouldReturnFalseWhenInvalidCredentialsArePassed() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertFalse(userOne.validate("123-1111", "password"));

    }

    @Test
    public void shouldReturnTrueWhenValidCredentialsArePassed() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", false);

        assertTrue(userOne.validate("111-1111", "password"));
    }


    @Test
    public void checkIfAnUserIsALibrarian() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", true);

        assertTrue(userOne.userIsLibrarian());
    }


    @Test
    public void shouldGetNameOfUserCorrectly() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", true);

        String actualName = userOne.nameOfUser();
        String expectedName = "Name";

        assertThat(actualName, is(expectedName));
    }

    @Test
    public void shouldReturnUserDetailInCorrectFormat() {
        User userOne = new User("Name", "111-1111", "930129876", "asd@gmail.com", "password", true);

        String actualName = userOne.action();
        String expectedName = "111-1111\tName\t930129876\tasd@gmail.com\n";

        assertThat(actualName, is(expectedName));
    }


}


