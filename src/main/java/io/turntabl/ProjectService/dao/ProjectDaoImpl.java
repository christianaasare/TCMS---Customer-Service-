package io.turntabl.ProjectService.dao;

import io.turntabl.ProjectService.mapper.ProjectMapper;
import io.turntabl.ProjectService.models.ProjectTO;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    public ProjectDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<ProjectTO> getAllProjects() {
        return template.query("select * from projects", new ProjectMapper());
    }

    @Override
    public void insertProject(ProjectTO project){
        final String sql = "insert into projects(id, projectName, description) values(:id, :projectName, :description)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", project.getId())
                .addValue("projectName", project.getName())
                .addValue("description", project.getDescription());
                    template.update(sql,param,holder);
    }


    @Override
    public void updateProject(ProjectTO project){
        final String sql = "update projects set id=:id, projectName=:projectName, description=:description where id=:id";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", project.getId())
                .addValue("projectName", project.getName())
                .addValue("description", project.getDescription());
                    template.update(sql,param,holder);
    }


    @Override
    public void executeUpdateProject(ProjectTO project){
        final String sql = "update projects set id=:id, projectName=:projectName, description=:description where id=:id";

        Map<String,Object> map= new HashMap<String, Object>();
        map.put("id", project.getId());
        map.put("projectName", project.getName());
        map.put("description", project.getDescription());

        template.execute(sql, map, (PreparedStatementCallback<Object>) ps -> ps.executeUpdate());
    }


        @Override
        public void deleteProject(ProjectTO project){
            final String sql = "delete from projects where id=:id";

            Map<String, Object> map = new HashMap<String, Object>();
           map.put("id", project.getId());

            template.execute(sql, map, (PreparedStatementCallback<Object>) ps -> ps.executeUpdate());
        }


    @Override
    public List<ProjectTO> searchProject(String projectName){
        final String sql = "select * from projects where projectName =:projectName";

        Map<String, Object> map = new HashMap<String, Object>();

        return (List<ProjectTO>) template.execute(sql, map, (PreparedStatementCallback<Object>) ps -> ps.executeQuery());

    }
    }

