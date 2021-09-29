package com.letscoding.batch.multijobscrm.job;


import com.letscoding.batch.config.DozerBeanConfig;
import com.letscoding.batch.multijobscrm.dbmodel.postgress.Employee;
import com.letscoding.batch.multijobscrm.dto.EmployeeDTO;
import com.letscoding.batch.multijobscrm.repository.postgress.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChunkOrientedCrmWriter implements ItemWriter<Employee> {


    @Override
    public void write(List<? extends Employee> items) throws Exception {
        System.out.println("hello chunkoriented job running...");
    }
}
