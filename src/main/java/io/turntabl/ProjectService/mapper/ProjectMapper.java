package io.turntabl.ProjectService.mapper;

import io.turntabl.ProjectService.models.ProjectTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectMapper implements RowMapper<ProjectTO> {

    @Override
    public ProjectTO mapRow(ResultSet rs, int arg1) throws SQLException{
        ProjectTO project = new ProjectTO();
        project.setId(rs.getString("id"));
        project.setName(rs.getString("projectName"));
        project.setDescription(rs.getString("description"));


        return project;
    }

}
