package tn.enis.ecommerce.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/getAllGrades")
    public List<Grade> getAllGrades(){
        return gradeService.getAllGardes();
    }

    @GetMapping("/getGrade/{idGrade}")
    public Grade getGradeById(@PathVariable long idGrade){
        return gradeService.getGradeById(idGrade);
    }

    @PostMapping("/create")
    public void createGrade(@RequestBody Grade gradeToCreate){
        gradeService.createGrade(gradeToCreate);
    }

    @PutMapping("/updateGrade/{idGradeToUpdate}")
    public void updateGrade(@PathVariable long idGradeToUpdate,@RequestBody Grade gradeUpdated){
        gradeService.setGrade(idGradeToUpdate,gradeUpdated);
    }

    @DeleteMapping("/delete/{idGradeToDelete}")
    public void deleteGrade(@PathVariable long idGradeToDelete){
        gradeService.deleteGradeById(idGradeToDelete);
    }

}
