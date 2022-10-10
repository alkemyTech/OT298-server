package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.PageNotFound;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.exception.ThereAreNoTestimonials;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import javax.validation.constraints.Size;

import com.alkemy.ong.repository.TestimonialRepository;
import com.alkemy.ong.service.ITestimonialService;
import com.alkemy.ong.mapper.TestimonialMapper;
import com.alkemy.ong.model.Testimonial;
import com.alkemy.ong.dto.TestimonialDTO;

import java.net.URI;
import java.util.*;

import static com.alkemy.ong.util.Constants.URI_PAGE;

@Service
@Transactional
public class TestimonialServiceImpl implements ITestimonialService {

    @Autowired
    private MessageSource message;

    @Autowired
    private TestimonialRepository repository;

    @Autowired
    private TestimonialMapper mapper;


    public TestimonialDTO save(TestimonialDTO dto){
        Testimonial Testimonial = repository.save(mapper.toEntity(dto));
        return mapper.toDto(Testimonial);
    }

    @Override
    public TestimonialDTO update(Long id, TestimonialDTO dto) {
        if(!findById(id).isPresent()){
            throw new ResourceNotFoundException(message.getMessage("testimonial.notFound", null, Locale.US));
        }
        Testimonial testimonialEntity = findById(id).get();
        Testimonial  testimonial = mapper.updateTestimonialFromDto(dto, testimonialEntity);
        TestimonialDTO testimonialDTO = mapper.toDto(testimonial);
        return testimonialDTO;
    }

    @Override
    public Optional<Testimonial> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public void delete (Long id) {
        Optional<Testimonial> response = repository.findById(id);
        if(response.isPresent()) {
            repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException(message.getMessage("testimonial.notFound",null,Locale.US)+id);
        }
    }

    @Override
    public Page<Testimonial> getTestimonialPage(Integer numberPage, Pageable pageable) {
        if(repository.findAll().isEmpty()){
            throw new ThereAreNoTestimonials(message.getMessage("testimonial.thereAreNo", null, Locale.US));
        }

        pageable = PageRequest.of(numberPage, 10);
        Page<Testimonial> testimonialPage = repository.findAll(pageable);

        if(numberPage>=testimonialPage.getTotalPages()) {
            throw new PageNotFound(message.getMessage("page.notFound", null, Locale.US));
        }

        return testimonialPage;
    }

    @Override
    public Map<String, Object> responseTestimonialPage(Integer numberPage, Pageable pageable) {

        Page<Testimonial> testimonialPage = this.getTestimonialPage(numberPage, pageable);
        List<Testimonial> testimonials = testimonialPage.getContent();
        List<TestimonialDTO> testimonialDtos = mapper.listTestimonialsToListDtos(testimonials);

        Map<String, Object> response = new HashMap<>();

        Integer lastPageNumber = testimonialPage.getPageable().previousOrFirst().getPageNumber();
        if(testimonialPage.hasPrevious()){
            response.put("lastPage", URI.create(URI_PAGE + lastPageNumber));
        }

        Integer nextPageNumber = testimonialPage.getPageable().next().getPageNumber();
        if(testimonialPage.hasNext()){
            response.put("nextPage", URI.create(URI_PAGE + nextPageNumber));
        }
        response.put("testimonials", testimonialDtos);
        response.put("totalElements", testimonialPage.getTotalElements());
        response.put("totalPages", testimonialPage.getTotalPages());

        return response;
    }


}