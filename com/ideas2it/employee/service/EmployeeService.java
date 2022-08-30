/**
 * <p>
 * This is the package for employeeservice interface
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer;
  
/**
 * <p>
 * Interface employeeservice used to implements employeeserviceimple
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */
public interface EmployeeService {

    /**  
     * <p>
     * This abstract method is uesd to add trainer details
     * </p>
     *
     * @param name - trainer name
     * @param dateOfBirth - trainer date of birth
     * @param contactNumber - trainer contact number 
     * @param alternateContactNumber - trainer alternate contact number
     * @param address - trainer address
     * @param graduation - trainer graduation
     * @param language - trainer primary language
     * #param aadharNumber - trainer aadhar number
     * @param panCard - trainer pancard number
     * @param trainingExperience - trainer training experience
     * @param projectCount - trainer project count
     * @param projectName - trainer project name
     *
     * @return void
     */
    public boolean addTrainer(String name, LocalDate dateOfBirth, 
                              long contactNumber, long alternateContactNumber, 
                              String address, int graduation, String language, 
                              long aadharNumber, String panCard,
                              int trainingExperience, int projectCount,
                              String projectName) throws SQLException;
    
    /**  
     * <p>
     * This method is uesd to add trainee details
     * </p>
     *
     * @param name - trainee name
     * @param dateOfBirth - trainee date of birth
     * @param contactNumber - trainee contact number
     * @param alternateContactNumber - trainee alternate contact number
     * @param address - trainee address
     * @param graduation - trainee graduation
     * @param language - trainee primary language
     * #param aadharNumber - trainee aadhar number
     * @param panCard - trainee pancard number
     * @param skill - trainee programming skill
     * @param degree - trainee degree
     *
     * @return void
     */
    public boolean addTrainee(String name, LocalDate dateOfBirth, 
                              long contactNumber, long alternateContactNumber, 
                              String address, int graduation, String language, 
                              long aadharNumber, String panCard, 
                              String skill, String degree) throws SQLException;
    
    /**  
     * <p>
     * This abstract method is used to delete trainer 
     * by using trainer id
     * </p> 
     *
     * @param id - trainer id
     *
     * @return boolean
     */
    public boolean deleteTrainerById(String id) throws SQLException; 
    
    /**  
     * <p>
     * This abstract method is used to delete trainee 
     * by using trainee id
     * </p>
     *
     * @param id - trainee id
     *
     * @return boolean
     */
    public boolean deleteTraineeById(String id) throws SQLException;
 
    /**  
     * <p>
     * This abstract method is used to update trainer by id and updateNewValue and trainerUpdate
     * </p>
     *
     * @param id - trainer id
     * @param traineeUpdate - trainer update option
     * @param updateNewValue - trainer new value to update
     *
     * @return boolean
     */ 
    public boolean updateTrainerById(String id, int trainerUpdate, String updateNewValue) throws SQLException; 
    
    /**  
     * <p>
     * This abstract method is used to update trainee by id and updateNewValue and traineeUpdate
     * </p>
     *
     * @param id - trainee id
     * @param traineeUpdate - trainee update option 
     * @param updateNewValue - trainee new value to update
     *
     * @return boolean
     */
    public boolean updateTraineeById(String id, int traineeUpdate, String updateNewValue) throws SQLException;
    
    /**  
     * <p>
     * This abstract method is used to display trainer by
     * using trainer id
     * </p>
     *
     * @param Id - trainer id
     *
     * @return trainer
     */
    public Trainer displayTrainer(String id) throws SQLException;
    
    /**  
     * <p>
     * This abstract method is used to display trainee by 
     * using trainee id
     * </p>
     *
     * @param Id - trainee id
     *
     * @return trainer
     */
    public Trainee displayTrainee(String id) throws SQLException;  
 
    /**  
     * <p>
     * This abstract method is used to display all trainers detail
     * </p> 
     *
     * @return trainers
     */
    public List<Trainer> displayTrainers() throws SQLException;
  
    /**  
     * <p>
     * This abstract method is used to display all trainees detail
     * </p> 
     *
     * @return trainers
     */
    public List<Trainee> displayTrainees() throws SQLException;
 
    /**
     * <p>
     * This method used for assign trainer to trainee
     * </p>
     *
     * @param trainerId
     * @param traineeId
     *
     * @return boolean
     */   
    public boolean assignTrainerToTrainees(String trainerId, String traineeId) throws SQLException;

    /**
     * <p>
     * This method used for retrieve trainees 
     * </p>
     *
     * @param id = id of the trainee
     *
     * @return trainees
     */   
    public List<Trainee> displayAssignedTrainerToTrainees(String id) throws SQLException; 
  
    /**
     * <p>
     * This method used for retrieve trainer contact number 
     * </p>
     *
     * @param contactNumber = contact number of the trainer
     *
     * @return boolean
     */ 
    public boolean isTrainerContactNumberExist(Long contactNumber) throws SQLException;
    
    /**
     * <p>
     * This method used for retrieve trainee contact number 
     * </p>
     *
     * @param contactNumber = contact number of the trainee
     *
     * @return boolean
     */ 
    public boolean isTraineeContactNumberExist(Long contactNumber) throws SQLException;
    
    /**
     * <p>
     * This method used for retrieve trainee aadhar number 
     * </p>
     *
     * @param aadharNumber = aadharcard number of the trainee
     *
     * @return boolean
     */ 
    public boolean isTraineeAadharNumberExist(Long aadharNumber) throws SQLException;
    
    /**
     * <p>
     * This method used for retrieve trainer aadhar number 
     * </p>
     *
     * @param aadharNumber = aadharcard number of the trainer
     *
     * @return boolean
     */ 
    public boolean isTrainerAadharNumberExist(Long aadharNumber) throws SQLException;
    
    /**
     * <p>
     * This method used for retrieve trainer pancard number 
     * </p>
     *
     * @param panCard = pancard number of the trainer
     *
     * @return boolean
     */  
    public boolean isTrainerPancardNumberExist(String panCard) throws SQLException;
    
    /**
     * <p>
     * This method used for retrieve trainee pancard number 
     * </p>
     *
     * @param panCard = pancard number of the trainee
     *
     * @return boolean
     */ 
    public boolean isTraineePancardNumberExist(String panCard) throws SQLException;

}