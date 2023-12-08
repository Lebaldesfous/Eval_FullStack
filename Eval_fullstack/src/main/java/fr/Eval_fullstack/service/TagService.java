package fr.Eval_fullstack.service;

import fr.Eval_fullstack.entity.TagEntity;
import fr.Eval_fullstack.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;


}
