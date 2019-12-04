package io.turntabl.ProjectService.dao;

import io.turntabl.ProjectService.models.ProjectTO;
import java.util.List;


public interface ProjectDao {
    List<ProjectTO> getAllProjects();

    void insertProject(ProjectTO project);

    void updateProject(ProjectTO project);

    void executeUpdateProject(ProjectTO project);

    void deleteProject(ProjectTO project);

    List<ProjectTO> searchProject(String projectName);
}
