package it.step.libraryit.service.impl;

import it.step.libraryit.model.Magazine;
import it.step.libraryit.repository.MagazineRepository;
import it.step.libraryit.service.GenericsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazinesServiceImpl implements GenericsService<Magazine> {

    private final MagazineRepository magazinesRepository;

    @Autowired
    public MagazinesServiceImpl(MagazineRepository magazinesRepository) {
        this.magazinesRepository = magazinesRepository;
    }


    @Override
    public Magazine findById(Long id) {
        return this.magazinesRepository.getOne(id);
    }

    @Override
    public List<Magazine> findAll(String keyword) {
        if(keyword != null){
            return magazinesRepository.search(keyword);
        }
        return this.magazinesRepository.findAll();
    }

    @Override
    public Magazine save(Magazine magazine) {
        return this.magazinesRepository.save(magazine);
    }

    @Override
    public void deleteById(Long id) {
        magazinesRepository.deleteById(id);
    }
}
