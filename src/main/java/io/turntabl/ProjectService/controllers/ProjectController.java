package io.turntabl.ProjectService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.turntabl.ProjectService.models.ProjectTO;
import io.turntabl.ProjectService.service.ProjectService;
import javax.annotation.Resource;
import java.util.List;

@Api
@RestController
@RequestMapping("/projectApp")
public class ProjectController {

    @Resource
    ProjectService projectService;

    @ApiOperation("List Projects")
    @GetMapping("/projectList")
    public List<ProjectTO> getAllProjects(){
        return projectService.getAllProjects();}

    @ApiOperation("Create Project")
    @PostMapping("/createProject")
    public void createProject(@RequestBody ProjectTO project){ projectService.insertProject(project);}

    @ApiOperation("Update Project")
    @PutMapping(value = "/updateProject")
    public void updateProject(@RequestBody ProjectTO project){ projectService.updateProject(project);
        System.out.println(" Updated Successfully");
    }

    @ApiOperation("Execute Update Project")
    @PutMapping("/executeUpdateProject")
    public void executeUpdateProject(@RequestBody ProjectTO project){ projectService.executeUpdateProject(project);
        System.out.println("Executed Successfully");
    }

    @ApiOperation("Delete Project")
    @DeleteMapping("/deleteProject")
    public void deleteProject(@RequestBody ProjectTO project){
        projectService.deleteProject(project);
        System.out.println("Deleted Successfully");
    }

    @ApiOperation("Search Project")
    @GetMapping("/searchProject/{name}")
    public List<ProjectTO> searchProject(@PathVariable String project){

        return projectService.searchProject(project);

    }

//    @ApiOperation("Testing search")
//    @GetMapping("/search/{name}")
//    public ClientTO search(@PathVariable String name){
//        ClientTO client = new ClientTO();
//        client.setName(name);
//        customerService.searchCustomer(client);
//        return client;
//    }
}
