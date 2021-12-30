package com.atcportal.projectmanager.daorepository;

import com.atcportal.partandprojectmanager.daorepository.ProjectDao;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDaoTest {

    @MockBean
    ProjectDao projectDao;

    @Test
    public void testFindNewProjectId(){
        Assertions.assertThat(projectDao.findNewProjectId() == 22);
    }

    @Test
    public void testFindProjectYears(){
        Assertions.assertThat(projectDao.findProjectYears().size() == 2);
    }

    @Test
    public void testFindByEnginerIdOrderByOrderDateDesc(){
        Assertions.assertThat(projectDao.findByEnginerIdOrderByProjectIdDesc(1).size() == 21);
       // Assertions.assertThat(projectDao.findByEnginerIdOrderByProjectIdDesc().size() == 21);
    }
}
