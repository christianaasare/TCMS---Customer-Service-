package io.turntabl.ProjectService.service;

import io.turntabl.ProjectService.models.ProjectTO;

import java.util.List;

public interface ProjectService {
    List<ProjectTO> getAllProjects();

    void insertProject(ProjectTO project);

    void updateProject(ProjectTO project);

    void executeUpdateProject(ProjectTO project);

    void deleteProject(ProjectTO project);

    List<ProjectTO> searchProject(String projectName);
}
