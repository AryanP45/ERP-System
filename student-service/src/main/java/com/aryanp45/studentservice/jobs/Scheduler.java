package com.aryanp45.studentservice.jobs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@EnableScheduling
@Slf4j
public class Scheduler {
	
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	// uncomment cron job for resume scheduling
//	@Scheduled(cron = "0/15 * * * * ?")
	public void scheduleScript() {
		log.info("Cron task : Execution Start Time - {}",DATE_TIME_FORMATTER.format(LocalDateTime.now()));
		try {
			String[] cmd = new String[2];
			cmd[0] = "echo";
			cmd[1] = "SCRIPT RUNNING !!!";
			Process process = Runtime.getRuntime().exec(cmd);
			Thread.sleep(5000);
			BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line="";
			while((line = bfr.readLine()) != null) {
				log.info(line);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("EXCEPTION while schediling script : "+e);
		}
		
		log.info("Cron task : Execution End Time - {}",DATE_TIME_FORMATTER.format(LocalDateTime.now()));
	}

}
