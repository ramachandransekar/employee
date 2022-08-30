/**
 * <p>
 * This is the base package for all the model classes
 * </p>
 *
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
public class Trainer extends Employee {
     
    private int trainingExperience;
    private int projectCount;
    private String projectName;
    private List<Trainee> trainees;
    
    /**
     * <p>
     * This method used to get trainees
     * </p>
     *
     * @return trainees
     */
    public List<Trainee> getTrainees() {
        return trainees;
    }
    
    /**
     * <p>
     * This method used to set trainees
     * </p>
     *
     * @param trainees
     *
     * @return void
     */   
    public void setTrainees(List<Trainee> trainee) {
        this.trainees = trainee;
    }

    /**
     * <p>
     * This method used to get trainingExperience
     * </p>
     *
     * @return trainingExperience
     */	
    public int getTrainingExperience() {
        return trainingExperience;
    }

    /**
     * <p>
     * This method used to set trainingExperience
     * </p>
     *
     * @param trainingExperience 
     * 
     * @return void
     */
    public void setTrainingExperience(int trainingExperience) { 
	this.trainingExperience = trainingExperience;
    }

    /**
     * <p>
     * This method used to get projectCount
     * </p>
     *
     * @return the projectCount
     */
    public int getProjectCount() {
	return projectCount;
    }

    /**
     * <p>
     * This method used to set projectCount
     * </p>
     *
     * @param  projectCount - trainer projectCount 
     *
     * @return void
     */
    public void setProjectCount(int projectCount) {
	this.projectCount = projectCount;
    }

    /**
     * <p>
     * This method used to set projectName
     * </p>
     *
     * @return projectName
     */
    public String getProjectName() {
	return projectName;
    }

    /**
      * <p>
     * This method used to get projectName
     * </p>
     *
     * @param  projectName - trainer projectName 
     *
     * @retunr void
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * <p>
     * overriding the toString() method
     * </p> 
     *
     * @return trainer detail
     */ 
    @Override 
    public String toString() {
        return (" Company Name : " + Employee.companyName + "\n"  
                + " Id : " + getId() + "\n" + " Name :" + getName()
                + "\n" + " Email : " + getEmail() + "\n"
                + " Contact Number : " + getContactNumber() + "\n" + " Age :" + getAge()
                + "\n" + " Alternate Contact Number : " + getAlternateContactNumber() + "\n"
                + " Address : " + getAddress() + "\n" + " Year Of Graduation : " + getYearOfGraduation() 
                + "\n" + " Primary Language : " + getPrimaryLanguage() + "\n" 
                + " Aadhar Number : " + getAadharNumber() 
                + "\n" + " Pancard Number : " + getPancardNumber() + "\n" 
                + " Training Experience : " + getTrainingExperience() + "\n" 
                + " Projects Count  : " + getProjectCount() + "\n" 
                + " Projects Name : " + getProjectName());
    } 
}
