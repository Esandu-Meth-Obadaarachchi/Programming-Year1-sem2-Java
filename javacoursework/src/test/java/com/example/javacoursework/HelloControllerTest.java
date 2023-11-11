package com.example.javacoursework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloControllerTest {
    //=================================================================
    //ADD INPUTS

    //name
    @Test
    public void checkingIfTheUserHasEnteredName(){
        HelloController controller = new HelloController();
        assertFalse(controller.isNameValid(""));
    }
    //age
    @Test
    public void checkingIfAgeEnteredIsNull(){
        HelloController controller = new HelloController();
        assertFalse(controller.isNameValid(""));
    }
    @Test
    public void checkingIfAgeEnteredIsCorrect(){
        HelloController controller = new HelloController();
        assertFalse(controller.isAgeValid("g54"));
        assertTrue(controller.isAgeValid("19"));
    }
    @Test
    public void checkingIfAgeEnteredIsInvalid(){
        HelloController controller = new HelloController();
        assertFalse(controller.isAgeValid("34g"));
    }
    //points
    @Test
    public void checkingIfTheUserHasEnteredPoints(){
        HelloController controller = new HelloController();
        assertFalse(controller.isPointsValid(""));
    }
    @Test
    public void checkingIfPointsEnteredIsCorrect(){
        HelloController controller = new HelloController();
        assertFalse(controller.isAgeValid("g54"));
        assertTrue(controller.isAgeValid("19"));
    }
    @Test
    public void checkingIfPointsEnteredIsInvalid(){
        HelloController controller = new HelloController();
        assertFalse(controller.isAgeValid("34g"));
    }
    //team
    @Test
    public void checkingIfTheUserHasEnteredTeam(){
        HelloController controller = new HelloController();
        assertFalse(controller.isNameValid(""));
    }
    //car
    @Test
    public void checkingIfTheUserHasEnteredCar(){
        HelloController controller = new HelloController();
        assertFalse(controller.isNameValid(""));
    }
    //================================================================================
    //DDD INPUT
    @Test
    public void checkingIfTheUserHasEnteredIdToDelete(){
        HelloController controller = new HelloController();
        assertFalse(controller.isPointsValid(""));
    }
    @Test
    public void checkingIfEnteredIdToDeleteIsCorrect(){
        HelloController controller = new HelloController();
        assertFalse(controller.isAgeValid("g54"));
        assertTrue(controller.isAgeValid("19"));
    }
    @Test
    public void checkingIfEnteredIdToDeleteIsInvalid(){
        HelloController controller = new HelloController();
        assertFalse(controller.isAgeValid("34g"));
    }
}

