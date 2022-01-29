package tn.enis.ecommerce.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGardes(){
        return gradeRepository.findAll();
    }

    public Grade getGradeById(long idGrade){
        if(gradeRepository.findById(idGrade).isPresent()){
            return gradeRepository.findById(idGrade).get();
        }
        return null;
    }

    public void setGrade(long idGradeToUpdate,Grade gradeUpdated){
        if(gradeRepository.findById(idGradeToUpdate).isPresent()){
            Grade gradeToUpdate = gradeRepository.getById(idGradeToUpdate);
            gradeToUpdate.setDescription(gradeUpdated.getDescription());
            gradeRepository.save(gradeToUpdate);
        }
    }

    public void createGrade(Grade grade){
        gradeRepository.save(grade);
    }

    public void deleteGradeById(long idGradeToDelete){
        if(gradeRepository.findById(idGradeToDelete).isPresent()){
            gradeRepository.deleteById(idGradeToDelete);
        }
    }

}
