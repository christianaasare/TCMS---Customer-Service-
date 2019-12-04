package io.turntabl.ProjectService.service;

import io.turntabl.ProjectService.dao.ProjectDao;
import io.turntabl.ProjectService.models.ProjectTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao projectDao;

    @Override
    public List<ProjectTO> getAllProjects() {
        return projectDao.getAllProjects();
    }


    @Override
    public void insertProject(ProjectTO project) { projectDao.insertProject(project); }

    @Override
    public void updateProject(ProjectTO project) { projectDao.updateProject(project); }

    @Override
    public void executeUpdateProject(ProjectTO project) { projectDao.executeUpdateProject(project); }

    @Override
    public void deleteProject(ProjectTO project) { projectDao.deleteProject(project); }

    @Override
    public List<ProjectTO> searchProject(String projectName) { return projectDao.searchProject(projectName); }
}
