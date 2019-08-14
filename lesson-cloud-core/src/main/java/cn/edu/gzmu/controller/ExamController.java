package cn.edu.gzmu.controller;

import cn.edu.gzmu.auth.helper.OauthHelper;
import cn.edu.gzmu.model.constant.LessonResource;
import cn.edu.gzmu.model.entity.Exam;
import cn.edu.gzmu.model.entity.Student;
import cn.edu.gzmu.model.entity.Teacher;
import cn.edu.gzmu.service.ExamService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Exam Controller
 *
 * @author echo
 * @version 1.0
 * @date 2019-5-28 17:24:38
 *
 * @author ljq
 *
 * <p>
 * @author hzl
 * @date 2019-8-13 23:48:10
 * 获取到当前教师未发布的考试信息
 * </p>
 */
@RequiredArgsConstructor
@RepositoryRestController
@RequestMapping(LessonResource.EXAM_SEARCH)
public class ExamController extends BaseController<Exam, ExamService, Long> {

    private final @NonNull ExamService examService;

    /**
     * 根据班级列表和课程信息获取所有分页过后的考试信息
     *
     * @param courseId courseId
     * @return result
     */
    @GetMapping("/classAndCourse")
    public HttpEntity<?> classAndCourse(String courseId, String classIds,
                                        @PageableDefault(sort = {"sort", "id"}) Pageable pageable) {
        return ResponseEntity.ok(examService.searchByClassAndCourse(courseId, classIds, pageable));
    }

    /**
     * 获取当前登录学生的考试信息
     * 只有拥有学生角色以后才能够访问当前接口
     *
     * @param pageable 分页
     * @return 响应
     */
    @GetMapping("/student")
    @Secured("ROLE_STUDENT")
    public HttpEntity<?> fromStudent(@PageableDefault(sort = {"sort", "id"}) Pageable pageable) {
        // 获取当前登录用户
        Student student = OauthHelper.student();
        return ResponseEntity.ok(
                examService.searchByStudentPage(student, pageable)
        );
    }

    /**
     *获取到当前教师未发布的考试信息
     * @param logicClassIds 逻辑班级ids
     * @param courseId 课程id
     * @param pageable pageable
     * @return 。。。
     */
    @GetMapping("teacher/unpublish")
    @Secured("ROLE_TEACHER")
    public HttpEntity<?> getAllUnPublishExam(String logicClassIds,String courseId,@PageableDefault(sort = {"sort", "id"}) Pageable pageable){
        Teacher teacher=OauthHelper.teacher();
        return ResponseEntity.ok(examService.getAllUnPublishExam(teacher,logicClassIds,courseId,pageable));
    }

    /**
     * 获取当前登录的学生的指定id所有考试详细信息
     *
     */
    @GetMapping("/details/student/id/{id}")
    @Secured("ROLE_STUDENT")
    public HttpEntity<?> examDetailsById(@PathVariable Long id) {
        Student student = OauthHelper.student();
        return ResponseEntity.ok(examService.searchDetailsById(student, id));
    }

    /**
     * 查询所有考试的详细统计信息，需分页
     * 1. 获取到考试的题目数量（通过组卷规则）
     * 2. 获取到参与考试的所有逻辑班级的名称
     * 3. 获取到考试的应该参与的所有人数（通过当前考试关联的逻辑班级的所有班级人数以及重修人数相加）
     * 4. 获取考试的所有信息
     * 5. 条件可能为逻辑班级id和学期id（可能没有）
     */
    @GetMapping("/details/complete")
    @Secured("ROLE_TEACHER")
    public HttpEntity<?> examDetailsAll(@PageableDefault(sort = {"sort", "id"})Pageable pageable) {
        return ResponseEntity.ok(examService.searchDetailsAll(pageable));
    }

}
