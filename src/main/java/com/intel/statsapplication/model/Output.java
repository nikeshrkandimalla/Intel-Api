package com.intel.statsapplication.model;

import java.time.LocalDateTime;

public class Output {

	private double latency;
	private double score;
	private double fault;
	private LocalDateTime timestamp;
	 /**/
	public double getLatency() {
		return latency;
	}
	public void setLatency(double latency) {
		this.latency = latency;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getFault() {
		return fault;
	}
	public void setFault(double fault) {
		this.fault = fault;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
