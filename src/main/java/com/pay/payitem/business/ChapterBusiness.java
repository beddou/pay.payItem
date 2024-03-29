package com.pay.payitem.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.payitem.exception.EntityNotFoundException;
import com.pay.payitem.exception.NoEntityAddedException;
import com.pay.payitem.model.Chapter;
import com.pay.payitem.repository.ArticleRepository;
import com.pay.payitem.repository.ChapterRepository;

@Service
public class ChapterBusiness {

    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Chapter> getChapter(int idChapter) {
        return chapterRepository.findById(idChapter);
    }

    public List<Chapter> getChaptersOfOrganism(int idOrganism) {
        return chapterRepository.findByOrganism(idOrganism);
    }

    public List<Chapter> getChaptersOfOrganismCreatedByUser(int idOrganism) {
        return chapterRepository.findByOrganismAndSystemCreated(idOrganism, false);
    }

    public Chapter createChapter(Chapter chapter) {
        chapter.setSystemCreated(false);
        return chapterRepository.save(chapter);
    }

    public Chapter updateChapter(int id, Chapter chapter) {

        chapter.setId(id);
        return chapterRepository.save(chapter);

    }

    public boolean deleteChapter(int idChapter) {

        Optional<Chapter> chapter = chapterRepository.findById(idChapter);
        if (!chapter.isPresent())
            return false;
        if (chapter.get().isSystemCreated())
            return false;
        if (!articleRepository.existsByChapter_id(idChapter)) {
            try {
                chapterRepository.deleteById(idChapter);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else
            return false;

    }

}
