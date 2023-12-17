package tel.bvm.EmployeeNameTestWithMavenLibrary.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tel.bvm.EmployeeNameTestWithMavenLibrary.constants.EmployeeConstants;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class DetailsEmployeeDepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl serviceMock;

    @BeforeEach
    void setUp() {
        DetailsEmployeeDepartmentService out = new DetailsEmployeeDepartmentServiceImpl(serviceMock);
        when(serviceMock.getMap()).thenReturn(EmployeeConstants.MAP_EMPLOYEE);
    }

    @Test
    public void maxWageDepartmentVerify() {

    }
}
