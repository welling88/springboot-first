package com.cc.sbfirst.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cc.sbfirst.model.Calculation;

@RestController
@RequestMapping("/calculation")
public class CalculationController {

	@RequestMapping("/power")
	public Calculation pow(@RequestParam(value = "base") Double b, @RequestParam(value = "exponent") Double e) {
		List<Double> input = new ArrayList<Double>();
		input.add(b);
		input.add(e);

		List<Double> output = new ArrayList<Double>();
		Double powValue = Math.pow(b, e);
		output.add(powValue);
		return new Calculation(input, output, "power");
	}

	@RequestMapping(value = "/sqrt/{value:.+}", method = RequestMethod.GET)
	public Calculation sqrt(@PathVariable(value = "value") Double value) {
		List<Double> input = new ArrayList<Double>();
		input.add(value);

		List<Double> output = new ArrayList<Double>();
		Double sqrtValue = Math.sqrt(value);
		output.add(sqrtValue);
		return new Calculation(input, output, "sqrt");
	}

}
