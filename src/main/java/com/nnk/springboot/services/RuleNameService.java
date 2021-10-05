package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameService {
    @Autowired
    private RuleNameRepository ruleNameRepository;

    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    public void save(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    public Object updateById(Integer id) {
        return this.findById(id);
    }

    public void updateByRuleName(RuleName ruleName, Integer id) {
        ruleName.setId(id);
        ruleNameRepository.save(ruleName);
    }

    public void delete(Integer id){
        ruleNameRepository.delete(this.findById(id));
    }

    private RuleName findById(Integer id) {
        return ruleNameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Rule Name Id:" + id));
    }
}
