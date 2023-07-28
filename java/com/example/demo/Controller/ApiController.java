package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ApiModel;
import com.example.demo.Service.ApiService;

@RestController
@CrossOrigin(origins = "*")
public class ApiController {
	@Autowired(required=true)
	ApiService Service;
	@PostMapping("/aDetails")
	public ApiModel addInfo(@RequestBody ApiModel st)
	{
		return Service.SaveDetails(st);
	}
	
@GetMapping("shDetails")
	public List<ApiModel> fetchDetails()
	{
		return Service.getDetails();
	}
@PutMapping("/updDetails/{id}")
public ApiModel updateInfo(@RequestBody ApiModel st1, @PathVariable Long id )
{
	return Service.updateDetails(id, st1);
}

@DeleteMapping("/delDetails/{id}")
public String deleteInfo(@PathVariable Long id)
{
	Service.deleteDetails(id);
	return "Deleted details";
}
	
}