/**
 * <p>
 * This is the package for dao interface
 * </p>
 *
 * Copyright 2022 - ideas2it
 */
package com.ideas2it.employee.dao;

import java.sql.SQLException;
// -----import java.util.ArrayList;  
import java.util.List;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.employee.model.Trainee;
import com.ideas2it.employee.model.Trainer;


/**
 * <p>
 * Interface EmployeeDAO used to implements EmployeeDAOImpl
 * </p>
 *
 * @author  Ramachandran
 *
 * @version 1
 *
 * @since   2022-07-18
 */
public interface EmployeeDAO {
    
    /**  
     * <p>
     * This abstract method is used for retrieve trainers
     * detail
     * </p>
     */
    public List<Trainer> retrieveTrainers() throws SQLException;

    /**  
     * <p>
     * This abstract method is used for retrieve trainers
     * detail
     * </p>
     */
    public List<Trainee> retrieveTrainees() throws SQLException;

    /**  
     * <p>
     * This abstract method is used for update trainer detail
     * detail
     * </p>
     *
     * @param id - id of the trainer
     * @param trainerUpdate - trainer update option
     * @param updateNewValue - trainer update new value
     *
     * @return boolean
     */
    public boolean updateTrainer(String id, int trainerUpdate, String updateNewValue) throws SQLException;
 
    /**  
     * <p>
     * This abstract method is used for update trainee detail
     * </p>
     *
     * @param id - id of the trainee
     * @param traineeUpdate - trainee update option
     * @param updateNewValue - trainee update new value
     *
     * @return boolean
     */
    public boolean updateTrainee(String id, int traineeUpdate, String updateNewValue) throws SQLException;
    /**  
     * <p>
     * This abstract method is used for retriveTrainer
     * </p>
     *
     * @param id - id of the trainer
     *
     * @return trainer detail
     */
    public Trainer retrieveTrainer(String id) throws SQLException;
   
    /**
     * <p>
     * This abstract method is used for retriveTrainee
     * </p>
     *
     * @param id - id of the trainee
     *
     * @return trainee detail
     */
    public Trainee retrieveTrainee(String id) throws SQLException;

    /** 
     * <p>
     * This abstract method is used for insertTrainee
     * </p>
     *
     * @param trainee - trainee detail
     *
     * @return void
     */
    public boolean insertTrainee(Trainee trainee) throws SQLException;

    /**
     * <p>
     * This abstract method is used for insertTrainer
     * </p>
     *
     * @param trainer - trainer detail
     *
     * @return void
     */
    public boolean insertTrainer(Trainer trainer) throws SQLException;
  
    /**
     * <p>
     * This abstract method is used for deleteTrainee
     * </p>
     *
     * @param id - id of the trainee
     *
     * @return boolean
     */
    public boolean deleteTrainee(String id) throws SQLException;

    /**
     * <p>
     * This abstract method is used for deleteTrainer
     * </p>
     *
     * @param id - id of the trainer
     *
     * @return boolean
     */
    public boolean deleteTrainer(String id) throws SQLException;
  
    /**
     * <p>
     * This abstract method is used for assign trainer to trainee
     * </p>
     *
     * @param trainerId - id of the trainer
     * @param traineeId - id of the trainee
     *
     * @return boolean
     */
    public boolean assignTrainerToTrainee(String trainerId, String traineeId) throws SQLException;
    
    /**
     * <p>
     * This abstract method is used for retrieve trainees
     * </p>
     *
     * @param Id - id of the trainee
     *
     * @return trainees
     */
    public List<Trainee> displayAssignedTrainerToTrainees(String id) throws SQLException;
    
     /**
     * <p>
     * This abstract method is used retrieve trainer contact number
     * </p>
     *
     * @param contactNumber - contactNumber of the trainer
     *
     * @return boolean
     */
    public boolean getTrainerContactNumber(long contactNumber) throws SQLException;
    
    /**
     * <p>
     * This abstract method is used retrieve trainee contact number
     * </p>
     *
     * @param contactNumber - contactNumber of the trainee
     *
     * @return boolean
     */
    public boolean getTraineeContactNumber(long contactNumber) throws SQLException;   
    
    /**
     * <p>
     * This abstract method is used retrieve trainee aadharcard number
     * </p>
     *
     * @param aadharNumber - aadharNumber of the trainee
     *
     * @return boolean
     */
    public boolean getTraineeAadhartNumber(long aadharNumber) throws SQLException;

    /**
     * <p>
     * This abstract method is used retrieve trainer aadharcard number
     * </p>
     *
     * @param aadharNumber - aadharNumber of the trainer
     *
     * @return boolean
     */   
    public boolean getTrainerAadhartNumber(long aadharNumber) throws SQLException;
    
    /**
     * <p>
     * This abstract method is used retrieve trainer pancard number
     * </p>
     *
     * @param panCard - pancard number of the trainer
     *
     * @return boolean
     */ 
    public boolean getTrainerPancardNumber(String panCard) throws SQLException;
    
    /**
     * <p>
     * This abstract method is used retrieve trainee pancard number
     * </p>
     *
     * @param panCard - pancard number of the trainee
     *
     * @return boolean
     */
    public boolean getTraineePancardNumber(String panCard) throws SQLException;

}