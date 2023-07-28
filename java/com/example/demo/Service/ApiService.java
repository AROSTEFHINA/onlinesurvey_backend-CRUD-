package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ApiModel;
import com.example.demo.Repository.ApiRepo;

@Service
public class ApiService {
	@Autowired
	ApiRepo Repo;
	public List<ApiModel> getDetails()
	{
		return Repo.findAll();
	}
	public 	ApiModel SaveDetails(ApiModel e)
	{
		return Repo.save(e);
	}
	public ApiModel updateDetails(Long id, ApiModel e1)
	{
		ApiModel modelx = Repo.findById(id).orElse(null);
		if(modelx !=null) {
			modelx.setquestion(e1.getquestion());
			modelx.setoption1(e1.getoption1());
			modelx.setoption2(e1.getoption2());
			modelx.setoption3(e1.getoption3());
			modelx.setoption4(e1.getoption4());
			
			
			return Repo.saveAndFlush(modelx);
		}
		else {
			return null;
		}
	}
    public void deleteDetails(Long id)
    {
    	Repo.deleteById(id);
    }
}