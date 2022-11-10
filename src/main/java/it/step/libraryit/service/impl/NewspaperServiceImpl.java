package it.step.libraryit.service.impl;

import it.step.libraryit.model.Newspaper;
import it.step.libraryit.repository.NewspaperRepository;
import it.step.libraryit.service.GenericsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewspaperServiceImpl implements GenericsService<Newspaper> {

    private final NewspaperRepository newspaperRepository;

    @Autowired
    public NewspaperServiceImpl(NewspaperRepository newspaperRepository) {
        this.newspaperRepository = newspaperRepository;
    }


    @Override
    public Newspaper findById(Long id) {
        return newspaperRepository.getOne(id);
    }

    @Override
    public List<Newspaper> findAll(String keyword) {
        if(keyword != null){
            return newspaperRepository.search(keyword);
        }
        return newspaperRepository.findAll();
    }

    @Override
    public Newspaper save(Newspaper newspaper) {
        return newspaperRepository.save(newspaper);
    }

    @Override
    public void deleteById(Long id) {
        newspaperRepository.deleteById(id);
    }
}
