package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atMost;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
     private VetSDJpaService vetSDJpaService;

     @Test
     void deleteByIdAtMost(){
         vetSDJpaService.deleteById(1L);
         vetSDJpaService.deleteById(1L);
         vetSDJpaService.deleteById(1L);

         verify (vetRepository, atMost(3)).deleteById(1L);
     }

    @Test
    void deleteById() {
       vetSDJpaService.deleteById(1L);
       verify(vetRepository,times(1)).deleteById(1L);

    }
}