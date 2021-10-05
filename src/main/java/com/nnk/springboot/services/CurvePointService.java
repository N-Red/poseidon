package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointService {
    @Autowired
    private CurvePointRepository curvePointRepository;

    public List<CurvePoint> findAll() {
        return curvePointRepository.findAll();
    }

    public void save(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    public CurvePoint updateById(Integer id) {
        return this.findById(id);
    }

    public void updateByCurvePoint(CurvePoint curvePoint, Integer id) {
        curvePoint.setCurveId(id);
        curvePointRepository.save(curvePoint);
    }

    public void delete(Integer id) {
        CurvePoint curvePoint = this.findById(id);
        curvePointRepository.delete(curvePoint);
    }

    private CurvePoint findById(Integer id) {
        return curvePointRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Curve Point Id:" + id));
    }
}
