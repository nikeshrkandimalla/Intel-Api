package com.intel.statsapplication.model;

import java.time.LocalDateTime;


public class OutputData {
	
	public LocalDateTime timestamp;
    public Double latency;
    public Double score;
    public Double fault;
    
    public OutputData(LocalDateTime timestamp, Double latency, Double score, Double fault) {
        this.timestamp = timestamp;
        this.latency = latency;
        this.score = score;
        this.fault = fault;
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Double getLatency() {
		return latency;
	}

	public void setLatency(Double latency) {
		this.latency = latency;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getFault() {
		return fault;
	}

	public void setFault(Double fault) {
		this.fault = fault;
	}

	
}
