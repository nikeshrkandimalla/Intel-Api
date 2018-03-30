package com.intel.statsapplication.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Set;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.intel.statsapplication.model.InputData;
import com.intel.statsapplication.model.Output;

//import com.intel.statsapplication.model.InData;
//import com.intel.statsapplication.model.OutputData;
//import com.sun.javafx.collections.MappingChange.Map;

import io.swagger.annotations.Api;



@RestController
@Api(description="Anomoly Detector")
@RequestMapping("/api")  
public class RestCtrl {
	
	@RequestMapping(value="/stats", method =  RequestMethod.POST)
	public ResponseEntity<Output> processData(@RequestBody InputData data) {
		if (data==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		List<Double> arrayData = new ArrayList();
		arrayData.add(data.getActTime());
		arrayData.add(data.getActCurrentCompressorBottom());
		arrayData.add(data.getActCurrentCompressorTop());
		arrayData.add(data.getActFlowCompressorBottom());
		arrayData.add(data.getActFlowCompressorTop());
		arrayData.add(data.getActFlowInlet());
		arrayData.add(data.getActFluxCompressorBottom());
		arrayData.add(data.getActFluxCompressorTop());
		arrayData.add(data.getActPositionValveInlet());
		arrayData.add(data.getActPositionValveOutlet());
		arrayData.add(data.getActPositionValveRecycle());
		arrayData.add(data.getActPositionValveRecycleBottom());
		arrayData.add(data.getActPositionValveRecycleTop());
		arrayData.add(data.getActPowerINUOutputCompressorBottom());
		arrayData.add(data.getActPowerINUOutputCompressorTop());
		arrayData.add(data.getActPressureAbsoluteTankOut());
		arrayData.add(data.getActPressureDiffOrifice1());
		arrayData.add(data.getActPressureDiffOrifice2());
		arrayData.add(data.getActPressureDiffTankIn());
		arrayData.add(data.getActPressureDiffTankOut());
		arrayData.add(data.getActSpeedCompressorBottom());
		arrayData.add(data.getActSpeedCompressorTop());
		arrayData.add(data.getActTemperatureCompressorTopDriveSide());
		arrayData.add(data.getActTemperatureCompressorTopNonDriveSide());
		arrayData.add(data.getActTemperatureCompressorTopOutlet());
		arrayData.add(data.getActTemperatureCompressorTopWinding());
		arrayData.add(data.getActTemperatureReservation());
		arrayData.add(data.getActTemperatureTankIn());
		arrayData.add(data.getActTemperatureTankOut());
		arrayData.add(data.getActTorqueCompressorBottom());
		arrayData.add(data.getActVoltageDCLinkCompressorBottom());
		arrayData.add(data.getActVoltageDCLinkCompressorTop());
		arrayData.add(data.getActVoltageINUOutputCompressorBottom());
		arrayData.add(data.getActTorqueCompressorTop());
		arrayData.add(data.getActVoltageINUOutputCompressorTop());
		arrayData.add(data.getRefPositionValveInlet());
		arrayData.add(data.getRefPositionValveOutlet());
		arrayData.add(data.getRefPositionValveRecycle());
		arrayData.add(data.getRefPositionValveRecycleBottom());
		arrayData.add(data.getRefPositionValveRecycleTop());
		arrayData.add(data.getRefSpeedCompressorBottom());
		arrayData.add(data.getRefSpeedCompressorTop());
		double[] dataArray = arrayData.stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(dataArray);
		Output output = new Output();
		output.setLatency(dataArray[0]);
		output.setScore(dataArray[dataArray.length-1]);
		double total = Arrays.stream(dataArray).sum();
		output.setFault(total/dataArray.length);
		output.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/calculations", method =  RequestMethod.POST)
	public ResponseEntity<Output> processData(@RequestBody Map<String, Double> data) {
		if (data==null || data.size()==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		double[] dataArray = data.values().stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(dataArray);
		Output output = new Output();
		output.setLatency(dataArray[0]);
		output.setScore(dataArray[dataArray.length-1]);
		double total = Arrays.stream(dataArray).sum();
		output.setFault(total/dataArray.length);
		output.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Output>(output, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/math", method = RequestMethod.POST)
	public ResponseEntity<Output> processData(@RequestBody List<Double> data){
		
		if (data==null || data.size()==0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		double [] dataArray=  data.stream().mapToDouble(Double::doubleValue).toArray();
		Arrays.sort(dataArray);
		Output output = new Output();
		output.setLatency(dataArray[0]);
		output.setScore(dataArray[dataArray.length-1]);
	    double total = Arrays.stream(dataArray).sum();
	    output.setFault(total/dataArray.length);
	    output.setTimestamp(LocalDateTime.now());
	    return new ResponseEntity<Output>(output,HttpStatus.OK);
	}
	
}