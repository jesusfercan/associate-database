package com.jesusfercan.associate.service;

import com.jesusfercan.associate.entity.Associate;
import static org.junit.jupiter.api.Assertions.*;

import com.jesusfercan.associate.repository.AssociateRepository;

import com.jesusfercan.associate.service.impl.AssociateServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
//@DataJpaTest
public class AssociateServiceTest {

    @Mock
    AssociateRepository associateRepository;

    @InjectMocks
    AssociateServiceImpl associateService;


    @Test
    public void createSimpleAssociate(){
        Associate associate = Associate.builder().id(1).
                name("Nombre").
                surname("Apellidos").
                active(true).
                createdDate(LocalDateTime.now()).
                modifiedDate(LocalDateTime.now()).build();

        when(associateRepository.save(associate)).thenReturn(associate);

        Associate created = associateService.create(associate);

        assertNotNull(created);
        assertNotNull(created.getId());
        assertEquals(associate,created);
        verify(associateRepository,times(1)).save(associate);
    }
}
