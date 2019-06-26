package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitSDJpaService visitSDJpaService;

    @Test
    public void findAllTest(){
       Set<Visit> visits = new HashSet<Visit>();
        visits.add(new Visit());
        visits.add(new Visit());
        when (visitRepository.findAll()).thenReturn(visits);
        Set<Visit> found= visitSDJpaService.findAll();
        assertEquals(2, found.size());

        verify(visitRepository, times(1)).findAll();
    }

    @Test
    public void findByIdTest(){
        Visit visit = new Visit();
        when(visitRepository.findById(1L)).thenReturn(Optional.of(visit));
        Visit foundVisit = visitSDJpaService.findById(1L);
        assertThat(foundVisit).isNotNull();
        verify(visitRepository,times(1)).findById(anyLong());
    }

    @Test
    public void saveTest(){
        Visit visit = new Visit();
        when(visitRepository.save(visit)).thenReturn(visit);
        Visit saved = visitSDJpaService.save(visit);
        assertThat(saved).isNotNull();
        verify(visitRepository, times(1)).save(any(Visit.class));
    }

    @Test
    public void delete(){
        Visit visit = new Visit();
        visitSDJpaService.delete(visit);
        verify(visitRepository,times(1)).delete(visit);
    }

     @Test
     public void deleteById(){
       visitSDJpaService.deleteById(1L);
       verify(visitRepository,times(1)).deleteById(1L);
     }
}