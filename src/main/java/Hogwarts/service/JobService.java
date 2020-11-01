package Hogwarts.service;

import Hogwarts.entity.Job;

import java.util.List;


public interface JobService {
    List<Job> getJobs();
    Job saveJob(Job job);
    Job getJob(String id);
    Job assignJob(int userId,String userName,String jobId);
    Job updateJobSkills(List<String> skills,String jobId);
    List<Job> getSuggestJobs(int userId,int cnt);
    List<Job> getCurrentJobs();
    void setJobState(String jobId,int state);
    List<Job> getEmployeeJob(int userId);
    List<Job> getEmployerJob(int userId);
    List<Integer> getStatistics(int year,int lowMonth,int highMonth);
}
