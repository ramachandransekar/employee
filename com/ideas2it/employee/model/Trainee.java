/**
 * <p>
 * This is the base package for all the model classes
 * </p>
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.model;

import java.util.List;

/**
 * <p>
 * This Trainee class contains getter and setter methods and extends employee
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */
public class Trainee extends Employee {
    	
    private String skill;
    private String degree; 

    /**
     * <p>
     * This method used to get skill of trainee 
     * </p>
     *
     * @return skill
     */
    public String getSkill() {
	return skill;
    }

    /**
     * <p>
     * This method used to set skill of trainee 
     * </p>
     *
     * @param skill - trainee skill
     *
     * @return void
     */
    public void setSkill(String skill) {
	this.skill = skill;
    }

    /**
     * <p>
     * This method used to get degree of trainee
     * </p>
     *
     * @return degree
     */
    public String getDegree() {
	return degree;
    }

    /**
     * <p>
     * This method used to set degree of trainee
     * </p>
     *
     * @param degree - trainee degree 
     *
     * @return void
     */
    public void setDegree(String degree) {
	this.degree = degree;
    }

    /**
     * <p>
     * Overriding the toString() method 
     * </p>
     *
     * @return trainee detail
     */
    @Override
    public String toString() {
        return (" Company Name : " + Employee.companyName + "\n"  
                + " Id : " + getId() + "\n" + " Name : " + getName()
                + "\n"  + " Email : " + getEmail() + "\n" 
                + " Contact Number : " + getContactNumber() + "\n" + " Age :" + getAge()
                + "\n" + " Alternate Contact Number : " + getAlternateContactNumber() + "\n"
                + " Address : " + getAddress() + "\n" + " Year Of Graduation : " + getYearOfGraduation()  
                + "\n" + " Primary Language : " + getPrimaryLanguage() + "\n" 
                + " Aadhar Number : " +  getAadharNumber()
                + "\n" + " Pancard Number : " + getPancardNumber() + "\n" 
                + " Skills : " + getSkill() + "\n" 
                + " Degree : " + getDegree());
    }            
}
