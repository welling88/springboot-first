package com.cc.sbfirst.model;

import java.util.List;

public class Calculation {
	String function;
	private List<Double> input;
	private List<Double> output;

	public Calculation() {
		super();
	}

	public Calculation(List<Double> input, List<Double> output, String function) {
		super();
		this.input = input;
		this.output = output;
		this.function = function;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public List<Double> getInput() {
		return input;
	}

	public void setInput(List<Double> input) {
		this.input = input;
	}

	public List<Double> getOutput() {
		return output;
	}

	public void setOutput(List<Double> output) {
		this.output = output;
	}

}
